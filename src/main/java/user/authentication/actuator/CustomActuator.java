package user.authentication.actuator;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Actuator endpoints:
 *      /actuator/info
 *      /actuator/health
 *      /actuator/versions
 */
@Endpoint(id = "versions") // has to be plural
@Component
@RequiredArgsConstructor
public class CustomActuator {

    @Value("${info.app.version}")
    String appVersion;


    @SneakyThrows
    @ReadOperation
    public Map<String, String> customActuator() {
        Map<String, String> versions = new HashMap<>();
        versions.put("backendVersion", appVersion);
        return versions;
    }

}
