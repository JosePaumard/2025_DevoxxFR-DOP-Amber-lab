package org.paumard.flightmonitoring.db.model;

public non-sealed class MultilegFlightEntity implements FlightEntity {
    private MultilegFlightPK id;
    private CityEntity from;
    private CityEntity to;
    private CityEntity via;
    private PriceEntity price;
    private PlaneEntity plane;

    public MultilegFlightEntity(MultilegFlightPK id, CityEntity from, CityEntity to, CityEntity via, PriceEntity price, PlaneEntity plane) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.via = via;
        this.price = price;
        this.plane = plane;
    }

    public MultilegFlightPK id() {
        return this.id;
    }

    public CityEntity from() {
        return this.from;
    }

    public CityEntity to() {
        return this.to;
    }

    public CityEntity via() {
        return this.via;
    }

    public PriceEntity price() {
        return this.price;
    }

    public void updatePrice(PriceEntity price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight[id=" + id + ", from=" + from + ", city=" + to +
               ", price=" + price + ", plane = " + plane + "]";
    }
}
