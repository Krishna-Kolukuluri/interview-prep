package systemdesign.bikerental.service;

import systemdesign.bikerental.model.Bike;

import java.util.List;

public interface BikeSearch {
    public List<Bike> searchByType(String type);
    public List<Bike> searchByModel(String model);
}
