/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Basics.Album;
import Basics.Person;
import DB.DataBase;
import Files.APIWrapper;
import Files.FileWrapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.simple.parser.ParseException;

/**
 *
 * @authors 21726,21779,21709
 */
public class DemoDataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        
        //δημιουργια περσον αντικειμενου 
        String[] personAliases = {"Short Stack"};
        ArrayList<String> aliases = new ArrayList<String>(Arrays.asList(personAliases));
        
        String[] personTags = {"Rachel Berry", "Glee", "Pop"};
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(personTags));
        
        Person person = new Person("Lea Michele Sarfati", "Female", "America", "Brentwood", "29-08-1986", null, aliases, tags, "a1");
        
        //εισαγωγη του αντικειμενου περσον στον πινακα περσον της βασης δεδομενων
        DataBase.insertPersonToDB(DataBase.establishConnectioWithDB(), person);
        
        System.out.println();
        
        //εισαγωγη μιας λιστας αντικειμενων περσον που παιρνουμε με την κληση μιας APIWrapper μεθοδου, στην βαση δεδομενων
        DataBase.insertPersonArrayToDB(DataBase.establishConnectioWithDB(), APIWrapper.getPersonByName("Lea"));
        
        System.out.println();
        
        //γεμισμα λιστας αντικειμενων τυπου περσον δινοντας στην μεθοδο ως παραμετρο το ονομα του περσον
        DataBase.selectPersonFromDB(DataBase.establishConnectioWithDB(), "Lea");
        
        System.out.println();
        
        //δημιουργια αλμπουμ αντικειμενου 
        Album album = new Album(person, "Louder", "Official", "English", "28-02-2014", "CD", 11, "al1");
        
        //εισαγωγη του αντικειμενου αλμπουμ στον πινακα αλμπουμ της βασης δεδομενων
        DataBase.insertAlbumToDB(DataBase.establishConnectioWithDB(), album);
        
        System.out.println();
        
        //εισαγωγη μιας λιστας αντικειμενων αλμπουμ που παιρνουμε με την κληση μιας APIWrapper μεθοδου, στην βαση δεδομενων
        DataBase.insertAlbumArrayToDB(DataBase.establishConnectioWithDB(), APIWrapper.getAlbumByName("Louder"));
        
        System.out.println();
        
        //γεμισμα λιστας αντικειμενων τυπου αλμπουμ δινοντας στην μεθοδο ως παραμετρο τον τιτλο του αλμπουμ
        DataBase.selectAlbumFromDB(DataBase.establishConnectioWithDB(), "Louder");
    }
    
}
