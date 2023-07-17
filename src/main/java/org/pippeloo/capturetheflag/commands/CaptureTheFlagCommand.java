package org.pippeloo.capturetheflag.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.pippeloo.capturetheflag.CaptureTheFlag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaptureTheFlagCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a player is sending the command
        if (sender instanceof Player) {
            // Get the first argument
            String firstArgument = args[0];
            // Cast the sender to a player
            Player player = (Player) sender;

            // Check if the argument is "setBlueSpawn"
            if (Objects.equals(firstArgument, "setBlueSpawn")) {
                // Call the setBlueSpawn method
                setBlueSpawn(player);
            }

            // Check if the argument is "setRedSpawn"
            else if (Objects.equals(firstArgument, "setRedSpawn")) {
                // Call the setRedSpawn method
                setRedSpawn(player);
            }

            else {
                // Send a message to the player
                player.sendMessage(ChatColor.RED + "Invalid argument: " + firstArgument);
            }

        } else {
            // Send a message to the console
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Only players can use this command!");
        }

        // Return true to indicate that the command was successful
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            // Provide suggestions for the first argument
            List<String> suggestions = new ArrayList<>();
            suggestions.add("setBlueSpawn");
            suggestions.add("setRedSpawn");
            return suggestions;
        }
        // Return an empty list for other argument completions
        return new ArrayList<>();
    }

    private void setBlueSpawn(Player player) {
        // Get the player's location and save it to the config
        Location location = player.getLocation();
        CaptureTheFlag.getInstance().getStorageManager().getConfig().set("blueSpawn", location);
        // Save the config
        CaptureTheFlag.getInstance().getStorageManager().saveConfig();
        // Send a message to the player
        player.sendMessage(ChatColor.GREEN + "The blue spawn has been set!");
    }

    private void setRedSpawn(Player player) {
        // Get the player's location and save it to the config
        Location location = player.getLocation();
        CaptureTheFlag.getInstance().getStorageManager().getConfig().set("redSpawn", location);
        // Save the config
        CaptureTheFlag.getInstance().getStorageManager().saveConfig();
        // Send a message to the player
        player.sendMessage(ChatColor.GREEN + "The red spawn has been set!");
    }
}
