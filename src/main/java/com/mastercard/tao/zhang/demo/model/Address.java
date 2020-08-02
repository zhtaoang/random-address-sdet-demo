package com.mastercard.tao.zhang.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;

import java.util.Objects;

@JsonPropertyOrder({"street", "house", "city", "county", "state", "stateCode", "country", "countryCode", "postalCode", "address"})
public class Address {

    private static final long serialVersionUID = 194164415864L;

    private String house;
    private String street;
    @JsonProperty("postal_code")
    private String postalCode;
    private String city;
    private String county;
    private String state;
    @JsonProperty("state_code")
    private String stateCode;
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    private String address;

    public Address(RandomAddressService service) {
        this.house = service.getHouse();
        this.street = service.getStreet();
        this.postalCode = service.getPostalCode();
        this.city = service.getCity();
        this.county = service.getCounty();
        this.state = service.getState();
        this.stateCode = service.getStateCode();
        this.country = service.getCountry();
        this.countryCode = service.getCountryCode();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(house, address.house) &&
                Objects.equals(street, address.street) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(county, address.county) &&
                Objects.equals(state, address.state) &&
                Objects.equals(stateCode, address.stateCode) &&
                Objects.equals(country, address.country) &&
                Objects.equals(countryCode, address.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, street, postalCode, city, county, state, stateCode, country, countryCode);
    }

    public String getAddress() {
        return address == null ? street +
                ", " + house +
                ", " + city +
                ", " + stateCode +
                ", " + postalCode
                : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
