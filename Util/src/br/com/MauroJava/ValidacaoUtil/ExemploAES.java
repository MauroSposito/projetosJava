package br.com.MauroJava.ValidacaoUtil;

public class ExemploAES{

	public static void main (String[] args) throws Exception{
		
		String chave = "140b41b22a29beb4061bda66b6747e14";
		
		String iv = "1234567890123456";
		
		String texto = "Em Criptografia, o Advance Encryption Standard (AES, ou Padr�o de Critografia Avan�ado, em portugu�s) tamb�m o AES j� � um dos algoritmos mais populares usados para criptografia sim�trica";
		
		System.out.println("Texto Original");
		System.out.println(texto);
		
		System.out.println("Texto em hexa");
		String textoEmHexa = Conversoes.converteByteArrayParaHexString(Conversoes.converteASCiiParaByteArray(texto, true));
		
		System.out.println(textoEmHexa);
		
		MyAES aes = new MyAES(chave, iv);
		
		String textoEncriptado = aes.encriptar(textoEmHexa);
		System.out.println("textoEncriptado");
		System.out.println(textoEncriptado);
		
		String textoDesencriptado = aes.desencriptar(textoEncriptado);
		System.out.println("textoDesencriptado");
		System.out.println(textoDesencriptado);
		
	}
}