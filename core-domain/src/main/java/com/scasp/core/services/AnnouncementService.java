
package com.scasp.core.services;

import com.scasp.core.interfaces.AnnouncementServiceInterface;
import com.scasp.core.Announcement;
import com.scasp.core.collections.AnnouncementCollection;
import java.util.List;

public class AnnouncementService implements AnnouncementServiceInterface {

    private final AnnouncementCollection announcementCollection;

    public AnnouncementService(AnnouncementCollection announcementCollection) {
        this.announcementCollection = announcementCollection;
    }

    // Add an announcement
    public void addAnnouncement(Announcement announcement) {
        announcementCollection.addAnnouncement(announcement);
    }

    // Remove an announcement
    public void removeAnnouncement(Announcement announcement) {
        announcementCollection.removeAnnouncement(announcement);
    }

    // Retrieve all announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementCollection.getAnnouncements();
    }

    // Get total announcements
    public int getTotalAnnouncements() {
        return announcementCollection.getAnnouncementCount();
    }
}
