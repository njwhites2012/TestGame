/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import javafx.scene.image.Image;

/**
 *
 * @author apwhitesell
 */
public class AnimatedImage {
    private Image[] frames;
    private float[] imageOffsetx;
    private float[] imageOffsety;
    public int currentFrame;
    private int totalFrames = 9;
    public boolean active;
    public double duration;
    
    public AnimatedImage(){
        
    }
    
    public AnimatedImage(Image[] arr, float[] offsetx, float[] offsety){
        currentFrame = 0;
        active = false;
        frames = arr;
        imageOffsetx = offsetx;
        imageOffsety = offsety;
    } 
     
    public Image getFrame(){
        Image show;
        if (currentFrame < 5){
            show = frames[0];
        }
        else{
            show = frames[1];
        }
        if (currentFrame == 0){
            active = true;
        }
        if (currentFrame == totalFrames){
            currentFrame = 0;
            active = false;
        }else
            currentFrame++;
        return show;
    }
    
    public float getOffsetx(){
        //pick represents what frame is shown befor getFrame incremented it
        int pick;
        if (currentFrame == 0){
            pick = 9;
        }
        else{
            pick = currentFrame - 1;
        }
        if (pick < 5){
            return imageOffsetx[0];
        }
        else{
            return imageOffsetx[1];
        }
    }
    
    public float getOffsety(){
       //pick represents what frame is shown befor getFrame incremented it
        int pick;
        if (currentFrame == 0){
            pick = 9;
        }
        else{
            pick = currentFrame - 1;
        }
        if (pick < 5){
            return imageOffsety[0];
        }
        else{
            return imageOffsety[1];
        }
    }
}
