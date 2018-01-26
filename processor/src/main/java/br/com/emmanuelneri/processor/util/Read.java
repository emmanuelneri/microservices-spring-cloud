package br.com.emmanuelneri.processor.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class Read {

    public static ObjectMapper createDeserializer() {
        final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.WRAP_EXCEPTIONS);
    }
}
