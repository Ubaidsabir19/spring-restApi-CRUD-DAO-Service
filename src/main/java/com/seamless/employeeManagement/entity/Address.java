package com.seamless.employeeManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private int street;

    @Column(name = "phoneNo")
    private String phoneNo;

//    @ManyToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    private Employee employee;

    // Constructors
    public Address(){}

    public Address(String country, String city, int street, String phoneNo) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.phoneNo = phoneNo;
    }

    // Getter & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

//    public Employee getEmployee() {
//        return employee;
//    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public void setEmployee(Employee employee){
//        this.employee = employee;
//    }

    // to string method
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street=" + street +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
