
package com.scasp.core.repositories;

import com.scasp.core.Announcement;
import com.scasp.core.Administrator;
import com.scasp.core.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAnnouncementRepository {

    public void save(Announcement announcement) {

        String sql = "INSERT INTO announcements "
                + "(announcement_id, title, message, publication_date, "
                + "administrator_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, announcement.getAnnouncementId());
            statement.setString(2, announcement.getTitle());
            statement.setString(3, announcement.getMessage());
            statement.setDate(4, java.sql.Date.valueOf(
                    announcement.getPublicationDate()));
            statement.setString(5,
                    announcement.getAuthor().getAdministratorId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save announcement.", e);
        }
    }

    public List<Announcement> findAll() {

        List<Announcement> announcements = new ArrayList<>();

        String sql = "SELECT a.*, ad.full_name, ad.email "
                + "FROM announcements a "
                + "JOIN administrators ad "
                + "ON a.administrator_id = ad.administrator_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Administrator administrator = new Administrator(
                        result.getString("administrator_id"),
                        result.getString("full_name"),
                        result.getString("email")
                );

                Announcement announcement = new Announcement(
                        result.getString("announcement_id"),
                        result.getString("title"),
                        result.getString("message"),
                        result.getDate("publication_date").toLocalDate(),
                        administrator
                );

                announcements.add(announcement);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not retrieve announcements.", e);
        }

        return announcements;
    }

    public int count() {

        String sql = "SELECT COUNT(*) FROM announcements";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not count announcements.", e);
        }

        return 0;
    }

    public void delete(String announcementId) {

        String sql = "DELETE FROM announcements WHERE announcement_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, announcementId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not delete announcement.", e);
        }
    }
}
