package com.wealcome.e2e;

import com.wealcome.nextride.adapters.primary.springboot.AppLaunch;
import com.wealcome.docker.TestContainers;
import com.wealcome.e2e.adapters.primary.springboot.configuration.SpringConfigurationE2E;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = AppLaunch.class
)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {SpringConfigurationE2E.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractBaseE2E extends TestContainers {
}
