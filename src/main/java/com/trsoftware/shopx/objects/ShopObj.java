package com.trsoftware.shopx.objects;

import org.bukkit.inventory.Inventory;

public class ShopObj {

    private String id;
    private String title;
    private Inventory inv;
    private int size;

    public ShopObj(String sId, String sTitle, Inventory sInv, int sSize) {
        setId(sId);
        setTitle(sTitle);
        setInv(sInv);
        setSize(sSize);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
