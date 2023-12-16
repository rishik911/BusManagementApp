package com.busManagament.app.dao.geolocation;

import com.busManagament.app.model.Geolocation;
import com.busManagament.app.repository.GeoLocation.GeoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GeoLocationDaoImpl implements GeoLocationDao {

    @Autowired
    GeoLocationRepository geoLocationRepository;

    public GeoLocationDaoImpl(GeoLocationRepository geoLocationRepository){
        this.geoLocationRepository = geoLocationRepository;
        if(geoLocationRepository.count() == 0){
            geoLocationRepository.save(new Geolocation("Bangalore"));
            geoLocationRepository.save(new Geolocation("Kerala"));
            geoLocationRepository.save(new Geolocation("Delhi"));
            geoLocationRepository.save(new Geolocation("Chandigarh"));
            geoLocationRepository.save(new Geolocation("Jaipur"));
            geoLocationRepository.save(new Geolocation("Hyderabad"));
        }
    }


    @Override
    public Geolocation findByName(String name) {
      return  geoLocationRepository.findByName(name);
    }

    @Override
    public List<Geolocation> findAllLocation() {
        List<Geolocation> locations= new ArrayList<>();
        locations = geoLocationRepository.findAll();
        return locations;
    }

    @Override
    public String findLocationById(String id){
        Optional<Geolocation> newLocation =  geoLocationRepository.findById(id);
        return newLocation.map(Geolocation::getName).orElse(null);
    }

    @Override
    public String findNameById(String id){
        Optional<Geolocation> newLocation =  geoLocationRepository.findById(id);
        if(newLocation.isPresent()){
            return newLocation.get().getName();
        }
        return null;
    }
}
