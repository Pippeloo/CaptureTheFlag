package org.pippeloo.capturetheflag.storage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class StorageManager {
    private final JavaPlugin plugin;
    private File file;
    private FileConfiguration config;

    public StorageManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "data.yml");
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        return config;
    }

    public void saveConfig() {
        if (config == null || file == null) {
            return;
        }

        try {
            getConfig().save(file);
        } catch (IOException ex) {
            plugin.getLogger().severe("Error saving config file: " + ex.getMessage());
        }
    }

    public void saveDefaultConfig() {
        if (!file.exists()) {
            plugin.getDataFolder().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                plugin.getLogger().severe("Error creating config file: " + ex.getMessage());
            }
        }
    }

}
