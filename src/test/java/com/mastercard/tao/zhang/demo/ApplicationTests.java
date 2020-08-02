package com.mastercard.tao.zhang.demo;

import com.mastercard.tao.zhang.demo.model.Address;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    RandomAddressService service;

    @Test
    void contextLoads() {
        for (int i = 0; i < 100; i++) {
            assertThat(new Address(service)).hasFieldOrProperty("address");
        }
    }

}
