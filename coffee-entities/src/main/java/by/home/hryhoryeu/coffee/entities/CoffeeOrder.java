package by.home.hryhoryeu.coffee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CoffeeOrder")
public class CoffeeOrder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "delivery_address")
	private String deliveryAddress;
	
	@Column(name = "cost")
	private double cost;

	@OneToMany(mappedBy = "coffeeOrder")
	private List<CoffeeOrderItem> coffeeOrderItemList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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

		CoffeeOrder that = (CoffeeOrder) o;

		if (id != that.id) return false;
		if (Double.compare(that.cost, cost) != 0) return false;
		if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
			return false;
		return coffeeOrderItemList != null ? coffeeOrderItemList.equals(that.coffeeOrderItemList) : that.coffeeOrderItemList == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (int) (id ^ (id >>> 32));
		result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
		temp = Double.doubleToLongBits(cost);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (coffeeOrderItemList != null ? coffeeOrderItemList.hashCode() : 0);
		return result;
	}
}
