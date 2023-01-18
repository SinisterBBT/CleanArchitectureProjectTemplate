package ru.foms.pmp.ms.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.foms.pmp.ms.configuration.MonitoringConfiguration;

@SpringBootApplication
@Import(MonitoringConfiguration.class)
public class MonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringApplication.class, args);
    }

}
