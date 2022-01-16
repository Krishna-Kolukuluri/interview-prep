package systemdesign.parkinglot.service;

public class EntrancePanelImpl implements EntrancePanel{
    private String entrancePanelId;

    public String getEntrancePanelId() {
        return entrancePanelId;
    }

    public void setEntrancePanelId(String entrancePanelId) {
        this.entrancePanelId = entrancePanelId;
    }

    @Override
    public boolean printTicket() {
        return false;
    }
}
