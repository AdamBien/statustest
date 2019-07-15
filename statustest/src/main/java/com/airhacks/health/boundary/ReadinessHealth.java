
package com.airhacks.health.boundary;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author airhacks.com
 */
@Readiness
@ApplicationScoped
public class ReadinessHealth implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("statustest").
                up().
                build();
    }

}
