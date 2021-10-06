package com.trsoftware.shopx.managers;

import com.trsoftware.shopx.ShopX;
import com.trsoftware.shopx.objects.ShopObj;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class ShopManager {

    public ShopX plugin;

    public ShopManager(ShopX pl) {
        plugin = pl;
    }

    public ArrayList<ShopObj> shopList = new ArrayList<>();

    public void loadShopList() {
        for(String key : plugin.getConfig().getConfigurationSection("shops").getKeys(false)) {

            Inventory inv = Bukkit.createInventory(null,
                    plugin.getConfig().getInt("shops." + key + ".size"),
                    plugin.getConfig().getString("shops." + key + ".title"));

            for(String slot : plugin.getConfig().getConfigurationSection("shops." + key + ".inventory").getKeys(false)) {
                //TODO create inventory items
            }

            shopList.add(
                    new ShopObj(key,
                            plugin.getConfig().getString("shops." + key + ".title"),
                            inv,
                            plugin.getConfig().getInt("shops." + key + ".size")));
        }
    }

    public void openShop(ShopObj shop) {
        //TODO Open inventory from the specified ShopObj
    }

}
