package org.pippeloo.capturetheflag.chat;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatLogger {
    private final String prefix;
    private final Color prefixColor;
    private final Color goodColor;
    private final Color badColor;
    private final Color normalColor;
    private final ConsoleCommandSender console;

    public ChatLogger(String prefix) {
        this.prefix = prefix;
        this.prefixColor = Color.WHITE;
        this.goodColor = Color.GREEN;
        this.badColor = Color.RED;
        this.normalColor = Color.WHITE;
        this.console = Bukkit.getConsoleSender();
    }

    public ChatLogger(String prefix, Color prefixColor, Color goodColor, Color badColor, Color normalColor) {
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
