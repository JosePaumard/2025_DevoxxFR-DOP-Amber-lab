package org.paumard.flightmonitoring;

import org.paumard.flightmonitoring.business.FlightMonitoring;
import org.paumard.flightmonitoring.business.model.FlightID;
import org.paumard.flightmonitoring.business.service.DBService;
import org.paumard.flightmonitoring.business.service.FlightGUIService;
import org.paumard.flightmonitoring.business.service.PriceMonitoringService;
import org.paumard.flightmonitoring.db.FlightDBService;
import org.paumard.flightmonitoring.gui.FlightGUI;
import org.paumard.flightmonitoring.pricemonitoring.FlightPriceMonitoringService;

import java.util.concurrent.Executors;

public class FlightMonitoringApp {

    public void main() throws InterruptedException {

        DBService dbService =
                new FlightDBService();
        FlightGUIService guiService =
                new FlightGUI();
        PriceMonitoringService monitoringService =
                new FlightPriceMonitoringService();
        var flightMonitoring =
                new FlightMonitoring(
                        dbService,
                        guiService,
                        monitoringService);

        var f1 = new FlightID("PaAt"); // Paris Atlanta
        var f2 = new FlightID("AmNY"); // Amsterdam New York
        var f3 = new FlightID("LoMi"); // London Miami
        var f4 = new FlightID("FrWa"); // Frankurt Washington

        flightMonitoring.followFlight(f1);
        flightMonitoring.followFlight(f2);
        flightMonitoring.followFlight(f3);
        flightMonitoring.followFlight(f4);

        flightMonitoring.monitorFlight(f1);
        flightMonitoring.monitorFlight(f2);
        flightMonitoring.monitorFlight(f3);
        flightMonitoring.monitorFlight(f4);

        var executor = Executors.newScheduledThreadPool(1);

        var updatePrices = monitoringService.updatePrices(executor);
        var display = flightMonitoring.launchDisplay(executor);

        Thread.sleep(5_000);
        display.cancel(true);
        updatePrices.cancel(true);
        executor.shutdownNow();
    }
}