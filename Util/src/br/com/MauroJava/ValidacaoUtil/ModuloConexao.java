package br.com.MauroJava.ValidacaoUtil;

//importa biblioteca java sql.
import java.sql.*;


public class ModuloConexao {
	
	// metodo responsavel por estabelcer a conexao com o banco de dados.
	public static Connection conector(){
		
		//cria uma variavel chamada conexao nula.
		java.sql.Connection conexao = null;
		
		//armazena em variavel para "chamar" o driver importado para biblioteca.
		String driver = "com.mysql.jdbc.Driver";
		
		//armazenando informaçoes referente ao banco de dados.
		String url = "jdbc:mysql://localhost:3306/dbprincipal?useSSL=true";
		String user = "root";
		String password = "mshigh001";
		
		//estabelecendo a conexao com o banco de dados.
		try {
			//executa o arquivo do driver
			Class.forName(driver);
			// obtem a conexao utilizando os paramentos informados nas variaveis.
			conexao = DriverManager.getConnection(url, user, password);
			// retorna se conexao foi feita com sucesso ou nao.
			return conexao;
			
		} catch (Exception e) {
			//a linha abaixo serve de apoio para esclarecer o erro quando necessario.
			// System.out.println(e);
			return null;
		}
		
		
	}
}
