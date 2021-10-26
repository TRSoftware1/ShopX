package com.trsoftware.shopx.objects.tools;

import com.trsoftware.shopx.ShopX;
import com.trsoftware.shopx.objects.ShopObj;

public class ShopTools {

    public final String[] supportedActions = {"buy", "sell", "command", "jump", "back"};

    public ShopX plugin;

    public ShopTools(ShopX pl) {
        plugin = pl;
    }

    public ShopObj getShopById(String shopId) {
        for(int i = 0; i < plugin.sm.shopList.size(); i++) {
            if(plugin.sm.shopList.get(i).getId().equalsIgnoreCase(shopId)) {
                return plugin.sm.shopList.get(i);
            }
        }
        return null;
    }

    public boolean verifySupportedAction(String action) {
        for(int i = 0; i < supportedActions.length; i++) {
            if(supportedActions[i].equalsIgnoreCase(action)) {
                return true;
            }
        }
        return false;
    }

}
