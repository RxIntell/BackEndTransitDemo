package DTO;

import java.util.Date;

public class AlarmReportDTO {

    private int severity;
    private Date alarmTimestamp;
    private String alarmType;
    private int tunnelId;
    
    
    
    
	public AlarmReportDTO() {
		super();
	}

	public AlarmReportDTO(int severity, Date alarmTimestamp, String alarmType, int tunnelId) {
		super();
		this.severity = severity;
		this.alarmTimestamp = alarmTimestamp;
		this.alarmType = alarmType;
		this.tunnelId = tunnelId;
	}




	public int getSeverity() {
		return severity;
	}


	public void setSeverity(int severity) {
		this.severity = severity;
	}


	public Date getAlarmTimestamp() {
		return alarmTimestamp;
	}


	public void setAlarmTimestamp(Date alarmTimestamp) {
		this.alarmTimestamp = alarmTimestamp;
	}


	public String getAlarmType() {
		return alarmType;
	}


	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}


	public int getTunnelId() {
		return tunnelId;
	}


	public void setTunnelId(int tunnelId) {
		this.tunnelId = tunnelId;
	}
    
    
}
