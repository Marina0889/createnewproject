package ru.sapteh.utils;

import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.ModelDaoIml;
import ru.sapteh.model.Model;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getInstance();
        Dao<Model, Integer> modelDao = new ModelDaoIml(connection);
        System.out.println(modelDao.findById(1));
        modelDao.findAll().forEach(System.out::println);

//        Model model = new Model("Honda","sedan","fuel");
//        modelDao.save(model);


//       Model modelUpdater = modelDao.findById(1);
//        modelUpdater.setMark("Honda");
//      modelUpdater.setBodyType("sedan");
//        modelUpdater.setGasoline("fuel");
//       modelDao.update(modelUpdater);


//        modelDao.deleteById(1);
        Connector.close(connection);
    }
}
