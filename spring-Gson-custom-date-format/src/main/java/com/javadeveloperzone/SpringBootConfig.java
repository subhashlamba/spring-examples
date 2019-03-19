package com.javadeveloperzone;

import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */

@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {



    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringBootConfig.class, args);            // it wil start application
    }

    // for date to long

    @Bean
    GsonBuilder gsonBuilder(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
                // convert date to long
                return new JsonPrimitive(date.getTime());
            }
        });

        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                                                                                                        JsonParseException {
                // convert long to date
                return new Date(json.getAsLong());
            }
        });
        return gsonBuilder;
    }

    // for time zone

    /* @Bean
    GsonBuilder gsonBuilder(){
        GsonBuilder gsonBuilder=new GsonBuilder();

        final DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");      //This is the format I need
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        gsonBuilder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
                // convert date to long
                return new JsonPrimitive(dateFormat.format(date));
            }
        });

        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                                                                                                   JsonParseException {
                try {
                    return dateFormat.parse(json.getAsString());
                }catch (Exception e){
                    return null;
                }
            }
        });
        return gsonBuilder;
    }/*

    /* @Bean
        GsonBuilder gsonBuilder(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setDateFormat("MM-dd-yyyy");
        return gsonBuilder;
    }*/
}
