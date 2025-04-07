package org.paumard.flightmonitoring;

import org.paumard.flightmonitoring.business.FlightMonitoring;
import org.paumard.flightmonitoring.db.model.FlightPK;

public class FlightMonitoringApp {

    public void main() {

        var flightMonitoring = FlightMonitoring.getInstance();

        var f1 = new FlightPK("PaAt"); // Paris Atlanta
        var f2 = new FlightPK("AmNY"); // Amsterdam New York
        var f3 = new FlightPK("LoMi"); // London Miami
        var f4 = new FlightPK("FrWa"); // Frankurt Washington

        flightMonitoring.followFlight(f1);
        flightMonitoring.followFlight(f2);
        flightMonitoring.followFlight(f3);
        flightMonitoring.followFlight(f4);

        flightMonitoring.monitorFlight(f1);
        flightMonitoring.monitorFlight(f2);
        flightMonitoring.monitorFlight(f3);
        flightMonitoring.monitorFlight(f4);

        while (true) {

        }
    }
}