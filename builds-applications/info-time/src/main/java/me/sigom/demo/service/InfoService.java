package me.sigom.demo.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.sigom.demo.repository.InfoRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class InfoService {

    @ConfigProperty(name = "app.info.version")
    String infoVersion;
    @ConfigProperty(name = "app.info.zone")
    String infoZone;
    @ConfigProperty(name = "app.info.datacenter")
    String infoDatacenter;
    @ConfigProperty(name = "app.info.manager")
    String infoManager;
    @Inject
    InfoRepository infoRepository;

    public String getInfoTime(String tag) {
        return infoRepository.getInfoTime(tag);
    }

    public Map<String,String> getInfo() {
        Map<String,String> info = new HashMap<>();
        info.put("Application version: ", infoVersion);
        info.put("Managed by: ", infoManager);
        info.put("Running at Datacenter", infoDatacenter);
        info.put("Timme Zone", infoZone);
        return info;
    }
}
