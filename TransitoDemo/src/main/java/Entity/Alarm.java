package Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alarm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idTunnel;
    private String alarmType;
    private Date alarmTimestamp;
    private int severity;
    
    // Constructor
    public Alarm() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdTunnel() {
        return idTunnel;
    }

    public void setIdTunnel(int idTunnel) {
        this.idTunnel = idTunnel;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Date getAlarmTimestamp() {
        return alarmTimestamp;
    }

    public void setAlarmTimestamp(Date alarmTimestamp) {
        this.alarmTimestamp = alarmTimestamp;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}

