package Products;


public class Product {
    private static Integer uniquePrdId = 1;
    protected Integer productId;

    public Integer ownerId;

    public Float Price;

    protected Product(Integer ownerId) {
        this.productId = uniquePrdId++;
        this.ownerId = ownerId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public static Integer getUniquePrdId() {
        return uniquePrdId;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }


}
