package telas;

abstract public class Perfil {
	
	//atributos
	private static int idUser;
	private static String logUsuario;
	private static String logSenha;
	private static String logLogin;
	private static int logNivel;
	private static String logEntrada;
	private static String logSaida;
	
	//getters e setters
	public static int getIdUser() {
		return idUser;
	}
	public static void setIdUser(int idUser) {
		Perfil.idUser = idUser;
	}
	public static String getLogLogin() {
		return logLogin;
	}
	public static void setLogLogin(String logLogin) {
		Perfil.logLogin = logLogin;
	}
	public static String getLogSenha() {
		return logSenha;
	}
	public static void setLogSenha(String logSenha) {
		Perfil.logSenha = logSenha;
	}
	public static String getLogUsuario() {
		return logUsuario;
	}
	public static void setLogUsuario(String logUsuario) {
		Perfil.logUsuario = logUsuario;
	}
	public static int getLogNivel() {
		return logNivel;
	}
	public static void setLogNivel(int logNivel) {
		Perfil.logNivel = logNivel;
	}
	public static String getLogEntrada() {
		return logEntrada;
	}
	public static void setLogEntrada(String logEntrada) {
		Perfil.logEntrada = logEntrada;
	}
	public static String getLogSaida() {
		return logSaida;
	}
	public static void setLogSaida(String logSaida) {
		Perfil.logSaida = logSaida;
	}
	
			
	
	
	
}
