package com.airbnb.ams.controller;

import com.airbnb.ams.entity.Listings;
import com.airbnb.ams.entity.User;
import com.airbnb.ams.service.ListingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/listings")
public class ListingsController {

    private final ListingsService listingsService;

    public ListingsController(ListingsService listingsService) {
        this.listingsService = listingsService;
    }

    // URL: http://localhost:8081/listings
    @PostMapping
    public ResponseEntity<String> saveListings(@RequestBody Listings listings) {
        return ResponseEntity.ok(this.listingsService.saveListings(listings));
    }

    // URL: http://localhost:8081/listings
    @GetMapping
    public ResponseEntity<List<Listings>> getAllListings() {
        return ResponseEntity.ok(listingsService.getAllListings());
    }

    // URL: http://localhost:8081/listings
    @GetMapping("/{id}")
    public ResponseEntity<Listings> getListingsById(@PathVariable Long id) {
        return ResponseEntity.ok(listingsService.getListingsById(id));
    }

    // URL: http://localhost:8081/listings
    @PutMapping("/{id}")
    public ResponseEntity<Listings> updateListings(@PathVariable Long id, @RequestBody Listings listings) {
        return ResponseEntity.ok(listingsService.updateListings(id, listings));
    }

    // URL: http://localhost:8081/listings
    @DeleteMapping("/{id}")
    public void deleteListings(@PathVariable Long id) {
        listingsService.deleteListings(id);
    }

}
