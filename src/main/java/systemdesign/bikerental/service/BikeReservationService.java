package systemdesign.bikerental.service;

import systemdesign.bikerental.model.AdditionalRider;

import java.util.List;

public interface BikeReservationService {
    public BikeReservation fetchReservationDetails(String reservationNumber);
    public List<AdditionalRider> getAdditionalRiders( String reservationNumber);
}
