package com.scasp.core.interfaces;

import com.scasp.core.Announcement;
import java.util.List;

public interface AnnouncementRepositoryInterface {

    void save(Announcement announcement);

    void delete(Announcement announcement);

    List<Announcement> findAll();

    int count();
}