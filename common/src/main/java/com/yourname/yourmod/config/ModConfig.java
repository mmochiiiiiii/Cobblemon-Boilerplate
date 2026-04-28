package com.yourname.yourmod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yourname.yourmod.ExampleMod;
import dev.architectury.platform.Platform;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File(Platform.getConfigFolder().toFile(), ExampleMod.MOD_ID + ".json");

    // These are the actual config values that developers can add to
    public static ConfigData data = new ConfigData();

    public static class ConfigData {
        public boolean enableCustomFeatures = true;
        public int maxPokemonLevel = 100;
        public String discordWebhookUrl = "";
    }

    public static void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                data = GSON.fromJson(reader, ConfigData.class);
            } catch (IOException e) {
                ExampleMod.LOGGER.error("Failed to load config file!", e);
            }
        } else {
            save(); // Create a new default config if it doesn't exist
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(data, writer);
        } catch (IOException e) {
            ExampleMod.LOGGER.error("Failed to save config file!", e);
        }
    }
}