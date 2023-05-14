package Products;

import Collection.GraffitiSet;
public class Graffiti extends Product{

    public String graffitiName;
    public Integer numberOfUses;
    public GraffitiSet graffitiSet;

    public Graffiti(Integer ownerId, GraffitiSet graffitiSet) {
        super(ownerId);
        this.graffitiSet = graffitiSet;
        float roll = (float) Math.random();
        if(roll < 0.2)
        {
            this.graffitiName = graffitiSet.Bot;
            this.numberOfUses = graffitiSet.numberOfUsesBot;
        } else if (roll < 0.4) {
            this.graffitiName = graffitiSet.Fragger;
            this.numberOfUses = graffitiSet.numberOfUsesFragger;
        } else if (roll < 0.6) {
            this.graffitiName = graffitiSet.Leader;
            this.numberOfUses = graffitiSet.numberOfUsesLeader;
        } else if (roll < 0.8) {
            this.graffitiName = graffitiSet.Support;
            this.numberOfUses = graffitiSet.numberOfUsesSupport;
        } else {
            this.graffitiName = graffitiSet.Ninja;
            this.numberOfUses = graffitiSet.numberOfUsesNinja;
        }
    }

}
