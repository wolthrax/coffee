package by.home.hryhoryeu.coffee.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CoffeeType")
public class CoffeeType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
	
	@Column(name = "type_name", nullable = false)
	private String typeName;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "disabled")
	private char disabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "coffeeType")
	private List<CoffeeOrderItem> coffeeOrderItemList;

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

	public char getDisabled() {
		return disabled;
	}

	public void setDisabled(char disabled) {
		this.disabled = disabled;
	}

	public List<CoffeeOrderItem> getCoffeeOrderItemList() {
		return coffeeOrderItemList;
	}

	public void setCoffeeOrderItemList(List<CoffeeOrderItem> coffeeOrderItemList) {
		this.coffeeOrderItemList = coffeeOrderItemList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CoffeeType that = (CoffeeType) o;

		if (id != that.id) return false;
		if (Double.compare(that.price, price) != 0) return false;
		if (disabled != that.disabled) return false;
		if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
		return coffeeOrderItemList != null ? coffeeOrderItemList.equals(that.coffeeOrderItemList) : that.coffeeOrderItemList == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (int) (id ^ (id >>> 32));
		result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (int) disabled;
		result = 31 * result + (coffeeOrderItemList != null ? coffeeOrderItemList.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CoffeeType{" +
				"id=" + id +
				", typeName='" + typeName + '\'' +
				", price=" + price +
				", disabled=" + disabled +
				", coffeeOrderItemList=" + coffeeOrderItemList +
				'}';
	}
}
