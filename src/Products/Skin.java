package Products;

import Collection.SkinCollection;



public class Skin extends Product{
    public Weapon weapon;
    public String finish;
    public Float skinFloat;

    public SkinCollection skinCollection;

    public Skin(Integer ownerId, Weapon weapon, String finish, Float skinFloat, SkinCollection skinCollection) {
        super(ownerId);
        this.weapon = weapon;
        this.finish = finish;
        this.skinFloat = skinFloat;
        this.skinCollection = skinCollection;
    }

    @Override
    public String toString() {
        return "Skin{" +
                "weapon=" + weapon +
                ", finish='" + finish + '\'' +
                ", skinFloat=" + skinFloat +
                ", skinCollection=" + skinCollection +
                '}';
    }
}
