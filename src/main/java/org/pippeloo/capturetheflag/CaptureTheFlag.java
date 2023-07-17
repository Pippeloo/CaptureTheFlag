package org.pippeloo.capturetheflag;

import org.bukkit.plugin.java.JavaPlugin;
import org.pippeloo.capturetheflag.commands.CaptureTheFlagCommand;
import org.pippeloo.capturetheflag.commands.HubCommand;
import org.pippeloo.capturetheflag.commands.SetHubCommand;
import org.pippeloo.capturetheflag.storage.StorageManager;

public final class CaptureTheFlag extends JavaPlugin {

    private static CaptureTheFlag instance;
    private StorageManager storageManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        registerStorage();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        storageManager.saveConfig();
    }

    private void registerCommands() {
        // Tell the server is registering commands
        getLogger().info("Registering commands...");
        // Register the commands
        getCommand("sethub").setExecutor(new SetHubCommand());
        getCommand("hub").setExecutor(new HubCommand());
        getCommand("ctf").setExecutor(new CaptureTheFlagCommand());
    }

    private void registerStorage() {
        // Tell the server is registering storage
        getLogger().info("Registering storage...");
        // Create a new storage manager
        storageManager = new StorageManager(this);
        // Save the default config
        storageManager.saveDefaultConfig();
    }

    public static CaptureTheFlag getInstance() {
        return instance;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }
}
