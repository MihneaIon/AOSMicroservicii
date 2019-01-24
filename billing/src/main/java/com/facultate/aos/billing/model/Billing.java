package com.facultate.aos.billing.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameOfPerson;

    private String date;

    private String placeForDeleavery;

    // numle utilizatorului
    private String name;

    private String itemName;

    private String warehouse;

    private double price;

    private int quantity;


    public Billing()
    {

    }

    public Billing(String nameOfPerson, String date, String placeForDeleavery) {
        this.nameOfPerson = nameOfPerson;
        this.date = date;
        this.placeForDeleavery = placeForDeleavery;
    }

    public Billing(String nameOfPerson, String date, String placeForDeleavery, String name, String itemName, String warehouse, double price, int quantity) {
        this.nameOfPerson = nameOfPerson;
        this.date = date;
        this.placeForDeleavery = placeForDeleavery;
        this.name = name;
        this.itemName = itemName;
        this.warehouse = warehouse;
        this.price = price;
        this.quantity = quantity;
    }

    public Billing(String nameOfPerson, String date, String placeForDeleavery, String name, double price, int quantity) {
        this.nameOfPerson = nameOfPerson;
        this.date = date;
        this.placeForDeleavery = placeForDeleavery;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlaceForDeleavery() {
        return placeForDeleavery;
    }

    public void setPlaceForDeleavery(String placeForDeleavery) {
        this.placeForDeleavery = placeForDeleavery;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        Billing billing = (Billing) o;
        return id == billing.id &&
                Double.compare(billing.price, price) == 0 &&
                quantity == billing.quantity &&
                Objects.equals(nameOfPerson, billing.nameOfPerson) &&
                Objects.equals(date, billing.date) &&
                Objects.equals(placeForDeleavery, billing.placeForDeleavery) &&
                Objects.equals(name, billing.name) &&
                Objects.equals(itemName, billing.itemName) &&
                Objects.equals(warehouse, billing.warehouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfPerson, date, placeForDeleavery, name, itemName, warehouse, price, quantity);
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", nameOfPerson='" + nameOfPerson + '\'' +
                ", date='" + date + '\'' +
                ", placeForDeleavery='" + placeForDeleavery + '\'' +
                ", name='" + name + '\'' +
                ", itemName='" + itemName + '\'' +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }
}
