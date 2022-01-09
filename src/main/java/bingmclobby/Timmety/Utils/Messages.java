package bingmclobby.Timmety.Utils;

import org.bukkit.ChatColor;

public enum Messages {

    PREFIX("&8[&aBingoMC&8] &f"),
    GUI_SERVER_SELECTOR("Speel bingo"),
    GUI_SERVERS_SELECTOR("Bingo servers");

    private String message;

    Messages(String message) {
        this.message = ChatColor.translateAlternateColorCodes('&',message);
    }

    public String getMessage() {
        return message;
    }
}
