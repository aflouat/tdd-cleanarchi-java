package integration;

import docker.TestContainers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@EnableAutoConfiguration
// @EntityScan("com.wealcome.nextride.....jpa.entities")
// @EnableJpaRepositories("com.wealcome.nextride....repositories.jpa")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AbstractBaseIntegration extends TestContainers {
}
