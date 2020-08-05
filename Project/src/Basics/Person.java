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
public class Person extends Artist implements Serializable{                   //Εδω δηλωνουμε την κλαση του καλλιτεχνη και τις μεταβλητες/γνωρισματα της 
    protected String gender;
    protected String birthDate;
    protected String deathDate;
    protected final String pid; 

    public Person(String name, String gender, String country, String cities, String birthDate, String deathDate, ArrayList<String> aliases, ArrayList<String> tags, String pid) {
        this.name = name;
        this.gender = gender;
        this.country = country;             //Εδω ο constructor του person αρχικοποιει τις τιμες των μεταβλητων/γνωρισματων                                                                     
        this.cities = cities;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.aliases = aliases;
        this.tags = tags;
        this.pid = pid;
    }

    //λαμβανουμε υποψιν μας οτι κληρονομουνται οι getters και οι setters της κλασης Artist
    
    public String getGender() {             //Εδω δηλωνουμε τις μεθοδους set και get ωστε να τροποποιουμε και να παιρνουμε τις τιμες των μεταβλητων/γνωρισματων
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String DeathDate) {
        this.deathDate = deathDate;
    }

    public String getPid() {
        return pid;
    }
    
    public String personToString(){
        return name + ",    " + gender + ",    " + country + ",    " + cities + ",    " + birthDate + ",    " + deathDate;
    }
}
