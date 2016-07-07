package telas;

import javax.swing.ImageIcon;

//import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.Dimension;

import java.sql.*;
import dal.ModuloConexao;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuarios extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIdUser;
	private JLabel lblCampo;
	private JTextField txfIdUser;
	private JLabel lblUsuario;
	private JTextField txfUsuario;
	private JLabel lblLogin;
	private JTextField txfLogin;
	private JLabel lblFone;
	private JTextField txfFone;
	private JLabel lblNivel;
	private JComboBox<Integer> cbbNivel;
	private JLabel lblSenha;
	private JTextField txfSenha;
	private JButton btnCreate;
	private JButton btnRead;
	private JButton btnUpdate;
	private JButton btnDelete;

	Connection conexao = null;// conecta o banco de dados
	PreparedStatement pst = null;// framework sql. prepara a conexao com banco
									// de dados
	ResultSet rs = null;// para exibir o resultado das instrucoes sql dentro do
						// java

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TelaCadastroUsuarios frame = new
	 * TelaCadastroUsuarios(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 * 
	 * /** Create the frame.
	 */

	public TelaCadastroUsuarios() {
		/*
		 * cria o Frame Interno.
		 */
		setTitle("Cadastro de Usu�rios");
		setMaximumSize(new Dimension(795, 526));
		setPreferredSize(new Dimension(795, 526));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(0, 0, 795, 526);
		getContentPane().setLayout(null);

		/*
		 * Cria os campos
		 */
		lblIdUser = new JLabel("*C�digo..:");
		lblIdUser.setBounds(90, 70, 65, 14);
		getContentPane().add(lblIdUser);

		txfIdUser = new JTextField();
		txfIdUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = (e.getKeyCode());
				if (key == 10) {
					consultar();
				}
			}
		});
		txfIdUser.setBounds(156, 68, 65, 20);
		getContentPane().add(txfIdUser);

		lblCampo = new JLabel("*Campos Obrigat�rios");
		lblCampo.setBounds(545, 70, 130, 14);
		getContentPane().add(lblCampo);

		lblUsuario = new JLabel("*Usu�rio:");
		lblUsuario.setBounds(90, 130, 65, 14);
		getContentPane().add(lblUsuario);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(156, 128, 520, 20);
		getContentPane().add(txfUsuario);

		lblLogin = new JLabel("*Login...:");
		lblLogin.setBounds(90, 190, 65, 14);
		getContentPane().add(lblLogin);

		txfLogin = new JTextField();
		txfLogin.setBounds(156, 188, 200, 20);
		getContentPane().add(txfLogin);

		lblFone = new JLabel("Telefone..:");
		lblFone.setBounds(390, 190, 200, 20);
		getContentPane().add(lblFone);

		txfFone = new JTextField();
		txfFone.setBounds(465, 188, 210, 20);
		getContentPane().add(txfFone);

		lblSenha = new JLabel("*Senha...:");
		lblSenha.setBounds(90, 250, 65, 14);
		getContentPane().add(lblSenha);

		txfSenha = new JTextField();
		txfSenha.setBounds(156, 248, 200, 20);
		getContentPane().add(txfSenha);

		lblNivel = new JLabel("*N�vel........:");
		lblNivel.setBounds(390, 250, 65, 14);
		getContentPane().add(lblNivel);

		cbbNivel = new JComboBox<Integer>();
		cbbNivel.setBounds(465, 248, 40, 20);
		cbbNivel.addItem(0);
		cbbNivel.addItem(1);
		getContentPane().add(cbbNivel);

		btnCreate = new JButton();
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});

		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setToolTipText("Adicionar");
		btnCreate.setPreferredSize(new Dimension(80, 80));
		btnCreate.setBounds(130, 350, 80, 80);
		btnCreate.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/icones/create.png")));
		getContentPane().add(btnCreate);

		btnRead = new JButton();
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();

			}
		});

		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setToolTipText("Procurar");
		btnRead.setPreferredSize(new Dimension(80, 80));
		btnRead.setBounds(280, 350, 80, 80);
		btnRead.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/icones/read.png")));
		getContentPane().add(btnRead);

		btnUpdate = new JButton();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();

			}
		});

		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Alterar");
		btnUpdate.setPreferredSize(new Dimension(80, 80));
		btnUpdate.setBounds(430, 350, 80, 80);
		btnUpdate.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/icones/update.png")));
		getContentPane().add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
				remover();

			}
		});
		
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Apagar");
		btnDelete.setPreferredSize(new Dimension(80, 80));
		btnDelete.setBounds(580, 350, 80, 80);
		btnDelete.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/icones/delete.png")));
		getContentPane().add(btnDelete);

	}

	/*
	 * metodo para consultar usuarios.
	 */
	private void consultar() {
		// estabelece a conexao com banco de dados
		conexao = ModuloConexao.conector();

		if (txfIdUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira C�digo");
		} else {
			String sql = "select * from tbusuarios where id_user =?";
			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, txfIdUser.getText());
				rs = pst.executeQuery();

				if (rs.next()) {
					txfUsuario.setText(rs.getString("usuario"));
					txfLogin.setText(rs.getString("login"));
					txfSenha.setText(rs.getString("senha"));
					txfFone.setText(rs.getString("fone"));
					cbbNivel.setSelectedItem(rs.getInt("nivel"));
					conexao.close();
				} else {
					txfUsuario.setText(null);
					txfLogin.setText(null);
					txfSenha.setText(null);
					txfFone.setText(null);
					cbbNivel.setEditable(true);
					conexao.close();
					JOptionPane.showMessageDialog(null, "Usu�rio n�o Cadastrado");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/*
	 * metodo para adicionar usuarios.
	 */
	private void adicionar() {
		// estabelece a conexao com banco de dados
		conexao = ModuloConexao.conector();

		if (txfIdUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira C�digo");
		} else {
			// verifica se o cliente ja � cadastrado
			String sql = "select * from tbusuarios where id_user =?";
			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, txfIdUser.getText());
				rs = pst.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Usu�rio Cadastrado");
					consultar();

				} else {
					// senao for cadastrado faz o cadastro
					sql = "insert into tbusuarios (id_user,usuario,login,senha,fone,nivel,cadastro_por) values (?,?,?,?,?,?,?)";
					try {
						pst = conexao.prepareStatement(sql);
						pst.setString(1, txfIdUser.getText());
						pst.setString(2, txfUsuario.getText());
						pst.setString(3, txfLogin.getText());
						pst.setString(4, txfSenha.getText());
						pst.setString(5, txfFone.getText());
						int caixa = (int) cbbNivel.getSelectedItem();
						pst.setInt(6, caixa);
						pst.setString(7, Perfil.getLogUsuario());

						// estrutura abaixo verifica se os campos obrigatorios
						// nao estao vazios
						if (txfUsuario.getText().isEmpty() || txfLogin.getText().isEmpty()
								|| txfSenha.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigat�rios!");
						} else {

							// a estrutura abaixo � usada para confirmar a
							// inser��o dos dados na tabeala.
							int adicionado = pst.executeUpdate();// adiciona o usuario na tabela sql atribui um valor a variavel
							
							if (adicionado > 0) {
								JOptionPane.showMessageDialog(null, "Usu�rio adicionado com sucesso!");
								txfIdUser.setText(null);
								txfUsuario.setText(null);
								txfLogin.setText(null);
								txfSenha.setText(null);
								txfFone.setText(null);
								conexao.close();

							}
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

		}

	}

	private void alterar() {
		// estabelece a conexao com banco de dados
		conexao = ModuloConexao.conector();
		if (txfIdUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira C�digo");
		} else {

			String sql = "update tbusuarios set  usuario=?, login=?, senha=?, fone=?, nivel=?, cadastro_por=? where id_user =?";
			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, txfUsuario.getText());
				pst.setString(2, txfLogin.getText());
				pst.setString(3, txfSenha.getText());
				pst.setString(4, txfFone.getText());
				pst.setInt(5, (int) cbbNivel.getSelectedItem());
				pst.setString(6, Perfil.getLogUsuario());
				pst.setString(7, txfIdUser.getText());
				// estrutura abaixo verifica se os campos obrigatorios nao estao
				// vazios
				if (txfUsuario.getText().isEmpty() || txfLogin.getText().isEmpty() || txfSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigat�rios!");
				} else {

					int confirma = JOptionPane.showConfirmDialog(null, "Deseja Alterar?", "Aten��o",
							JOptionPane.YES_NO_OPTION);
					if (confirma == JOptionPane.YES_OPTION) {
						// a estrutura abaixo � usada para confirmar a inser��o
						// dos dados na tabeala.
						int alterado = pst.executeUpdate();// adiciona o usuario na tabela sql atribui um valor a variavel
						
						if (alterado > 0) {
							JOptionPane.showMessageDialog(null, "Usu�rio alterado com sucesso!");
							txfIdUser.setText(null);
							txfUsuario.setText(null);
							txfLogin.setText(null);
							txfSenha.setText(null);
							txfFone.setText(null);
							conexao.close();
						} else {
							txfIdUser.setText(null);
							txfUsuario.setText(null);
							txfLogin.setText(null);
							txfSenha.setText(null);
							txfFone.setText(null);
							conexao.close();
						}

					} else {
						txfIdUser.setText(null);
						txfUsuario.setText(null);
						txfLogin.setText(null);
						txfSenha.setText(null);
						txfFone.setText(null);
						conexao.close();
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void remover(){
		if (txfIdUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira C�digo");
		} else {
			int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usu�rio?", "Aten��o", JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				conexao = ModuloConexao.conector();
				String sql = "delete from tbusuarios where id_user=?";
				try {
					pst = conexao.prepareStatement(sql);
					pst.setString(1, txfIdUser.getText());
					int removido = pst.executeUpdate();// adiciona o usuario na tabela sql atribui um valor a variavel
					
					if (removido > 0) {
						JOptionPane.showMessageDialog(null, "Usu�rio removido com sucesso!");
						txfIdUser.setText(null);
						txfUsuario.setText(null);
						txfLogin.setText(null);
						txfSenha.setText(null);
						txfFone.setText(null);
						conexao.close();
					} else {
						txfIdUser.setText(null);
						txfUsuario.setText(null);
						txfLogin.setText(null);
						txfSenha.setText(null);
						txfFone.setText(null);
						conexao.close();
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	}
}
