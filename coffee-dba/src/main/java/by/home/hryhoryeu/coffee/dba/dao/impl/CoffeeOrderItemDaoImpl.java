package by.home.hryhoryeu.coffee.dba.dao.impl;

import by.home.hryhoryeu.coffee.dba.dao.ICoffeeOrderItemDAO;
import by.home.hryhoryeu.coffee.entities.CoffeeOrderItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Scope("singleton")
public class CoffeeOrderItemDaoImpl extends BaseDAOImpl<CoffeeOrderItem, Long> implements ICoffeeOrderItemDAO{

    public CoffeeOrderItemDaoImpl(){
        super(CoffeeOrderItem.class);
    }
}
