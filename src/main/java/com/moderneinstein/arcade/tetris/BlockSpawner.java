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
public class BlockSpawner extends
 Thread implements Runnable{
public static Integer[][] filt1 = new Integer[][]{{0,0},{0,1},{1,0},{1,1}} ; 
public static Integer[][] filt2 = new Integer[][]{{0,0},{0,1},{0,2},{1,2}} ;
public static Integer[][] filt3  = new Integer[][]{{1,0},{1,1},{1,2},{0,2}} ;
public static Integer[][] filt4 = new Integer[][]{{0,0},{0,1},{1,1},{1,2}} ;
public static Integer[][] filt5 = new Integer[][]{{1,0},{1,1},{0,1},{0,2}} ;
public static Integer[][] filt5 = new Integer[][]{{0,0},{1,0},{2,0},{3,0}}  ; 
public static Integer[][] filt6 =  new Integer[][]{{1,0},{1,1},{0,1},{1,2}} ;
public static Integer[][][] bricks = new Integer[][][]{filt1,filt2,filt3,filt4,filt5,filt6} ;
public static Random random ;
public  TetrisBlock current ;
public LinkedList<TetrisBlock> list4 ;
public int counter = 0 ;
public BlockSpawner(){
	long long1 = System.getCurrentMillis() ;
	random	 = new Random(long1) ; 
	int digit1 = random.nextInt(bricks.length) ;
	Integer[][] quest = bricks[(int)digit1] ;
	int digit2 = random.nextInt(Grid.Width) ;
	Integer[] position = new Integer[]{digit2,0} ;
	current =   new TetrisBlock(quest,position) ;
    list4 = (LinkedList<TetrisBlock>)Collections.
    synchronizedList(new LinkedList<TetrisBlock>())  ;
}
public TetrisBlock  nextBrick(){
	 int digit4 = random.nextInt(bricks.length) ;
	 Integer[][]  quest = this.bricks[digit4] ;
	 int digit2 = random.nextInt(Grid.Width) ; 
	 Integer[] position = new Integer[]{digit2,0} ;
	 current = new TetrisBlock(quest,position) ; 
	 return current ; 
}
public TetrisBlock  nextBrick(Integer[] position){
	 int digit4 = random.nextInt(bricks.length) ;
	 Integer[][]  quest = this.bricks[digit4] ;
	 current = new TetrisBlock(quest,position) ; 
	 return current ; 
}
@Override 
public void run () {
	TetrisBlock block1 = null ; 
    for(int c=0 ;c<3;c++){
        if(list4.get(c)==null){
        block1 = this.nextBrick() ;
        list4.insert(block1,c)  ;
        }
    }

}

}