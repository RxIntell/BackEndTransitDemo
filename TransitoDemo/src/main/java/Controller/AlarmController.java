package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entity.Alarm;
import service.AlarmService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/alarms")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping("/")
    public ResponseEntity<?> createAlarm(@RequestParam int idTunnel, @RequestParam String alarmType, @RequestParam int severity) {
        try {
            Alarm createdAlarm = alarmService.createAlarm(idTunnel, alarmType, severity);
            return new ResponseEntity<>(createdAlarm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la alarma: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<?> getAlarmsBetweenDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBetweenDates(startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<?> getAlarmsBySeverity(@PathVariable int severity) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBySeverity(severity);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por severidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/severity/{severity}/date-range")
    public ResponseEntity<?> getAlarmsBySeverityAndBetweenDates(@PathVariable int severity,
                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBySeverityAndBetweenDates(severity, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por severidad y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/severity/{severity}/tunnel/{idTunnel}/date-range")
    public ResponseEntity<?> getAlarmsBySeverityAndTunnelIdAndBetweenDates(@PathVariable int severity,
                                                                           @PathVariable int idTunnel,
                                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBySeverityAndTunnelIdAndBetweenDates(severity, idTunnel, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por severidad, túnel y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/severity/{severity}/type/{alarmType}/date-range")
    public ResponseEntity<?> getAlarmsBySeverityAndTypeAndBetweenDates(@PathVariable int severity,
                                                                       @PathVariable String alarmType,
                                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBySeverityAndTypeAndBetweenDates(severity, alarmType, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por severidad, tipo de alarma y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/type/{alarmType}/date-range")
    public ResponseEntity<?> getAlarmsByTypeAndBetweenDates(@PathVariable String alarmType,
                                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsByTypeAndBetweenDates(alarmType, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por tipo de alarma y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tunnel/{idTunnel}/date-range")
    public ResponseEntity<?> getAlarmsByTunnelIdAndBetweenDates(@PathVariable int idTunnel,
                                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsByTunnelIdAndBetweenDates(idTunnel, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por túnel y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/severity/{severity}/tunnel/{idTunnel}/type/{alarmType}/date-range")
    public ResponseEntity<?> getAlarmsBySeverityAndTunnelIdAndTypeAndBetweenDates(@PathVariable int severity,
                                                                                   @PathVariable int idTunnel,
                                                                                   @PathVariable String alarmType,
                                                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
                                                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
        try {
            List<Alarm> alarms = alarmService.getAlarmsBySeverityAndTunnelIdAndTypeAndBetweenDates(severity, idTunnel, alarmType, startDate, endDate);
            return new ResponseEntity<>(alarms, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las alarmas por severidad, túnel, tipo de alarma y rango de fecha: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

