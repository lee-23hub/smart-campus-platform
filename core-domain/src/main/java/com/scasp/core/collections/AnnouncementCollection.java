
package com.scasp.core.collections;

import com.scasp.core.Announcement;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementCollection {

    private final List<Announcement> announcements = new ArrayList<>();

    // Add an announcement
    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    // Remove an announcement
    public void removeAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
    }

    // Get all announcements
    public List<Announcement> getAnnouncements() {
        return new ArrayList<>(announcements);
    }

    // Get total number of announcements
    public int getAnnouncementCount() {
        return announcements.size();
    }

    // Check if collection is empty
    public boolean isEmpty() {
        return announcements.isEmpty();
    }
}
