package com.busManagament.app.service.route;

import com.busManagament.app.dao.bus.BusDao;
import com.busManagament.app.dao.geolocation.GeoLocationDao;
import com.busManagament.app.dao.route.RouteDao;
import com.busManagament.app.model.RouteResponse;
import com.busManagament.app.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteServiceImplentation implements RouteService {

    @Autowired
    RouteDao routeDao;

    @Autowired
    BusDao busService;

    @Autowired
    GeoLocationDao geoLocationService;


    @Override
    public Route addRoute(Route route) throws Exception {
        validateAddRoute(route);
        return routeDao.addRoute(route);
    }

    public void validateAddRoute(Route route) throws Exception {
        String busId = route.getBusId();
        String sourceId = route.getSourceId();
        String destinationId = route.getDestinationId();
        if(busId == null) throw new Exception("Bus Id is not present");
        if(sourceId == null) throw new Exception("Source Id is not present");
        if(destinationId == null)  throw new Exception("Destination Id is not present");

        if(busService.findById(busId).isEmpty()) throw new Exception("Bus Id is not valid");
        if(geoLocationService.findLocationById(sourceId) ==  null) throw new Exception("Bus Id is not valid");
        if(geoLocationService.findLocationById(destinationId)== null)  throw new Exception("Bus Id is not valid");
    }

    @Override
    public List<RouteResponse> getAllRoute() {
        List<Route> allRoutes =  routeDao.findAllRoute();
        List<RouteResponse> routeResponses = new ArrayList<>();
        allRoutes.forEach(route -> {
            routeResponses.add(setRouteResponse(route));
        });
        return routeResponses;
    }

    public RouteResponse setRouteResponse(Route route){
        RouteResponse newRouteResponse = new RouteResponse();
        String busId = route.getBusId();
        String sourceId = route.getSourceId();
        String destinationId = route.getDestinationId();
        newRouteResponse.setBusRegNo(busService.getRegNoById(busId));
        newRouteResponse.setSource(geoLocationService.findNameById(sourceId));
        newRouteResponse.setDestination(geoLocationService.findNameById(destinationId));
        newRouteResponse.setRouteName(route.getRouteName());
        newRouteResponse.setId(route.getId());
        newRouteResponse.setArrivalTime(route.getArrivalTime());
        newRouteResponse.setDepartureTime(route.getDepartureTime());
        return newRouteResponse;
    }
}
