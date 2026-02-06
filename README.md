# FullLight (Fabric)

A small client-side Minecraft mod that permanently enforces `gamma = 15.0` so you can keep maximum visibility on Minecraft Java versions where editing `options.txt` gamma is no longer effective.

## Features

- Runs on Fabric (`fabric-loader` + `fabric-api`)
- Forces gamma to `15.0` every client tick
- Client-only mod (safe to use on vanilla/Fabric servers)

## Requirements

- JDK 17 (recommended for Minecraft 1.20.1 + Fabric Loom)
- Gradle (or Gradle Wrapper)

## How to package into a mod `.jar` on Windows

### 1) Open terminal in project folder

- In File Explorer, open this project folder.
- Click the address bar, type `cmd`, and press Enter (opens Command Prompt in this folder).
- You can also use PowerShell; commands below are for Command Prompt.

### 2) Build the mod

Run:

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

You will usually get two jars:

- `fulllight-<version>.jar` -> **install this one**
- `fulllight-<version>-dev.jar` -> development jar (do not install for normal gameplay)

### 4) Install in Minecraft (Fabric)

1. Install Fabric Loader for Minecraft `1.20.1`.
2. Press `Win + R`, enter `%appdata%\.minecraft\mods`, press Enter.
3. Copy `fulllight-<version>.jar` into that `mods` folder.
4. Start Minecraft using the Fabric profile.

## Run in dev environment

```bat
gradlew.bat runClient
```
