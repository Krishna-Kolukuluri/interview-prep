package systemdesign.bikerental.model;

import java.util.Date;

public class BikeLog {
    private String logId;
    private BikeLogType type;
    private String description;
    private Date creationDate;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public BikeLogType getType() {
        return type;
    }

    public void setType(BikeLogType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
