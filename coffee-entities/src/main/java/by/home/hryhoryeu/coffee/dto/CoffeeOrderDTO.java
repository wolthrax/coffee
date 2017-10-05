package by.home.hryhoryeu.coffee.dto;

import java.util.List;

public class CoffeeOrderDTO {

    private List<CoffeeTypeDTO> coffeeTypeDTOList;
    private String name;
    private String address;
    private double sum;
    private double delivery;
    private double total;

    public CoffeeOrderDTO() {}

    public CoffeeOrderDTO(List<CoffeeTypeDTO> coffeeTypeDTOList, String name,
                          String address, double sum, double delivery, double total) {
        this.coffeeTypeDTOList = coffeeTypeDTOList;
        this.name = name;
        this.address = address;
        this.sum = sum;
        this.delivery = delivery;
        this.total = total;
    }

    public List<CoffeeTypeDTO> getCoffeeTypeDTOList() {
        return coffeeTypeDTOList;
    }

    public void setCoffeeTypeDTOList(List<CoffeeTypeDTO> coffeeTypeDTOList) {
        this.coffeeTypeDTOList = coffeeTypeDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CoffeeOrderDTO{" +
                "coffeeTypeDTOList=" + coffeeTypeDTOList +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", delivery=" + delivery +
                ", total=" + total +
                '}';
    }
}