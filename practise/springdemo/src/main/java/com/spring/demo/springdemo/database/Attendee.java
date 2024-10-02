package com.spring.demo.springdemo.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "attendees")
@SequenceGenerator(name = "attendees_gen", sequenceName = "attendees_seq", allocationSize = 1)
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendees_gen")
    @Column(name = "attendee_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 80)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "title", length = 40)
    private String title;

    @Column(name = "company", length = 50)
    private String company;

    public Attendee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return Objects.equals(id, attendee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    public static void main1(String args[]){
        int ans = Attendee.myprint(100,2000);
        System.out.println(ans);
            }

    public static int myprint(int A,int B){

        if(B==0) return A;
        else return myprint(B,A%B);
    }

    public static void main(String args[]){
        String outputString = "CLEBURNE TX 76031";
        int spaceIndexGFStateCode = outputString.trim().substring(0,outputString.lastIndexOf(" ")).lastIndexOf(" ");
        outputString = outputString.substring(0,spaceIndexGFStateCode)+","+outputString.substring(spaceIndexGFStateCode,outputString.length());
        System.out.println(outputString);
    }
}
