package me.Browk.qShop.Shop;

import org.bukkit.Material;

public class ShopItem {

    private Material material;
    private byte materialData;
    private double buyPrice;
    private double sellPrice;
    private String name;

    public ShopItem(Material material, byte materialData, double buyPrice, double sellPrice, String name) {
        this.material = material;
        this.materialData = materialData;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public byte getMaterialData() {
        return materialData;
    }

    public void setMaterialData(byte materialData) {
        this.materialData = materialData;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
