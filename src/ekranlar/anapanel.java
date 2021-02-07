
package ekranlar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.layout.Background;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static sun.net.www.http.HttpClient.New;

public class anapanel extends JPanel {
    
    anaekran ae;
    private BufferedImage img;
    String yol="src//resimler//anaresim.jpg";
    
    public anapanel(anaekran ae){
        this.ae=ae;
        setLayout(null);
        setBackground(Color.red);
        
        try{
           File file=new File(yol);
           img=ImageIO.read(file);
        }  catch(IOException e){
            
        }
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
    
    @Override
    public void paintComponent (Graphics g){
        g.drawImage(img, 0, 0,1000,600, null);
        repaint();
    }
}
