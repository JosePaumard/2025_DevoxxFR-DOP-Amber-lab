package org.paumard.flightmonitoring.gui;

import org.paumard.flightmonitoring.business.model.City;
import org.paumard.flightmonitoring.business.model.Flight;
import org.paumard.flightmonitoring.business.model.MultilegFlight;
import org.paumard.flightmonitoring.business.model.SimpleFlight;
import org.paumard.flightmonitoring.business.service.FlightGUIService;

public class FlightGUI implements FlightGUIService {

    public void displayFlight(Flight flight) {
        switch (flight) {
            case SimpleFlight(var id, City(var from), City(var to)) -> System.out.println(
                  "Flight from " + from + " to " + to +
                  ": price is now " + SimpleFlight.price(id).price());
            case MultilegFlight(var id, City(var from), City(var via), City(var to)) -> System.out.println(
                  "Flight from " + from +
                        " to " + to +
                        " via " + via +
                        ": price is now " + MultilegFlight.price(id).price());
        }
    }
}
