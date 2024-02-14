package service;

import java.util.Date;
import java.util.List;

import Entity.Alarm;

public interface AlarmService {
    
    Alarm createAlarm(int idTunnel, int alarmType, int severity);
    
    List<Alarm> getAlarmsBetweenDates(Date startDate, Date endDate);
    
    List<Alarm> getAlarmsBySeverity(int severity);
    
    List<Alarm> getAlarmsBySeverityAndBetweenDates(int severity, Date startDate, Date endDate);
    
    List<Alarm> getAlarmsBySeverityAndTunnelIdAndBetweenDates(int severity, int tunnelId, Date startDate, Date endDate);
    
    List<Alarm> getAlarmsBySeverityAndTypeAndBetweenDates(int severity, String alarmType, Date startDate, Date endDate);
    
    List<Alarm> getAlarmsByTypeAndBetweenDates(String alarmType, Date startDate, Date endDate);
    
    List<Alarm> getAlarmsByTunnelIdAndBetweenDates(int tunnelId, Date startDate, Date endDate);
    
    List<Alarm> getAlarmsBySeverityAndTunnelIdAndTypeAndBetweenDates(int severity, int tunnelId, String alarmType, Date startDate, Date endDate);

	List<Alarm> getAlarmsByCriteria(Date startDate, Date endDate, Integer severity, Integer tunnelId);
}
