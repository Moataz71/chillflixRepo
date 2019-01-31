package com.molveno.molveno.help;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;



public class JsonBuilder {


    private final ObjectMapper objectMapper;

    public JsonBuilder() {
        this(false);
    }

    public JsonBuilder(final boolean prettyPrint) {
        objectMapper = new ObjectMapper();
        if (prettyPrint) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        // These settings enable the correct conversion of LocalDateTime, LocalDate, LocalTime to ISO strings
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public <T> T readValue(final String content, final Class<T> valueType) throws IOException {
        return objectMapper.readValue(content, valueType);
    }

    public <T> T readValue(final Reader src, final Class<T> valueType) throws IOException {
        return objectMapper.readValue(src, valueType);
    }

    public <T> T readValue(final byte[] src, final Class<T> valueType) throws IOException {
        return objectMapper.readValue(src, valueType);
    }

    public void writeValue(final Writer w, final Object value) throws IOException {
        objectMapper.writeValue(w, value);
    }

    public String writeValueAsString(final Object value) throws IOException {
        return objectMapper.writeValueAsString(value);
    }

    public String writeValueAsStringPrettyPrint(final Object value) throws IOException {
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(value);
    }




}
