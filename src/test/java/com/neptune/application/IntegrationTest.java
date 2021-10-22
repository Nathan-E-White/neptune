package com.neptune.application;

import com.neptune.application.AbstractNeo4jIT;
import com.neptune.application.NeptuneApp;
import com.neptune.application.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { NeptuneApp.class, TestSecurityConfiguration.class })
@ExtendWith(AbstractNeo4jIT.class)
public @interface IntegrationTest {
}
