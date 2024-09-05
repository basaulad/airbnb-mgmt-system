package com.airbnb.ams.repository;

import com.airbnb.ams.entity.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingsRepository extends JpaRepository<Listings, Long> {
}
