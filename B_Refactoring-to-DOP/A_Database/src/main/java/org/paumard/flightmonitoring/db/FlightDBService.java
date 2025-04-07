package org.paumard.flightmonitoring.db;

import org.paumard.flightmonitoring.business.model.*;
import org.paumard.flightmonitoring.business.service.DBService;
import org.paumard.flightmonitoring.db.model.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlightDBService implements DBService {

    private static Map<String, CityEntity> cities = Map.ofEntries(
            Map.entry("Pa", new CityEntity("Paris")),
            Map.entry("Lo", new CityEntity("London")),
            Map.entry("Am", new CityEntity("Amsterdam")),
            Map.entry("Fr", new CityEntity("Francfort")),
            Map.entry("NY", new CityEntity("New York")),
            Map.entry("Wa", new CityEntity("Washington")),
            Map.entry("At", new CityEntity("Atlanta")),
            Map.entry("Mi", new CityEntity("Miami"))
    );

    private static Map<SimpleFlightPK, SimpleFlightEntity> simpleFlights = new ConcurrentHashMap<>();
    private static Map<MultilegFlightPK, MultilegFlightEntity> multilegFlights = new ConcurrentHashMap<>();

    public Flight fetchFlight(FlightID flightId) {
        System.out.println("Fetching flight " + flightId);

        var flightPK = switch (flightId) {
            case SimpleFlightID(String id) -> new SimpleFlightPK(id);
            case MultilegFlightID(String id) -> new MultilegFlightPK(id);
        };
        var flightEntity = switch (flightPK) {
            case SimpleFlightPK simpleFlightPK -> simpleFlights.computeIfAbsent(
                  simpleFlightPK,
                  pk -> {
                      var from = pk.flightId().substring(0, 2);
                      var to = pk.flightId().substring(2);
                      return new SimpleFlightEntity(
                            pk,
                            cities.get(from), cities.get(to),
                            new PriceEntity(100), new PlaneEntity("Airbus A350"));
                  });

            case MultilegFlightPK multilegFlightPK -> multilegFlights.computeIfAbsent(
                  multilegFlightPK,
                  pk -> {
                      var from = pk.flightId().substring(0, 2);
                      var via = pk.flightId().substring(2, 4);
                      var to = pk.flightId().substring(4);
                      return new MultilegFlightEntity(
                            pk,
                            cities.get(from), cities.get(via), cities.get(to),
                            new PriceEntity(100), new PlaneEntity("Airbus A350"));
                  });
        };

        return switch (flightEntity) {
            case SimpleFlightEntity simpleFlightEntity -> {
                var id = new SimpleFlightID(simpleFlightEntity.id().flightId());
                var from = new City(simpleFlightEntity.from().name());
                var to = new City(simpleFlightEntity.to().name());
                yield new SimpleFlight(id, from, to);
            }
            case MultilegFlightEntity multilegFlightEntity -> {
                var id = new MultilegFlightID(multilegFlightEntity.id().flightId());
                var from = new City(multilegFlightEntity.from().name());
                var via = new City(multilegFlightEntity.via().name());
                var to = new City(multilegFlightEntity.to().name());
                yield new MultilegFlight(id, from, via, to);
            }
        };
    }
}
