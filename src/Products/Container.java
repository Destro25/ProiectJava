package Products;

import Collection.SkinCollection;

public class Container extends Product{

    public String containerName;
    public static float oddsMachineGun = 0.5f;

    public static float oddsShotgun = 0.3f;

    public static float oddsSmg = 0.1f;

    public static float oddsPistol = 0.05f;

    public static float oddsSniperRifle = 0.03f;

    public static float oddsRifle = 0.015f;

    public static float oddsKnife = 0.005f;

    public SkinCollection skinCollection;

    public Container(Integer ownerId, SkinCollection skinCollection) {
        super(ownerId);
        this.containerName = skinCollection.collectionName + " Case";
        this.skinCollection = skinCollection;
    }

    public Skin openContainer(){
        Skin s = null;
        float roll = (float) Math.random();
        if (roll < oddsKnife)
        {
            s = new Skin(ownerId, Weapon.knife, skinCollection.knifeSkin, (float) (Math.random() * skinCollection.floatCapKnifeSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle) {
            s = new Skin(ownerId, Weapon.rifle, skinCollection.rifleSkin, (float) (Math.random() * skinCollection.floatCapRifleSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle + oddsSniperRifle) {
            s = new Skin(ownerId, Weapon.sniperRifle, skinCollection.sniperRifleSkin, (float) (Math.random() * skinCollection.floatCapSniperRifleSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol) {
            s = new Skin(ownerId, Weapon.pistol, skinCollection.pistolSkin, (float) (Math.random() * skinCollection.floatCapPistolSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg) {
            s = new Skin(ownerId, Weapon.smg, skinCollection.smgSkin, (float) (Math.random() * skinCollection.floatCapSmgSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg + oddsShotgun) {
            s = new Skin(ownerId, Weapon.shotgun, skinCollection.shotgunSkin, (float) (Math.random() * skinCollection.floatCapShotgunSkin), this.skinCollection);
        } else if (roll < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg + oddsShotgun + oddsMachineGun) {
            s = new Skin(ownerId, Weapon.machineGun, skinCollection.machineGunSkin, (float) (Math.random() * skinCollection.floatCapMachineGunSkin), this.skinCollection);
        }
        return s;
    }

    @Override
    public String toString() {
        return "Container{" +
                "productId=" + productId +
                ", containerName='" + containerName + '\'' +
                ", skinCollection=" + skinCollection +
                '}';
    }
}
