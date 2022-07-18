/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author oOOo
 */
public class Student {
    public String name;
    public String address;
    public String dob;
    public String email;
    public Float mark;
    public String phone;
    public String id;

    public Student(String name, String address, String dob, String email, Float mark, String phone, String id) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.mark = mark;
        this.phone = phone;
        this.id = id;
    }

    public Student() { 
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", address=" + address + ", dob=" + dob + ", email=" + email + ", mark=" + mark + ", phone=" + phone + ", id=" + id + '}';
    }
}
