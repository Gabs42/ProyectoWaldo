/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.util.ArrayList;
import character.Character;
import java.awt.Rectangle;

/**
 *
 * @author Gabriel
 */
public class Scene {
    private ArrayList<Character> characters;
    private ArrayList<Character> mainCharacters;
    private Background background;
    private ArrayList<Rectangle> unavailableAreas = new ArrayList<Rectangle>();
    private ConfigurationWaldo config;

    public Scene(ArrayList<Character> characters, ArrayList<Character> mainCharacters, Background background,ConfigurationWaldo config) {
        this.characters = characters;
        this.mainCharacters = mainCharacters;
        this.background = background;
        this.config = config;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Character> getMainCharacters() {
        return mainCharacters;
    }

    public void setMainCharacters(ArrayList<Character> mainCharacters) {
        this.mainCharacters = mainCharacters;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }
    
    public void addArea(Rectangle r){
        this.unavailableAreas.add(r);
    }

    public ArrayList<Rectangle> getUnavailableAreas() {
        return unavailableAreas;
    }
    
    
    
    private void buildScene(){
        
    }

    public ConfigurationWaldo getConfig() {
        return config;
    }
    
    
}
