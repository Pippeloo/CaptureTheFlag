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
import org.pippeloo.capturetheflag.chat.ChatLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaptureTheFlagCommand implements CommandExecutor, TabCompleter {

    private final ChatLogger chatLogger;

    public CaptureTheFlagCommand() {
        this.chatLogger = CaptureTheFlag.getInstance().getChatLogger();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if a player is sending the command
        if (sender instanceof Player) {
            // Check if the first and second argument are given
            if (args.length < 2) {
                // Send a message to the player
                chatLogger.chatBad((Player) sender, "No arguments given!");
                // Return true to indicate that the command was successful
                return true;
            }

            // Get the first argument
            String firstArgument = args[0];
            // Get the second argument
            String secondArgument = args[1];
            // Cast the sender to a player
            Player player = (Player) sender;

            // Check if the argument is "setBlueSpawn"
            if (Objects.equals(firstArgument, "setSpawn")) {
                verifyAndExecuteFunction(player, secondArgument, "setSpawn");
            }

            // Check if the argument is "setBlueEntrance"
            else if (Objects.equals(firstArgument, "setEntrance")) {
                verifyAndExecuteFunction(player, secondArgument, "setEntrance");
            }

            // Check if the argument is "setBlueFlag"
            else if (Objects.equals(firstArgument, "setFlag")) {
                verifyAndExecuteFunction(player, secondArgument, "setFlag");
            }

            else {
                // Send a message to the player
                chatLogger.chatBad(player, "Invalid argument: " + firstArgument);
            }

        } else {
            // Send a message to the console
            chatLogger.consoleBad("Only players can use this command!");
        }

        // Return true to indicate that the command was successful
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            // Provide suggestions for the first argument
            List<String> suggestions = new ArrayList<>();
            suggestions.add("setSpawn");
            suggestions.add("setEntrance");
            suggestions.add("setFlag");
            return suggestions;
        }

        if (args.length == 2) {
            // Provide suggestions for the second argument
            List<String> suggestions = new ArrayList<>();
            suggestions.add("blue");
            suggestions.add("red");
            return suggestions;
        }
        // Return an empty list for other argument completions
        return new ArrayList<>();
    }

    private void verifyAndExecuteFunction(Player player, String team, String function) {
        if (isTeam(team)) {
            switch (function) {
                case "setSpawn":
                    setSpawn(player, team);
                    break;
                case "setEntrance":
                    setEntrance(player, team);
                    break;
                case "setFlag":
                    setFlag(player, team);
                    break;
                default:
                    chatLogger.chatBad(player, "Invalid function: " + function);
                    break;
            }
        } else {
            chatLogger.chatBad(player, "Invalid team: " + team);
        }
    }

    private void setSpawn(Player player, String team) {
        // Get the player's location and save it to the config
        Location location = player.getLocation();

        String teamSpawn = team + "Spawn";
        CaptureTheFlag.getInstance().getStorageManager().getConfig().set(teamSpawn, location);
        // Save the config
        CaptureTheFlag.getInstance().getStorageManager().saveConfig();

        // Send a message to the player
        chatLogger.chatGood(player, "The spawn for team " + team + " has been set!");
    }

    private void setEntrance(Player player, String team) {
        // Get the player's location and save it to the config
        Location location = player.getLocation();

        String teamEntrance = team + "Entrance";
        CaptureTheFlag.getInstance().getStorageManager().getConfig().set(teamEntrance, location);
        // Save the config
        CaptureTheFlag.getInstance().getStorageManager().saveConfig();

        // Send a message to the player
        chatLogger.chatGood(player, "The entrance for team " + team + " has been set!");
    }
    private void setFlag(Player player, String team) {
        // Get the player's location and save it to the config
        Location location = player.getLocation();

        String teamFlag = team + "Flag";
        CaptureTheFlag.getInstance().getStorageManager().getConfig().set(teamFlag, location);
        // Save the config
        CaptureTheFlag.getInstance().getStorageManager().saveConfig();

        // Send a message to the player
        chatLogger.chatGood(player, "The flag for team " + team + " has been set!");
    }

    private Boolean isTeam(String team) {
        return Objects.equals(team, "blue") || Objects.equals(team, "red");
    }
}
