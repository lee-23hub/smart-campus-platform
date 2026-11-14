package com.scasp.core.enterprise;

import com.scasp.core.Announcement;
import com.scasp.core.interfaces.AnnouncementServiceInterface;
import java.util.List;

public class AnnouncementEnterpriseService {

    private final AnnouncementServiceInterface announcementService;

    public AnnouncementEnterpriseService(
            AnnouncementServiceInterface announcementService) {
        this.announcementService = announcementService;
    }

    public void addAnnouncement(Announcement announcement) {
        announcementService.addAnnouncement(announcement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    public int getTotalAnnouncements() {
        return announcementService.getTotalAnnouncements();
    }
}