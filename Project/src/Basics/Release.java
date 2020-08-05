/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.io.Serializable;

/**
 *
 * @authors 21726,21779,21709  
 */
public abstract class Release implements Serializable{                  //Εδω δηλωνουμε την κλαση της κυκλοφοριας και τις μεταβλητες/γνωρισματα της
    protected String title;
    protected String status;
    protected String language;
    protected String releaseDate;
    protected String format;
    protected Integer trackCount;
    protected final String rid;

    public Release(String title, String status, String language, String releaseDate, String format, Integer trackCount, String rid) {
        this.title = title;
        this.status = status;
        this.language = language;               //Εδω ο constructor της release αρχικοποιει τις τιμες των μεταβλητων/γνωρισματων
        this.releaseDate = releaseDate;
        this.format = format;
        this.trackCount = trackCount;
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {                //Εδω δηλωνουμε τις μεθοδους set και get ωστε να τροποποιουμε και να παιρνουμε τις τιμες των μεταβλητων/γνωρισματων
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public String getRid() {
        return rid;
    }
    
}
