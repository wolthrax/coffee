package by.home.hryhoryeu.coffee.dba.dao.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeOrderDAO;
import by.home.hryhoryeu.coffee.entities.CoffeeOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Scope("singleton")
public class CoffeeOrderDAOImpl extends BaseDAOImpl<CoffeeOrder, Long> implements ICoffeeOrderDAO {

    public CoffeeOrderDAOImpl(){
        super(CoffeeOrder.class);
    }
}
