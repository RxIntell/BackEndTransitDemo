package service;

import java.util.Date;
import java.util.List;

import DTO.AlarmReportDTO;

public interface PriceAlarmReportService {
    List<AlarmReportDTO> getAlarmsReport(Date startDate, Date endDate, Integer severity, Integer tunnelId);
}
