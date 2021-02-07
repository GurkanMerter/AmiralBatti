package ekranlar;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import olaylar.Olaylar;

/* BU CLASSTA ANAEKRAN VE EANAEKRANIN İÇERİSİNDEKİ ANA PANEL BELİRLENDİ*/
public class anaekran { 
    JFrame anaekran = null;
    anapanel ap=null;
    girisekran ge=null;
    oyunekran oa= null;
    useralan ua = null;
    pcalan pa = null;
    Olaylar o = null;

    public anaekran(){
        getAp().add(getGe().getBaslik());                           // ana panele başlık paneli eklendi
        getAp().add(getGe().getButonpanel());
        getAp().add(getOa().getDeniz());
        getAnaekran().setVisible(true);          // ana ekranı görünür yap  
    }

    /*ANA EKRAN VE ANAPANELİN GET VE SET METODLARI*/

    public JFrame getAnaekran() {
       if(anaekran==null){
           anaekran = new JFrame("Amiral Battı");                        // isim konuldu
           anaekran.setLocation(20,25);                                  // başlangıç konumu seçildi
           anaekran.setSize(1000,600);                                    // boyutu ayarlandı
           anaekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // kapatılırsa arkada çalışmayacak
           anaekran.setContentPane(getAp());                       // anaekrana anapanel eklendi
           anaekran.setLayout(null);
           anaekran.setResizable(false);
       }
        return anaekran;
    }

    public void setAnaekran(JFrame anaekran) {
        this.anaekran = anaekran;
    }
    
    public girisekran getGe() {
        if(ge==null) {
            ge=new girisekran(this);
        }
        return ge;
    }

    public oyunekran getOa() {
        if(oa==null){
            oa=new oyunekran(this);
        }
        return oa;
    }

    public useralan getUa() {
        if(ua==null){
            ua=new useralan(this);
        }
        return ua;
    }

    public pcalan getPa() {
        if(pa==null){
            pa=new pcalan(this);
        }
        return pa;
    }

    public Olaylar getO() {
        if(o==null){
            o=new Olaylar(this);
        }
        return o;
    } 

    public anapanel getAp() {
         if(ap==null){
            ap=new anapanel(this);
        }
        return ap;
    }
}
