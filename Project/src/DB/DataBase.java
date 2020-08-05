/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Basics.Album;
import Basics.Person;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @authors 21726,21779,21709
 */
public class DataBase {
    
    //δημιουργια συνδεσης με την βαση δεδομενων 
    public static Connection establishConnectioWithDB(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e){
            System.out.println("Driver not found");
        }
        
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl", "it21709", "efanyd57");
        }catch(Exception e){
            System.out.println("Server not found");
        }
        return connection;
    }
    
    //εισαγωγη ενος αντικειμενου περσον στον πινακα περσον που εχει δημιουργηθει στην βαση δεδομενων
    public static void insertPersonToDB(Connection connection, Person p) throws SQLException{
        boolean success;
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
        
        String personUrl;
        personUrl = "INSERT INTO PERSON VALUES('" + p.getName() + "', '" + p.getGender() + "', '" + p.getCountry() + "', '" + p.getCities() + "', '" + p.getBirthDate() + "', '" + p.getDeathDate() + "', '" + p.getPid() + "')";
        try{
            st.executeQuery(personUrl);
            success = true;
        }catch(Exception e){
            System.out.println(e);
            success = false;
        }
        if(success == true){
            System.out.println("Insertion has been successful!");
        }else{
            System.out.println("Insertion has not been successful!");
        }
    }
    
    //εισαγωγη μιας λιστας αντικειμενων περσον στον πινακα περσον που εχει δημιουργηθει στην βαση δεδομενων
    public static void insertPersonArrayToDB(Connection connection, ArrayList<Person> p) throws SQLException {
        boolean success;
        int total = 0;
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
        String personUrl;
        for(int i = 0; i < p.size(); i++){
            Person per = p.get(i);
            personUrl = "INSERT INTO PERSON VALUES('" + per.getName() + "', '" + per.getGender() + "', '" + per.getCountry() + "', '" + per.getCities() + "', '" + per.getBirthDate() + "', '" + per.getDeathDate() + "', '" + per.getPid() + "')";
            try{
                st.executeQuery(personUrl);
                success = true;
            }catch(Exception e){
                System.out.println(e);
                success = false;
            }
            if(success == true){
                total++;
            }
        }
        System.out.println(total);
    }
    
    //δημιουργια λιστας αντικειμενων περσον με τα στοιχεια του πινακα περσον που εχει δημιουργηθει στην βαση δεδομενων με βαση το ονομα του περσον
    public static ArrayList<Person> selectPersonFromDB(Connection connection, String name) throws SQLException {
        ArrayList<Person> artist = new ArrayList<Person>();
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }

        ResultSet rs = st.executeQuery("SELECT DISTINCT NAME, GENDER, COUNTRY, CITIES, BIRTHDATE, DEATHDATE, PID FROM PERSON WHERE NAME = '" + name + "'");
        while(rs.next()){
            Person per = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), null, null, rs.getString(7));
            artist.add(per);
        }
        return artist;
    }
    
    //εισαγωγη ενος αντικειμενου αλμπουμ στον πινακα αλμπουμ που εχει δημιουργηθει στην βαση δεδομενων
    public static void insertAlbumToDB(Connection connection, Album al) throws SQLException{
        boolean success;
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
        
        String albumUrl;
        albumUrl = "INSERT INTO ALBUM VALUES('" + al.getTitle() + "', '" + al.getStatus() + "', '" + al.getLanguage() + "', '" + al.getReleaseDate() + "', '" + al.getRid() + "')";
        try{
            st.executeQuery(albumUrl);
            success = true;
        }catch(Exception e){
            System.out.println(e);
            success = false;
        }
        if(success == true){
            System.out.println("Insertion has been successful!");
        }else{
            System.out.println("Insertion has not been successful!");
        }
    }
    
    //εισαγωγη μιας λιστας αντικειμενων αλμπουμ στον πινακα αλμπουμ που εχει δημιουργηθει στην βαση δεδομενων
    public static void insertAlbumArrayToDB(Connection connection, ArrayList<Album> a) {
        boolean success;
        int total = 0;
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
        String albumUrl;
        for(int i = 0; i < a.size(); i++){
            Album al = a.get(i);
            albumUrl = "INSERT INTO ALBUM VALUES('" + al.getTitle() + "', '" + al.getStatus() + "', '" + al.getLanguage() + "', '" + al.getReleaseDate() + "', '" + al.getRid() + "')";
            try{
                st.executeQuery(albumUrl);
                success = true;
            }catch(Exception e){
                System.out.println(e);
                success = false;
            }
            if(success == true){
                total++;
            }
        }
        System.out.println(total);
    }
    
    //δημιουργια λιστας αντικειμενων αλμπουμ με τα στοιχεια του πινακα αλμπουμ που εχει δημιουργηθει στην βαση δεδομενων με βαση τον τιτλο του αλμπουμ
    public static ArrayList<Album> selectAlbumFromDB(Connection connection, String title) throws SQLException {
        ArrayList<Album> album = new ArrayList<Album>();
        Statement st = null;
        try{
            st = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }

        ResultSet rs = st.executeQuery("SELECT DISTINCT TITLE, STATUS, LANGUAGE, RELEASEDATE, RID FROM ALBUM WHERE TITLE = '" + title + "'");
        while(rs.next()){
            Album al = new Album(null, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), null, null, rs.getString(5));
            album.add(al);
        }
        return album;
    }
}
