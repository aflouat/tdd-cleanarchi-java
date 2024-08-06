package com.wealcome.integration;

import com.wealcome.integration.configuration.SecondaryAdaptersIntegrationTestConfiguration;
import com.wealcome.docker.TestContainers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@EnableAutoConfiguration
@EntityScan("com.wealcome.nextride")
@EnableJpaRepositories("com.wealcome.nextride")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {SecondaryAdaptersIntegrationTestConfiguration.class})
public class AbstractBaseIntegration extends TestContainers {
}
