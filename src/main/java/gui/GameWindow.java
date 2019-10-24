/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Scene.Scene;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import prototype.PrototypeFactory;
import character.Character;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class GameWindow extends JFrame{
    int charHeight = 40;
    int charWidth = 40;
    int charAmount = 15;
    private ArrayList<Integer> usedX = new ArrayList<>();
    private ArrayList<Integer> usedY = new ArrayList<>();
    private int encontrados = 0;
    
    Scene s;
    JButton btnWaldo;
    JButton btnWaldo2;
    
    public GameWindow(Scene s) throws IOException{
        cargarVentana();
        this.s = s;
        cargarBackgroundCharacters();
        cargarImage(); 
        mostrarVentana();
    }
    
    private void cargarVentana() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1024,768);
      setResizable(false);
    }
    
    private void mostrarVentana() {
        setLayout(null);
        setVisible(true);
    }

    private void cargarImage()throws IOException {        
        
        BufferedImage bg = null;
        bg = ImageIO.read(new File(s.getBackground().getImage()));
        Image bgresized = bg.getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        
        JLabel lbl = new JLabel();
        lbl.setIcon(new ImageIcon(bgresized));
        lbl.setBounds(0,0,this.getWidth(),this.getHeight());
        
        for(Character c:s.getMainCharacters()){
            BufferedImage charImg = ImageIO.read(new File(c.getImages().get(0)));
            Image charImgResized = charImg.getScaledInstance(this.charWidth,this.charHeight,Image.SCALE_DEFAULT);
            JButton bt1 = new JButton();
            bt1.setIcon(new ImageIcon(charImgResized));
            
            boolean posEncontrada = false;
            
            while(!posEncontrada){
                    int posX = random(0,this.getWidth()-(this.charHeight+5));
                    int posY = random(0,this.getHeight()-(this.charWidth+30));
                    if(posicionOcupada(posX,posY)||areaInvalida(posX,posY)){
                        
                    }
                    else{
                        this.usedX.add(posX);
                        this.usedY.add(posY);
                        bt1.setBounds(posX,posY,this.charWidth,this.charHeight);
                        posEncontrada = true;
                    }
                }
            bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    encontrados +=1;
                    bt1.setEnabled(false);
                    if(encontrados == 5){
                        mostrarEmergente("Felicidades gano");
                    }
                    
                }
            });
            bt1.setRolloverEnabled(false);
            bt1.setBorderPainted(false); 
            bt1.setContentAreaFilled(false); 
            add(bt1);
            validate();
        }
        add(lbl);
        /*
        btnWaldo = new JButton();
        btnWaldo.setIcon(new ImageIcon(resized));
        btnWaldo.setBounds(500,500,this.charWidth,this.charHeight);
        
        btnWaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEmergente("Hola");
            }
        });
        btnWaldo.setRolloverEnabled(false);
        
        add(btnWaldo);
        */
        
    }
    
    private void cargarBackgroundCharacters() throws IOException {
        int counter = 0;
        while(counter!=this.charAmount){
            for(String image:s.getCharacters().get(0).getImages()){
                BufferedImage character = ImageIO.read(new File(image));
                Image resized = character.getScaledInstance(this.charWidth,this.charHeight,Image.SCALE_DEFAULT);
                JLabel lbl = new JLabel();
                lbl.setIcon(new ImageIcon(resized));
                boolean posEncontrada = false;
                while(!posEncontrada){
                    int posX = random(0,this.getWidth()-(this.charHeight+5));
                    int posY = random(0,this.getHeight()-(this.charWidth+30));
                    if(posicionOcupada(posX,posY)||areaInvalida(posX,posY)){
                        
                    }
                    else{
                        this.usedX.add(posX);
                        this.usedY.add(posY);
                        lbl.setBounds(posX,posY,this.charWidth,this.charHeight);
                        posEncontrada = true;
                    }
                }               
                //lbl.setBounds(1024-(this.charHeight+5),768-(this.charWidth+30),this.charWidth,this.charHeight);
                add(lbl);
                counter+=1;
            }
        }
        
    }
    
    public void mostrarEmergente(String mensaje) {
	    Emergente emergente = new Emergente(mensaje);
            emergente.mostrar();
    }
    
    public int random(int min,int max){
        int range = (max-min)+1;
        return (int)(Math.random()*range)+min;
    }

    private boolean posicionOcupada(int posX, int posY) {
        for(int x:this.usedX){
            for(int y:this.usedY){
                if(posX>x && posX<x+this.charWidth && posY>y&&posY<this.charHeight){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean areaInvalida(int posX, int posY) {
        for(Rectangle r:this.s.getUnavailableAreas()){
            if(posX>r.x && posX<r.width && posY>r.y && posY<r.height){
                return true;
            }
        }
        return false;
    }

    
}
