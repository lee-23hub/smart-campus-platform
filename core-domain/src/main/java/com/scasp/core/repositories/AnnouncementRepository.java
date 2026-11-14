
package com.scasp.core.repositories;

import com.scasp.core.interfaces.AnnouncementRepositoryInterface;
import com.scasp.core.Announcement;
import com.scasp.core.collections.AnnouncementCollection;
import java.util.List;

public class AnnouncementRepository implements AnnouncementRepositoryInterface {

    private final AnnouncementCollection announcementCollection;

    public AnnouncementRepository(AnnouncementCollection announcementCollection) {
        this.announcementCollection = announcementCollection;
    }

    // Save an announcement
    public void save(Announcement announcement) {
        announcementCollection.addAnnouncement(announcement);
    }

    // Delete an announcement
    public void delete(Announcement announcement) {
        announcementCollection.removeAnnouncement(announcement);
    }

    // Find all announcements
    public List<Announcement> findAll() {
        return announcementCollection.getAnnouncements();
    }

    // Count announcements
    public int count() {
        return announcementCollection.getAnnouncementCount();
    }
}
