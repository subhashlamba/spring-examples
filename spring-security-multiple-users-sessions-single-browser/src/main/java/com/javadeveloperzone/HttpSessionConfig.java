package com.javadeveloperzone;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;


/**
 * Created by Java Developer Zone on 13-11-2017.
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig extends AbstractHttpSessionApplicationInitializer {

    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();                // redis configuration
    }

    @Bean
    public EmbeddedServletContainerCustomizer customizer() { // allowed space in cookies name - http://javadeveloperzone.com/common-error/java-lang-illegalargumentexception-invalid-character-32-present-cookie-value/
        return container -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
            }
        };
    }
}