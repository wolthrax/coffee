package by.home.hryhoryeu.coffee.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CoffeeOrderItem")	
public class CoffeeOrderItem implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
	private CoffeeType coffeeType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CoffeeOrder coffeeOrder;

	@Column(name = "quantity")
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public CoffeeOrder getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(CoffeeOrder coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeOrderItem that = (CoffeeOrderItem) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (coffeeType != null ? !coffeeType.equals(that.coffeeType) : that.coffeeType != null) return false;
        return coffeeOrder != null ? coffeeOrder.equals(that.coffeeOrder) : that.coffeeOrder == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (coffeeType != null ? coffeeType.hashCode() : 0);
        result = 31 * result + (coffeeOrder != null ? coffeeOrder.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
