package systemdesign.bikerental.model;

import java.util.Date;

public class BarCode {
    private String barCode;
    private Date issuedAt;
    private boolean active;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive(){
        return active;
    }
}
