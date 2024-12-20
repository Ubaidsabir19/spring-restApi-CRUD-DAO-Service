package com.seamless.employeeManagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // used for unique value
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

/*  One-to-one relationship

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
*/

    /*  One-to-Many relationship */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
    @JsonManagedReference
    private List<Address> address;

    /*  Many-to-Many relationship */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments = new ArrayList<>();

    // Constructors --------------------------------------
    public Employee(){}

    public Employee(String first_name, String last_name, String email, List<Address> address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
    }

    // Getters -------------------------------------------
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    // to String Method ---------------------------------------
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", departments=" + departments +
                '}';
    }
}
