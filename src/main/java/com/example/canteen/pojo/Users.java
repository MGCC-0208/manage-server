package com.example.canteen.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "age")
    private int age;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "cities")
    private String cities;
    @Basic
    @Column(name = "detailed_address")
    private String detailedAddress;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getCities () {
        return cities;
    }

    public void setCities (String cities) {
        this.cities = cities;
    }

    public String getDetailedAddress () {
        return detailedAddress;
    }

    public void setDetailedAddress (String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Timestamp getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && age == users.age && Objects.equals(name, users.name) && Objects.equals(gender, users.gender) && Objects.equals(address, users.address) && Objects.equals(phone, users.phone) && Objects.equals(cities, users.cities) && Objects.equals(detailedAddress, users.detailedAddress) && Objects.equals(createTime, users.createTime) && Objects.equals(updateTime, users.updateTime);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, name, gender, age, address, phone, cities, detailedAddress, createTime, updateTime);
    }
}
