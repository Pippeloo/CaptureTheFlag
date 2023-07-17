package org.pippeloo.capturetheflag.chat;

import org.bukkit.Color;
import org.bukkit.entity.Player;

public class ChatLogger {
    private String prefix;
    private Color prefixColor;
    private Color goodColor;
    private Color badColor;
    private Color normalColor;

    public ChatLogger(String prefix) {
        this.prefix = prefix;
        this.prefixColor = Color.WHITE;
        this.goodColor = Color.GREEN;
        this.badColor = Color.RED;
        this.normalColor = Color.WHITE;
    }

    public ChatLogger(String prefix, Color prefixColor, Color goodColor, Color badColor, Color normalColor) {
        this.prefix = prefix;
        this.prefixColor = prefixColor;
        this.goodColor = goodColor;
        this.badColor = badColor;
        this.normalColor = normalColor;
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
}
