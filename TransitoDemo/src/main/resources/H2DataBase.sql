CREATE TABLE IF NOT EXISTS ta (
    id INT PRIMARY KEY,
    Xkey VARCHAR(10) NOT NULL,
    Description VARCHAR(255) NOT NULL
);

INSERT INTO ta (id, Xkey, Description) VALUES (2, 'HUM', 'Humedad');
INSERT INTO ta (id, Xkey, Description) VALUES (3, 'DI', 'Dioxido de Carbono');

CREATE TABLE IF NOT EXISTS alarmas (
   id INT AUTO_INCREMENT PRIMARY KEY,
   idTunel INT NOT NULL,
   alarm_type INT NOT NULL,
   alarm_timestamp TIMESTAMP NOT NULL,
   description VARCHAR(255) NOT NULL,
   severity INT NOT NULL,
   FOREIGN KEY (idTunel) REFERENCES ta(id)
);

INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (101, 2, '2024-01-02 23:21:59', 'Humeda al 10%', 1);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (102, 2, '2024-01-02 22:21:59', 'Humeda al 60%', 3);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (104, 2, '2024-04-10 21:21:59', 'Humeda al 90%', 5);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (107, 3, '2024-03-10 22:21:59', 'Dioxido de carbono 60%', 4);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (240, 3, '2024-04-10 22:21:59', 'Dioxido de carbono 80%', 5);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (10, 3, '2024-02-07 22:21:59', 'Dioxido de carbono 20%', 1);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (14, 2, '2024-02-07 22:21:59', 'Humeda al 60%', 3);
INSERT INTO alarmas (idTunel, alarm_type, alarm_timestamp, description, severity) VALUES (107, 3, '2024-03-10 23:59:59', 'Dioxido de carbono 10%', 1);
