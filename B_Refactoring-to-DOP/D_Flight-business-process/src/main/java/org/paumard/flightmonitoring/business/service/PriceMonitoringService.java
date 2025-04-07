package org.paumard.flightmonitoring.business.service;

import org.paumard.flightmonitoring.business.model.FlightID;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public interface PriceMonitoringService {
    void followPrice(FlightID flightID, FlightConsumer consumer);
    Future<?> updatePrices(ScheduledExecutorService executor);
}