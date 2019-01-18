package lk.ijse.dep.library.dao;

import lk.ijse.dep.library.entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {

    Optional<T> find(String key) throws Exception;

    Optional<List<T>> findAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(String key) throws SQLException, Exception;


}



