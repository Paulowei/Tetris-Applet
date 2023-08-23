import java.awt.event.*;
import java.awt.event.KeyAdapter ;
import java.awt.event.KeyEvent ;
import java.awt.event.KeyListener ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ; 
import java.awt.Container ; 
import java.awt.Component ;
import javax.swing.JLayeredPane ; 
import javax.swing.JPanel ;
import java.awt.Label ; 
import java.awt.Rectangle ; 

	public class KeyList extends KeyAdapter implements KeyListener{
		public  Game game1 ;
		public Label label1  ;
		public Scene scene1 ; 
		public TetrisBlock current ;
        public Grid grid1 ;
		public KeyList(Game game2){
			this.game1 = game2  ; 
			//this.scene1 = game1.scene1 ; 
            this.grid1 = game1.grid  ;
			this.current = scene1.currentBlock ;
		}
        public void init6(){
            game1.setLayeredPane(game1.layeredPane) ;
            game1.setAutoRequestFocus(true) ;
            game1.requestFocus() ; 
            game1.suspend = true  ;
            game1.threads[4].run() ; 
        }
		@Override
		public void keyTyped(KeyEvent event1 ){
			int keyCode = event1.getKeyCode() ;
            int identity = event1.getID() ;
            //int mods = event1.getModifiers() ; 
            Object source1 = event1.getSource()  ;
            String str1 = event1.paramString() ;
			this.current = scene1.currentBlock ; 
			switch(keyCode) {
				case KeyEvent.VK_LEFT :
				     current.translate(-1,0) ;
					 break ; 
				 case KeyEvent.VK_RIGHT :
					 current.translate(1,0) ; 
					 break ; 
				 case KeyEvent.VK_UP :
					 current.rotateLeft(1) ; 
					 break ;
				 case KeyEvent.VK_DOWN : 
				   		current.rotateRight(1) ; 
						break ;
                case KeyEvent.VK_SHIFT :
                game1.init4(game1.G4) ;
                grid1.suspend = true ;
                game1.setBounds(new Rectangle(520,520)) ;
                game1.setBounds(new Rectangle(500,500))  ;
                game1.addKeyListener(game1.keyList) ;
                 case KeyEvent.VK_ESCAPE :
                 Container cont1 = game1.getLayeredPane() ; 
                 if(cont1.equals
                 (game1.newPane)){
                    init6() ;
                    validateArray() ; 

                 }
                    setBounds(new Rectangle(520,520)) ;
                    setBounds(new Rectangle(500,500)) ;
                break ;  
                 case KeyEvent.VK_ENTER :
                   grid1.shuffleBlock(0) ;
                   break ;
				 default :
				 	System.out.println(keyCode) ;
			}
			
		}
        public void validateArray(){
            grid1.array1[0] = game1.array1[0]  ;
            grid1.array1[1]  =  game1.array1[1]  ;
   }
		@Override 
		public void  keyReleased(KeyEvent event2 ) { 
            int keyCode = event1.getKeyCode() ;
            int identity = event1.getID() ;
            //int mods = event1.getModifiers() ; 
            Object source1 = event1.getSource()  ;
            String str1 = event1.paramString() ;
		}
		@Override 
		public void keyPressed(KeyEvent event3){
            int keyCode = event1.getKeyCode() ;
            int identity = event1.getID() ;
            //int mods = event1.getModifiers() ; 
            Object source1 = event1.getSource()  ;
            String str1 = event1.paramString() ;
		}
	}