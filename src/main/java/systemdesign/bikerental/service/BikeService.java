package systemdesign.bikerental.service;

import systemdesign.bikerental.model.Bike;

public interface BikeService {
    public String reserveBike();
    public boolean returnBike();
}
