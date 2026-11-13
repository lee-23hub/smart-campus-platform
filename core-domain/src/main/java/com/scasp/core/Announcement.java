
package com.scasp.core;

import com.scasp.core.Administrator;
import java.time.LocalDate;

public class Announcement {

    private String announcementId;
    private String title;
    private String message;
    private LocalDate publicationDate;
    private Administrator author;

    public Announcement(String announcementId, String title,
                         String message, LocalDate publicationDate,
                         Administrator author) {
        this.announcementId = announcementId;
        this.title = title;
        this.message = message;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Administrator getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
