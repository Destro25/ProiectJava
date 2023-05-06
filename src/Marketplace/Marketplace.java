package Marketplace;

import Products.*;
import Collection.SkinCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Marketplace {

    private static Marketplace single_instance = null;
    public Integer exchangesEffectuated;

    private Float profitMade;

    public List<Product> productsForPurchase = new ArrayList<Product>();

    public Set<SkinCollection> skinCollections = new HashSet<SkinCollection>();

    public void addToMarket(Product p){
        productsForPurchase.add(p);
    }

    public void marketCollection(SkinCollection c){
        skinCollections.add(c);
    }

    private static synchronized Marketplace getInstance()
    {
        if(single_instance == null)
            single_instance = new Marketplace();

        return single_instance;
    }

    public void showMarketplace(){
        System.out.println(productsForPurchase);
    }
}
