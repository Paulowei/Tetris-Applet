import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Robot;
import java.awt.AWTException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;
import java.lang.Math;

public class TetrisBlock extends Component{
	 public Integer[] position ; 
	 public Integer[][] blocks ; 
	 public int orientation ; 
	 public Color color ; 
	 public int velocity ; 
	 public Random random ;
	 public boolean[] options ;
	 public Integer resonance = 0 ;  
	 public TetrisBlock(){
	    super() ;
	 	orientation = 0 ; 
		random = new Random(	(long)System.currentTimeMillis()) ; 
		position = new Integer[]{random.nextInt(Grid.Length),0} ;
		color = new Color
		(random.nextInt(256),random.nextInt(256),random.nextInt(256)) ;
		this.velocity = 1  ; 
		}
	  public TetrisBlock(Integer[][] int1){
	  		    super() ;
	 	orientation = 0 ; 
		random = new Random(	(long)System.currentTimeMillis()) ; 
		position = new Integer[]{random.nextInt(Grid.Length),0} ;
		color = new Color
		(random.nextInt(256),random.nextInt(256),random.nextInt(256)) ;
		this.velocity = 1  ; 
		this.blocks = int1 ;
	  }
	  public TetrisBlock(Integer[][] int1 ,Integer[] position){
	  	 super() ;
	 	orientation = 0 ; 
		random = new Random(	(long)System.currentTimeMillis()) ; 
		position =  position ;
		color = new Color
		(random.nextInt(256),random.nextInt(256),random.nextInt(256)) ;
		this.velocity = 1  ; 
		this.blocks = int1 ;
	  }
	  public void transverse(){
	  	int size1 = blocks.length ; 
		Integer int4 =null ;
		if(this.velocity==0 ){
			return ;
		}
		if(this.position[0]<0){
			this.position[0] += Integer.valueOf(Grid.Width ) ; 
		}
		if(this.position[1]<0){
			this.position[1] += Integer.valueOf(Grid.Length ) ;
		}
		for(int c=1;c<2;c++){
			int4 = positions[c] ;
			int4 = int4+1*this.velocity  ;
		}
		if(options[0]==true){
			this.color= 
			new Color(random.nextInt(256),
			random.nextInt(256),random.nextInt(256)) ;
		}
		
	  }
	  //CounterClockWise Rotation ;
	  public void rotateLeft(int reps){
	  	int size1 = this.blocks.length ; 
		Integer[] center = new Integer[]{0,0} ;
		int counter = 0 ;
		Integer[] tmp1= null ;
		while(counter<reps){
		    for(int c=0;c<size1;c++){
		//	if(tmp [])
				tmp1 =  blocks[c] ;
				Integer tmp0 = tmp1[0] ;
				tmp1[0] = tmp1[1] ;
				tmp1[1] =   size1 - tmp0 ;
			}
			counter++ ;
			Integer[][] int4 = this.maxX() ; 
			Integer[][]  int5   = this.maxY()    ;
			Integer resX = int4[0][0] -this.position[0] ;
			Integer rexY  =  size1  -    int5[1][1]  ;
			this.translate( resY  * -1 ,  resX * -1  ) ;
		}
	  }
	  
	  //ClockWise Rotation ;
	  public void rotateRight(int reps){
	  	int size1 = this.blocks.length ; 
		Integer[] center = new Integer[]{0,0} ;
		int counter1 = 0 ; 
		Integer[]	 tmp1  = null ;
		while(counter1<reps){
			for(int c=0 ;c<size1;c++){
				tmp1=  blocks[c]  ;
				Integer tmp0 = tmp1[1] ;
				tmp1[1] = tmp1[0];
				tmp1[0] = size1-tmp1[1] ;
			}
			counter1++ ;
			Integer[][] int1 = this.maxX() ; 
			Integer[][] int2 =this.maxY() ;
			Integer resX =int1[0][0] -this.positions[0] ;
			Integer rexY =int1[0][1]	-this.positions[1] ;
			this.translate(resX *-1 , resY * -1  ) ; 
		}
	  }
	  @Override
	  public void update(Graphics g1){
	  BufferedImage img1 = new BufferedImage(40,40,BuffereedImage.TYPE_INT_RGB ) ;
	  	if(g1==null){
			g1 = img1.getGraphics() ;
		}
		if(this.velocity<1){
			this.velocity  = 1 ;
		}
		resonance = resonance+1 ;
		if(resonance>=500/this.velocity){
			this.transverse();
			resonance= 0 ;
		}
		g1.setColor(this.color) ;
		this.paint(g2) ;
	  }
	  public void translate(int xdis,int ydis){
	  	Integer[] int4 = this.position ;
		Integer xTrans = Integer.valueOf (	xDis%grid.Width  ) ;
		Integer yTrans = Integer.valueOf (   yDis% grid.Length  )  ;
		int4[0] =int4[0] +  xTrans ;
		int4[1] = int4[1] + yTrans ;
	  }
	  public Integer[] maxX(){
	  	int size1 = this.blocks.length   ;
		Integer[]  tmp1    =  this.blocks[0]   ;
		Integer[] max1   =    this.blocks[0]  ;
		Integer[] min1 =  this.blocks[0]  ; 
	   Integer[][] retVal  = new   Integer[2][2] ;
	    
	   for(int v=0;v<size1;v++){
	   	tmp1  = this.blocks[v] ;
		Integer comp = tmp1[0] ;
		if(comp<min1[0] ) {
			min1 = tmp1 ; 
		}
		if(comp>max1[0])	{
			max1 = tmp1   ; 
		}
	   }
	   retVal[0] =  min1 ; 
	   retVal1[1] = max1  ;
	   return retVal     ; 
	  }
	  public Integer[][]   maxY(){
	  	int size1 = this.blocks.length ; 
		Integer[]	 tmp1 = this.blocks[0] ;
		Integer[]	 max1 =this.blocks[0] ;
		Integer[]	 min1 = this.blocks[0] ;
		Integer[][]  retVal = new Integer[2][2] ;
		for(int c=0;c<size1;c++){
			tmp1 = this.blocks[c] ;
			Integer  comp = tmp1[1] ;
			if(comp>max1[1]){
				max1 = tmp1 ;
			}
			if(comp<min1[1]){
				min1 =  tmp1 ;
			}
		}
		retVal[0] = min1  ; 
		retVal[1] = max1 ; 
		return retVal   ;
	  }
	  publ
	  @Override 
	  public void paint(Graphics g1){
	   BufferedImage img1 = new BufferedImage(40,40,BufferedImage.TYPE_INT_RGB ) ;
	   if(g1==null){
	   	g1 = img1.getGraphics() ;
		g1.setColor(this.color) ;
	   }
	   int size1= this.blocks.size ; 
	   Integer[] tmp2 = null ; 
	   g1.setColor(this.color ) ; 
	   for(int c=0;c<size1;c++){
	   tmp2 = this.blocks[c] ;
	   g1.drawRect((tmp2[0]+this.positions[0])*Grid.Width,(tmp2[1]+this.positions[1])*Grid.Length,
	   Grid.Width,Grid.Length)  ;
	   g1.fillRect((tmp2[0]+this.positions[0])*Grid.Width,)(tmp2[1]+this.positions[1])*Grid.Length,
	   Grid.Width,Grid.Length ) ;
	   }
	   
	  }
	  
}