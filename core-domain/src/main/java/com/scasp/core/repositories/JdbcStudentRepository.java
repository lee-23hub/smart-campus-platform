
package com.scasp.core.repositories;

import com.scasp.core.Student;
import com.scasp.core.database.DatabaseConnection;
import com.scasp.core.interfaces.StudentRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentRepository implements StudentRepositoryInterface {

    @Override
    public void save(Student student) {

        String sql = "INSERT INTO students "
                + "(student_id, full_name, email, programme, year_of_study) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getStudentId());
            statement.setString(2, student.getFullName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getProgramme());
            statement.setInt(5, student.getYearOfStudy());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save student.", e);
        }
    }

    @Override
    public void delete(Student student) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getStudentId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not delete student.", e);
        }
    }

    @Override
    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Student student = new Student(
                        result.getString("student_id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getString("programme"),
                        result.getInt("year_of_study")
                );

                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not retrieve students.", e);
        }

        return students;
    }

    @Override
    public int count() {

        String sql = "SELECT COUNT(*) FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not count students.", e);
        }

        return 0;
    }
}
