package com.mastercard.tao.zhang.demo.util;

import com.mastercard.tao.zhang.demo.exception.NoSuchTxtFileException;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class TextReader {

    private final String filename;

    public TextReader(String filename) {
        this.filename = filename;
    }

    public List<String> linesFromFile() {
        List<String> lines = new ArrayList<>();
        try {
            Path path = new ClassPathResource(filename).getFile().toPath();
            lines.addAll(Files.readAllLines(path, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new NoSuchTxtFileException(e.getMessage());
        }
        return lines;
    }

}
