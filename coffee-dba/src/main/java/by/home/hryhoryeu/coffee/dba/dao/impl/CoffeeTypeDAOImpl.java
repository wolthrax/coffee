package by.home.hryhoryeu.coffee.dba.dao.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeTypeDAO;
import by.home.hryhoryeu.coffee.entities.CoffeeType;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Scope("singleton")
public class CoffeeTypeDAOImpl extends BaseDAOImpl<CoffeeType, Long> implements ICoffeeTypeDAO{

    public CoffeeTypeDAOImpl(){
        super(CoffeeType.class);
    }

    @Override
    public List<CoffeeType> getEnabledCoffeeType() {
        Query query = getSession().createQuery("select c from CoffeeType c where c.disabled != 'Y'");
        return (List<CoffeeType>) query.getResultList();
    }
}
