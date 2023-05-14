import Customer.*;
import Marketplace.*;
import Products.*;
import Collection.SkinCollection;


public class Main {
    public static void main(String[] args) {
        Marketplace m = new Marketplace();

        Customer c1 = new Customer( "j1", "3232");
        c1.createCollection("Anubis",  "mg", 0.8f, "sg", 0.9f, "smg", 0.9f, "pist", 1.0f, "snprf", 0.5f, "rfl", 0.3f, "knf", 0.01f, m);
        c1.createGraffitiSet("Vertigo", "Defused", 100, "Info Giver", 50, "Smoked out", 150, "Entry Man", 100, "Maxed Out", 30, m);

        c1.playAGame(m);
        c1.playAGame(m);
        c1.playAGame(m);
        c1.playAGame(m);

        c1.showInventory();

        //c1.putProductForSale(0, m);

        //m.showMarketplace();
        //c1.showInventory();
        //System.out.println(c1.getAccountId());

        //System.out.println(m.skinCollections);
    }
}