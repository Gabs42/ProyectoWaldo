/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class ConfigurationWaldo {
    private ArrayList<String> mainChars = new ArrayList<>();
    private ArrayList<String> chars = new ArrayList<>();
    private Background bg;
    private static ConfigurationWaldo configuration;
    
    public ConfigurationWaldo() throws FileNotFoundException, IOException{
        File file =  new File("background.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        mainChars = (ArrayList<String>) Files.readAllLines(Paths.get("mainChars.txt"));
        chars = (ArrayList<String>) Files.readAllLines(Paths.get("chars.txt"));
        bg = new Background(br.readLine());
        
    }
    
    public static ConfigurationWaldo getInstance() throws FileNotFoundException, IOException{
        if(configuration == null){
            configuration = new ConfigurationWaldo();
            return configuration;
        }
        else{
            return configuration;
        }
    }

    public ArrayList<String> getMainChars() {
        return mainChars;
    }

    public void setMainChars(ArrayList<String> mainChars) {
        this.mainChars = mainChars;
    }

    public ArrayList<String> getChars() {
        return chars;
    }

    public void setChars(ArrayList<String> chars) {
        this.chars = chars;
    }

    public Background getBg() {
        return bg;
    }

    public void setBg(Background bg) {
        this.bg = bg;
    }

    public static ConfigurationWaldo getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(ConfigurationWaldo configuration) {
        ConfigurationWaldo.configuration = configuration;
    }
    
}
