package com.scasp.core.interfaces;

import com.scasp.core.Announcement;
import java.util.List;

public interface AnnouncementServiceInterface {

    void addAnnouncement(Announcement announcement);

    void removeAnnouncement(Announcement announcement);

    List<Announcement> getAllAnnouncements();

    int getTotalAnnouncements();
}