package ekranlar;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class useralan {
    JPanel userpanel= null;
    JButton[] userbutton=null;
    int i,sayac=0;
    int[] gemikonum=new int[3];
    anaekran ae=null;
      
    public useralan(anaekran ae){
        this.ae=ae;
        getUserbutton();
    }
       
    public JPanel getUserpanel() {
        if(userpanel==null){
           userpanel=new JPanel();
           userpanel.setVisible(true);
           userpanel.setPreferredSize(new Dimension(370, 360));
           userpanel.setBorder(new EmptyBorder(5, 0, 5, 25));
           //userpanel.setBackground(Color.red);
           userpanel.setOpaque(false);
        }
        return userpanel;
    }

    public void setUserpanel(JPanel userpanel) {
        this.userpanel = userpanel;
    } 
    
    /*USERBUTTON GET MOETODU*/
    public JButton[] getUserbutton() {
       
        if(userbutton==null){
            
                userbutton=new JButton[16];
            
                for(i=0;i<16;i++){
                    userbutton[i]=new JButton();
                    userbutton[i].setPreferredSize(new Dimension(80, 80));
                    userbutton[i].setBackground(Color.gray);
                    getUserpanel().add(userbutton[i]); 
                    userbutton[i].addActionListener(ae.getO());                  // butonu actionlistenere ekle
                }        
        }
        
          return userbutton;
    }
    /*USER BUTTON GET METODU BİTİŞ*/   
    
    public void setUserbutton(JButton[] userbutton) {
        this.userbutton = userbutton;
    }   
}
