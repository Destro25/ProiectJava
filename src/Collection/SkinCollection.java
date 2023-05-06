package Collection;


public class SkinCollection {
    private static Integer uniqueColId = 1;

    public Integer collectionId;

    public String collectionName;
    public Integer creatorId;

    public String machineGunSkin;

    public float floatCapMachineGunSkin;

    public String shotgunSkin;

    public float floatCapShotgunSkin;

    public String smgSkin;

    public float floatCapSmgSkin;

    public String pistolSkin;

    public float floatCapPistolSkin;

    public String sniperRifleSkin;

    public float floatCapSniperRifleSkin;

    public String rifleSkin;

    public float floatCapRifleSkin;

    public String knifeSkin;

    public float floatCapKnifeSkin;

    public SkinCollection(String collectionName, Integer creatorId, String machineGunSkin, float floatCapMachineGunSkin, String shotgunSkin, float floatCapShotgunSkin, String smgSkin, float floatCapSmgSkin, String pistolSkin, float floatCapPistolSkin, String sniperRifleSkin, float floatCapSniperRifleSkin, String rifleSkin, float floatCapRifleSkin, String knifeSkin, float floatCapKnifeSkin) {
        this.collectionId = uniqueColId++;
        this.collectionName = collectionName;
        this.creatorId = creatorId;
        this.machineGunSkin = machineGunSkin;
        this.floatCapMachineGunSkin = floatCapMachineGunSkin;
        this.shotgunSkin = shotgunSkin;
        this.floatCapShotgunSkin = floatCapShotgunSkin;
        this.smgSkin = smgSkin;
        this.floatCapSmgSkin = floatCapSmgSkin;
        this.pistolSkin = pistolSkin;
        this.floatCapPistolSkin = floatCapPistolSkin;
        this.sniperRifleSkin = sniperRifleSkin;
        this.floatCapSniperRifleSkin = floatCapSniperRifleSkin;
        this.rifleSkin = rifleSkin;
        this.floatCapRifleSkin = floatCapRifleSkin;
        this.knifeSkin = knifeSkin;
        this.floatCapKnifeSkin = floatCapKnifeSkin;
    }

    public String getCollectionName() {
        return collectionName;
    }
}
