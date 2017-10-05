package by.home.hryhoryeu.coffee.services.convertors;

import by.home.hryhoryeu.coffee.dto.ConfigurationDTO;
import by.home.hryhoryeu.coffee.entities.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigurationToDTO {

    public ConfigurationDTO convertTo(List<Configuration> configList){
        ConfigurationDTO configDTO = new ConfigurationDTO();

        for(Configuration config : configList){
            if(config.getId().equals("x"))
                configDTO.setX(Integer.valueOf(config.getValue()));
            else if(config.getId().equals("n"))
                configDTO.setN(Integer.valueOf(config.getValue()));
            else if(config.getId().equals("m"))
                configDTO.setM(Integer.valueOf(config.getValue()));
        }
        configDTO.setDefaultConfig(true);
        return configDTO;
    }
}
