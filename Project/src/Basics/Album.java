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
public class Album extends Release implements Serializable{ //δηλωση της κλασης album η οποια κληρονομει την κλαση release αρα και ολα της τα γνωρισματα
    public Artist albnumArtist;

    public Album(Artist albnumArtist, String title, String status, String language, String releaseDate, String format, Integer trackCount, String rid) {
        super(title, status, language, releaseDate, format, trackCount, rid);
        this.albnumArtist = albnumArtist;
    }               //Εδω ο constructor του album αρχικοποιει τις τιμες των μεταβλητων/γνωρισματων της κλασης release καθως και του προσθετου γνωρισματος/μεταβλητης

    //Εδω δηλωνουμε τις μεθοδους set και get ωστε να τροποποιουμε και να παιρνουμε τις τιμες των μεταβλητων/γνωρισματων
    
    public Object isArtist() {
        return albnumArtist;
    }

    public void setArtist(Artist albnumArtist) {
        this.albnumArtist = albnumArtist;
    }   
    
    public String albumToString(){
        return title + ",   " + status + ",    " + language + ",    " + releaseDate;
    }
}
