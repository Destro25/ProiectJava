import Collection.GraffitiSet;
import Customer.*;
import Marketplace.*;
import Products.*;
import Collection.SkinCollection;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;


        Marketplace m = new Marketplace();

        Customer c1 = new Customer("0", "0");
        c1.createCollection("Anubis",  "Steel Delta", 0.8f, "sg", 0.9f, "ScaraB Rush", 0.9f, "Ramese's Reach", 1.0f, "Black Nile", 0.5f, "Eye of Horus", 0.3f, "Scepter of Ra", 0.01f, m);
        c1.createGraffitiSet("Vertigo", "Defused", 100, "Info Giver", 50, "Smoked out", 150, "Entry Man", 100, "Maxed Out", 30, m);


        //m.showMarketplace();
        //c1.showInventory();
        //System.out.println(c1.getAccountId());

        //System.out.println(m.skinCollections);

        String currentCust = "";
        Integer accountId = 0;

        System.out.println("The available commands are:");
        System.out.println("0. Show commands list.");
        System.out.println("1. Create a customer.");
        System.out.println("2. Select existing customer/logout.");
        System.out.println("3. Deposit/withdraw funds.");
        System.out.println("4. Create a Skin Collection.");
        System.out.println("5. Create a Graffiti Set.");
        System.out.println("6. Play the game.");
        System.out.println("7. Open a container.");
        System.out.println("8. List a product for sale.");
        System.out.println("9. Buy a product from the marketplace.");
        System.out.println("10. See account operations.");
        System.out.println("11. List all customers.");
        System.out.println("12. Exit.");

        do {
            System.out.println("Please choose a command: ");
            command = scanner.next();

            if (!currentCust.equals(""))
            {
                System.out.println("Hello " + currentCust + "!");
            }

            switch (command)
            {
                case "0":
                    if(currentCust.equals(""))
                    {
                        System.out.println("The available commands are:");
                        System.out.println("0. Show commands list.");
                        System.out.println("1. Create a customer.");
                        System.out.println("2. Select existing customer/logout.");
                        System.out.println("3. Deposit/withdraw funds.");
                        System.out.println("4. Create a Skin Collection.");
                        System.out.println("5. Create a Graffiti Set.");
                        System.out.println("6. Play the game.");
                        System.out.println("7. Open a container.");
                        System.out.println("8. List a product for sale.");
                        System.out.println("9. Buy a product from the marketplace.");
                        System.out.println("10. See account operations.");
                        System.out.println("11. List all customers.");
                        System.out.println("12. Exit.");
                    }
                    else {
                        System.out.println("The available commands are:");
                        System.out.println("0. Show commands list.");
                        System.out.println("1. Delete Account.");
                        System.out.println("2. Select existing customer/logout.");
                        System.out.println("3. Deposit/withdraw funds.");
                        System.out.println("4. Create a Skin Collection.");
                        System.out.println("5. Create a Graffiti Set.");
                        System.out.println("6. Play the game.");
                        System.out.println("7. Open a container.");
                        System.out.println("8. List a product for sale.");
                        System.out.println("9. Buy a product from the marketplace.");
                        System.out.println("10. See account operations.");
                        System.out.println("11. Exit.");
                    }
                    break;

                case "1":
                    if (currentCust.equals(""))
                    {
                        System.out.println("Email: ");
                        String email = scanner.next();

                        System.out.println("Account name: ");
                        String name = scanner.next();
                        currentCust = name;

                        Customer t = new Customer(email, name);
                        accountId = t.getAccountId();

                        m.customers.add(t);
                    }
                    else
                    {
                        System.out.println("Introduce email to delete: ");
                        String email = scanner.next();

                        Customer temp = new Customer(email, currentCust);
                        m.customers.remove(temp);
                    }
                    break;

                case "2":
                    if(currentCust.equals(""))
                    {
                        System.out.println("Email: ");
                        String email = scanner.next();

                        for (Customer c : m.customers)
                        {
                            if (c.getEmail().equals(email))
                            {
                                currentCust = c.getAccountName();
                                accountId = c.getAccountId();

                            }
                        }
                    }else {
                        currentCust = "";
                        accountId = 0;
                    }
                    break;

                case "3":
                    if (accountId != 0)
                    {
                        for (Customer c : m.customers)
                        {
                            if (c.getAccountId() == accountId)
                            {
                                System.out.println("Your balance is: " + c.getBalance());
                                System.out.println("If you would like to deposit choose 1. ");
                                System.out.println("If you would like to withdraw choose 2. ");
                                String depwith = scanner.next();
                                if (depwith.equals("1")){
                                    System.out.println("Introduce the sum you would like to deposit: ");
                                    String dep = scanner.next();
                                    Float newBal = c.getBalance() + Float.parseFloat(dep);
                                    c.setBalance(newBal);
                                } else if (depwith.equals("2")) {
                                    System.out.println("Introduce the sum you would like to withdraw: ");
                                    String with = scanner.next();
                                    Float newBal = c.getBalance() - Float.parseFloat(with);
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
                    else
                    {
                        System.out.println("Please create an account, or login!");
                    }
                    break;

                case "4":
                    if(accountId != 0)
                    {
                        for (Customer c : m.customers)
                        {
                            if (c.getAccountId() == accountId)
                            {
                                System.out.println("To create a skin collection it costs 100. Everytime someone buys a skin from the marketplace that is from the collection you made, you will get 7% of the price of the transaction.");
                                System.out.println("If you would like to continue choose 1. ");
                                String cont = scanner.next();
                                if (cont.equals("1"))
                                {
                                    if(c.getBalance() < 100f)
                                    {
                                        System.out.println("Insufficient funds!");
                                    }
                                    else
                                    {
                                        System.out.println("Please choose a collection name: ");
                                        String collectionName = scanner.next();

                                        System.out.println("Please choose a machine gun skin: ");
                                        String machineGunSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the machine gun skin: ");
                                        float floatCapMachineGunSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a shotgun skin: ");
                                        String shotgunSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the shotgun skin: ");
                                        float floatCapShotgunSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a smg skin: ");
                                        String smgSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the smg skin: ");
                                        float floatCapSmgSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a pistol skin: ");
                                        String pistolSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the pistol skin: ");
                                        float floatCapPistolSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a sniper rifle skin: ");
                                        String sniperRifleSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the sniper rifle skin: ");
                                        float floatCapSniperRifleSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a rifle skin: ");
                                        String rifleSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the rifle skin: ");
                                        float floatCapRifleSkin = Float.parseFloat(scanner.next());

                                        System.out.println("Please choose a knife skin: ");
                                        String knifeSkin = scanner.next();

                                        System.out.println("Please choose a float cap for the knife skin: ");
                                        float floatCapKnifeSkin = Float.parseFloat(scanner.next());

                                        c.createCollection(collectionName, machineGunSkin, floatCapMachineGunSkin, shotgunSkin, floatCapShotgunSkin, smgSkin, floatCapSmgSkin, pistolSkin, floatCapPistolSkin, sniperRifleSkin, floatCapSniperRifleSkin, rifleSkin, floatCapRifleSkin, knifeSkin, floatCapKnifeSkin, m);
                                        c.setBalance(c.getBalance()-100f);
                                    }
                                }
                            }
                        }
                    }else
                    {
                        System.out.println("Please create an account, or login!");
                    }
                    break;

                case "5":
                    if (accountId != 0)
                    {
                        for(Customer c: m.customers)
                        {
                            if (c.getAccountId() == accountId)
                            {
                                System.out.println("To create a graffiti set it costs 20. Everytime someone buys a graffiti from the marketplace that is from the collection you made, you will get 7% of the price of the transaction.");
                                System.out.println("If you would like to continue choose 1. ");
                                String cont = scanner.next();

                                if (cont.equals("1"))
                                {
                                    if(c.getBalance() < 20f)
                                    {
                                        System.out.println("Insufficient funds!");
                                    }
                                    else
                                    {
                                        System.out.println("Please choose a graffiti set name: ");
                                        String graffitiSetName = scanner.next();

                                        System.out.println("Please choose a support style graffiti: ");
                                        String support = scanner.next();

                                        System.out.println("Please choose the number of uses for the support graffiti: ");
                                        Integer numberOfUsesSupport = Integer.parseInt(scanner.next());

                                        System.out.println("Please choose a leader style graffiti: ");
                                        String leader = scanner.next();

                                        System.out.println("Please choose the number of uses for the leader graffiti: ");
                                        Integer numberOfUsesLeader = Integer.parseInt(scanner.next());

                                        System.out.println("Please choose a ninja style graffiti: ");
                                        String ninja = scanner.next();

                                        System.out.println("Please choose the number of uses for the ninja graffiti: ");
                                        Integer numberOfUsesNinja = Integer.parseInt(scanner.next());

                                        System.out.println("Please choose a fragger style graffiti: ");
                                        String fragger = scanner.next();

                                        System.out.println("Please choose the number of uses for the fragger graffiti: ");
                                        Integer numberOfUsesFragger = Integer.parseInt(scanner.next());

                                        System.out.println("Please choose a bot style graffiti: ");
                                        String bot = scanner.next();

                                        System.out.println("Please choose the number of uses for the bot graffiti: ");
                                        Integer numberOfUsesBot = Integer.parseInt(scanner.next());

                                        c.createGraffitiSet(graffitiSetName, support, numberOfUsesSupport, leader, numberOfUsesLeader, ninja, numberOfUsesNinja, fragger, numberOfUsesFragger, bot, numberOfUsesBot, m);
                                        c.setBalance(c.getBalance()-20f);
                                    }
                                }
                            }
                        }
                    }else
                    {
                        System.out.println("Please create an account, or login!");
                    }
                    break;
                case "6":
                    if(accountId != 0)
                    {
                        for(Customer c : m.customers)
                        {
                            if (c.getAccountId() == accountId)
                            {
                                c.playAGame(m);
                            }
                        }
                    }else
                    {
                        System.out.println("Please create an account, or login!");
                    }
                    break;

                case "7":
                    if(accountId != 0)
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
                                        System.out.println(p);
                                        conts++;
                                    }
                                }
                                if (conts > 0)
                                {
                                    System.out.println("Those are your avalible containers. To open a container it costs 2. Please choose the id of the container you would like to open, or 0 to go back: ");
                                    Integer id = Integer.parseInt(scanner.next());

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
                    }else
                    {
                        System.out.println("Please create an account, or login!");
                    }
                    break;
                case "11":
                    System.out.println(m.customers);
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }   while (!command.equals("12"));

        scanner.close();
    }
}