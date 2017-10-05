package by.home.hryhoryeu.coffee.dto;

public class CoffeeTypeDTO {
    private long id;
    private String typeName;
    private double price;
    private double cost;
    private int quantity;

    public CoffeeTypeDTO() {}

    public CoffeeTypeDTO(long id, String typeName, double price, double cost, int quantity) {
        this.id = id;
        this.typeName = typeName;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CoffeeTypeDTO{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
