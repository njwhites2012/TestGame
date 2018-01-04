/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.awt.AlphaComposite;
import javafx.geometry.Rectangle2D;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author apwhitesell
 */
public class Player {
    String name;
    float health;
    int pnum;
    int x;
    int y;
    //set as [forward0, forward1, forward2, left0, left1, left2, back0, back1,
    //back2, right0, right1, right2] 
    Image[] imageArr = new Image[13];
    Image image;
    int imageCount;
    boolean attacking;
    boolean isAlive;
    boolean isSet;
    boolean isHit;
    AnimatedImage attackFrock;
    AnimatedImage attackFpaper;
    AnimatedImage attackFscissors;
    AnimatedImage attackLrock;
    AnimatedImage attackLpaper;
    AnimatedImage attackLscissors;
    AnimatedImage attackBrock;
    AnimatedImage attackBpaper;
    AnimatedImage attackBscissors;
    AnimatedImage attackRrock;
    AnimatedImage attackRpaper;
    AnimatedImage attackRscissors;
    int attack;
    String attackType;
    
    public Player(){
        isSet = false;
    }
    public void attack(boolean value){
        if(value == false){
            attackType = null;
        }
        attacking = value;
    }
    public void attack(boolean value, Player otherPlayer){
        if(value == false){
            attackType = null;
            otherPlayer.isHit = false;
        }
        attacking = value;
    }
    public void attack(boolean value, String type){
        attacking = value;
        attackType = type;
    }
    public boolean getAttack(){
        return attacking;
    }
    public void setName(String Name){
        name = Name;
    }
    public void setHealth(float Health, int angle){
        health = Health;
        isHit = true;
        switch (angle) {
            case 3:
                moveUp();
                break;
            case 4:
                moveRight();
                break;
            case 1:
                moveDown();
                break;
            default:
                moveLeft();
                break;
        }
        if (health <= 0){
            isAlive = false;
            image = imageArr[28];
        }
    }
    public void setX(int X){
        x = X;
    }
    public void setY(int Y){
        y = Y;
    }
    public void setImageArr(Image[] ImageArr){
        imageArr = ImageArr;
    }
    public Image[] getImageArr(){
        return imageArr;
    }
    public void setImageCount(int num){
        imageCount = num;
    }
    public void setImage(int num){
        image = imageArr[num];
        imageCount = num;
    }
    public void setPosition(int X, int Y){
        x = X;
        y = Y;
    }
    public String getName(){
        return name;
    }
    public float getHealth(){
        return health;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Image getImage(){
        return image;
    }
    public int getImageCount(){
        return imageCount;
    }
    public float[] getPosition(){
         float[] arr = new float[2];
         arr[0] = x;
         arr[1] = y;
         return arr;
    }
    public AnimatedImage getAnimatedImage(){
        switch(attackType){
            case "rock":
                if(imageCount < 7){
                    return attackFrock;
                }else if (imageCount < 14){
                    return attackLrock;
                }else if (imageCount < 21){
                    return attackBrock;
                }else{
                    return attackRrock;
                }
            case "paper":
                if(imageCount < 7){
                    return attackFpaper;
                }else if (imageCount < 14){
                    return attackLpaper;
                }else if (imageCount < 21){
                    return attackBpaper;
                }else{
                    return attackRpaper;
                }
            case "scissors":
                if(imageCount < 7){
                    return attackFscissors;
                }else if (imageCount < 14){
                    return attackLscissors;
                }else if (imageCount < 21){
                    return attackBscissors;
                }else{
                    return attackRscissors;
                }
        }
        return attackFrock;
    }
 
    //moves up as long as it doesn't intersect other player or boundary
    public void moveUp(Player otherPlayer){
        setImage(14);
        
        if(!getFutureBoundary(0, -1).intersects(otherPlayer.getBoundary()) && y > 65){
            y = y - 1;
        }
    }
    public void moveUp(){
        if(y > 65){
            y = y - 5;
        }
    }
    public void moveDown(Player otherPlayer){
        setImage(0);
        if((!getFutureBoundary(0, 1).intersects(otherPlayer.getBoundary()) && y < 614)){
            y = y + 1;
        }
    }
    public void moveDown(){
        if(y < 614){
            y = y + 5;
        }
    }
    public void moveLeft(Player otherPlayer){
        setImage(7);
        if(!getFutureBoundary(-1, 0).intersects(otherPlayer.getBoundary()) && x > 74){
            x = x - 1;
        }
    }
    public void moveLeft(){
        if(x > 74){
            x = x - 5;
        }
    }
    public void moveRight(Player otherPlayer){
        setImage(21);
        if(!getFutureBoundary(1, 0).intersects(otherPlayer.getBoundary()) && x < 619){
            x = x + 1;
        }
    }
    public void moveRight(){
        if(x < 619){
            x = x + 5;
        }
    }
    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, image.getWidth(), image.getHeight());
    }
    public Rectangle2D getFutureBoundary(double X, double Y) {
        return new Rectangle2D(x+X, y+Y, image.getWidth(), image.getHeight());
    }
    
    public void attackPlayer(Player otherPlayer, Rectangle2D attackBoundary){
        if(attackBoundary.intersects(otherPlayer.getBoundary()) && !isHit){
            boolean win = false;
            switch(attackType){
                case "rock":
                    if("scissors".equals(otherPlayer.attackType)){
                        win = true;
                    }
                    break;
                case "paper":
                    if("rock".equals(otherPlayer.attackType)){
                        win = true;
                    }
                    break;
                case "scissors":
                    if("paper".equals(otherPlayer.attackType)){
                        win = true;
                    }
                    break;
            }
            if(win){
                System.out.println(attackType+" beats "+otherPlayer.attackType);
            }
            if(imageCount < 7 && otherPlayer.y > y){
                if((win || !otherPlayer.attacking) && !otherPlayer.isHit){
                    otherPlayer.setHealth(otherPlayer.getHealth()-attack, 1);
                }else
                    otherPlayer.moveDown();
            }
            else if(imageCount < 14 && otherPlayer.x < x){
                if((win || !otherPlayer.attacking) && !otherPlayer.isHit){
                    otherPlayer.setHealth(otherPlayer.getHealth()-attack, 2);
                }else
                    otherPlayer.moveLeft();
            }
            else if(imageCount < 21 && otherPlayer.y < y){
                if((win || !otherPlayer.attacking) && !otherPlayer.isHit){
                    otherPlayer.setHealth(otherPlayer.getHealth()-attack, 3);
                }else
                    otherPlayer.moveUp();
            }
            else if (otherPlayer.x > x){
                if((win || !otherPlayer.attacking) && !otherPlayer.isHit){
                    otherPlayer.setHealth(otherPlayer.getHealth()-attack, 4);
                }else
                    otherPlayer.moveRight();
            }
        }
        attack(getAnimatedImage().active, otherPlayer);
    }
}
