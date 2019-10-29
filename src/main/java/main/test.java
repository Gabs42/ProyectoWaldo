/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import Scene.Background;
import Scene.ConfigurationWaldo;
import Scene.Scene;
import character.Character;
import character.Character.CharacterBuilder;
import configuration.Configuration;
import gui.startWindow;
import java.awt.Rectangle;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import prototype.PrototypeFactory;
/**
 *
 * @author Gabriel
 */
public class test {
    public static void main(String args[]) throws IOException{
        
        /*
        Rectangle r = new Rectangle();
        r.x = 0;
        r.y = 0;
        r.width = 1024;
        r.height = 200;
       */
        
        ConfigurationWaldo waldoConf = ConfigurationWaldo.getInstance();
        Character waldo = (Character) (new CharacterBuilder()).setName("waldo").addImage(waldoConf.getMainChars().get(0)).build();
        Character wenda = (Character) (new CharacterBuilder()).setName("wenda").addImage(waldoConf.getMainChars().get(1)).build();
        Character woof = (Character) (new CharacterBuilder()).setName("woof").addImage(waldoConf.getMainChars().get(2)).build();
        Character odlaw = (Character) (new CharacterBuilder()).setName("odlaw").addImage(waldoConf.getMainChars().get(3)).build();
        Character barbablanca = (Character) (new CharacterBuilder()).setName("barbablanca").addImage(waldoConf.getMainChars().get(4)).build();
        Configuration configuration = Configuration.getInstance();
        
        CharacterBuilder extraChars = new CharacterBuilder();
        
        for(String image:waldoConf.getChars()){
            extraChars.addImage(image);
        }
        Character extra = extraChars.build();
        
        configuration.savePrototype(waldo,"waldo",Character.class);
        configuration.savePrototype(wenda,"wenda",Character.class);
        configuration.savePrototype(woof,"woof",Character.class);
        configuration.savePrototype(odlaw,"odlaw",Character.class);
        configuration.savePrototype(barbablanca,"barbablanca",Character.class);
        
        configuration.loadPrototypes();
        ArrayList<Character> main = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        
        main.add((Character) PrototypeFactory.getPrototye("waldo"));
        main.add((Character) PrototypeFactory.getPrototye("wenda"));
        main.add((Character) PrototypeFactory.getPrototye("woof"));
        main.add((Character) PrototypeFactory.getPrototye("odlaw"));
        main.add((Character) PrototypeFactory.getPrototye("barbablanca"));
        
        chars.add(extra);
        Background bg = waldoConf.getBg();
        
        Scene s = new Scene(chars,main,bg,waldoConf);
        for(Rectangle r:waldoConf.getBackgroundProividas()){
            s.addArea(r);
        }
        //s.addArea(r);
        
        startWindow w = new startWindow(s);
    }
}

/*
TODO: Agregar generci chars y los 5 waldos
*/
