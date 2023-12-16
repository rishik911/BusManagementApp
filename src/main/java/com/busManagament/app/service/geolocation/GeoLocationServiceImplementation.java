package com.busManagament.app.service.geolocation;

import com.busManagament.app.dao.geolocation.GeoLocationDao;
import com.busManagament.app.model.Geolocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeoLocationServiceImplementation implements GeoLocationService {

    @Autowired
    private GeoLocationDao geoLocationDao;
    @Override
    public List<Geolocation> getAllLocation() {
        return geoLocationDao.findAllLocation();
    }

    @Override
    public Geolocation findByName (String name){
        return geoLocationDao.findByName(name);
    }

}
