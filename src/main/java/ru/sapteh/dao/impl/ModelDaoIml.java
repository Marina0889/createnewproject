package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

  public class ModelDaoIml implements Dao<Model, Integer> {
      private final Connection connection;
      public ModelDaoIml(Connection connection) {
          this.connection = connection;
      }
      @Override
      public Model findById(Integer id) {
          String query = "SELECT * FROM model WHERE id=?";
          Model model = null;
          try {
              PreparedStatement statement = connection.prepareStatement(query);
              statement.setInt(1, id);
              ResultSet resultSet = statement.executeQuery();
              while (resultSet.next()) {
                  model = new Model(
                          resultSet.getInt("id"),
                          resultSet.getString("mark"),
                          resultSet.getString("body_type"),
                          resultSet.getString("gasoline")
                  );
              }
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
          return model;
      }

      @Override
      public List<Model> findAll() {
          List<Model> model = new ArrayList<>();
          String query = "SELECT * FROM model";
          try {
              PreparedStatement statement = connection.prepareStatement(query);
              ResultSet resultSet = statement.executeQuery();
              while (resultSet.next()) {
                  model.add(
                          new Model(
                                  resultSet.getInt("id"),
                                  resultSet.getString("mark"),
                                  resultSet.getString("body_type"),
                                  resultSet.getString("gasoline")
                          )
                  );
              }
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
          return model;

      }

      @Override
      public void save(Model model) {
          String save = "INSERT INTO model (mark, body_type, gasoline) VALUES (?, ?,?)";
          try {
              PreparedStatement statement = connection.prepareStatement(save);
              statement.setString(1, model.getMark());
              statement.setString(2, model.getBodyType());
              statement.setString(3, model.getGasoline());

              int result = statement.executeUpdate();
              System.out.println(result == 1 ? "Save success" : "Save failed");
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
      }

      @Override
      public void deleteById(Integer id) {
          String delete = "DELETE FROM model WHERE id=?";
          try {
              PreparedStatement statement = connection.prepareStatement(delete);
              statement.setInt(1, id);
              int result = statement.executeUpdate();
              System.out.println(result == 1 ? "Delete success" : "Delete failed");
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
      }

      @Override
      public void update(Model model) {
          String update = "UPDATE model SET mark=?, body_type=?, gasoline=? WHERE id=?";
          try {
              PreparedStatement statement = connection.prepareStatement(update);
              statement.setString(1, model.getMark());
              statement.setString(2, model.getBodyType());
              statement.setString(3, model.getGasoline());
              statement.setInt(4, model.getId());
              int result = statement.executeUpdate();
              System.out.println(result == 1 ? "Update success" : "Update failed");
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }

      }
  }


