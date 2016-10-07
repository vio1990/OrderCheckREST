package com.ozerian.rest;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * Class for configuration of date format after json conversion.
 */
@Provider
@Produces("application/json")
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

    public JacksonConfigurator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        mapper.setDateFormat(dateFormat);
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> clazz) {
        return mapper;
    }

    private final ObjectMapper mapper = new ObjectMapper();
}

