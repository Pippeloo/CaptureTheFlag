package org.pippeloo.capturetheflag.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pippeloo.capturetheflag.CaptureTheFlag;

public class SetHubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a player is sending the command
        if (sender instanceof Player) {
            // Cast the sender to a player
            Player player = (Player) sender;
            // Get the player's location and save it to the config
            Location location = player.getLocation();
            CaptureTheFlag.getInstance().getStorageManager().getConfig().set("hub", location);
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
