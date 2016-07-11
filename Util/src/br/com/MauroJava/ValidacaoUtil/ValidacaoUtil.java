package br.com.MauroJava.ValidacaoUtil;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.Locale;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;


; 

public abstract class ValidacaoUtil {


	/*
	 * Metodo validaCpf(String cpf) retorna verdadeiro ou falso alem de verificar quantidade de caracteres.
	 */
	public static boolean validaCpf(String cpf){
		if	(cpf.length() != 11 && cpf.length() < 11){
			JOptionPane.showMessageDialog(null, "Mínimo de 11 numeros");
			return false;
		}
		if	(cpf.length() != 11 && cpf.length() > 11){
			JOptionPane.showMessageDialog(null, "Máximo de 11 numeros");
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
	
	/* 
	 * Metodo agora() retorna data e hora do momento que for chamada.
	 */
	public static String agora (){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt", "br"));
		return (now.format(formatador));
	}
	
	/*
	 * Metodo hoje(), retorna data no formatado na mascara dd/MM/yyyy
	 */
	public static String hoje(){
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return (today.format(formatador)); 
	}
	
	/* 
	 * Metodo idMaquina() para retornar id da cpu windows ou serial hd Linux
	 */
	public static String idMaquina() {
		Properties propriedades = System.getProperties();
		String os = (String) propriedades.get("os.name");
		if (os.contains("Windows")) {
			final String COMANDO = "wmic bios get serialnumber";
			final String SUB_STRING = "SerialNumber";
			final String LOCALIZADOR = "               ";
			Process processo = null;
			InputStream iStream = null;
			try {
				processo = Runtime.getRuntime().exec(COMANDO);
				iStream = processo.getInputStream();
				byte[] buf = new byte[1024];
				int tamanho = 0;
				StringBuffer sb = new StringBuffer();
				while ((tamanho = iStream.read(buf))>=0) {
					sb.append(new String(buf));
				}
				String ret = sb.toString();
				if (ret.contains(SUB_STRING)) {
					String volume = ret.substring(ret.lastIndexOf(LOCALIZADOR) + LOCALIZADOR.length(), ret.length()).trim();
					return volume.substring(0, 16);
				} else {
					return "Not found";
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (processo != null) {
						processo.destroy();
					}
					if (iStream != null) {
						iStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (os.contains("Linux")) {
			final String COMANDO = "ls -l /dev/disk/by-id/";
			Process processo = null;
			InputStream iStream = null;
			try {
				processo = Runtime.getRuntime().exec(COMANDO);
				iStream = processo.getInputStream();
				byte[] buf = new byte[1024];
				int tamanho = 0;
				StringBuffer sb = new StringBuffer();
				while ((tamanho = iStream.read(buf))>=0) {
					sb.append(new String(buf));
				}
				String volume = sb.toString().substring(73, 88);
				return volume;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (processo != null) {
						processo.destroy();
					}
					if (iStream != null) {
						iStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "Not found";
	}
	
	
}