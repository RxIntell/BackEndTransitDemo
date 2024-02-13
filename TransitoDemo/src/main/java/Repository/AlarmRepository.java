package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Alarm;

import java.util.Date;
import java.util.List;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    List<Alarm> findByAlarmTimestampBetween(Date startDate, Date endDate);
    List<Alarm> findBySeverity(int severity);
    List<Alarm> findBySeverityAndAlarmTimestampBetween(int severity, Date startDate, Date endDate);
    List<Alarm> findBySeverityAndIdTunnelAndAlarmTimestampBetween(int severity, int idTunnel, Date startDate, Date endDate);
    List<Alarm> findBySeverityAndAlarmTypeAndAlarmTimestampBetween(int severity, String alarmType, Date startDate, Date endDate);
    List<Alarm> findByAlarmTypeAndAlarmTimestampBetween(String alarmType, Date startDate, Date endDate);
    List<Alarm> findByIdTunnelAndAlarmTimestampBetween(int idTunnel, Date startDate, Date endDate);
    List<Alarm> findBySeverityAndIdTunnelAndAlarmTypeAndAlarmTimestampBetween(int severity, int idTunnel, String alarmType, Date startDate, Date endDate);
}

