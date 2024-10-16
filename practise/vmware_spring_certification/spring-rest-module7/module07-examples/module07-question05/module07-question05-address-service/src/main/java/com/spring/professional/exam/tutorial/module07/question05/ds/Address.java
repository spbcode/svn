package com.spring.professional.exam.tutorial.module07.question05.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @NotBlank(message = "Address name cannot be empty")
    private String addressName;
    @Positive(message = "Street Number cannot be empty")
    private Integer streetNumber;
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-' ]*", message = "Street name contains illegal characters")
    private String streetName;
    private Integer aptNumber;
    @NotBlank(message = "City cannot be empty")
    @Pattern(regexp = "[A-Za-z-' ]*", message = "City contains illegal characters")
    private String city;
    @NotBlank(message = "State cannot be empty")
    @Size(min = 2, max = 2, message = "State needs to be 2 letter code")
    @Pattern(regexp = "[A-Z]*", message = "State contains illegal characters")
    private String state;
    @NotBlank(message = "Zip Code cannot be empty")
    @Pattern(regexp = "[0-9]*", message = "Zip Code contains illegal characters")
    private String zipCode;

    @SuppressWarnings("unused")
    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressName='" + addressName + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", aptNumber=" + aptNumber +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
