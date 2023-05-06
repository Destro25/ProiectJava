package Products;

import Collection.SkinCollection;



public class Skin extends Product{
    public Weapon weapon;
    public String finish;
    public Float skinFloat;

    public Skin(Integer ownerId, SkinCollection collection, Weapon weapon, String finish, Float skinFloat) {
        super(ownerId, collection);
        this.weapon = weapon;
        this.finish = finish;
        this.skinFloat = skinFloat;
    }
}
