# FullLight (Fabric)

A small client-side Minecraft mod that permanently enforces `gamma = 15.0` so you can keep maximum visibility on Minecraft Java versions where editing `options.txt` gamma is no longer effective.

## Features

- Runs on Fabric (`fabric-loader` + `fabric-api`)
- Forces gamma to `15.0` every client tick
- Client-only mod (safe to use on vanilla/Fabric servers)

## Build

```bash
./gradlew build
```

The built jar will be generated in `build/libs/`.
