package telas;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import br.com.MauroJava.ValidacaoUtil.ValidacaoUtil;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import para conectar bando de dados
import java.sql.*;
import dal.ModuloConexao;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class TelaLogin extends JFrame {
	/*
	 * Variaveis para manipular banco de dados
	 */
	Connection conexao =  null;//conectando banco de dados
	//cria duas variaveis especiais de apoio a conexao.
	PreparedStatement pst = null;//framework sql.
	ResultSet rs = null;//para exibir o resultado das instrucoes sql dentro do java
	
	/*
	 * Variaveis (objetos)
	 */
	private static final long serialVersionUID = 1L;// para tirar o alerta foi criado automatico
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblStatus;
	private JTextField txfUsuario;
	private JPasswordField pwfSenha;
	private JButton btnSair;
	private JButton btnLogin;

	/**
	 * Executa a aplica��o.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame.
	 */
	public TelaLogin() {
		//frame
		setResizable(false);
		setTitle("Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		//centraliza o JFrame.
		setLocationRelativeTo(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txfUsuario, pwfSenha, btnSair, btnLogin}));
		
		//Painel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label
		lblUsuario = new JLabel("Usu�rio..:");
		lblUsuario.setBounds(90, 40, 58, 14);
		contentPane.add(lblUsuario);
		
		lblSenha = new JLabel("Senha....:");
		lblSenha.setBounds(90, 65, 58, 14);
		contentPane.add(lblSenha);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/dberror.png")));
		lblStatus.setBounds(364, 106, 70, 74);
		contentPane.add(lblStatus);
		
		//TextField
		txfUsuario = new JTextField();
		txfUsuario.setBounds(150, 37, 180, 20);
		contentPane.add(txfUsuario);
		txfUsuario.setColumns(10);
		
		//PasswordField
		pwfSenha = new JPasswordField();
		pwfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = (e.getKeyCode());
				if (key == 10){
					logar();
				}
			}
		});
		pwfSenha.setBounds(150, 62, 180, 20);
		contentPane.add(pwfSenha);
		
		//Button
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 93, 89, 23);
		btnLogin = new JButton("Login");
		btnLogin.setBounds(241, 93, 89, 23);
		contentPane.add(btnSair);
		contentPane.add(btnLogin);
		
		//Button Actions
		/*
		 * Button Sair Action <ENTER>	
		 */	
		btnSair.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = (e.getKeyCode());
				if (key == 10){
					System.exit(0);
				}
			}
		});
		/*
		 * Button Sair Action <Click Mouse>
		 */
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		/*
		 * Button Login Action <ENTER>	
		 */			
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = (e.getKeyCode());
				if (key == 10){
					logar();
				}
			}
		});
		/*
		 * Button Login Action <Click Mouse>	
		 */	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// "chama" o metodo logar.
				logar();
			}
		});
		/*
		 * Ordem do <TAB> no frame
		 */
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txfUsuario, pwfSenha, btnSair, btnLogin}));
		
		/*
		 * Conecta bando de dados e exibe Icone conectado ou nao conectado na label Status
		 */
		conexao = ModuloConexao.conector();
		if (conexao != null){
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbok.png")));
		}else{
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dberror.png")));
		}
	}

	/**
	 * Cria metodo para logar.
	 */
	@SuppressWarnings("deprecation")// para tirar o alerta foi criado automatico
	public void logar(){
		String sql = "select * from tbusuarios where login=? and senha=?";
		try {
			/* as linhas abaixo preparam a consulta ao bando de dados em funcao
			 * do que foi digitado na caixa de texto, o ? � susbstituito pelo 
			 * conteudo das variaveis.
			 */
			pst = conexao.prepareStatement(sql);
			pst.setString(1,  txfUsuario.getText());
			pst.setString(2,  pwfSenha.getText());

			//a linha abaixo executa a query
			rs = pst.executeQuery();

			// se existir usuarioe senha correspondente
			if (rs.next()){

				Perfil.setIdUser(rs.getInt("id_user"));
				Perfil.setLogUsuario(rs.getString("usuario"));
				Perfil.setLogSenha(rs.getString("senha"));
				Perfil.setLogLogin(rs.getString("login"));
				Perfil.setLogNivel(rs.getInt("nivel"));
				Perfil.setLogEntrada(ValidacaoUtil.agora());

				if (Perfil.getLogNivel() == 0 ){
					// instaciar tela principal.
					TelaPrincipal principal = new TelaPrincipal();
					//abre a tela principal.
					principal.setVisible(true);
					//Habilita opcoes no menu 
					TelaPrincipal.mntmUsurios.setEnabled(true);
					TelaPrincipal.mnVendas.setEnabled(true);
					// muda a cor da letra
					TelaPrincipal.lblPerfilUsuario.setForeground(Color.red);
					//fecha a janela de login
					this.dispose();

				}else{// instaciar tela principal.
					TelaPrincipal principal = new TelaPrincipal();
					//abre a tela principal.
					principal.setVisible(true);
					//fecha a janela de login
					this.dispose();

				}
				//fecha o banco de dados
				conexao.close();

			}else{
				//exibe uma mensagem na tela se nao achar usuario.
				pwfSenha.setText("");
				JOptionPane.showMessageDialog(null,"Usu�rio e/ou senha inv�lido(s)");
			}


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);

		}

	}
		
}
