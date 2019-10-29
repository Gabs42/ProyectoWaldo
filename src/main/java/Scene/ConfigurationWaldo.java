/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel
 */
public class ConfigurationWaldo {
    private ArrayList<String> mainChars = new ArrayList<>();
    private ArrayList<String> chars = new ArrayList<>();
    private Background bg;
    private static ConfigurationWaldo configuration;
    private ArrayList<Rectangle> backgroundProividas = new ArrayList<>();
    private ArrayList<Integer> settings  = new ArrayList<>();
    
    public ConfigurationWaldo() throws FileNotFoundException, IOException{
        File file =  new File("background.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        mainChars = (ArrayList<String>) Files.readAllLines(Paths.get("mainChars.txt"));
        chars = (ArrayList<String>) Files.readAllLines(Paths.get("chars.txt"));
        bg = new Background(br.readLine());
        String line;
        while((line = br.readLine())!=null){
            String[] parameters = line.split(",");
            Rectangle newRectangle = new Rectangle(Integer.parseInt(parameters[0]),Integer.parseInt(parameters[1]),Integer.parseInt(parameters[2]),Integer.parseInt(parameters[3]));
            this.backgroundProividas.add(newRectangle);
        }
        File settingsFile =  new File("settings.txt");
        BufferedReader settingsReader = new BufferedReader(new FileReader(settingsFile)); 
        String setting;
        while((setting=settingsReader.readLine())!=null){
            settings.add(Integer.parseInt(setting.replaceAll("\\D+","")));
        }
        System.out.println(settings.get(1));
        
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

    public ArrayList<Rectangle> getBackgroundProividas() {
        return backgroundProividas;
    }

    public ArrayList<Integer> getSettings() {
        return settings;
    }
    
    public int getCharAmountSetting(){
        return this.settings.get(0);
    }
    
    public int getCharWidthSetting(){
        return this.settings.get(1);
    }
    
    public int getCharHeightSetting(){
        return this.settings.get(2);
    }
    
    public int getCharWindowXSizeSetting(){
        return this.settings.get(3);
    }
    
    public int getCharWindowYSetting(){
        return this.settings.get(4);
    }
    
}
