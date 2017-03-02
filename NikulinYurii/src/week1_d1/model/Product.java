package week1_d1.model;

/**
 * Created by yurii on 21.01.2017.
 */
public class Product {
    private int pice;
    private String name;
    private int productId;
    private ProductType productType;

    public Product(ProductType tupe, int pice, String name) {
        this.productType = tupe;
        this.pice = pice;
        this.name = name;

    }

    public ProductType getType(){return productType;}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPice() {
        return pice;
    }

    public void setPice(int pice) {
        this.pice = pice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                " pice=" + pice +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId == product.productId;

    }

    @Override
    public int hashCode() {
        return productId;
    }
}
