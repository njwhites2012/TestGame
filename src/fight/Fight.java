/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;


/**
 *
 * @author apwhitesell
 */
public class Fight extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    //manipulates player moves for gc to display
    //returns true if moving and false if attacking
    public boolean movement(Player movingPlayer, Player otherPlayer, ArrayList<String> input){
        if(input.contains("SLASH") || input.contains("COMMA") || input.contains("PERIOD")
                || input.contains("Q") || input.contains("E") || input.contains("R")){
            if( movingPlayer.pnum == 2){
                if(input.contains("SLASH")){
                    movingPlayer.attack(true, "scissors");
                }else if (input.contains("PERIOD")){
                    movingPlayer.attack(true, "paper");                
                }else if (input.contains("COMMA")){
                    movingPlayer.attack(true, "rock");                
                }
            }else{
                if(input.contains("R")){
                    movingPlayer.attack(true, "scissors");
                }else if (input.contains("E")){
                    movingPlayer.attack(true, "paper");                
                }else if (input.contains("Q")){
                    movingPlayer.attack(true, "rock");                
                }
            }
        }
        if(!movingPlayer.attacking){
            if(movingPlayer.pnum == 1){
                if (input.contains("W")){
                    movingPlayer.moveUp(otherPlayer);
                }
                if (input.contains("S")){
                    movingPlayer.moveDown(otherPlayer);
                }
                if (input.contains("A")){
                    movingPlayer.moveLeft(otherPlayer);
                }
                if (input.contains("D")){
                    movingPlayer.moveRight(otherPlayer);
                }
            }else{
                if (input.contains("UP")){
                    movingPlayer.moveUp(otherPlayer);
                }
                if (input.contains("DOWN")){
                    movingPlayer.moveDown(otherPlayer);
                }
                if (input.contains("LEFT")){
                    movingPlayer.moveLeft(otherPlayer);
                }
                if (input.contains("RIGHT")){
                    movingPlayer.moveRight(otherPlayer);
                }
            }
        }
        return movingPlayer.getAttack();
    }
    
    public Player setPlayer(int count){
        Link player;
        if (count == 1){
            player = new Link(196, 196, 10, count);
        }else{
            player = new Link(500, 500, 10, count);
        }
        return player;
    }
    public Controller setController(Player p, Scene theScene){
        Controller p1Controller = new Controller(p, true, theScene);
        return p1Controller;
    }
 
    @Override
    public void start(Stage theStage) {
        theStage.setTitle( "Fight" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 730, 729 );
        root.getChildren().add( canvas );
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Player P1;
        P1 = setPlayer(1);
        Controller p1Controller;
        p1Controller = setController(P1, theScene);
        Player P2;
        P2 = setPlayer(2);
        Controller p2Controller;
        p2Controller = setController(P2, theScene);

        ArrayList<String> input;
        input = new ArrayList<>();
 
        theScene.setOnKeyPressed((KeyEvent e) -> {
            String code = e.getCode().toString();
            if (P1.isSet && P2.isSet){
                // only add once... prevent duplicates
                if ( !p1Controller.getHumanInput().contains(code) ){
                    p1Controller.addHumanInput(code);
                }
                // only add once... prevent duplicates
                if ( !p2Controller.getHumanInput().contains(code) ){
                    p2Controller.addHumanInput(code);
                }
            }else{
                input.clear();
            }
        });
 
        theScene.setOnKeyReleased((KeyEvent e) -> {
            String code = e.getCode().toString();
            p1Controller.removeHumanInput(code);
            p2Controller.removeHumanInput(code);
            input.clear();
            input.add(code);
        });
        
        final String dir = System.getProperty("user.dir");
        System.out.print("file:"+dir+"/src/resources/arena.png");
        Image arena = new Image("file:"+dir+"/src/resources/arena.png");
        Image link = new Image("file:"+dir+"/src/resources/linkSelect.png");
        Image linkBlue = new Image("file:"+dir+"/src/resources/linkSelectBlue.png");
        
        gc.drawImage( arena, 0, 0 );
        gc.drawImage( link, 200, 200 );
        gc.setFill(Color.WHITESMOKE);
        gc.setStroke(Color.WHITESMOKE);
        gc.setFont(new Font("Art Brush", 23));
        gc.fillText("Player", 210, 340);
        gc.fillText("CPU", 210, 380);
        gc.strokeRoundRect(200, 318, 95, 30, 10, 10);
        gc.drawImage( linkBlue, 430, 200 );
        gc.fillText("Player", 440, 340);
        gc.fillText("CPU", 440, 380);
        Menu menu = new Menu();
        
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                //for menu skip on testing
//                if(true){
//                    P1.isSet = true;
//                    P1.isSet = true;
//                    p1Controller.setHuman(false);
                if(P1.isSet && P2.isSet){
                    // background image clears canvas
                    gc.drawImage( arena, 0, 0 );  

                    ArrayList<String> p1Input = p1Controller.getMove();
                    //P1 movement display
                    if(P1.isAlive){
                        if(!movement(P1, P2, p1Input)){
                            gc.drawImage( P1.getImage(), P1.getPosition()[0], P1.getPosition()[1] );
                        }
                        //P1 attack display
                        else{
                            Image attackImage = P1.getAnimatedImage().getFrame();
                            gc.drawImage(attackImage, P1.getX()-P1.getAnimatedImage().getOffsetx(), P1.getY()-P1.getAnimatedImage().getOffsety());
                            Rectangle2D attackBoundary = new Rectangle2D(P1.getX()-P1.getAnimatedImage().getOffsetx(), P1.getY()-P1.getAnimatedImage().getOffsety()
                                                                            , attackImage.getWidth(), attackImage.getHeight());
                            //delay slightly for ties
                            if(P1.getAnimatedImage().currentFrame > 3){
                                P1.attackPlayer(P2, attackBoundary);
                            }else{
                                P1.attack(P1.getAnimatedImage().active, P2);
                            }
                        }
                    }
                    else{
                        gc.drawImage( P1.getImage(), P1.getPosition()[0], P1.getPosition()[1] );
                    }

                    ArrayList<String> p2Input = p2Controller.getMove();
                    //P2 movement display
                    if(P2.isAlive){
                        if(!movement(P2, P1, p2Input)){
                            gc.drawImage( P2.getImage(), P2.getPosition()[0], P2.getPosition()[1] );
                        }
                        //P2 attack display
                        else{
                            Image attackImage = P2.getAnimatedImage().getFrame();
                            gc.drawImage(attackImage, P2.getX()-P2.getAnimatedImage().getOffsetx(), P2.getY()-P2.getAnimatedImage().getOffsety());
                            Rectangle2D attackBoundary = new Rectangle2D(P2.getX()-P2.getAnimatedImage().getOffsetx(), P2.getY()-P2.getAnimatedImage().getOffsety()
                                                                            , attackImage.getWidth(), attackImage.getHeight());
                            
                            if(P2.getAnimatedImage().currentFrame > 3){
                                P2.attackPlayer(P1, attackBoundary);
                            }else{
                                P2.attack(P2.getAnimatedImage().active, P1);
                            }
                        }
                    //P2 dead display
                    }else{
                        gc.drawImage( P2.getImage(), P2.getPosition()[0], P2.getPosition()[1] );
                    }

                    //P1 health bar
                    if(P1.getHealth() < 60){
                        gc.setFill(Color.RED);
                    }else{
                        gc.setFill(Color.LIGHTGREEN);
                    }
                    gc.setStroke(Color.BLACK);
                    gc.setLineWidth(2);
                    gc.fillRoundRect(76, 32, P1.getHealth(), 26, 10, 10);
                    gc.strokeRoundRect(74, 30, 204, 30, 10, 10);
                    gc.setFill(Color.WHITESMOKE);
                    gc.setFont(new Font("Impact", 23));
                    gc.fillText(P1.getName(), 76, 23, 200);



                    //P2 health bar
                    if(P2.getHealth() < 60){
                        gc.setFill(Color.RED);
                    }else{
                        gc.setFill(Color.LIGHTGREEN);
                    }
                    gc.fillRoundRect(452, 32, P2.getHealth(), 26, 10, 10);
                    gc.strokeRoundRect(450, 30, 204, 30, 10, 10);
                    gc.setFill(Color.WHITESMOKE);
                    gc.fillText(P1.getName(), 452, 23, 200);
                }else{
                    if(input.contains("ENTER")){
                        input.clear();
                        if (!P1.isSet){
                            gc.strokeRoundRect(430, 318, 95, 30, 10, 10);
                            P1.isSet = true;
                            p1Controller.setHuman(menu.p1IsHuman);
                        }else{
                            P2.isSet = true;
                            p2Controller.setHuman(menu.p2IsHuman);
                        }
                    }else if (input.contains("UP") || input.contains("DOWN")){
                        input.clear();
                        gc.drawImage( arena, 0, 0 );
                        gc.drawImage( link, 200, 200 );
                        gc.fillText("Player", 210, 340);
                        gc.fillText("CPU", 210, 380);
                        gc.drawImage( linkBlue, 430, 200 );
                        gc.fillText("Player", 440, 340);
                        gc.fillText("CPU", 440, 380);
                        if (!P1.isSet){
                            if(menu.p1IsHuman){
                                gc.strokeRoundRect(200, 358, 95, 30, 10, 10);
                                menu.p1IsHuman = false;
                            }else{
                                gc.strokeRoundRect(200, 318, 95, 30, 10, 10);
                                menu.p1IsHuman = true;
                            }
                        }else{
                            if(menu.p1IsHuman){
                                gc.strokeRoundRect(200, 318, 95, 30, 10, 10);
                            }else{
                                gc.strokeRoundRect(200, 358, 95, 30, 10, 10);
                            }
                            if(menu.p2IsHuman){
                                gc.strokeRoundRect(430, 358, 95, 30, 10, 10);
                                menu.p2IsHuman = false;
                            }else{
                                gc.strokeRoundRect(430, 318, 95, 30, 10, 10);
                                menu.p2IsHuman = true;
                            }
                        }

                    }
                }
            }
        }.start();

        theStage.show();
    }
}