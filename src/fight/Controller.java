/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.util.ArrayList;
import javafx.scene.Scene;


/**
 *
 * @author apwhitesell
 */
public class Controller {
    private Player player;
    private boolean isHuman;
    private ArrayList<String> humanInput;
    private ArrayList<String> cpuInput;
    boolean isSet;
    
    public Controller(){
        isSet = false;
    }
    
    public Controller(Player p, boolean human, Scene theScene){
        player = p;
        isHuman = human;
        humanInput = new ArrayList<>();
        cpuInput = new ArrayList<>();
        isSet = true;
    }
    
    public ArrayList<String> getHumanInput(){
        return humanInput;
    }
    
    public void addHumanInput(String s){
        humanInput.add(s);
    }
    
    public void removeHumanInput(String s){
        humanInput.remove(s);
    }
    
    public ArrayList<String> getMove(){
        if(isHuman)
            return humanInput;
        else
            if ( !cpuInput.contains("S") ){
                cpuInput.add("S");
            }
            return cpuInput;
    }
    
    public void setHuman(boolean Human){
        isHuman = Human;
    }
}
