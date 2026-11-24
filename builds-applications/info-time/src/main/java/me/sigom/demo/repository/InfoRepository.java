package me.sigom.demo.repository;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
@ApplicationScoped
public class InfoRepository {

    private static final Logger LOG = LoggerFactory.getLogger(InfoRepository.class);

    private final Map<String, LocalDateTime> times = Collections.synchronizedMap(new LinkedHashMap<>());
    @PostConstruct
    void init() {
        times.clear();
        times.put("LA", ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).toLocalDateTime());
        times.put("SA", ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).toLocalDateTime());
        times.put("MIA", ZonedDateTime.now(ZoneId.of("America/New_York")).toLocalDateTime());
        times.put("NYC", ZonedDateTime.now(ZoneId.of("America/New_York")).toLocalDateTime());
        // This runs after the constructor and after all @Inject fields are set
        LOG.info("Service is initialized and ready to use!");
    }
    public String getInfoTime(String tag) {
        return times.get(tag).toString();
    }

}
