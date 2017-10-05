package by.home.hryhoryeu.coffee.dba.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IBaseDAO<T, PK extends Serializable> {
    List<T> getAll();
    T get(PK id);
    PK add(T object);
    void delete (T object);
    void update (T object);
}
