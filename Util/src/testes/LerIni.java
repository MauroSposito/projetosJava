package testes;

import java.io.FileInputStream;
import java.util.Properties;

import br.com.MauroJava.ValidacaoUtil.Conversoes;
import br.com.MauroJava.ValidacaoUtil.MyAES;
import br.com.MauroJava.ValidacaoUtil.ValidacaoUtil;

public class LerIni {

	public static void main(String[] args) throws Exception {
		
		Properties arqIni = new Properties();
		arqIni.load(new FileInputStream("c:\\Users\\mauro\\conf.ini"));
		String texto = arqIni.getProperty("x");
		String maquina = arqIni.getProperty("idMaquina");
		String chave = arqIni.getProperty("evahc");
		String iv = arqIni.getProperty("vi");
		
		MyAES aes = new MyAES("140b41b22a29beb4061bda66b6747e14", "1234567890123456");
		
		String desencrip = aes.desencriptar(texto);
		texto = Conversoes.converteHexStringParaString(desencrip);
		desencrip = aes.desencriptar(maquina);
		maquina = Conversoes.converteHexStringParaString(desencrip);
		if (ValidacaoUtil.idMaquina().equals(maquina)){
			System.out.println(maquina);
			System.out.println("igual");
		}
		
		
		
		System.out.println(texto);
	}
}
