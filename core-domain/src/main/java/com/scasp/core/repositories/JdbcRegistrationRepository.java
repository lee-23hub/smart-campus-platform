
package com.scasp.core.repositories;

import com.scasp.core.Registration;
import com.scasp.core.Student;
import com.scasp.core.Course;
import com.scasp.core.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRegistrationRepository {

    public void save(Registration registration) {

        String sql = "INSERT INTO registrations "
                + "(registration_id, student_id, course_id, registration_date, status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, registration.getRegistrationId());
            statement.setString(2, registration.getStudent().getStudentId());
            statement.setString(3, registration.getCourse().getCourseId());
            statement.setDate(4, java.sql.Date.valueOf(
                    registration.getRegistrationDate()));
            statement.setString(5, registration.getStatus());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save registration.", e);
        }
    }

    public List<Registration> findAll() {

        List<Registration> registrations = new ArrayList<>();

        String sql = "SELECT r.*, "
                + "s.full_name, s.email, s.programme, s.year_of_study, "
                + "c.course_name, c.course_code, c.credit_hours, c.capacity "
                + "FROM registrations r "
                + "JOIN students s ON r.student_id = s.student_id "
                + "JOIN courses c ON r.course_id = c.course_id";

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

                Course course = new Course(
                        result.getString("course_id"),
                        result.getString("course_name"),
                        result.getString("course_code"),
                        result.getInt("credit_hours"),
                        result.getInt("capacity")
                );

                Registration registration = new Registration(
                        result.getString("registration_id"),
                        student,
                        course,
                        result.getDate("registration_date").toLocalDate(),
                        result.getString("status")
                );

                registrations.add(registration);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not retrieve registrations.", e);
        }

        return registrations;
    }

    public int count() {

        String sql = "SELECT COUNT(*) FROM registrations";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not count registrations.", e);
        }

        return 0;
    }

    public void delete(String registrationId) {

        String sql = "DELETE FROM registrations WHERE registration_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, registrationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not delete registration.", e);
        }
    }
}
