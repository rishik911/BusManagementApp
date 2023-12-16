package com.busManagament.app.repository.route;

import com.busManagament.app.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}
