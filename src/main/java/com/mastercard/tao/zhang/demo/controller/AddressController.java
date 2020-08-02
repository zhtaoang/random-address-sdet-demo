package com.mastercard.tao.zhang.demo.controller;

import com.mastercard.tao.zhang.demo.model.Address;
import com.mastercard.tao.zhang.demo.service.RandomAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/randomizer")
public class AddressController {

    private final RandomAddressService service;

    public AddressController(RandomAddressService service) {
        this.service = service;
    }

    @RequestMapping(value = "/address", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<Address> getRandomAddress() {
        return ResponseEntity.ok(new Address(service));
    }
}