package com.TaxEngine;

public class TaxableEntity {

    public int id;
    public int age;
    public Character sex;
    public String name;
    public String location;
    public TaxParamVO taxParams;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TaxParamVO getTaxParams() {
        return taxParams;
    }

    public void setTaxParams(TaxParamVO taxParams) {
        this.taxParams = taxParams;
    }
}
