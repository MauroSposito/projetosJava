package br.com.MauroJava.ValidacaoUtil;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionListener; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 

public abstract class ValidacaoUtil implements ActionListener{
	javax.swing.Timer timer; 
	JLabel horario = new JLabel(); 

	/*metodo validaCpf
	 * 
	 */
	public static boolean validaCpf(String cpf){
		if	(cpf.length() != 11 && cpf.length() < 11){
			JOptionPane.showMessageDialog(null, "M�nimo de 11 numeros");
			return false;
		}
		if	(cpf.length() != 11 && cpf.length() > 11){
			JOptionPane.showMessageDialog(null, "M�ximo de 11 numeros");
			return false;
		}
		int tamanho = cpf.length();
		String s;
		Integer soma = 0;
		int nono = 0;
		for (int i = 0; i < (tamanho ); i++){
			s=""+ cpf.charAt(i);
			Integer numero = Integer.parseInt(s);
			if (i == 9)
				nono = numero;
			if (i <9 ){
				numero = numero * (10-i);
				soma = soma + numero;
			}
		}
		if ((soma*10)%11 == nono){
			soma = 0;
			for (int i = 0; i < (tamanho ); i++){
				s=""+ cpf.charAt(i);
				Integer numero = Integer.parseInt(s);
				if (i == 10)
					nono = numero;
				if (i <10 ){
					numero = numero * (11-i);
					soma = soma + numero;
				}
			}
		}
		if ((soma*10)%11 == nono){
			return true;
		}
		else {
			return false;
		}
	}
	/* metodo agora()
	 * 
	 */
	public static String agora (){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt", "br"));
		return (now.format(formatador));
	}
	
	/*metodo hoje()
	 * 
	 */
	public static String hoje(){
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return (today.format(formatador)); 
	}
	
		
	

	
		

	
}	