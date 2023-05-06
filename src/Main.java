import Customer.*;
import Marketplace.*;
import Products.*;
import Collection.SkinCollection;


public class Main {
    public static void main(String[] args) {
        Marketplace m = new Marketplace();

        SkinCollection col = new SkinCollection("Anubis", 1, "mg", 0.8f, "sg", 0.9f, "smg", 0.9f, "pist", 1.0f, "snprf", 0.5f, "rfl", 0.3f, "knf", 0.01f);

        Skin s = new Skin(1, col, Weapon.knife, "Doppler", 0.5f);

        Customer c1 = new Customer( "j1", "3232");

        c1.depositProduct(s);
        c1.depositProduct(s);
        c1.depositProduct(s);

        c1.showInventory();

        c1.putProductForSale(0, m);

        m.showMarketplace();
        c1.showInventory();
        System.out.println(c1.getAccountId());

    }
}