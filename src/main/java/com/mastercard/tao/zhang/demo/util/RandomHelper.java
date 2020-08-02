package com.mastercard.tao.zhang.demo.util;

import java.util.List;
import java.util.Random;

public final class RandomHelper {
    private static final Random RANDOM = new Random();

    public static <T> T getRandomSampleFromList(List<T> input) {
        return input.get(RANDOM.nextInt(input.size()));
    }

    public static int randomInt(int digits) {
        int minimum = (int) Math.pow(10, digits - 1);
        int maximum = (int) Math.pow(10, digits) - 1;
        return minimum + RANDOM.nextInt((maximum - minimum) + 1);
    }

}
