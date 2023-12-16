package com.busManagament.app.dao.geolocation;

import com.busManagament.app.model.Geolocation;

import java.util.List;

public interface GeoLocationDao {

    Geolocation findByName(String name);

    List<Geolocation> findAllLocation();

    String findLocationById(String id);

    String findNameById(String id);

}
