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

    public Container(Integer ownerId, SkinCollection skinCollection) {
        super(ownerId, skinCollection);
        containerName = skinCollection.collectionName + "Case";
    }

    public Skin openContainer(){
        Skin s = null;
        if (Math.random() < oddsKnife)
        {
            s = new Skin(ownerId, this.skinCollection, Weapon.knife, skinCollection.knifeSkin, (float) (Math.random() * skinCollection.floatCapKnifeSkin));
        } else if (Math.random() < oddsKnife + oddsRifle) {
            s = new Skin(ownerId, this.skinCollection, Weapon.rifle, skinCollection.rifleSkin, (float) (Math.random() * skinCollection.floatCapRifleSkin));
        } else if (Math.random() < oddsKnife + oddsRifle + oddsSniperRifle) {
            s = new Skin(ownerId, this.skinCollection, Weapon.sniperRifle, skinCollection.sniperRifleSkin, (float) (Math.random() * skinCollection.floatCapSniperRifleSkin));
        } else if (Math.random() < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol) {
            s = new Skin(ownerId, this.skinCollection, Weapon.pistol, skinCollection.pistolSkin, (float) (Math.random() * skinCollection.floatCapPistolSkin));
        } else if (Math.random() < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg) {
            s = new Skin(ownerId, this.skinCollection, Weapon.smg, skinCollection.smgSkin, (float) (Math.random() * skinCollection.floatCapSmgSkin));
        } else if (Math.random() < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg + oddsShotgun) {
            s = new Skin(ownerId, this.skinCollection, Weapon.shotgun, skinCollection.shotgunSkin, (float) (Math.random() * skinCollection.floatCapShotgunSkin));
        } else if (Math.random() < oddsKnife + oddsRifle + oddsSniperRifle + oddsPistol + oddsSmg + oddsShotgun + oddsMachineGun) {
            s = new Skin(ownerId, this.skinCollection, Weapon.machineGun, skinCollection.machineGunSkin, (float) (Math.random() * skinCollection.floatCapMachineGunSkin));
        }
        return s;
    }
}
