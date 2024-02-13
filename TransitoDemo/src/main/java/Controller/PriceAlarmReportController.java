package Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.AlarmReportDTO;
import service.PriceAlarmReportService;

@RestController
@RequestMapping("/reports")
public class PriceAlarmReportController {

    @Autowired
    private PriceAlarmReportService alarmReportService;

    @GetMapping("/alarms")
    public List<AlarmReportDTO> getAlarmsReport(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date endDate,
            @RequestParam(required = false) Integer severity,
            @RequestParam(required = false) Integer tunnelId) {

        return alarmReportService.getAlarmsReport(startDate, endDate, severity, tunnelId);
    }
}
