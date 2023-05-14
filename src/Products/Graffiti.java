package Products;

public class Graffiti extends Product{
    public Integer numberOfUses;

    public Graffiti(Integer ownerId, Integer numberOfUses) {
        super(ownerId);
        this.numberOfUses = numberOfUses;
    }
}
