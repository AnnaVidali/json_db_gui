/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @authors 21726,21779,21709
 */
public class Compilation extends Release implements Serializable{      //δηλωση της κλασης συλλογη η οποια κληρονομει την κλαση κυκλοφορια αρα και ολα της τα γνωρισματα
    public ArrayList<Artist> artists = new ArrayList<Artist>();

    public Compilation(ArrayList<Artist> artists, String title, String status, String language, String releaseDate, String format, Integer trackCount, String rid) {
        super(title, status, language, releaseDate, format, trackCount, rid);
        this.artists = artists;
    }                                //Εδω ο constructor της compilation αρχικοποιει τις τιμες των μεταβλητων/γνωρισματων της κλασης release καθως και του προσθετου γνωρισματος/μεταβλητης

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

}
