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
public class Link extends Player {
    
    public Link(int X, int Y, int Attack, int playerNum){
        name = "Link";
        health = 200;
        x = X;
        y = Y;
        attack = Attack;
        pnum = playerNum;
        isAlive = true;
        isSet = false;
        attackType = null;
        isHit = false;
        final String dir = System.getProperty("user.dir");
        Image [] ImageArr = new Image[29];
        if (pnum == 1){
            ImageArr[0] = new Image("file:"+dir+"/src/resources/linkf0.png");
            ImageArr[1] = new Image("file:"+dir+"/src/resources/linkf1rock.png");
            ImageArr[2] = new Image("file:"+dir+"/src/resources/linkf2rock.png");
            ImageArr[3] = new Image("file:"+dir+"/src/resources/linkf1.png");
            ImageArr[4] = new Image("file:"+dir+"/src/resources/linkf2.png");
            ImageArr[5] = new Image("file:"+dir+"/src/resources/linkf1scissors.png");
            ImageArr[6] = new Image("file:"+dir+"/src/resources/linkf2scissors.png");
            ImageArr[7] = new Image("file:"+dir+"/src/resources/linkl0.png");
            ImageArr[8] = new Image("file:"+dir+"/src/resources/linkl1rock.png");
            ImageArr[9] = new Image("file:"+dir+"/src/resources/linkl2rock.png");
            ImageArr[10] = new Image("file:"+dir+"/src/resources/linkl1.png");
            ImageArr[11] = new Image("file:"+dir+"/src/resources/linkl2.png");
            ImageArr[12] = new Image("file:"+dir+"/src/resources/linkl1scissors.png");
            ImageArr[13] = new Image("file:"+dir+"/src/resources/linkl2scissors.png");
            ImageArr[14] = new Image("file:"+dir+"/src/resources/linkb0.png");
            ImageArr[15] = new Image("file:"+dir+"/src/resources/linkb1rock.png");
            ImageArr[16] = new Image("file:"+dir+"/src/resources/linkb2rock.png");
            ImageArr[17] = new Image("file:"+dir+"/src/resources/linkb1.png");
            ImageArr[18] = new Image("file:"+dir+"/src/resources/linkb2.png");
            ImageArr[19] = new Image("file:"+dir+"/src/resources/linkb1scissors.png");
            ImageArr[20] = new Image("file:"+dir+"/src/resources/linkb2scissors.png");
            ImageArr[21] = new Image("file:"+dir+"/src/resources/linkr0.png");
            ImageArr[22] = new Image("file:"+dir+"/src/resources/linkr1rock.png");
            ImageArr[23] = new Image("file:"+dir+"/src/resources/linkr2rock.png");
            ImageArr[24] = new Image("file:"+dir+"/src/resources/linkr1.png");
            ImageArr[25] = new Image("file:"+dir+"/src/resources/linkr2.png");
            ImageArr[26] = new Image("file:"+dir+"/src/resources/linkr1scissors.png");
            ImageArr[27] = new Image("file:"+dir+"/src/resources/linkr2scissors.png");
            ImageArr[28] = new Image("file:"+dir+"/src/resources/linkd.png");
        }
        else {
            ImageArr[0] = new Image("file:"+dir+"/src/resources/linkf02.png");
            ImageArr[1] = new Image("file:"+dir+"/src/resources/linkf1rock2.png");
            ImageArr[2] = new Image("file:"+dir+"/src/resources/linkf2rock2.png");
            ImageArr[3] = new Image("file:"+dir+"/src/resources/linkf12.png");
            ImageArr[4] = new Image("file:"+dir+"/src/resources/linkf22.png");
            ImageArr[5] = new Image("file:"+dir+"/src/resources/linkf1scissors2.png");
            ImageArr[6] = new Image("file:"+dir+"/src/resources/linkf2scissors2.png");
            ImageArr[7] = new Image("file:"+dir+"/src/resources/linkl02.png");
            ImageArr[8] = new Image("file:"+dir+"/src/resources/linkl1rock2.png");
            ImageArr[9] = new Image("file:"+dir+"/src/resources/linkl2rock2.png");
            ImageArr[10] = new Image("file:"+dir+"/src/resources/linkl12.png");
            ImageArr[11] = new Image("file:"+dir+"/src/resources/linkl22.png");
            ImageArr[12] = new Image("file:"+dir+"/src/resources/linkl1scissors2.png");
            ImageArr[13] = new Image("file:"+dir+"/src/resources/linkl2scissors2.png");
            ImageArr[14] = new Image("file:"+dir+"/src/resources/linkb02.png");
            ImageArr[15] = new Image("file:"+dir+"/src/resources/linkb1rock2.png");
            ImageArr[16] = new Image("file:"+dir+"/src/resources/linkb2rock2.png");
            ImageArr[17] = new Image("file:"+dir+"/src/resources/linkb12.png");
            ImageArr[18] = new Image("file:"+dir+"/src/resources/linkb22.png");
            ImageArr[19] = new Image("file:"+dir+"/src/resources/linkb1scissors2.png");
            ImageArr[20] = new Image("file:"+dir+"/src/resources/linkb2scissors2.png");
            ImageArr[21] = new Image("file:"+dir+"/src/resources/linkr02.png");
            ImageArr[22] = new Image("file:"+dir+"/src/resources/linkr1rock2.png");
            ImageArr[23] = new Image("file:"+dir+"/src/resources/linkr2rock2.png");
            ImageArr[24] = new Image("file:"+dir+"/src/resources/linkr12.png");
            ImageArr[25] = new Image("file:"+dir+"/src/resources/linkr22.png");
            ImageArr[26] = new Image("file:"+dir+"/src/resources/linkr1scissors2.png");
            ImageArr[27] = new Image("file:"+dir+"/src/resources/linkr2scissors2.png");
            ImageArr[28] = new Image("file:"+dir+"/src/resources/linkd2.png");
        }
        imageArr = ImageArr;
        image = imageArr[0];
        imageCount = 0;
        attacking = false;
        Image[] imageArrayFrock = new Image[2];
        Image[] imageArrayFpaper = new Image[2];
        Image[] imageArrayFscissors = new Image[2];
        Image[] imageArrayLrock = new Image[2];
        Image[] imageArrayLpaper = new Image[2];
        Image[] imageArrayLscissors = new Image[2];
        Image[] imageArrayBrock = new Image[2];
        Image[] imageArrayBpaper = new Image[2];
        Image[] imageArrayBscissors = new Image[2];
        Image[] imageArrayRrock = new Image[2];
        Image[] imageArrayRpaper = new Image[2];
        Image[] imageArrayRscissors = new Image[2];
        float[] imageArrayFoffsetx = new float[2];
        imageArrayFoffsetx[0] = 0;
        imageArrayFoffsetx[1] = 0;
        float[] imageArrayFoffsety = new float[2];
        imageArrayFoffsety[0] = 0;
        imageArrayFoffsety[1] = 0;
        float[] imageArrayLoffsetx = new float[2];
        imageArrayLoffsetx[0] = 30;
        imageArrayLoffsetx[1] = 30;
        float[] imageArrayLoffsety = new float[2];
        imageArrayLoffsety[0] = 20;
        imageArrayLoffsety[1] = 0;
        float[] imageArrayBoffsetx = new float[2];
        imageArrayBoffsetx[0] = 5;
        imageArrayBoffsetx[1] = 10;
        float[] imageArrayBoffsety = new float[2];
        imageArrayBoffsety[0] = 10;
        imageArrayBoffsety[1] = 30;
        float[] imageArrayRoffsetx = new float[2];
        imageArrayRoffsetx[0] = 0;
        imageArrayRoffsetx[1] = 0;
        float[] imageArrayRoffsety = new float[2];
        imageArrayRoffsety[0] = 0;
        imageArrayRoffsety[1] = 0;
        
        imageArrayFrock[0] = imageArr[1];
        imageArrayFrock[1] = imageArr[2];
        imageArrayFpaper[0] = imageArr[3];
        imageArrayFpaper[1] = imageArr[4];
        imageArrayFscissors[0] = imageArr[5];
        imageArrayFscissors[1] = imageArr[6];
        imageArrayLrock[0] = imageArr[8];
        imageArrayLrock[1] = imageArr[9];
        imageArrayLpaper[0] = imageArr[10];
        imageArrayLpaper[1] = imageArr[11];
        imageArrayLscissors[0] = imageArr[12];
        imageArrayLscissors[1] = imageArr[13];
        imageArrayBrock[0] = imageArr[15];
        imageArrayBrock[1] = imageArr[16];
        imageArrayBpaper[0] = imageArr[17];
        imageArrayBpaper[1] = imageArr[18];
        imageArrayBscissors[0] = imageArr[19];
        imageArrayBscissors[1] = imageArr[20];
        imageArrayRrock[0] = imageArr[22];
        imageArrayRrock[1] = imageArr[23];
        imageArrayRpaper[0] = imageArr[24];
        imageArrayRpaper[1] = imageArr[25];
        imageArrayRscissors[0] = imageArr[26];
        imageArrayRscissors[1] = imageArr[27];
        attackFrock = new AnimatedImage(imageArrayFrock, imageArrayFoffsetx, imageArrayFoffsety);
        attackFpaper = new AnimatedImage(imageArrayFpaper, imageArrayFoffsetx, imageArrayFoffsety);
        attackFscissors = new AnimatedImage(imageArrayFscissors, imageArrayFoffsetx, imageArrayFoffsety);
        attackLrock = new AnimatedImage(imageArrayLrock, imageArrayLoffsetx, imageArrayLoffsety);
        attackLpaper = new AnimatedImage(imageArrayLpaper, imageArrayLoffsetx, imageArrayLoffsety);
        attackLscissors = new AnimatedImage(imageArrayLscissors, imageArrayLoffsetx, imageArrayLoffsety);
        attackBrock = new AnimatedImage(imageArrayBrock, imageArrayBoffsetx, imageArrayBoffsety);
        attackBpaper = new AnimatedImage(imageArrayBpaper, imageArrayBoffsetx, imageArrayBoffsety);
        attackBscissors = new AnimatedImage(imageArrayBscissors, imageArrayBoffsetx, imageArrayBoffsety);
        attackRrock = new AnimatedImage(imageArrayRrock, imageArrayRoffsetx, imageArrayRoffsety);
        attackRpaper = new AnimatedImage(imageArrayRpaper, imageArrayRoffsetx, imageArrayRoffsety);
        attackRscissors = new AnimatedImage(imageArrayRscissors, imageArrayRoffsetx, imageArrayRoffsety);
    }
    
}
