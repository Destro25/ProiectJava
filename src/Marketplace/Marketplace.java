package Marketplace;

import Customer.Customer;
import Products.*;
import Collection.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Marketplace {

    private static Marketplace single_instance = null;
    public Integer exchangesEffectuated;

    private Float profitMade = 0.0f;

    public Set<Customer> customers = new HashSet<Customer>();
    public ArrayList<Product> productsForPurchase = new ArrayList<Product>();

    public Set<SkinCollection> skinCollections = new HashSet<SkinCollection>();

    public Set<GraffitiSet> graffitiSets = new HashSet<GraffitiSet>();

    public void addToMarket(Product p){
        productsForPurchase.add(p);
    }

    public void marketCollection(SkinCollection c){
        skinCollections.add(c);
    }

    public void addProfit(Float f)
    {
        profitMade = profitMade + f;
    }

    public void marketGraffitiSet(GraffitiSet g) {graffitiSets.add(g); }

    private static synchronized Marketplace getInstance()
    {
        if(single_instance == null)
            single_instance = new Marketplace();

        return single_instance;
    }

    public void showMarketplace(){
        System.out.println(productsForPurchase);
    }

    public Customer findCustById(Integer id)
    {
        Customer cus = null;
        for(Customer c : customers)
        {
            if (c.getAccountId() == id)
            {
                cus = c;
            }
        }
        return cus;
    }

    public Integer findDesignerIdByProductId(Integer id)
    {
        Integer idus = 0;
        for(Product p : productsForPurchase)
        {
            if(p.getProductId() == id)
            {
                if(p instanceof Container)
                {
                    idus = ((Container) p).skinCollection.creatorId;
                } else if (p instanceof Skin) {
                    idus = ((Skin) p).skinCollection.creatorId;
                } else if (p instanceof Graffiti) {
                    idus = ((Graffiti) p).graffitiSet.creatorId;
                }
            }
        }
        return idus;
    }

    public void removeItemFromMarket(Product p)
    {
        productsForPurchase.remove(p);
    }
}
