/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plataforma.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Seven
 */
public class SpriteAnimation {

    private int currentImageIndex;
    private int indexInc;
    private boolean loop;
    private ArrayList<BufferedImage> images;

    public SpriteAnimation() {
        currentImageIndex = 0;
        loop = false;
        indexInc = 1;
        images = new ArrayList<BufferedImage>();
    }

    public void setLoop(boolean value) {
        loop = value;
    }

    public boolean isLoop() {
        return loop;
    }

    public void addImage(BufferedImage img) {
        images.add(img);
    }
    
    public void update (int currentTick){
        if (currentTick % 8 == 0){
            currentImageIndex += indexInc;
            if(currentImageIndex == images.size() || currentImageIndex == -1){
                if (loop){
                    indexInc *= -1;
                    currentImageIndex += indexInc;
                }else{
                    currentImageIndex = 0;
                }
            }
        }
    }
    
    public BufferedImage getImage(){
        return images.get(currentImageIndex);
    }
}
