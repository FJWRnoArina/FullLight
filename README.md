# FullLight (Fabric)

A small client-side Minecraft mod that forces very high brightness so you can keep maximum visibility on Minecraft Java versions where editing `options.txt` no longer works.

## Why the previous implementation failed

The original code called:

- `client.options.getGamma().setValue(15.0)`

That looks correct, but in modern Minecraft versions, gamma is stored in `SimpleOption<Double>` with a validator/clamp. `setValue(...)` goes through that validator, so out-of-range values (like `15.0`) are clamped back to the normal slider range (typically `0.0` to `1.0`).

So the mod kept writing a value that Minecraft immediately normalized, resulting in **no visible full-bright effect**.

## Principle of the fixed approach

This mod still runs every client tick, but now it:

1. Gets the gamma `SimpleOption<Double>`.
2. Uses a Mixin accessor to write directly to the internal `value` field.
3. Sets that field to `15.0` directly, bypassing the normal `setValue(...)` clamp path.

This keeps the internal gamma value at full-bright levels and makes the effect visible in-game.

## Features

- Runs on Fabric (`fabric-loader` + `fabric-api`)
- Forces gamma internal value to `15.0` every client tick
- Client-only mod (safe to use on vanilla/Fabric servers)

## Supported game version

- Minecraft Java Edition **1.20.1**

## Requirements

- JDK 17 (recommended for Minecraft 1.20.1 + Fabric Loom)
- Gradle (or Gradle Wrapper)

## How to package into a mod `.jar` on Windows

### 1) Open terminal in project folder

- In File Explorer, open this project folder.
- Click the address bar, type `cmd`, and press Enter (opens Command Prompt in this folder).

### 2) Build the mod

```bat
gradlew.bat clean build
```

If wrapper files are missing in your local copy, generate them once (requires global Gradle):

```bat
gradle wrapper --gradle-version 8.10.2
gradlew.bat clean build
```

### 3) Find the packaged `.jar`

After build succeeds, open:

```text
build\libs\
```

You will usually get:

- `fulllight-<version>.jar` -> **install this one**
- `fulllight-<version>-dev.jar` -> development jar (do not install for normal gameplay)

### 4) Install in Minecraft (Fabric)

1. Install Fabric Loader for Minecraft `1.20.1`.
2. Press `Win + R`, enter `%appdata%\.minecraft\mods`, press Enter.
3. Copy `fulllight-<version>.jar` into that `mods` folder.
4. Start Minecraft using the Fabric profile.
