package com.trsoftware.shopx.managers;

import com.trsoftware.shopx.ShopX;
import com.trsoftware.shopx.objects.ShopObj;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    /*
    Load each of the items into the inventory of the specific shop
    Required fields:
    - Item
    - Action (Buy, Sell, Command, Jump (Into other shop), Back, Close)

    Optional Fields:
    - Name
    - Lore
    - Enchantments
    - Buy Price (0 by default)
    - Sell Price (0 by default)
     */
    public void loadInventory(String shopId) {
        for(String slot : plugin.getConfig().getConfigurationSection("shops." + shopId + ".inventory").getKeys(false)) {
            String path = "shops." + shopId + ".inventory" + slot;
            ItemStack item = new ItemStack(Material.getMaterial(plugin.getConfig().getString(path + ".item")));
            String action = "";

            if(plugin.st.verifySupportedAction(plugin.getConfig().getString(path + ".action"))) {
                action = plugin.getConfig().getString(path + ".action");
            } else {
                // This is a fail safe for if the "action" field is not set
                // If it's not set or unsupported, the item will not be set
                continue;
            }

            ItemMeta itemMeta = item.getItemMeta();
            // If there is a custom name set, then apply it
            if(plugin.getConfig().contains(path + ".name")) {
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(path + ".name")));
            }

            ArrayList<String> itemLore = new ArrayList<>();
            for(String lore : plugin.getConfig().getStringList(path + ".lore")) {
                itemLore.add(lore);
            }
            itemMeta.setLore(itemLore);

            //TODO Add enchantments

        }
    }

    public void openShop(Player p, String shopId) {
        //TODO Add message? Maybe? Keep track of which shop they're in? (sub shop, item, or main)
        p.openInventory(plugin.st.getShopById(shopId).getInv());
    }

}
