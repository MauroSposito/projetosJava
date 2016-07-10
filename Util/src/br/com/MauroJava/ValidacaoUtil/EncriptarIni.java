package br.com.MauroJava.ValidacaoUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class EncriptarIni {

	public static void main (String[] args) throws Exception{
		
		/*
		 * chave para criptografia obrigatoriedade de 16 hexadecimal
		 
		String chave1 = "140b41b22a29beb4061bda66b6747e14";
		
		/*
		 * vetor para criptografia tambem obrigatoriamente 16 numeros
		 
		String iv1 = "1234567890123456";
		
		/*
		 * Texto a ser criptografado
		 */
		
		String maquina = ValidacaoUtil.idMaquina();
		System.out.println(maquina);
		maquina =  Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(maquina, true));
		String chave;
		do{
		chave = JOptionPane.showInputDialog(null, "Chave da AES com 32 caracterea(0-9)(a-f)");
		System.out.println(chave);
		}while (chave.length() != 32);
		
		String iv;
		do{
		iv = JOptionPane.showInputDialog(null, "Chave da AES com 16 caracterea(0-9)");
		System.out.println(iv);
		}while (iv.length() != 16);
		
		String driver;
		do{
		driver = JOptionPane.showInputDialog(null, "driver banco de dados");
		System.out.println(driver);
		}while (driver.isEmpty());
		driver = Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(driver, true));
		
		String url;
		do{
		url = JOptionPane.showInputDialog(null, "url para banco de dados");
		System.out.println(url);
		}while (url.isEmpty());
		url = Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(url, true));
		
		String user;
		do{
		user = JOptionPane.showInputDialog(null, "user do banco de dados");
		System.out.println(user);
		}while (user.isEmpty());
		user =  Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(user, true));
		
		String password;
		do{
		password = JOptionPane.showInputDialog(null, "password do banco de dados");
		System.out.println(password);
		}while (password.isEmpty());
		password =  Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(password, true));
	
		/*
		 * Instacia o objeto do tipo MyAES passando como
		 * parametros a chave e o vetor
		 */
		MyAES aes = new MyAES(chave, iv);
		
		chave =  Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(chave, true));
		iv =  Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(iv, true));
		
		
		maquina = aes.encriptar(maquina);
		System.out.println(maquina);
		chave = aes.encriptar(chave);
		System.out.println(chave);
		iv = aes.encriptar(iv);
		System.out.println(iv);
		driver = aes.encriptar(driver);
		System.out.println(driver);
		url = aes.encriptar(url);
		System.out.println(url);
		user = aes.encriptar(user);
		System.out.println(user);
		password = aes.encriptar(password);
		System.out.println(password);
		
		File arquivo = new File("C:\\Users\\mauro\\Desktop\\conf.ini");
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter("C:\\Users\\mauro\\Desktop\\conf.ini");
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("maquina="+maquina);
		bw.newLine();
		bw.write("tombol="+chave);
		bw.newLine();
		bw.write("vektor="+iv);
		bw.newLine();
		bw.write("driver="+driver);
		bw.newLine();
		bw.write("url="+url);
		bw.newLine();
		bw.write("user="+user);
		bw.newLine();
		bw.write("password="+password);
		bw.close();
		fw.close();
		
		
	}
}