package com.splittypay.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.lang.syntax.elements.ClassesThat;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;

@AnalyzeClasses(packages = "com.splittypay")
class ModelsDependencyTest {

    private static final String MODELS_PACKAGE = "..splittypay.model";

    private static ClassesThat<GivenClassesConjunction> notTestClassesThat() {
        return ArchRuleDefinition.classes().that()
                .haveNameNotMatching(".*(Test|Spec).*")
                .and();
    }

    @ArchTest
    private static ArchRule MODELS_SHOULD_NOT_DEPEND_ON_OTHER_CLASSES =
            notTestClassesThat()
                    .resideInAPackage(MODELS_PACKAGE)
                    .should()
                    .onlyDependOnClassesThat()
                    .resideInAnyPackage(
                            MODELS_PACKAGE,
                            "java.lang", "java.time", "java.util..", "io.vavr..", "java.io",
                            "" /* Avoid issue with enums. See: https://github.com/TNG/ArchUnit/issues/81#issuecomment-399688049 */
                    );
}
