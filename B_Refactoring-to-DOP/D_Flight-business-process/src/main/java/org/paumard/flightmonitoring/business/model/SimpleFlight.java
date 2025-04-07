package org.paumard.flightmonitoring.business.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public record SimpleFlight(SimpleFlightID id, City from, City to)
      implements Flight {

    private static final Map<FlightID, Price> pricePerFlight =
          new ConcurrentHashMap<>();

    public static Price price(SimpleFlightID id) {
        return pricePerFlight.get(id);
    }

    public static void updatePrice(SimpleFlightID id, Price price) {
        pricePerFlight.put(id, price);
    }
}
