/***
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;
import Basics.Album;
import Basics.Artist;
import Basics.Compilation;
import Basics.Group;
import Basics.Person;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @authors 21726,21779,21709 
 */
public class DemoBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        //εδω φτιαχνουμε αντικειμενο τυπου person και δινουμε τιμες στις λιστες
        
        String[] personAliases = {"Short Stack"};
        ArrayList<String> aliases = new ArrayList<String>(Arrays.asList(personAliases));
        
        String[] personTags = {"Rachel Berry", "Glee", "Pop"};
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(personTags));
        
        //εδω δινουμε τιμες στις μεταβλητες μεσω του constructor για το ιδιο αντικειμενο
        
        Person person = new Person("Lea Michele Sarfati", "Female", "America", "Brentwood", "29-08-1986", null, aliases, tags, "a1");
        
        //εδω φτιαχνουμε αντικειμενο τυπου group και δινουμε τιμες στις λιστες
        
        String[] groupAliases = {"GNR", "Gn'R"};
        ArrayList<String> aliases1 = new ArrayList<String>(Arrays.asList(groupAliases));
        
        String[] groupTags = {"Axl Rose", "Hard Rock", "80s music"};
        ArrayList<String> tags1 = new ArrayList<String>(Arrays.asList(groupTags));
        
        ArrayList<Artist> members1 = new ArrayList<Artist>();
        members1.add(new Person("Axl Rose", "Male", "America", "Los Angeles", "06-02-1962", null, null, null, "a11"));
        members1.add(new Person("Duff McKagan", "Male", "America", "Seattle", "05-02-1964", null, null, null, "a12"));
        members1.add(new Person("Slash", "Male", "England", "Hampstead", "23-07-1965", null, null, null, "a13"));
        members1.add(new Person("Dizzy Reed", "Male", "America", "Hinsdale", "18-06-1963", null, null, null, "a14"));
        members1.add(new Person("Richard Fortus", "Male", "America", "St. Louis", "17-11-1966", null, null, null, "a15"));
        members1.add(new Person("Frank Ferrer", "Male", "America", "Brooklyn", "25-03-1966", null, null, null, "a16"));
        members1.add(new Person("Melissa Reese", "Female", "America", "Seattle", "01-03-1985", null, null, null, "a17"));
        
        //εδω δινουμε τιμες στις μεταβλητες μεσω του constructor για το ιδιο αντικειμενο
        
        Group group = new Group("Guns N' Roses", "America", "Los Angeles", "1985", null, aliases1, tags1, members1,  "g1");
        
        //εδω δινουμε τιμες στις μεταβλητες μεσω του constructor για το αντικειμενο album
        
        Album album = new Album(person, "Louder", "Official", "English", "28-02-2014", "CD", 11, "al1");
        
        //εδω φτιαχνουμε αντικειμενο τυπου person και δινουμε τιμες στις λιστες για να το χρησιμοποιησουμε στην δημιουργια αντικειμενου compilation
        
        String[] personAliases1 = {"Mister D"};
        ArrayList<String> aliases2 = new ArrayList<String>(Arrays.asList(personAliases1));
        
        String[] personTags1 = {"Blaine Aderson", "Glee", "Pop"};
        ArrayList<String> tags2 = new ArrayList<String>(Arrays.asList(personTags1));
        
        //εδω δινουμε τιμες στις μεταβλητες μεσω του constructor για το ιδιο αντικειμενο
        
        Person person1 = new Person("Darren Everett Criss", "Male", "America", "San Francisco", "05-02-1987", null, aliases2, tags2, "a2");
        
        //εδω βαζουμε τιμες στην λιστα Artists αποδιδοντας ως τιμες τα δυο αντικειμενα person που εχουμε φτιαξει
        
        Artist[] compilationArtists = {person, person1};
        ArrayList<Artist> artists = new ArrayList<Artist>(Arrays.asList(compilationArtists));
        
        //εδω δινουμε τιμες στις μεταβλητες μεσω του constructor για το αντικειμενο compilation
        
        Compilation compilation = new Compilation(artists, "LM/DC Tour", "Official", "English", "30-05-2018", "CD", 22, "c1");
        
    }
    
}
