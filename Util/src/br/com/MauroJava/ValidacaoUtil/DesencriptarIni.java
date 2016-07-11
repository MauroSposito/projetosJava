package br.com.MauroJava.ValidacaoUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DesencriptarIni {


	public static void main(String[] args) throws Exception{
		
	
	
		File arquivo = new File("c:\\Users\\mauro\\conf.ini");
			if (!arquivo.exists()){
				JOptionPane.showMessageDialog(null, "Arquivo conf.ini n�o existe, verifique.");
				System.exit(0);
			}
		
		//carrega o arquivo INI
		Properties arqIni = new Properties();
		arqIni.load(new FileInputStream("c:\\Users\\mauro\\conf.ini"));
		
		MyAES aes = new MyAES(arqIni.getProperty("tombol"),arqIni.getProperty("vektor"));
		
		String maquina = Converter.HexStringParaString(aes.desencriptar(arqIni.getProperty("maquina")));
		String driver = Converter.HexStringParaString(aes.desencriptar(arqIni.getProperty("driver")));
		String url = Converter.HexStringParaString(aes.desencriptar(arqIni.getProperty("url")));
		String user = Converter.HexStringParaString(aes.desencriptar(arqIni.getProperty("user")));
		String password = Converter.HexStringParaString(aes.desencriptar(arqIni.getProperty("password")));
		String chave = arqIni.getProperty("tombol");
		String iv = arqIni.getProperty("vektor");
		
		arquivo = new File("C:\\Users\\mauro\\Desktop\\conf_desencriptado.ini");
		if (arquivo.exists()){
			int sair = JOptionPane.showConfirmDialog(null,"Arquivo conf_desencriptado.ini j� existe, Subscrever?","Aten��o",JOptionPane.YES_NO_OPTION);
			if(sair == JOptionPane.YES_OPTION){
				arquivo.delete();
				
			} else {
				JOptionPane.showMessageDialog(null, "Saindo do sistema sem executar opera��o");
				System.exit(0);
			}
		}
		arquivo = new File("C:\\Users\\mauro\\Desktop\\conf_desencriptado.ini");
		arquivo.createNewFile();
		
		FileWriter fw = new FileWriter("C:\\Users\\mauro\\Desktop\\conf_desencriptado.ini");
		BufferedWriter bw = new BufferedWriter(fw);
		

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
		bw.newLine();
		bw.write("maquina="+maquina);
		bw.close();
		fw.close();
		JOptionPane.showMessageDialog(null, "Opera��o executada com sucesso");
	}
}