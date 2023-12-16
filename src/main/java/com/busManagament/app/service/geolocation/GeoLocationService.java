package com.busManagament.app.service.geolocation;

import com.busManagament.app.model.Geolocation;

import java.util.List;

public interface GeoLocationService {

    List<Geolocation> getAllLocation();

    Geolocation findByName(String name);
}
