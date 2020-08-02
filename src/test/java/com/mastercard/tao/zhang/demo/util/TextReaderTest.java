package com.mastercard.tao.zhang.demo.util;

import com.mastercard.tao.zhang.demo.exception.NoSuchTxtFileException;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TextReaderTest {

    @Test
    void linesFromFile() {
        List<String> streets = new TextReader(RandomAddressService.US_STREETS_FILENAME).linesFromFile();
        assertThat(streets).contains("A. Alfred Lombardi").hasSize(91670);
    }

    @Test
    void missingFile() {
        Assertions.assertThrows(NoSuchTxtFileException.class, () -> {
            new TextReader("567").linesFromFile();
        });
    }
}