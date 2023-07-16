package org.pippeloo.capturetheflag.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pippeloo.capturetheflag.CaptureTheFlag;

public class HubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a player is sending the command
        if (sender instanceof Player) {
            // Cast the sender to a player
            Player player = (Player) sender;
            // Get the location from the config
            Location location = CaptureTheFlag.getInstance().getStorageManager().getConfig().getLocation("hub");
            // Check if the location is null
            if (location == null) {
                // Send a message to the player
                player.sendMessage(ChatColor.RED + "The hub has not been set!");
                // Return true to indicate that the command was successful
                return true;
            }
            // Teleport the player to the hub
            player.teleport(location);
            // Send a message to the player
            player.sendMessage(ChatColor.GREEN + "Teleported to the hub!");
        } else {
            // Send a message to the console
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Only players can use this command!");
        }
        // Return true to indicate that the command was successful
        return true;
    }
}
