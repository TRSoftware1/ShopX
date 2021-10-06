package com.trsoftware.shopx;

import com.trsoftware.shopx.commands.ShopCommand;
import com.trsoftware.shopx.managers.ShopManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ShopX extends JavaPlugin {

    public ShopX plugin;

    public ShopCommand sc;

    public ShopManager sm;

    public File messages = new File("plugins/ShopX/", "messages.yml");
    public FileConfiguration pmessages = YamlConfiguration.loadConfiguration(messages);

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveDefaultMessages();
        reloadMessages();

        doInitiate();
    }

    @Override
    public void onDisable() {
        doUnInitiate();
    }

    private void doInitiate() {
        plugin = this;

        sc = new ShopCommand(this);

        sm = new ShopManager(this);
    }

    private void doUnInitiate() {
        plugin = null;

        sc = null;

        sm = null;
    }

    public void saveDefaultMessages() {
        try {
            saveResource("messages.yml", false);
        } catch (Exception e) {

        }
    }

    /*
     * The reloadMessages() method just prevents an error stemming from the first use after file generation
     */

    public void reloadMessages() {
        pmessages = YamlConfiguration.loadConfiguration(messages);
    }

    public void sendMessage(Player p, String s) {
        if(s.equalsIgnoreCase("")) {
            return;
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public void sendMessageToConsole(CommandSender sender, String s) {
        if(s.equalsIgnoreCase("")) {
            return;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

}
