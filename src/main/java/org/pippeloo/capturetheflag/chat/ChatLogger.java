package org.pippeloo.capturetheflag.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatLogger {
    private final String prefix;
    private final ChatColor prefixColor;
    private final ChatColor goodColor;
    private final ChatColor badColor;
    private final ChatColor normalColor;
    private final ConsoleCommandSender console;

    public ChatLogger(String prefix) {
        this.prefix = prefix;
        this.prefixColor = ChatColor.WHITE;
        this.goodColor = ChatColor.GREEN;
        this.badColor = ChatColor.RED;
        this.normalColor = ChatColor.WHITE;
        this.console = Bukkit.getConsoleSender();
    }

    public ChatLogger(String prefix, ChatColor prefixColor, ChatColor goodColor, ChatColor badColor, ChatColor normalColor) {
        this.prefix = prefix;
        this.prefixColor = prefixColor;
        this.goodColor = goodColor;
        this.badColor = badColor;
        this.normalColor = normalColor;
        this.console = Bukkit.getConsoleSender();
    }

    public void chatGood(Player player, String message) {
        player.sendMessage(prefixColor + prefix + goodColor + message);
    }

    public void chatBad(Player player, String message) {
        player.sendMessage(prefixColor + prefix + badColor + message);
    }

    public void chatNormal(Player player, String message) {
        player.sendMessage(prefixColor + prefix + normalColor + message);
    }

    public void consoleGood(String message) {
        console.sendMessage(prefix + message);
    }

    public void consoleBad(String message) {
        console.sendMessage(prefix + message);
    }

    public void consoleNormal(String message) {
        console.sendMessage(prefix + message);
    }


}
