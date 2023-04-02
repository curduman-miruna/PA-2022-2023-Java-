package com.mycompany.laborator6.GameConfiguration.Elements;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.awt.geom.Line2D;
import java.io.IOException;

public class Line2DSerializer extends JsonSerializer<Line2D> {

    @Override
    public void serialize(Line2D value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("x1", value.getX1());
        gen.writeNumberField("y1", value.getY1());
        gen.writeNumberField("x2", value.getX2());
        gen.writeNumberField("y2", value.getY2());
        gen.writeEndObject();
    }
}