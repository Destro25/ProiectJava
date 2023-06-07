package Collection;

import java.util.Objects;

public class GraffitiSet {
    public String graffitiSetName;

    public Integer creatorId;

    public String Support;

    public Integer numberOfUsesSupport;

    public String Leader;

    public Integer numberOfUsesLeader;

    public String Ninja;

    public Integer numberOfUsesNinja;

    public String Fragger;

    public Integer numberOfUsesFragger;

    public String Bot;

    public Integer numberOfUsesBot;

    public GraffitiSet(String graffitiSetName, Integer creatorId, String support, Integer numberOfUsesSupport, String leader, Integer numberOfUsesLeader, String ninja, Integer numberOfUsesNinja, String fragger, Integer numberOfUsesFragger, String bot, Integer numberOfUsesBot) {
        this.graffitiSetName = graffitiSetName;
        this.creatorId = creatorId;
        Support = support;
        this.numberOfUsesSupport = numberOfUsesSupport;
        Leader = leader;
        this.numberOfUsesLeader = numberOfUsesLeader;
        Ninja = ninja;
        this.numberOfUsesNinja = numberOfUsesNinja;
        Fragger = fragger;
        this.numberOfUsesFragger = numberOfUsesFragger;
        Bot = bot;
        this.numberOfUsesBot = numberOfUsesBot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraffitiSet that = (GraffitiSet) o;
        return Objects.equals(graffitiSetName, that.graffitiSetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graffitiSetName);
    }

    @Override
    public String toString() {
        return "GraffitiSet{" +
                "graffitiSetName='" + graffitiSetName + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}
