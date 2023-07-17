package org.pippeloo.capturetheflag.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pippeloo.capturetheflag.CaptureTheFlag;
import org.pippeloo.capturetheflag.chat.ChatLogger;

public class SetHubCommand implements CommandExecutor {

    private final ChatLogger chatLogger;

    public SetHubCommand() {
        this.chatLogger = CaptureTheFlag.getInstance().getChatLogger();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a player is sending the command
        if (sender instanceof Player) {
            // Cast the sender to a player
            Player player = (Player) sender;
            // Get the player's location and save it to the config
            Location location = player.getLocation();
            CaptureTheFlag.getInstance().getStorageManager().getConfig().set("hub", location);
            // Save the config
            CaptureTheFlag.getInstance().getStorageManager().saveConfig();
            // Send a message to the player
            chatLogger.chatGood(player, "The hub has been set!");
        } else {
            // Send a message to the console
            chatLogger.consoleBad("Only players can use this command!");
        }
        // Return true to indicate that the command was successful
        return true;
    }
}
