package systemdesign.bikerental.service;

import systemdesign.bikerental.model.AdditionalRider;
import systemdesign.bikerental.model.Bike;
import systemdesign.bikerental.model.Bill;
import systemdesign.bikerental.model.ReservationStatus;

import java.util.Date;
import java.util.List;

public class BikeReservation {
    private String reservationNumber;
    private Date creationDate;
    private ReservationStatus status;
    private Date dueDate;
    private Date returnedDate;
    private String pickupLocation;
    private int customerId;
    private Bike bike;
    private Bill bill;
    private List<AdditionalRider> additionalRiders;
    private List<Notification> notifications;
    private List<RentalInsurance> insurances;
    private List<Equipment> equipments;
    private List<AdditionalService> services;

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<AdditionalRider> getAdditionalRiders() {
        return additionalRiders;
    }

    public void setAdditionalRiders(List<AdditionalRider> additionalRiders) {
        this.additionalRiders = additionalRiders;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<RentalInsurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<RentalInsurance> insurances) {
        this.insurances = insurances;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<AdditionalService> getServices() {
        return services;
    }

    public void setServices(List<AdditionalService> services) {
        this.services = services;
    }
}
