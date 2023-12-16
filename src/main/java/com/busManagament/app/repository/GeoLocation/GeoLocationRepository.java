package com.busManagament.app.repository.GeoLocation;

import com.busManagament.app.model.Geolocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends MongoRepository<Geolocation, String> {
    Geolocation findByName(String name);

}
