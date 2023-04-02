package com.mycompany.laborator6.GameConfiguration.Elements;

import java.awt.geom.Line2D;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class Line2DDeserializer extends StdDeserializer<Line2D> {

    public Line2DDeserializer() {
        this(null);
    }

    public Line2DDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Line2D deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        double x1 = node.get("x1").asDouble();
        double y1 = node.get("y1").asDouble();
        double x2 = node.get("x2").asDouble();
        double y2 = node.get("y2").asDouble();
        return new Line2D.Double(x1, y1, x2, y2);
    }
}