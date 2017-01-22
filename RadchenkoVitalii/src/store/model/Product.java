package store.model;

import store.enums.ProductType;

public class Product {
    private String name;
    private int id;
    private String description;
    private ProductType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!name.equals(product.name)) return false;
        if (!description.equals(product.description)) return false;
        return type.equals(product.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id;
        result = 31 * result + description.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
