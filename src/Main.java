import Customer.*;
import Marketplace.*;
import Products.*;
import Collection.SkinCollection;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;


        Marketplace m = new Marketplace();


//        c1.createCollection("Anubis",  "mg", 0.8f, "sg", 0.9f, "smg", 0.9f, "pist", 1.0f, "snprf", 0.5f, "rfl", 0.3f, "knf", 0.01f, m);
//        c1.createGraffitiSet("Vertigo", "Defused", 100, "Info Giver", 50, "Smoked out", 150, "Entry Man", 100, "Maxed Out", 30, m);
//
//        c1.playAGame(m);
//        c1.playAGame(m);
//        c1.playAGame(m);
//        c1.playAGame(m);
//
//        c1.showInventory();

        //c1.putProductForSale(0, m);

        //m.showMarketplace();
        //c1.showInventory();
        //System.out.println(c1.getAccountId());

        //System.out.println(m.skinCollections);

        String currentCust = "";

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

                        m.customers.add(new Customer(email, name));
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
                    }

                case "11":
                    System.out.println(m.customers);

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }   while (!command.equals("12"));

        scanner.close();
    }
}