package ekranlar;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class oyunekran {
    
    static JPanel deniz = null;
    anaekran ae=null;
    
    public oyunekran(anaekran ae){
        this.ae=ae;
       getDeniz().add(ae.getUa().getUserpanel());
       getDeniz().add(ae.getPa().getPcpanel());                   // pc kutusu deniz arkaplanlı yere eklendi       
    }
    
    
    public JPanel getDeniz() {
        
        if(deniz==null){
            deniz=new JPanel();
            deniz.setBounds(80,100,800,400);
            deniz.setBorder(new EmptyBorder(25, 25, 25, 25));
            //deniz.setBackground(Color.blue);
            deniz.setOpaque(false);
            deniz.setVisible(false);
        }
        return deniz;
    }

    public void setDeniz(JPanel deniz) {
        this.deniz = deniz;
    } 
}
