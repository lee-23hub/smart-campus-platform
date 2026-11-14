
package com.scasp.core.repositories;

import com.scasp.core.Course;
import com.scasp.core.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCourseRepository {

    public void save(Course course) {

        String sql = "INSERT INTO courses "
                + "(course_id, course_name, course_code, credit_hours, capacity) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setString(3, course.getCourseCode());
            statement.setInt(4, course.getCreditHours());
            statement.setInt(5, course.getCapacity());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save course.", e);
        }
    }

    public List<Course> findAll() {

        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM courses";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Course course = new Course(
                        result.getString("course_id"),
                        result.getString("course_name"),
                        result.getString("course_code"),
                        result.getInt("credit_hours"),
                        result.getInt("capacity")
                );

                courses.add(course);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not retrieve courses.", e);
        }

        return courses;
    }

    public int count() {

        String sql = "SELECT COUNT(*) FROM courses";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not count courses.", e);
        }

        return 0;
    }

    public void delete(String courseId) {

        String sql = "DELETE FROM courses WHERE course_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, courseId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not delete course.", e);
        }
    }
}
