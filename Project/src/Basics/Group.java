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
public class Group extends Artist implements Serializable{                    //Εδω δηλωνουμε την κλαση του συγκροτηματος και τις μεταβλητες/γνωρισματα της
    protected String beginDate;
    protected String endDate;
    protected ArrayList<Artist> members = new ArrayList<Artist>();
    protected final String gid;

    public Group(String name, String country, String cities, String beginDate, String endDate, ArrayList<String> aliases, ArrayList<String> tags, ArrayList<Artist> members, String gid) {
        this.name = name;
        this.country = country;
        this.cities = cities;           //Εδω ο constructor του group αρχικοποιει τις τιμες των μεταβλητων/γνωρισματων
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.aliases = aliases;
        this.tags = tags;
        this.members = members;
        this.gid = gid;
    }
    
    //λαμβανουμε υποψιν μας οτι κληρονομουνται οι getters και οι setters της κλασης Artist
    
    public String getBeginDate() {     //Εδω δηλωνουμε τις μεθοδους set και get ωστε να τροποποιουμε και να παιρνουμε τις τιμες των μεταβλητων/γνωρισματων
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Artist> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Artist> members) {
        this.members = members;
    }

    public String getGid() {
        return gid;
    }
    
}
