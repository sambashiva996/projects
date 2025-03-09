package com.location.service;

import com.location.entity.Address;
import com.location.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address getAddressById(Long locationId) {
        return addressRepository.findByLocationSeqId(locationId);
    }

    @Override
    public List<Address> getAddressList() {
        return addressRepository.findAll();
    }
}
