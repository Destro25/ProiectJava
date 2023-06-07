import Collection.GraffitiSet;
import Customer.*;
import Marketplace.*;
import Products.*;
import Collection.SkinCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Service {
    private static Service singleInstance = null;

    Marketplace m;
    Connection con;
    Customer c1;

    String currentCust = "";
    Integer accountId = 0;

    public static synchronized Service getInstance() throws SQLException {
        if (singleInstance == null)
            singleInstance = new Service();

        return singleInstance;
    }

    private Service() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "root");

        m = new Marketplace();

        c1 = new Customer("admin", "admin");
        c1.createCollection("Anubis",  "Steel Delta", 0.8f, "Sobek's Bite", 0.9f, "ScaraB Rush", 0.9f, "Ramese's Reach", 1.0f, "Black Nile", 0.5f, "Eye of Horus", 0.3f, "Scepter of Ra", 0.01f, m);
        c1.createGraffitiSet("Vertigo", "Defused", 100, "Info Giver", 50, "Smoked out", 150, "Entry Man", 100, "Maxed Out", 30, m);

        m.customers.add(c1);
    }

    public String getCurrentCust() {
        return currentCust;
    }

    public void setCurrentCust(String currentCust) {
        this.currentCust = currentCust;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void addACustomer(String email, String accountName)
    {
        currentCust = accountName;

        Customer t = new Customer(email, accountName);
        accountId = t.getAccountId();

        m.customers.add(t);
    }

    public Integer testEmail(Integer id, String email)
    {
        if(!m.findCustEmailById(id).equals(email))
        {
            throw new RuntimeException();
        }
        return 5;
    }
    public void removeACustomer(String email)
    {
        Customer temp = new Customer(email, currentCust);

        for(Customer c : m.customers)
        {
            if (c == temp)
            {
                if(c.getProductsInventory().size()>0)
                {
                    for(Product p : c.getProductsInventory())
                    {
                        p.setOwnerId(1);
                    }
                }
            }
        }

        for(SkinCollection s : m.skinCollections)
        {
            if(s.creatorId == accountId)
            {
                s.setCreatorId(1);
            }
        }

        for(GraffitiSet g : m.graffitiSets)
        {
            if(g.creatorId == accountId)
            {
                g.setCreatorId(1);
            }
        }

        m.customers.remove(temp);
        currentCust = "";
        accountId = 0;
        System.out.println("Your account was succesfully deleted!");
    }

    public void login(String email)
    {
        for (Customer c : m.customers)
        {
            if (c.getEmail().equals(email))
            {
                currentCust = c.getAccountName();
                accountId = c.getAccountId();
                System.out.println("Hello " + currentCust + "!");
            }
        }
    }

    public void logout()
    {
        System.out.println("Goodbye " + currentCust + "!");
        currentCust = "";
        accountId = 0;
    }

    public Float getAccountBalance()
    {
        Float Balance = 0f;
        for (Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                Balance = c.getBalance();
            }
        }
        return Balance;
    }

    public void addOrWithdraw(String depwith, String dep)
    {
        for (Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                if (depwith.equals("1"))
                {
                    Float newBal = c.getBalance() + Float.parseFloat(dep);
                    c.setBalance(newBal);
                } else if (depwith.equals("2")) {

                    float newBal = c.getBalance() - Float.parseFloat(dep);
                    if(newBal > 0.0f)
                    {
                        c.setBalance(newBal);
                    }else {
                        System.out.println("Insufficient funds! ");
                    }
                }
            }
        }
    }

    public void createASkinCollection(String collectionName, String machineGunSkin, Float floatCapMachineGunSkin, String shotgunSkin, Float floatCapShotgunSkin, String smgSkin, Float floatCapSmgSkin, String pistolSkin, Float floatCapPistolSkin, String sniperRifleSkin, Float floatCapSniperRifleSkin, String rifleSkin, Float floatCapRifleSkin, String knifeSkin, Float floatCapKnifeSkin)
    {
        for (Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                c.createCollection(collectionName, machineGunSkin, floatCapMachineGunSkin, shotgunSkin, floatCapShotgunSkin, smgSkin, floatCapSmgSkin, pistolSkin, floatCapPistolSkin, sniperRifleSkin, floatCapSniperRifleSkin, rifleSkin, floatCapRifleSkin, knifeSkin, floatCapKnifeSkin, m);
                c.setBalance(c.getBalance()-100f);
            }
        }
    }

    public void createAGraffitiSet(String graffitiSetName, String support, Integer numberOfUsesSupport, String leader, Integer numberOfUsesLeader, String ninja, Integer numberOfUsesNinja, String fragger, Integer numberOfUsesFragger, String bot, Integer numberOfUsesBot)
    {
        for(Customer c: m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                c.createGraffitiSet(graffitiSetName, support, numberOfUsesSupport, leader, numberOfUsesLeader, ninja, numberOfUsesNinja, fragger, numberOfUsesFragger, bot, numberOfUsesBot, m);
                c.setBalance(c.getBalance()-20f);
            }
        }
    }

    public void playAccountGame()
    {
        for(Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                c.playAGame(m);
            }
        }
    }

    public Integer showAccountContainers()
    {
        int conts = 0;
        for(Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                for (Product p : c.getProductsInventory())
                {
                    if (p instanceof Container) {
                        System.out.println(p);
                        conts++;
                    }
                }
            }
        }
        return conts;
    }

    public void accountOpenContainer(Integer id)
    {
        for(Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                int conts = 0;
                for(Product p : c.getProductsInventory())
                {
                    if(p instanceof Container)
                    {
                        conts++;
                    }
                }
                if (conts > 0)
                {
                    if (id != 0)
                    {
                        if(c.getBalance() > 2f)
                        {
                            Container cont = null;
                            for(Product p : c.getProductsInventory())
                            {
                                if (p.getProductId() == id)
                                {
                                    cont = (Container) p;
                                }
                            }
                            Skin s = cont.openContainer();
                            System.out.println("Congratulations! You got: " + s);
                            c.addASkin(s);
                            c.removeProduct(id);
                            c.setBalance(c.getBalance()-2f);
                        }
                        else
                        {
                            System.out.println("Insufficient funds!");
                        }
                    }
                }
            }
        }
    }

    public void showAccountProducts()
    {
        for(Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                for (Product p : c.getProductsInventory())
                {
                    System.out.println(p);
                }
            }
        }
    }

    public void sellAccountProduct(Integer id, Float pret)
    {
        for(Customer c : m.customers)
        {
            if(c.getAccountId()==accountId)
            {
                if (id != 0)
                {
                    Product prd = null;

                    for(Product p : c.getProductsInventory())
                    {
                        if (p.getProductId() == id)
                        {
                            prd = p;
                        }
                    }

                    prd.setPrice(pret);
                    m.addToMarket(prd);
                    c.removeProduct(id);
                }
            }
        }
    }

    public void showMarketProducts()
    {
        Collections.sort(m.productsForPurchase);
        for (Product p : m.productsForPurchase)
        {
            System.out.println(p + " cost: " + p.getPrice().toString());
        }
    }

    public void buyTheItem(Integer id)
    {
        for(Customer c : m.customers)
        {
            if (c.getAccountId() == accountId)
            {
                Product prd = null;

                if (id != 0)
                {
                    for(Product p : m.productsForPurchase)
                    {
                        if (p.getProductId() == id)
                        {
                            prd = p;
                        }
                    }

                    if(c.getBalance() > prd.getPrice())
                    {
                        c.setBalance(c.getBalance()-prd.getPrice());
                        m.addProfit(0.03f * prd.getPrice());

                        Customer own = m.findCustById(prd.ownerId);
                        own.setBalance(own.getBalance() + 0.9f * prd.getPrice());

                        Customer desig = m.findCustById(m.findDesignerIdByProductId(prd.getProductId()));
                        desig.setBalance(desig.getBalance() + 0.07f * prd.getPrice());

                        prd.setOwnerId(c.getAccountId());
                        c.addAProduct(prd);

                        m.removeItemFromMarket(prd);
                        System.out.println("Exchange finnalized!");
                    }
                    else
                    {
                        System.out.println("Insufficient funds!");
                    }
                }
            }
        }
    }

    public void showTheCustomers()
    {
        System.out.println(m.customers);
    }

    public void checkForEmail(String email)
    {
        for(Customer c : m.customers)
        {
            if(c.getEmail().equals(email))
                throw new RuntimeException();
        }
    }

    public Float profidMade()
    {
        return m.getProfitMade();
    }
}




