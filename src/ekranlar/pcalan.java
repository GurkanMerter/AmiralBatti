package ekranlar;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class pcalan {
    JPanel pcpanel= null;
    JButton pcbutton[]=null;
    int i;
    anaekran ae=null;
    
    public pcalan(anaekran ae){
        this.ae=ae;
        getPcbutton();
    }
    
    public JPanel getPcpanel() {
        if(pcpanel==null){
            pcpanel=new JPanel();
            pcpanel.setPreferredSize(new Dimension(370, 360));
            pcpanel.setBorder(new EmptyBorder(5, 25, 5, 0));
            pcpanel.setVisible(true);
            pcpanel.setOpaque(false);
        }
        return pcpanel;
    }

    public void setPcpanel(JPanel pcpanel) {
        this.pcpanel = pcpanel;
    }

    public JButton[] getPcbutton() {   
        if(pcbutton==null){
            pcbutton=new JButton[16];
            
            for(i=0;i<16;i++){
                pcbutton[i]=new JButton();
                pcbutton[i].setEnabled(false);
                pcbutton[i].setPreferredSize(new Dimension(80, 80));
                pcbutton[i].setBackground(Color.gray);
                getPcpanel().add(pcbutton[i]);
                pcbutton[i].addActionListener(ae.getO());
                
            }      
        } 
        
        return pcbutton;
    }

    public void setPcbutton(JButton[] pcbutton) {
        this.pcbutton = pcbutton;
    } 
}
