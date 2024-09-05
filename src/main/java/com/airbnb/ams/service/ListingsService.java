package com.airbnb.ams.service;

import com.airbnb.ams.entity.Listings;
import com.airbnb.ams.repository.ListingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingsService {

    private final ListingsRepository listingsRepository;

    public ListingsService(ListingsRepository listingsRepository) {
        this.listingsRepository = listingsRepository;
    }

    public String saveListings(Listings listings) {
        Listings savedListings = this.listingsRepository.save(listings);
        if (savedListings != null){
            return "success";
        }else {
            return "failed";
        }
    }
    public List<Listings> getAllListings(){
        return listingsRepository.findAll();
    }

    public Listings getListingsById(Long id){
        return listingsRepository.findById(id).orElse(null);
    }

   public Listings updateListings(Long id, Listings listingsDetails) {
        return listingsRepository.findById(id).map(listings -> {
            listings.setTitle(listingsDetails.getTitle());
            listings.setDescription(listingsDetails.getDescription());
            listings.setPricePerNight(listingsDetails.getPricePerNight());
            return listingsRepository.save(listings);
        }).orElse(null);
   }

    public String deleteListings(Long id) {
        Optional<Listings> listingsOptional = listingsRepository.findById(id);
        if(listingsOptional.isPresent()){
            listingsRepository.deleteById(id);
            return "Listings having "+id+ " deleted successfully";
        }//else
        return "Listings having id "+id+ " not found.";
    }
}
