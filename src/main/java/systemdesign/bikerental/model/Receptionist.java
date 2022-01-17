package systemdesign.bikerental.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Receptionist extends Account{
    private Date dateJoined;

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<Member> searchMember(String name){
        return Collections.emptyList();
    }
    @Override
    public boolean resetPassword() {
        return false;
    }
}
