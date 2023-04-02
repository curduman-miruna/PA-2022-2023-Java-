package com.mycompany.laborator6.GameConfiguration.Elements;

import java.awt.Color;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class ColorDeserializer extends StdDeserializer<Color> {

    public ColorDeserializer() {
        super(Color.class);
    }

    @Override
    public Color deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        int r = node.get("r").intValue();
        int g = node.get("g").intValue();
        int b = node.get("b").intValue();
        int a = node.get("a").intValue();
        return new Color(r, g, b, a);
    }
}