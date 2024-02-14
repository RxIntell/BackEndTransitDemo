package Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alarm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idTunel")
    private int idTunnel;
    
    @ManyToOne
    @JoinColumn(name = "alarm_type_id")
    private int alarmType;
    
    @Column(name = "alarm_timestamp")
    private Date alarmTimestamp;
    
    @Column(name = "severity")
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

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
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

