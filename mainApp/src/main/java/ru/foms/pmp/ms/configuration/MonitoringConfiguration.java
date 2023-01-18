package ru.foms.pmp.ms.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseCreateNewEntityExample;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseGetEntityExample;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExampleExtractor;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExamplePersister;
import ru.foms.pmp.ms.monitoring.usecase.usecaseexample.UseCaseCreateNewEntityExampleImpl;
import ru.foms.pmp.ms.monitoring.usecase.usecaseexample.UseCaseGetEntityExampleImpl;
import ru.foms.pmp.ms.monitoring.persistence.InMemoryUseCaseExampleRepository;

@Configuration
public class MonitoringConfiguration {

    @Bean
    UseCaseExampleExtractor useCaseExampleExtractor() {
        return new InMemoryUseCaseExampleRepository();
    }

    @Bean
    UseCaseExamplePersister useCaseExamplePersister() {
        return new InMemoryUseCaseExampleRepository();
    }

    @Bean
    UseCaseGetEntityExample useCaseGetEntityExample(@Qualifier("useCaseExampleExtractor") UseCaseExampleExtractor extractor) {
        return new UseCaseGetEntityExampleImpl(extractor);
    }

    @Bean
    UseCaseCreateNewEntityExample useCaseCreateNewEntityExample(@Qualifier("useCaseExamplePersister") UseCaseExamplePersister persister) {
        return new UseCaseCreateNewEntityExampleImpl(persister);
    }

}
