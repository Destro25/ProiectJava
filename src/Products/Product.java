package Products;

import Collection.SkinCollection;

public class Product {
    private static Integer uniquePrdId = 1;
    private Integer productId;

    public Integer ownerId;

    public SkinCollection skinCollection;

    public Float Price;

    public Product(Integer ownerId, SkinCollection skinCollection) {
        this.productId = uniquePrdId++;
        this.ownerId = ownerId;
        this.skinCollection = skinCollection;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public SkinCollection getSkinCollection() {
        return skinCollection;
    }


    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }
}
