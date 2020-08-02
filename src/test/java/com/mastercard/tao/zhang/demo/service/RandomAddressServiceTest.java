package com.mastercard.tao.zhang.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class RandomAddressServiceTest {

    RandomAddressService service;

    @BeforeEach
    void setUp() {
        service = new RandomAddressService();
    }

    @Test
    void houseEndsWithNumber() {
        assertThat(service.getHouse()).containsPattern(Pattern.compile("[0-9]+$"));
    }

    @Test
    void streetStartWithNumber() {
        assertThat(service.getStreet()).containsPattern(Pattern.compile("^[0-9]+"));
    }

}