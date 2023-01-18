package ru.foms.pmp.ms.monitoring.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;


@AnalyzeClasses(packages = "ru.foms.pmp.ms.monitoring", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureGuardTest {

    @ArchTest
    public static ArchRule archRule = Architectures.onionArchitecture()
            .domainModels("ru.foms.pmp.ms.monitoring.domain..")
            .domainServices("ru.foms.pmp.ms.monitoring.domain..")
            .applicationServices("ru.foms.pmp.ms.monitoring.usecase..")
            .adapter("persistence","ru.foms.pmp.ms.monitoring.persistence..")
            .adapter("integration", "ru.foms.pmp.ms.monitoring.integration..");

}