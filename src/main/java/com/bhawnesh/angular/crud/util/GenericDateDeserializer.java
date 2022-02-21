package com.bhawnesh.angular.crud.util;

import com.bhawnesh.angular.crud.constants.GenericConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
public class GenericDateDeserializer extends StdDeserializer<Date> {
    public GenericDateDeserializer() {
        this(null);
    }

    public GenericDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        final String date = node.textValue();

        for (String DATE_FORMAT : GenericConstants.DATE_FORMATS) {
            try {
                return new SimpleDateFormat(DATE_FORMAT).parse(date);
            } catch (ParseException e) {
                log.error("unable to parse date:{}: format:{}: due to:{}", date, DATE_FORMAT, e.getMessage());
            }
        }
        throw new JsonParseException(jp, "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.toString(GenericConstants.DATE_FORMATS));
    }
}