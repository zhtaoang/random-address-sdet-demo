package com.mastercard.tao.zhang.demo.util;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class RandomHelperTest {

    @Test
    void getRandomSampleFromListKeepsTypeReference() {
        // given
        List<Map.Entry<String, Integer>> input = new ArrayList<>();
        input.add(new AbstractMap.SimpleEntry<>("NY", 1));
        input.add(new AbstractMap.SimpleEntry<>("CA", 2));
        // when
        Object picked = RandomHelper.getRandomSampleFromList(input);
        // then
        assertThat(picked).isInstanceOf(Map.Entry.class);
    }

    @Test
    void randomIntShouldFallInRange() {
        for (int i = 0; i < 1000; i++) {
            int picked = RandomHelper.randomInt(4);
            assertThat(picked).isBetween(1000, 9999);
        }
    }
}