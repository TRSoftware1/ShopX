package com.trsoftware.shopx.commands;

import com.trsoftware.shopx.ShopX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ShopCommand implements CommandExecutor {

    public ShopX plugin;

    public ShopCommand(ShopX pl) {
        plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(cmd.getName().equalsIgnoreCase("shopx")) {
            switch (args.length) {
                default:
                    //TODO ShopManager.openShop(main)
                    break;
            }
        }

        return true;
    }
}
