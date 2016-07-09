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
		String texto = ValidacaoUtil.idMaquina();
		
		/*
		 * Converte o texto em ByteArray e depois
		 * converte o ByteArray em HexString 
		 */
		String textoEmHexa = Conversoes.converteByteArrayParaHexString(Conversoes.converteASCiiParaByteArray(texto, true));
		
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
		String textoDesencriptado = aes.desencriptar(textoEncriptado);
		
		/*
		 * converte o HexString em String legivel 
		 */
		String texto2 = Conversoes.converteHexStringParaString(textoDesencriptado);
		
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