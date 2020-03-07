package com.jg.axonqueryone.config;

import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.messaging.StreamableMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class AxonConfiguration {

    // Default all processors to subscribing mode.
    @Autowired
    public void configure(final EventProcessingConfigurer config) {
        config.registerTrackingEventProcessorConfiguration(c -> customConfiguration());
    }

    private TrackingEventProcessorConfiguration customConfiguration() {
        System.out.println("Answer of " + Instant.now().toString() + " : " +Instant.now().isAfter(Instant.parse("2020-03-07T23:37:21.516Z")));
        return TrackingEventProcessorConfiguration
                .forSingleThreadedProcessing()
                .andInitialTrackingToken(StreamableMessageSource::createHeadToken);
    }

}
