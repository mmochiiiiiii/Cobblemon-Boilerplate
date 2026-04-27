# Cobblemon Boilerplate

![Fabric](https://img.shields.io/badge/Fabric-1.21.1-dbcaab?style=for-the-badge&logo=curseforge)![NeoForge](https://img.shields.io/badge/NeoForge-1.21.1-e08328?style=for-the-badge&logo=curseforge)![Cobblemon](https://img.shields.io/badge/Cobblemon-1.7.3+-cb303c?style=for-the-badge)

## 🚀 What's This?

A ready-to-go template for building Cobblemon mods that work on **both Fabric and NeoForge**.

- 🎯 **One Code, Many Loaders** – Fabric & NeoForge, no copy-paste nonsense
- 💬 **Modern Networking** – Built with Minecraft 1.21.1's new `CustomPacketPayload` system
- ⚙️ **Config System** – JSON configs that just work out of the box
- 🛠️ **Commands Ready** – Brigadier commands work across all platforms
- 🤝 **Kotlin Friendly** – Talk to Cobblemon's Kotlin events from Java
- 📦 **Smart Gradle** – Publish to CurseForge & Modrinth in one go

## 📁 Project Structure

```
cobblemon-boilerplate/
├── common/          → Shared code for both loaders
├── fabric/          → Fabric-specific stuff
├── neoforge/        → NeoForge-specific stuff
└── gradle/          → Build config
```

Put your main code in `common/` and it'll work everywhere. Only put loader-specific code in `fabric/` or `neoforge/`.

## 🔧 Making Your First Mod

1. **Rename your mod** in `gradle.properties`
2. **Replace package names** (`com.example` → your own)
3. **Drop code in `common/src/main/java/`**
4. **Build & test** in your Test Server

## 📚 Need Help?

- Join Nova Co. discord: [discord.gg/gUAA4vjHjw]

