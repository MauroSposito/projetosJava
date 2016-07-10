package br.com.MauroJava.ValidacaoUtil;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MyAES{
	
	private final String ALGORITMO = "AES/CTR/NoPadding";
	private Key chaveAES;
	private IvParameterSpec ivps;
	
	public MyAES(String key, String iv){
		byte[] ivArray = Converter.ASCiiParaByteArray(iv, false);
		ivps = new IvParameterSpec(ivArray);
		chaveAES = gerarChaveAES(key);
	}
	/*  
	* Metodo para gerar a chave 
	* java.security.Key
	*/
	public static Key gerarChaveAES(String key){
		byte[] keyArray = Converter.HexStringParaByteArray(key);
		return new SecretKeySpec(keyArray,"AES");
	}
	/*
	* texto String em formato hexadecimal do texto a encriptar
	*/
	public String encriptar(String texto) throws Exception{
		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.ENCRYPT_MODE, chaveAES, ivps);
		byte[] textoArray = Converter.HexStringParaByteArray(texto);
		byte[] msg = c.doFinal(textoArray);
		return Converter.ByteArrayParaHexString(msg);
	}
	/*
	* textoCifrado String em formato hexadecimal do texto encriptado
	*/
	public String desencriptar(String textoCifrado) throws Exception{
		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.DECRYPT_MODE, chaveAES, ivps);
		byte[] textoArray = Converter.HexStringParaByteArray(textoCifrado);
		byte[] msg = c.doFinal(textoArray);
		return Converter.ByteArrayParaHexString(msg);
	}
}

