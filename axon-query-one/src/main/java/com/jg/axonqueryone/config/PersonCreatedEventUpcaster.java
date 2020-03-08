package com.jg.axonqueryone.config;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jg.axoncommons.api.events.PersonCreatedEvent;
import org.axonframework.serialization.SimpleSerializedType;
import org.axonframework.serialization.upcasting.event.IntermediateEventRepresentation;
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster;
import org.dom4j.Document;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PersonCreatedEventUpcaster extends SingleEventUpcaster {

    private static SimpleSerializedType targetType =
            new SimpleSerializedType(PersonCreatedEvent.class.getTypeName(), null);

    @Override
    protected boolean canUpcast(IntermediateEventRepresentation intermediateRepresentation) {
        return intermediateRepresentation.getType().equals(targetType);
    }

    @Override
    protected IntermediateEventRepresentation doUpcast(IntermediateEventRepresentation intermediateRepresentation) {
        return intermediateRepresentation.upcastPayload(
                new SimpleSerializedType(targetType.getName(), "2.0"),
                Document.class,
                document -> {
                    document.getRootElement()
                            .addElement("age")
                            .setText("-1");
                    return document;
                }
        );
    }
}
