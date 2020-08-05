/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import Basics.Album;
import Basics.Person;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @authors 21726,21779,21709 
 */
public class FileWrapper {    
    
    //γραφει μια λιστα αντικειμενων περσον σε αρχειο το οποιο θα ειναι json
    public static void writePersonsToFile(String filename, ArrayList<Person> list){
        try{
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(list);
            for(int i=0; i<list.size(); i++){
                Person p = list.get(i);
                System.out.println(p.getName() + ", " + p.getGender() + ", " + p.getCountry() + ", " + p.getCities() + ", " + p.getBirthDate() + ", " + p.getDeathDate() + ", " + p.getPid());
            }
            o.close();
            f.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
 
    //γραφει μια λιστα αντικειμενων αλμπουμ σε αρχειο το οποιο θα ειναι json
    public static void writeAlbumToFile(String filename, ArrayList<Album> list){
        try{
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(list);
            for(int i=0; i<list.size(); i++){
                Album al = list.get(i);
                System.out.println(al.getTitle() + ", " + al.getStatus() + ", " + al.getLanguage() + ", " + al.getReleaseDate() + ", " + al.getRid());
            }
            o.close();
            f.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
