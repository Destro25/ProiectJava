package Customer;

import Collection.SkinCollection;
import Marketplace.Marketplace;
import Products.*;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static Integer uniqueAccId = 1;
    private Integer accountId;
    private String email;
    private String password;
    private Float balance = 0.0F;

    private List<Product> productsInventory = new ArrayList<Product>();

    public Customer(String email, String password) {
        this.accountId = uniqueAccId++;
        this.email = email;
        this.password = password;
    }

    public void depositProduct(Product p){
        productsInventory.add(p);
    }

    public void putProductForSale(Integer i, Marketplace m) {
        Product p = productsInventory.get(i);
        productsInventory.remove(p);
        m.addToMarket(p);
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void createCollection(String collectionName, String machineGunSkin, float floatCapMachineGunSkin, String shotgunSkin, float floatCapShotgunSkin, String smgSkin, float floatCapSmgSkin, String pistolSkin, float floatCapPistolSkin, String sniperRifleSkin, float floatCapSniperRifleSkin, String rifleSkin, float floatCapRifleSkin, String knifeSkin, float floatCapKnifeSkin, Marketplace m)
    {
        SkinCollection c = new SkinCollection(collectionName, accountId, machineGunSkin, floatCapMachineGunSkin, shotgunSkin, floatCapShotgunSkin, smgSkin, floatCapSmgSkin, pistolSkin, floatCapPistolSkin, sniperRifleSkin, floatCapSniperRifleSkin, rifleSkin, floatCapRifleSkin, knifeSkin, floatCapKnifeSkin);
        m.marketCollection(c);
    }


    public void showInventory(){
        System.out.println(productsInventory);
    }
}
