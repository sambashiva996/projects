package com.location.service;

import com.location.entity.Address;

import java.util.List;

public interface AddressService {
    Address getAddressById(Long locationId);

    List<Address> getAddressList();
}
