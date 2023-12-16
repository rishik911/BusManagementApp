package com.busManagament.app.repository.bus;

import com.busManagament.app.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String> {
    Bus findByRegNumber(String regNumber);
}
