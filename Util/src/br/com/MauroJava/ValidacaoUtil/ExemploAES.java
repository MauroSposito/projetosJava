package br.com.MauroJava.ValidacaoUtil;



public class ExemploAES{

	public static void main (String[] args) throws Exception{
		
		/*
		 * chave para criptografia obrigatoriedade de 16 hexadecimal
		 */
		String chave = "140b41b22a29beb4061bda66b6747e14";
		
		/*
		 * vetor para criptografia tambem obrigatoriamente 16 numeros
		 */
		String iv = "1234567890123456";
		
		/*
		 * Texto a ser criptografado
		 */
		String texto = "texto a ser criptografado";
		
		
		/*
		 * Converte o texto em ByteArray e depois
		 * converte o ByteArray em HexString 
		 */
		String textoEmHexa = Converter.ByteArrayParaHexString(Converter.ASCiiParaByteArray(texto, true));
		
		/*
		 * Instacia o objeto do tipo MyAES passando como
		 * parametros a chave e o vetor
		 */
		MyAES aes = new MyAES(chave, iv);
		
		/*
		 * uma variavel recebe o texto encriptado
		 */
		String textoEncriptado = aes.encriptar(textoEmHexa);
		
		/*
		 * uma variavel recebe o texto desencriptado
		 */
		String textoDesencriptado = aes.desencriptar("774AE710E0A24C102DEE38D0FD923CED22F7BD446C503C1DCBB9091A499D4E3D2797A0F8A7C7F0E38D8C22EFE287236AF9D7257760D6");
		
		/*
		 * converte o HexString em String legivel 
		 */
		String texto2 = Converter.HexStringParaString(textoDesencriptado);
		
		/*
		 * para conferencia
		 */
		System.out.println("Texto Original");
		System.out.println(texto);
		System.out.println("Texto em hexa");
		System.out.println(textoEmHexa);
		System.out.println("TextoEncriptado");
		System.out.println(textoEncriptado);
		System.out.println("TextoDesencriptado");
		System.out.println(textoDesencriptado);
		System.out.println("Texto extraido");
		System.out.println(texto2);		
	}
}