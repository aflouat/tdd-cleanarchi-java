package e2e;

import com.wealcome.nextride.adapters.primary.springboot.AppLaunch;
import docker.TestContainers;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = AppLaunch.class
)
// @ContextConfiguration(classes = {UseCasesConfiguration.class, RepositoriesConfigurationWithDatabase.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractBaseE2E extends TestContainers {
}
