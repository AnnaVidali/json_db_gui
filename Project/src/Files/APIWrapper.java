/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Basics.Album;
import Basics.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @authors 21726,21779,21709 
 */
public class APIWrapper {
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    
    //δημιουργια σωστου url ειτε βαζοντας το ονομα ενος περσον ειτε βαζοντας τον τιτλο ενος αλμπουμ κι επιστροφη jsonobject
    private static JSONObject readJsonFromUrl(String name) throws IOException, ParseException{
        String url = "http://musicbrainz.org/ws/2/artist/?query=" + name + "&fmt=json";
        InputStream is = new URL(url).openStream();
        JSONParser parser = new JSONParser();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json =  (JSONObject) parser.parse(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    
    //εδω παιρνουμε τις πληροφοριες απο το json κι αφου φτιαξουμε περσον αντικειμενα τα βαζουμε σε λιστα αντικειμενων περσον με βαση το ονομα του περσον
    public static ArrayList<Person> getPersonByName(String artistName) throws IOException, ParseException {
        ArrayList<Person> artist = new ArrayList<Person>();
        JSONObject json = readJsonFromUrl(artistName);
        JSONArray jsonArray = (JSONArray) json.get("artists");
        Iterator iter = jsonArray.iterator();
        while(iter.hasNext()){
            JSONObject artistObject = (JSONObject) iter.next();
            String name = (String) artistObject.get("name");
            String gender = (String) artistObject.get("gender");
            JSONObject area = (JSONObject) artistObject.get("area");
            String country;
            JSONObject beginArea = (JSONObject) artistObject.get("begin-area");
            String cities;
            JSONObject lifeSpan = (JSONObject) artistObject.get("life-span");
            String birthDate;
            String deathDate;  
            try{
                country = (String) area.get("name");
                cities = (String) beginArea.get("name");
                birthDate = (String) lifeSpan.get("begin");
                deathDate = (String) lifeSpan.get("ended");   
            }catch(Exception e){
                country = null;
                cities = null;
                birthDate = null;
                deathDate = null;
            }
            String pid = (String) artistObject.get("id");
            Person personObject = new Person(name, gender, country, cities, birthDate, deathDate, null, null, pid);
            artist.add(personObject);
        }
        return artist;
    }
    
    //εδω παιρνουμε τις πληροφοριες απο το json κι αφου φτιαξουμε αλμπουμ αντικειμενα τα βαζουμε σε λιστα αντικειμενων αλμπουμ με βαση τον τιτλο του αλμπουμ
    public static ArrayList<Album> getAlbumByName(String albumName) throws IOException, ParseException {
        ArrayList<Album> album = new ArrayList<Album>();
        JSONObject json = readJsonFromUrl(albumName);
        JSONArray jsonArray = (JSONArray) json.get("artists");
        Iterator iter = jsonArray.iterator();
        while(iter.hasNext()){
            JSONObject releaseObject = (JSONObject) iter.next();
            String title = (String) releaseObject.get("name");
            JSONObject area = (JSONObject) releaseObject.get("area");
            String language;
            JSONObject relDate = (JSONObject) releaseObject.get("life-span"); 
            String releaseDate;
            try{
                releaseDate = (String) relDate.get("begin");
                language = (String) area.get("name");
            }catch(Exception e){
                releaseDate = null;
                language = null;
            }
            String status;
            if(releaseDate != null){
                status = "Official";
            }else{
                status = "Unofficial";
            }
            String rid = (String) releaseObject.get("id");
            Album alObj = new Album(null, title, status, language, releaseDate, null, null, rid);
            album.add(alObj);
        }
        return album;
    }
}