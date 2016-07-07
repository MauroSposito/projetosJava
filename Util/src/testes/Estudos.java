package testes;

/*
Este exemplo mostra como definir uma tecla
de atalho para um menu. Observe que a tecla
de atalho aparecer� sublinhada. Quando usamos
uma tecla de atalho (por exemplo, a letra "A"),
o menu poder� ser acessado com a combina��o
Alt+A.
*/

import javax.swing.*;
import java.awt.event.*;

public class Estudos extends JFrame{
public Estudos(){
  super("Menus");

  // Cria a barra de menus
  JMenuBar barra = new JMenuBar();
  setJMenuBar(barra);

  // Cria um menu
  JMenu arquivo = new JMenu("Arquivo");

  // Define a tecla de atalho
  arquivo.setMnemonic(KeyEvent.VK_A);

  // Cria um item de menu e o adiciona no menu
  JMenuItem fechar = new JMenuItem("Fechar");
  arquivo.add(fechar);

  // Adiciona o menu � barra de menus
  barra.add(arquivo);

  setSize(300, 150);
  setVisible(true);    
}

public static void main(String args[]){
  Estudos app = new Estudos();
  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
