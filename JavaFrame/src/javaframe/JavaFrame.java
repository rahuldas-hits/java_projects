
package javaframe;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class JavaFrame extends Frame 
{
    BufferedImage bi;
    public void myFrame(){
        try {    
            bi = ImageIO.read(new File("F:\\programmer_quotes_12.jpg") );
        } catch (IOException ex) {
            
        }
        
        setSize(1786,750);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){  
        super.paint(g);
        g.drawImage(bi, 0,0,getWidth(),getHeight(),null);
    }
    public static void main(String[] args) {
        new JavaFrame().myFrame();

    }

   
    
}
