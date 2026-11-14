
package com.scasp.core.repositories;

import com.scasp.core.AcademicRequest;
import com.scasp.core.Student;
import com.scasp.core.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAcademicRequestRepository {

    public void save(AcademicRequest request) {

        String sql = "INSERT INTO academic_requests "
                + "(request_id, student_id, request_type, description, "
                + "submission_date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, request.getRequestId());
            statement.setString(2, request.getStudent().getStudentId());
            statement.setString(3, request.getRequestType());
            statement.setString(4, request.getDescription());
            statement.setDate(5, java.sql.Date.valueOf(
                    request.getSubmissionDate()));
            statement.setString(6, request.getStatus());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save academic request.", e);
        }
    }

    public List<AcademicRequest> findAll() {

        List<AcademicRequest> requests = new ArrayList<>();

        String sql = "SELECT a.*, s.full_name, s.email, "
                + "s.programme, s.year_of_study "
                + "FROM academic_requests a "
                + "JOIN students s ON a.student_id = s.student_id";

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

                AcademicRequest request = new AcademicRequest(
                        result.getString("request_id"),
                        student,
                        result.getString("request_type"),
                        result.getString("description"),
                        result.getDate("submission_date").toLocalDate(),
                        result.getString("status")
                );

                requests.add(request);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not retrieve academic requests.", e);
        }

        return requests;
    }

    public int count() {

        String sql = "SELECT COUNT(*) FROM academic_requests";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not count academic requests.", e);
        }

        return 0;
    }

    public void delete(String requestId) {

        String sql = "DELETE FROM academic_requests WHERE request_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, requestId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not delete academic request.", e);
        }
    }
}
