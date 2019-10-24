/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scene;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Background {
    private String  image;
    private ArrayList<Integer> positions;

    public Background(String image, ArrayList<Integer> positions) {
        this.image = image;
        this.positions = positions;
    }
    public Background(String image) {
        this.image = image;
    }
    
    public Background() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Integer> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Integer> positions) {
        this.positions = positions;
    }
    
    
}
