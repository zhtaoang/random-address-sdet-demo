package com.mastercard.tao.zhang.demo.util;

import com.mastercard.tao.zhang.demo.exception.NoSuchCsvFileException;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CsvReaderTest {

    @Test
    void getCitiesFromFile() {
        List<List<String>> cities = new CsvReader().getAll(RandomAddressService.US_CITIES_FILENAME);
        // a city may have multiple zip code
        assertThat(cities).contains(Arrays.asList("Lac La Belle", "WI", "Wisconsin", "Waukesha", "53066 53036"));
    }

    @Test
    void missingFile() {
        Assertions.assertThrows(NoSuchCsvFileException.class, () -> {
            new CsvReader().getAll("123");
        });
    }


}