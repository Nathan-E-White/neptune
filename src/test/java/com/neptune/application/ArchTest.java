package com.neptune.application;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.neptune.application");

        noClasses()
            .that()
            .resideInAnyPackage("com.neptune.application.service..")
            .or()
            .resideInAnyPackage("com.neptune.application.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.neptune.application.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
