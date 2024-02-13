package ServiceImpl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.AlarmReportDTO;
import Entity.Alarm;
import service.AlarmService;
import service.PriceAlarmReportService;

@Service
public class PriceAlarmReportServiceImpl implements PriceAlarmReportService {

    @Autowired
    private AlarmService alarmService;

    @Override
    public List<AlarmReportDTO> getAlarmsReport(Date startDate, Date endDate, Integer severity, Integer tunnelId) {
    	
    	//Llamo servicio de busqueda
        List<Alarm> alarms = alarmService.getAlarmsByCriteria(startDate, endDate, severity, tunnelId);
        
        //Ordenar en orden indicado
        alarms.sort(Comparator.comparing(Alarm::getSeverity).reversed().thenComparing(Alarm::getAlarmTimestamp));
        //Lo mapeo al objeto de salida
        return alarms.stream().map(this::mapToAlarmReportDTO).collect(Collectors.toList());
    }

    private AlarmReportDTO mapToAlarmReportDTO(Alarm alarm) {
        return new AlarmReportDTO(
                alarm.getSeverity(),
                alarm.getAlarmTimestamp(),
                alarm.getAlarmType(),
                alarm.getIdTunnel()
        );
    }
}

