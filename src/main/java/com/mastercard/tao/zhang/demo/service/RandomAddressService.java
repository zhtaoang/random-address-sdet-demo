package com.mastercard.tao.zhang.demo.service;

import com.mastercard.tao.zhang.demo.util.CsvReader;
import com.mastercard.tao.zhang.demo.util.RandomHelper;
import com.mastercard.tao.zhang.demo.util.TextReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RandomAddressService {

    private static final String[] validCountries = {"US", "Canada", "Mexico", "Netherlands"};
    private static final String[] validCountryCodes = {"USA", "CAN", "MEX", "NLD"};
    private static final String[] validHousePrefixes = {"Apt.", "Room", "Suite", "Unit"};
    private static final String[] validStreetSuffixes = {"St.", "Blvd.", "Ave.", "Dr.", "Pl.", "Rd."};
    public static final int DIGITS_APARTMENT_NUMBER = 2;
    public static final int DIGITS_STREET_NUMBER = 3;
    public static final String US_STREETS_FILENAME = "usstreets.txt";
    public static final String US_CITIES_FILENAME = "uscities.csv";

    private final List<String> cities;
    private final List<String> stateCodes;
    private final List<String> states;
    private final List<String> counties;
    private final List<String> postalCodes;
    private final List<String> housePrefixes;
    private final List<String> streetNames;
    private final List<String> streetSuffixes;
    private final List<String> countries;
    private final List<String> countryCodes;


    public RandomAddressService() {
        cities = new ArrayList<>();
        stateCodes = new ArrayList<>();
        states = new ArrayList<>();
        counties = new ArrayList<>();
        postalCodes = new ArrayList<>();
        for (List<String> cityInfo : new CsvReader().getAll(US_CITIES_FILENAME)) {
            cities.add(cityInfo.get(0));
            stateCodes.add(cityInfo.get(1));
            states.add(cityInfo.get(2));
            counties.add(cityInfo.get(3));
            postalCodes.add(cityInfo.get(4).split("\\s+")[0]);
        }
        streetNames = new TextReader(US_STREETS_FILENAME).linesFromFile();
        streetSuffixes = Arrays.asList(validStreetSuffixes);
        housePrefixes = Arrays.asList(validHousePrefixes);
        countries = Arrays.asList(validCountries);
        countryCodes = Arrays.asList(validCountryCodes);
    }

    public String getCity() {
        return RandomHelper.getRandomSampleFromList(cities);
    }

    public String getStateCode() {
        return RandomHelper.getRandomSampleFromList(stateCodes);
    }

    public String getState() {
        return RandomHelper.getRandomSampleFromList(states);
    }

    public String getCounty() {
        return RandomHelper.getRandomSampleFromList(counties);
    }

    public String getPostalCode() {
        return RandomHelper.getRandomSampleFromList(postalCodes);
    }

    public String getHouse() {
        return String.format("%s %d", RandomHelper.getRandomSampleFromList(housePrefixes),
                RandomHelper.randomInt(DIGITS_APARTMENT_NUMBER));
    }

    public String getStreet() {
        return String.format("%d %s %s", RandomHelper.randomInt(DIGITS_STREET_NUMBER),
                RandomHelper.getRandomSampleFromList(streetNames),
                RandomHelper.getRandomSampleFromList(streetSuffixes));
    }

    public String getCountry() {
        return RandomHelper.getRandomSampleFromList(countries);

    }

    public String getCountryCode() {
        return RandomHelper.getRandomSampleFromList(countryCodes);
    }
}
