package org.paumard.flightmonitoring.db.model;

public sealed interface FlightEntity
      permits SimpleFlightEntity, MultilegFlightEntity {}