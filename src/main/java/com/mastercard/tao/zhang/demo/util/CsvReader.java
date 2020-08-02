package com.mastercard.tao.zhang.demo.util;

import com.mastercard.tao.zhang.demo.exception.NoSuchCsvFileException;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public final class CsvReader {
    private static final String COMMA_DELIMITER = ",";

    public List<List<String>> getAll(String filename) {
        List<List<String>> records = new ArrayList<>();
        File citiesFile;
        try {
            citiesFile = new File(Objects.requireNonNull(
                    RandomAddressService.class.getClassLoader().getResource(filename)).getFile());
        } catch (NullPointerException e) {
            throw new NoSuchCsvFileException(e.getMessage());
        }
        try (Scanner scanner = new Scanner(citiesFile)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new NoSuchCsvFileException(e.getMessage());
        }
        return records;
    }


    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
