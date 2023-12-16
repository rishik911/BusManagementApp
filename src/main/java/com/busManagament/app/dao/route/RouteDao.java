package com.busManagament.app.dao.route;

import com.busManagament.app.model.Route;

import java.util.List;

public interface RouteDao {

    Route addRoute(Route route);

    Route updateRoute(Route route);

    Route deleteRoute(Route route);

    List<Route> findAllRoute();

}
