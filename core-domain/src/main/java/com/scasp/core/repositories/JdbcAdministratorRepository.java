
package com.scasp.core.repositories;

import com.scasp.core.Administrator;
import com.scasp.core.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAdministratorRepository {

    public void save(Administrator administrator) {

        String sql = "INSERT INTO administrators "
                + "(administrator_id, full_name, email) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, administrator.getAdministratorId());
            statement.setString(2, administrator.getFullName());
            statement.setString(3, administrator.getEmail());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save administrator.", e);
        }
    }

    public List<Administrator> findAll() {

        List<Administrator> administrators = new ArrayList<>();

        String sql = "SELECT * FROM administrators";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                administrators.add(new Administrator(
                        result.getString("administrator_id"),
                        result.getString("full_name"),
                        result.getString("email")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not retrieve administrators.", e);
        }

        return administrators;
    }

    public int count() {

        String sql = "SELECT COUNT(*) FROM administrators";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not count administrators.", e);
        }

        return 0;
    }

    public void delete(String administratorId) {

        String sql = "DELETE FROM administrators "
                + "WHERE administrator_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, administratorId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not delete administrator.", e);
        }
    }
}
