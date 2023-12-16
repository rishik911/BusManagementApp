package com.busManagament.app.service.route;

import com.busManagament.app.model.RouteResponse;
import com.busManagament.app.model.Route;

import java.util.List;

public interface RouteService {

    Route addRoute(Route route) throws Exception;

    List<RouteResponse> getAllRoute();
}
