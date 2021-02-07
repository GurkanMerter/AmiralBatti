
package olaylar;

import ekranlar.anaekran;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Olaylar implements ActionListener{
    
    
    Icon vurulmusgemi=new ImageIcon("src//resimler//vurulmuşgemi.jpg");
    Icon gemi=new ImageIcon("src//resimler//gemi.jpg");
    int atissayisi=1;
    anaekran ae=null;
    int i,sayac=0,j=0,gecici;
    int pcbatan=0,userbatan=0;
    
    
    int[] usergemikonum=new int[3];  
    int[] pcgemikonum=new int[3];
     
    int[] uservurulan=new int[16];
    int[] pcvurulan = new int[16];
      
    int pcindis=0;                          // karşıdan kaç tane vurdugumuz
    
    
    
    Random r = new Random();
    int tiklanma=0;
    int kontrol=0;
    
    
    public Olaylar(anaekran ae){
        this.ae=ae;
        
    
        
          for(i=0;i<16;i++){
              pcvurulan[i]=-1;
          }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == ae.getGe().getNasil()){
                   JOptionPane.showMessageDialog(null,
                           "1.Sol taraf sizin sağ taraf rakibin alanıdır.\n"
                           + "2.Her iki tarafında 3 gemisi bulunmaktadır.Kendi alanınızda tıklayarak gemilerinizi farklı alanlara yerleştirin(Sarı renk ile belirtilenler).\n"
                           + "3.Gemilerinizi yerleştirdikten sonra rakibin alanında bir bölgeye tıklayarak atış yapın(atış yapılan yer kırmızı olursa rakip gemi vurulmuş demektir).\n"
                           + "4.Oyun bu şekilde devam eder rakibinin 3 gemisini önce vuran oyunu kazanır.\n "
                           + "İyi Oyunlar!");

       }  
        
       if(e.getSource() == ae.getGe().getBasla()){                                   //basla butonuna tıklandığında        
                       ae.getOa().getDeniz().setVisible(true);                       //deniz arkaplanı true olsun
                       ae.getGe().getBaslik().setBackground(Color.gray);
                       ae.getGe().getBasla().setVisible(false);
                       ae.getGe().getCikis().setVisible(true);
                       ae.getGe().getAmiral().setFont(new Font("Verdana", Font.BOLD, 20));
                       ae.getGe().getAmiral().setBounds(425,20,200,30);
                       ae.getGe().getKomut().setText("Gemilerinizi Yerleştirin (3 Geminiz var)");
                       ae.getGe().getKomut().setFont(new Font("Verdana", Font.BOLD, 15)); 
                       random16();
                       pcrandom3kutu();
                       
       }
       
       if(e.getSource() == ae.getGe().getCikis()){
                   System.exit(0);
       }       
      
        for(i=0;i<16;i++){
            if(e.getSource() == ae.getUa().getUserbutton()[i]){
                
                if(tiklanma < 3){
                    ae.getUa().getUserbutton()[i].setEnabled(false);
                    ae.getUa().getUserbutton()[i].setIcon(gemi);
                    usergemikonum[tiklanma]=i;
                    tiklanma++;
                    try {
                        pasifkil();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Olaylar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } 

            
        for(i=0;i<16;i++){
            if(e.getSource() == ae.getPa().getPcbutton()[i]){
                ae.getPa().getPcbutton()[i].setOpaque(false);
                //ae.getPa().getPcbutton()[i].setEnabled(false);
                pcvurulan[pcindis]=i;
                pcindis++;
                
                for(j=0;j<3;j++){
                    if(i==pcgemikonum[j]){
                        pcbatan++;                  // karşı taraftan vurduğum gemi sayısı
                        ae.getPa().getPcbutton()[i].setOpaque(true);
                        ae.getPa().getPcbutton()[i].setBackground(Color.red);
                    }
                }
                
                if(pcbatan==3){
                    JOptionPane.showMessageDialog(null,"Tebrikler,Kazandınız");
                    System.exit(0);
                }
                
                
                try {
                    userinsirasi();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Olaylar.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if(kontrol<1){
                         kontrol++;
                         pcsirasi();
                    }  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Olaylar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }  
        
    }
    /*------------------FUNC BİTİŞ------------------*/
     
            /*PC ALANDAKİ KUTUDAN RASTGELE 3 TANE KUTU SEÇİLECEK*/
            public void pcrandom3kutu(){

                int indis = 0;                  // gemikonumun indisi                
                int denek;

                /*BU KISIMDA PCALAN DA 3 TANE FARKLI BUTON SEÇİLİYOR*/
                    while(indis<3){

                        denek = r.nextInt(16);
                        if(indis==0){
                            pcgemikonum[indis]=denek;
                        }

                        sayac=0;
                        while(sayac < indis){
                            if(denek==pcgemikonum[sayac]){
                               denek = r.nextInt(16);
                               sayac=0;
                            }else{
                                sayac++;
                            }
                        }

                        if(sayac==indis){
                            pcgemikonum[indis]=denek;
                        }

                        indis++;
                    }
                    /*3 TANE FARKLI BUTON SEÇİLDİ*/     
          
                    /*pc rastgele 3 kutuyu göstermek kısmı*/
                    int a;
                    for(i=0;i<3;i++){
                       a=pcgemikonum[i];
                       
                    }                         
            }
            /*------------------FUNC BİTİŞ------------------*/

            /*EĞER 3 TANE KUTUYA TIKLANMIŞSA DİĞER BUTONLARI PASİF KIL*/
            public void pasifkil() throws InterruptedException {
                
                if(tiklanma==3){
                    for(i=0;i<16;i++){
                      //  ae.getUa().getUserbutton()[i].setEnabled(false);
                    }
                    userinsirasi();
                }
                
            }
            /*------------------FUNC BİTİŞ------------------*/
                        
            public void userinsirasi() throws InterruptedException {
                
                ae.getGe().getKomut().setText("                     Savaş Başladı!");
                kontrol=0;
                for(i=0;i<16;i++){                
                            ae.getPa().getPcbutton()[i].setEnabled(true);
                          //  ae.getUa().getUserbutton()[i].setEnabled(false);
                }
                
                
                j=0;
                while(j<16){
                    if(pcvurulan[j]!=-1){
                       gecici=pcvurulan[j];
                       ae.getPa().getPcbutton()[gecici].setEnabled(false);
                    }
                    j++;
                }
                j=0;               
            }
            
            public void pcsirasi() throws InterruptedException {
                ae.getGe().getKomut().setText("                       Sıra Rakipte");
                int a=0;
                
                for(i=0;i<16;i++){
                    ae.getUa().getUserbutton()[i].setEnabled(true);
                   // ae.getPa().getPcbutton()[i].setEnabled(false);
                }
                
                int z=0;
                
               for(i=0;i<atissayisi;i++){
                    a=uservurulan[i];           
                    ae.getUa().getUserbutton()[a].setOpaque(false);
                }
               
               for(j=0;j<3;j++){
                   if(uservurulan[atissayisi-1]==usergemikonum[j]){  
                       z=usergemikonum[j];
                       ae.getUa().getUserbutton()[z].setIcon(vurulmusgemi);
                       userbatan++;
                   }
               }
               
               if(userbatan==3){
                   JOptionPane.showMessageDialog(null,"Malesef,Kaybettiniz.");
                   System.exit(0);
               }

                atissayisi++;
                userinsirasi();
                
            }
    
            public void random16(){
                int indis=0;
                int denek;
                
                 while(indis<16){
                        denek = r.nextInt(16);
                        if(indis==0){
                            uservurulan[indis]=denek;
                        }

                        sayac=0;
                        while(sayac < indis){
                            if(denek==uservurulan[sayac]){
                               denek = r.nextInt(16);
                               sayac=0;
                            }else{
                                sayac++;
                            }
                        }

                        if(sayac==indis){
                           uservurulan[indis]=denek;
                        }

                        indis++;
                    }
            }
    
}