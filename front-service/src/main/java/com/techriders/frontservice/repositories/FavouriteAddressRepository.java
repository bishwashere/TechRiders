package com.techriders.frontservice.repositories;

import com.techriders.frontservice.domains.FavouriteAddress;
import com.techriders.frontservice.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteAddressRepository extends CrudRepository<FavouriteAddress,Integer> {
    public List<FavouriteAddress> findAllByUser(User user);
    public void deleteById(Long id);
    public FavouriteAddress findById(Long id);
}
