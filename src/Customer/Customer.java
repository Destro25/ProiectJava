package Customer;

import Collection.GraffitiSet;
import Collection.SkinCollection;
import Marketplace.Marketplace;
import Products.*;

import java.util.ArrayList;
import java.util.Random;


public class Customer {
    private static Integer uniqueAccId = 1;
    private Integer accountId;
    private String email;
    private String password;
    private Float balance = 0.0F;

    private ArrayList<Product> productsInventory = new ArrayList<Product>();

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

    public void createGraffitiSet(String graffitiSetName, String support, Integer numberOfUsesSupport, String leader, Integer numberOfUsesLeader, String ninja, Integer numberOfUsesNinja, String fragger, Integer numberOfUsesFragger, String bot, Integer numberOfUsesBot, Marketplace m)
    {
        GraffitiSet g = new GraffitiSet(graffitiSetName, accountId, support, numberOfUsesSupport, leader, numberOfUsesLeader, ninja, numberOfUsesNinja, fragger, numberOfUsesFragger, bot, numberOfUsesBot);
        m.marketGraffitiSet(g);
    }
    public void showInventory(){
        System.out.println(productsInventory);
    }

    public void addBalance(float Balance)
    {
        balance = balance + Balance;
    }

    public void withdrawBalance(float Balance)
    {
        balance = balance - Balance;
    }

    public void playAGame(Marketplace m)
    {
        long start = System.nanoTime();

        while (System.nanoTime() - start < 500000000L) {}

        float rand = (float) Math.random();

        if (rand < 0.2f)
        {
            int size = m.skinCollections.size();
            int item = new Random().nextInt(size);
            int i = 0;
            for(SkinCollection s : m.skinCollections)
            {
                if(i == item)
                {
                    Container c = new Container(accountId, s);
                    productsInventory.add(c);
                    break;
                }
                i++;
            }
        }
        else
        {
            int size = m.graffitiSets.size();
            int item = new Random().nextInt(size);
            int i = 0;
            for(GraffitiSet g : m.graffitiSets)
            {
                if(i == item)
                {
                    Graffiti c = new Graffiti(accountId, g);
                    productsInventory.add(c);
                    break;
                }
                i++;
            }
        }
    }
}
