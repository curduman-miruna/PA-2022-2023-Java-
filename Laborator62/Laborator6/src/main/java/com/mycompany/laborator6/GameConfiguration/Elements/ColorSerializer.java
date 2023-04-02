package com.mycompany.laborator6.GameConfiguration.Elements;
import java.awt.Color;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class ColorSerializer extends StdSerializer<Color> {

    public ColorSerializer() {
        super(Color.class);
    }

    @Override
    public void serialize(Color color, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("r", color.getRed());
        gen.writeNumberField("g", color.getGreen());
        gen.writeNumberField("b", color.getBlue());
        gen.writeNumberField("a", color.getAlpha());
        gen.writeEndObject();
    }
}