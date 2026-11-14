package com.scasp.core.collections;

import com.scasp.core.Announcement;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementCollection {

    private final List<Announcement> announcements = new ArrayList<>();

    // Add an announcement
    public synchronized void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    // Remove an announcement
    public synchronized void removeAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
    }

    // Get all announcements
    public synchronized List<Announcement> getAnnouncements() {
        return new ArrayList<>(announcements);
    }

    // Get total number of announcements
    public synchronized int getAnnouncementCount() {
        return announcements.size();
    }

    // Check if collection is empty
    public synchronized boolean isEmpty() {
        return announcements.isEmpty();
    }
}