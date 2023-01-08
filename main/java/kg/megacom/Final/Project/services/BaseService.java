package kg.megacom.Final.Project.services;

import java.util.List;

public interface BaseService <T>{
    T save(T t);
    T findById(Long id, int lang);
    List<T> findAll();


}
