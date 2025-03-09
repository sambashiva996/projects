package com.location.controller;

import com.location.entity.Address;
import com.location.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location-service")
public class AddressController {

    @Autowired
    AddressService addressService;

   @GetMapping("/address/{locationById}")
    public ResponseEntity<Address> getAddress(@PathVariable("locationById") Long locationId){
       return ResponseEntity.ok().body(addressService.getAddressById(locationId));
   }

   @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAddressList(){
       return ResponseEntity.ok().body(addressService.getAddressList());
   }

}
