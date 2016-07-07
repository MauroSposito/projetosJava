package testes;


import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 

public class TesteData extends JFrame implements ActionListener{ 
   private   JLabel horario      =   new   JLabel(); 
   private javax.swing.Timer timer;  
  
   public TesteData() 
   { 
      super("Horario"); 
      add(horario); 
      disparaRelogio(); 
      setVisible(true); 
      setSize(200, 60); 
      setLocationRelativeTo(null); 
   } 
   
   public static void main(String args[]) 
   {   new TesteData();   } 
   
   public void disparaRelogio() {   
      if (timer == null) {   
          timer = new javax.swing.Timer(1000, this);   
          timer.setInitialDelay(0);   
          timer.start();   
      } else if (!timer.isRunning()) {   
         timer.restart();   
      }   
   } 
   public void actionPerformed(ActionEvent ae) { 
      Date   hora = new Date(); 
      SimpleDateFormat hora_formato = new SimpleDateFormat("HH:mm:ss"); 
      horario.setText(hora_formato.format(hora)); 
   } 
}
