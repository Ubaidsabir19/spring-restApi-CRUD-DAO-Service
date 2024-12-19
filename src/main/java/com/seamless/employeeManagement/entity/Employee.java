package com.seamless.employeeManagement.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
    private List<Address> address;

    // Constructors --------------------------------------
    public Employee(){}

    public Employee(String first_name, String last_name, String email, List<Address> address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
    }

    // Getters --------------------------------------
    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

//    public Address getAddress() {
//        return address;
//    }

    public List<Address> getAddress() {
        return address;
    }

    // Setters --------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    // to String Method --------------------------------------
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }


}
