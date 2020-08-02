package com.mastercard.tao.zhang.demo.model;

import com.mastercard.tao.zhang.demo.service.RandomAddressService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AddressTest {

    @Test
    void testToString() {
        // given
        RandomAddressService service = mock(RandomAddressService.class);
        // when
        when(service.getHouse()).thenReturn("getHouse");
        when(service.getStreet()).thenReturn("getStreet");
        when(service.getPostalCode()).thenReturn("getPostalCode");
        when(service.getCity()).thenReturn("getCity");
        when(service.getCounty()).thenReturn("getCounty");
        when(service.getState()).thenReturn("getState");
        when(service.getStateCode()).thenReturn("getStateCode");
        when(service.getCountry()).thenReturn("getCountry");
        when(service.getCountryCode()).thenReturn("getCountryCode");
        // then
        assertThat(new Address(service).getAddress()).isEqualTo(
                "getStreet, getHouse, getCity, getStateCode, getPostalCode");
    }
}