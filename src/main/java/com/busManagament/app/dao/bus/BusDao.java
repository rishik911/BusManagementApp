package com.busManagament.app.dao.bus;

import com.busManagament.app.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusDao {

    Bus addBus(Bus bus) throws Exception;

    Bus findByRegNo(String regNo);

    Bus findByType(String type);

    List<Bus> findAllBus();

    Bus updateBus(Bus bus, String id) throws Exception;

    String getRegNoById(String Id);

    Optional<Bus> findById(String id);
}
