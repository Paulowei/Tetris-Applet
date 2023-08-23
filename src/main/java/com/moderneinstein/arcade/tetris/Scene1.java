import java.util.Scanner;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Label;
public class Grid extends Scene  {
	Integer[][]	 filled ;
	TetrisBlock current ;
	BlockSpawner spawner ;
	public static int Length = 20 ;
    public static int Width = 16  ;
	public Graphics graphics ;
    public Label label1 ;
    public Integer score  ;
	public Grid(){
		super() ;
//current = null ;
		spawner = new BlockSpawner()   ;
		current = spawner.nextBrick() ;
		filled = new Integer[Width][Length]
		BufferedIamge image4 =
		new BufferedImage (60,60, BufferedImage.TYPE_INT_RGB )  ;
	   graphics = image4.getGraphics( )   ;
       score = 0 ; 
        label1 = new Label() ;
        String str1 = Integer.toString(score ) ;
        String str2 =  new String("Score : ")  ;
        label1.setText(str2.concat(str1))  ;
        this.add(label1,0) ;
	}
	@Override
	public void paint(Graphics g4){
		if(g4==null) {
			g4 = graphics.create() ;
		}
		current.paint(g4) ;
		Integer[] int4 = null ;
		Integer int5 = null ;
		g4.setColor(new Color(60,60,60)) ;
		for(int c= 0;c<Length;c++){
			int4 = this.filled[c] ;
			int size1 = int4.length ;
			for(int  v=0;v<size1;v++ ){
				int5 = int4[v]  ;
				if(int5==1){
					g4.drawRect(c*VGAP,v*HGAP,VGAP,HGAP) ;
					g4.fillRect(c*VGAP,v*HGAP,VGAP,HGAP ) ;
				}
			}
		}
	}
	@Override
	public void update(Graphics G4) {
		if(G4==null)  {
		  G4 = graphics.create ()  ;
		}
//current = spawner.nextBrick() ;
        this.score = this.score + 1;
        String str2 = Integer.toString(score) ;
        String str1 = new String("Score : ")  ;
        label1.setText(str1.concat(str2))  ;
		current.update(G4)  ;
		boolean bool1 = checkProgress()  ;
		if(bool1==true){
			current =  spawner.nextBrick()  ;
		}
		checkFilled() ;
		this.paint(G4) ;
	}
	public bolean checkProgress(){
			Integer[]		 tmp1 = current.position ;
		Integer[][] position = current.maxY() ;
		boolean bool1 =   true ;
//Integer[] min = position[0] ;
		Integer[] max  = position[1]  ;
		Integer next = tmp1[1]	+ max1[1]+ 1 ;
		if(this.filled[max[0]+tmp1[0]]	[next]
		== Integer.valueOf(1)){
			current.velocity=  0 ;
			bool1=  false ;
		}
		for(int c= 0;c< current.blocks.length;c++){
			max =  current.blocks[c]  ;
			Integer xPos  = max[0] + tmp1[0] ;
			Integer yPos = max[1]  + tmp1[1]  ;
//	this.filled[max[0]+tmp1[0]][max[1]+tmp1[1]] =
            this.filled[xPos][yPos] = 1 ;
		}
		return bool1  ;
	}
	public void checkFilled(){
		Integer[] tmp1 = null  ;
		Integer tmp2 = null ;
		boolean bool1  = true ;
		Integer[]   fills = new Integer[Length ] ;
		for(int c=0;c<length;c++){
			tmp1 = filled[c]  ;
			tmp2 = tmp1.length ;
			bool1 = true ;
			for(int v=0;v< width;v++){
				tmp2 =  tmp1[v] ;
				if(tmp2==0){
					 bool1 = false ;
				}
			}
			if(bool1==true){
				fills[c] = 1 ;
			}
		}
		for(int  v=0;v<Length;v++){
			tmp2 = fills[v] ;
			tmp1 = filled[v] ;
			if(tmp2!=null){
			for(int c = 1 ;c<v;c++){
					tmp1 = filled[c-1] ;
					filled[c] = tmp1 ;
				}
			}
		}
	}
}
