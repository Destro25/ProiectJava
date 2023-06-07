import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String command;

        Service service = Service.getInstance();

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
        System.out.println("10. List all customers.");
        System.out.println("11. Exit.");

        do {
            System.out.println("Please choose a command: ");
            command = scanner.next();


            switch (command) {
                case "0" -> {
                    if (service.getCurrentCust().equals("")) {
                        System.out.println("Admin mode!");
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
                        System.out.println("10. List all customers.");
                        System.out.println("11. Exit.");
                    } else {
                        System.out.println("User mode!");
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
                        System.out.println("10. Exit.");
                    }
                }
                case "1" -> {
                    if (service.getCurrentCust().equals("")) {
                        System.out.println("Email: ");
                        String email = scanner.next();

                        System.out.println("Account name: ");
                        String name = scanner.next();

                        try {
                            service.checkForEmail(email);
                            service.addACustomer(email, name);
                        } catch (RuntimeException e) {
                            System.out.println("There is already an account created with this email!");
                        }
                    } else {
                        System.out.println("Introduce your email to delete: ");
                        String email = scanner.next();

                        try {
                            if (service.testEmail(service.accountId, email) == 5) {
                                service.removeACustomer(email);
                            }

                        } catch (RuntimeException e) {
                            System.out.println("The email you introduced was wrong!");
                        }
                    }
                }
                case "2" -> {
                    if (service.getCurrentCust().equals("")) {
                        System.out.println("Email: ");
                        String email = scanner.next();

                        service.login(email);
                    } else {
                        service.logout();
                    }
                }
                case "3" -> {
                    if (service.getAccountId() != 0) {
                        System.out.println("Your balance is: " + service.getAccountBalance());
                        System.out.println("If you would like to deposit choose 1. ");
                        System.out.println("If you would like to withdraw choose 2. ");
                        String depwith = scanner.next();

                        System.out.println("Introduce the sum you would like to deposit or withdraw: ");
                        String dep = scanner.next();

                        try {
                            if (Integer.parseInt(dep) >= 0) {
                                service.addOrWithdraw(depwith, dep);
                            } else {
                                System.out.println("You cannot introduce negative balance!");
                            }
                        } catch (RuntimeException e) {
                            System.out.println("Invalid sum!");
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "4" -> {
                    if (service.getAccountId() != 0) {
                        System.out.println("To create a skin collection it costs 100. Everytime someone buys a skin from the marketplace that is from the collection you made, you will get 7% of the price of the transaction.");
                        System.out.println("If you would like to continue choose 1. ");
                        String cont = scanner.next();

                        if (cont.equals("1")) {
                            if (service.getAccountBalance() < 100f) {
                                System.out.println("Insufficient funds!");
                            } else {
                                try {
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

                                    if (floatCapMachineGunSkin < 0f || floatCapShotgunSkin < 0f || floatCapSmgSkin < 0f || floatCapPistolSkin < 0f || floatCapSniperRifleSkin < 0f || floatCapRifleSkin < 0f || floatCapKnifeSkin < 0f) {
                                        throw new RuntimeException();
                                    }

                                    service.createASkinCollection(collectionName, machineGunSkin, floatCapMachineGunSkin, shotgunSkin, floatCapShotgunSkin, smgSkin, floatCapSmgSkin, pistolSkin, floatCapPistolSkin, sniperRifleSkin, floatCapSniperRifleSkin, rifleSkin, floatCapRifleSkin, knifeSkin, floatCapKnifeSkin);
                                } catch (RuntimeException e) {
                                    System.out.println("The float value introduced was not valid!");
                                }
                            }
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "5" -> {
                    if (service.getAccountId() != 0) {
                        System.out.println("To create a graffiti set it costs 20. Everytime someone buys a graffiti from the marketplace that is from the collection you made, you will get 7% of the price of the transaction.");
                        System.out.println("If you would like to continue choose 1. ");
                        String cont = scanner.next();

                        if (cont.equals("1")) {
                            if (service.getAccountBalance() < 20f) {
                                System.out.println("Insufficient funds!");
                            } else {
                                try {
                                    System.out.println("Please choose a graffiti set name: ");
                                    String graffitiSetName = scanner.next();

                                    System.out.println("Please choose a support style graffiti: ");
                                    String support = scanner.next();

                                    System.out.println("Please choose the number of uses for the support graffiti: ");
                                    int numberOfUsesSupport = Integer.parseInt(scanner.next());

                                    System.out.println("Please choose a leader style graffiti: ");
                                    String leader = scanner.next();

                                    System.out.println("Please choose the number of uses for the leader graffiti: ");
                                    int numberOfUsesLeader = Integer.parseInt(scanner.next());

                                    System.out.println("Please choose a ninja style graffiti: ");
                                    String ninja = scanner.next();

                                    System.out.println("Please choose the number of uses for the ninja graffiti: ");
                                    int numberOfUsesNinja = Integer.parseInt(scanner.next());

                                    System.out.println("Please choose a fragger style graffiti: ");
                                    String fragger = scanner.next();

                                    System.out.println("Please choose the number of uses for the fragger graffiti: ");
                                    int numberOfUsesFragger = Integer.parseInt(scanner.next());

                                    System.out.println("Please choose a bot style graffiti: ");
                                    String bot = scanner.next();

                                    System.out.println("Please choose the number of uses for the bot graffiti: ");
                                    int numberOfUsesBot = Integer.parseInt(scanner.next());

                                    if (numberOfUsesBot < 0 || numberOfUsesFragger < 0 || numberOfUsesLeader < 0 || numberOfUsesNinja < 0 || numberOfUsesSupport < 0) {
                                        throw new RuntimeException();
                                    }

                                    service.createAGraffitiSet(graffitiSetName, support, numberOfUsesSupport, leader, numberOfUsesLeader, ninja, numberOfUsesNinja, fragger, numberOfUsesFragger, bot, numberOfUsesBot);
                                } catch (RuntimeException e) {
                                    System.out.println("The number of uses introduced are invalid!");
                                }
                            }
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "6" -> {
                    if (service.getAccountId() != 0) {
                        service.playAccountGame();
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "7" -> {
                    if (service.getAccountId() != 0) {
                        Integer conts = service.showAccountContainers();
                        if (conts > 0) {
                            System.out.println("Those are your avalible containers. To open a container it costs 2. Please choose the id of the container you would like to open, or 0 to go back: ");

                            try {
                                Integer id = Integer.parseInt(scanner.next());
                                service.accountOpenContainer(id);
                            } catch (RuntimeException e) {
                                System.out.println("The container Id introduced is not valid!");
                            }
                        } else {
                            System.out.println("You do not have any containers.");
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "8" -> {
                    if (service.getAccountId() != 0) {
                        service.showAccountProducts();
                        System.out.println("Those are the items you have in your inventory!");
                        System.out.println("Please select an id of an item you would like to sell, or 0 to go back.");

                        try {
                            int id = Integer.parseInt(scanner.next());

                            if (id != 0) {
                                System.out.println("The creator of the collection will get 7% of the asking price, and the market will get 3%.");
                                System.out.println("Choose a price for the item: ");

                                float pret = Float.parseFloat(scanner.next());

                                if (pret > 0f) {
                                    service.sellAccountProduct(id, pret);
                                } else {
                                    System.out.println("The price cannot be negative!");
                                }
                            }
                        } catch (RuntimeException e) {
                            System.out.println("There has been a problem putting your item for sale! Check the item id and the price.");
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "9" -> {
                    if (service.getAccountId() != 0) {
                        service.showMarketProducts();
                        System.out.println("Please choose the id of the item you would like to buy, or 0 to go back: ");

                        try {
                            Integer id = Integer.parseInt(scanner.next());
                            service.buyTheItem(id);
                        } catch (RuntimeException e) {
                            System.out.println("The id you introduced is invalid!");
                        }
                    } else {
                        System.out.println("Please create an account, or login!");
                    }
                }
                case "10" -> {
                    if (service.getAccountId() == 0) {
                        service.showTheCustomers();
                    } else {
                        command = "12";
                    }
                }
                case "11" -> command = "12";
                default -> System.out.println("Command not recognized. Returning to main menu.");
            }
        }   while (!command.equals("12"));

        scanner.close();
        System.out.println("Goodbye!");
        System.out.println("Profit made: " + service.profidMade());
    }
}