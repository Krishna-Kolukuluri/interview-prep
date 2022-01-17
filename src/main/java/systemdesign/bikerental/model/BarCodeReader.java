package systemdesign.bikerental.model;

import java.util.Date;

public class BarCodeReader {
    private String id;
    private Date registeredAt;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive(){
        return active;
    }
}
