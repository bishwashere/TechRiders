package com.techriders.frontservice.services.impl;

import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.repositories.FavouriteAddressRepository;
import com.techriders.frontservice.services.FavouriteAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FavouriteAddressServiceImpl implements FavouriteAddressService {

    @Autowired
    FavouriteAddressRepository favouriteAddressRepository;

    @Override
    public List<FavouriteAddress> findAllByUser(User user) {
        return favouriteAddressRepository.findAllByUser(user);
    }

    @Override
    public FavouriteAddress save(FavouriteAddress favouriteAddress) {
        return favouriteAddressRepository.save(favouriteAddress);
    }

    @Override
    public FavouriteAddress findById(Long id) {
        return favouriteAddressRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        favouriteAddressRepository.deleteById(id);
    }
}
