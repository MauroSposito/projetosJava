package br.com.MauroJava.ValidacaoUtil;



public class Ajuda {
	/* Relogio
	 *
	***imports***
	import java.awt.event.ActionEvent; 
	import java.awt.event.ActionListener; 
	import java.text.SimpleDateFormat; 
	import java.util.Date; 
	import javax.swing.JFrame; 
	import javax.swing.JLabel; 
    
    //colocar esses atributos no inicio da classe
     * 
    private JLabel <Nome Label> = new JLabel();
	private javax.swing.Timer timer; 
	
	//adiciona o JLabel e dispara o relogio.
	 *
	contentPane.add(<Nome Label>);
	disparaRelogio();
	
	//Cria os dois metodos no final da classe.
	 * 	
	public void disparaRelogio(){
		if (timer == null) {   
			timer = new javax.swing.Timer(1000,this);   
			timer.setInitialDelay(0);   
			timer.start();   
		} else if (!timer.isRunning()) {   
			timer.restart();   
		}
	}
	public void actionPerformed(ActionEvent ae) {
		Date hora = new Date(); 
		SimpleDateFormat hora_formato = new SimpleDateFormat("HH:mm:ss"); 
		<Nome Label>.setBounds(700, 530, 70, 14);
		<Nome Label>.setText(hora_formato.format(hora));
	}
	 */	
	
	
	/*
	 * Usar e Formatar uma data.
	 * 
	 ***imports***
	 *import java.text.DateFormat
	 *import java.util.Date
	 *
	 *String <VARIAVEL>;
	 *Date data = new Date();
	 *DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
	 *<VARIAVEL> = formatador.format(data);
	 *ou
	 *<JLabel>.setText(formatador.format(data));
	 */
	
	
	/* exemplo JOptionPane sim ou nao.
	 * 
	 * public void mouseClicked(MouseEvent arg0) {
				int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair","Aten��o",JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION){
					System.exit(0);
				}
	 */
	
	
	
	
	
	
	
}