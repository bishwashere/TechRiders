package com.techriders.frontservice.services;

import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.User;

import java.util.List;

public interface FavouriteAddressService {

    public List<FavouriteAddress> findAllByUser(User user);

    public FavouriteAddress save(FavouriteAddress favouriteAddress);

    public FavouriteAddress findById(Long id);

    public void deleteById(Long id);
}
