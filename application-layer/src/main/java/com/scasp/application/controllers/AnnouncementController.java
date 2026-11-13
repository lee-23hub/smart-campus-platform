package com.scasp.application.controllers;

import com.scasp.core.Announcement;
import com.scasp.core.services.AnnouncementService;
import java.util.List;

public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    // Add an announcement
    public void addAnnouncement(Announcement announcement) {
        announcementService.addAnnouncement(announcement);
    }

    // Retrieve all announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    // Get total announcements
    public int getTotalAnnouncements() {
        return announcementService.getAllAnnouncements().size();
    }
}