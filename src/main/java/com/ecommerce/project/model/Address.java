package com.ecommerce.project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 2, max = 100, message = "Street must be between 2 and 10 characters")
    private String street;

    @NotBlank
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;  

    @NotBlank
    @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    @Column(name = "state")
    private String state;

    @NotBlank
    @Size(min = 2, max = 20, message = "Zip code must be between 2 and 20 characters")
    @Column(name = "zip_code")
    private String zipCode;

    @NotBlank
    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    @Column(name = "country")
    private String country;

    @NotBlank
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")    
    @Column(name = "phone_number")
    @Pattern(regexp = "^[0-9]+$", message = "Phone number must contain only digits")
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinTable(name = "user_addresses",
               joinColumns = @JoinColumn(name = "address_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))

    private List<Address> addresses = new ArrayList<>();


    @OneToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, String city, String state, String zipCode, String country, String phoneNumber) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

}
