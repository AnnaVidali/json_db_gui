/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Files.APIWrapper;
import Files.FileWrapper;
import java.io.IOException;
import org.json.simple.parser.ParseException;


/**
 *
 * @authors 21726,21779,21709 
 */
public class DemoFilesAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        FileWrapper.writePersonsToFile("personFile.json", APIWrapper.getPersonByName("Lea"));
        System.out.println();
        FileWrapper.writeAlbumToFile("albumFile.json", APIWrapper.getAlbumByName("Louder"));
    }
}
