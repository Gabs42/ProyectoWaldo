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

    public Scene(ArrayList<Character> characters, ArrayList<Character> mainCharacters, Background background) {
        this.characters = characters;
        this.mainCharacters = mainCharacters;
        this.background = background;
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
}
