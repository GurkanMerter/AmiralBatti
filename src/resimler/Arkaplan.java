
package resimler;

import ekranlar.anaekran;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Arkaplan extends JPanel{
    
    anaekran ae=null;
    
    public Arkaplan(anaekran ae){
        this.ae=ae;
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image resim=new ImageIcon("resimler//1.jpeg").getImage();
        
        int basx=0,basy=0;
        
        g.drawImage(resim, basx, basy, null);
    }
    
}
