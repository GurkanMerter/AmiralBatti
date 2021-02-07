package ekranlar;

import static ekranlar.oyunekran.deniz;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/*  Giriş ekranında olan butonlar resimler ve yazılartı tutan class tır */ 
public class girisekran  {
    JPanel baslik = null,butonpanel=null;
    JLabel amiral= null,komut=null;
    JButton basla=null,cikis= null,nasil=null;
    anaekran ae=null;
    Icon anaresim=new ImageIcon("src//resimler//soru.jpg");
    
    public girisekran(anaekran ae){
        this.ae=ae;
          
        getBaslik().add(getAmiral());                            
        getBaslik().add(getKomut());
        getBaslik().add(getNasil());
        getButonpanel().add(getBasla());                        // butonpaneline butonu ekle
        getButonpanel().add(getCikis());
    }

    public JButton getCikis() {     
        if(cikis==null){
            cikis=new JButton("Çıkış");                                             // içindeki yazı
            cikis.setFont(new Font("Verdana", Font.BOLD, 25));                      // yazı şekli
            cikis.setForeground(Color.white);                                       // yazı rengi
            cikis.setBackground(Color.getHSBColor(0.5f, 0.6f, 0.6f).darker());      // arkaplan
            cikis.setSize(150,50);
            cikis.setVisible(false);
            cikis.addActionListener(ae.getO());
        }
        return cikis;    
    }
      
    public void setCikis(JButton cikis) {
        this.cikis = cikis;
    }
    
    
    public JPanel getBaslik() {
        if(baslik==null){
            baslik= new JPanel();
            baslik.setBackground(Color.gray);               // arkaplan
            baslik.setBounds(0,20,1000,100);
            baslik.setVisible(true);
            baslik.setLayout(null);  
        }
        return baslik;
    }

    public void setBaslik(JPanel baslik) {
        this.baslik = baslik;
    }

    public JPanel getButonpanel() { 
        if(butonpanel==null){   
            butonpanel= new JPanel();                         
            butonpanel.setBounds(420,500,150,50);             // boyut ve konum
            butonpanel.setBackground(Color.red);
            butonpanel.setLayout(null);
        }
        return butonpanel;
    }

    public void setButonpanel(JPanel butonpanel) {
        this.butonpanel = butonpanel;
    }

    public JLabel getAmiral() {
        if(amiral==null){
            amiral = new JLabel("Amiral Battı");                  // yazısı
            amiral.setFont(new Font("Verdana", Font.BOLD, 40));   // yazı şekli
            amiral.setBounds(370, 10, 450, 80);                   // konum ve boyutu
        }
        return amiral;
    }

    public void setAmiral(JLabel amiral) {
        this.amiral = amiral;
    }

    public JButton getBasla() {
        if(basla==null){
            basla= new JButton("Basla");                                            // içindeki yazı
            basla.setFont(new Font("Verdana", Font.BOLD, 30));                      // yazı şekli
            basla.setForeground(Color.white);                                       // yazı rengi
            basla.setBackground(Color.getHSBColor(0.5f, 0.6f, 0.6f).darker());      // arkaplan 
            basla.setSize(150,50);
            basla.addActionListener(ae.getO());
        }
        return basla;
    }

    public void setBasla(JButton basla) {
        this.basla = basla;
    }

    public JLabel getKomut() {
        if(komut==null){
            komut = new JLabel();
            komut.setBounds(330,50,500,50);        
        }
        return komut;
    }

    public void setKomut(JLabel komut) {
        this.komut = komut;
    }

    public JButton getNasil() {
        if(nasil==null){
            nasil=new JButton(anaresim);
            nasil.setBounds(900,20,60,60);
            nasil.setBackground(Color.getHSBColor(0.5f, 0.6f, 0.6f).darker());
            nasil.setForeground(Color.white);
            nasil.setBorder(new EmptyBorder(0, 0, 0, 0));
            nasil.addActionListener(ae.getO());
        }
        return nasil;
    }

    public void setNasil(JButton nasil) {
        this.nasil = nasil;
    }
     
}