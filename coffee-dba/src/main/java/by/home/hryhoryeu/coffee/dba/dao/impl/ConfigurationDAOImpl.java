package by.home.hryhoryeu.coffee.dba.dao.impl;

import by.home.hryhoryeu.coffee.dba.dao.IConfigurationDAO;
import by.home.hryhoryeu.coffee.entities.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Scope("singleton")
public class ConfigurationDAOImpl extends BaseDAOImpl<Configuration, String> implements IConfigurationDAO{

    public ConfigurationDAOImpl() {
        super(Configuration.class);
    }

}
