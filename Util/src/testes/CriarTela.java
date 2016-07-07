package testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.paint.Color;




public class CriarTela extends JFrame {

	private JPanel contentPane;

	// executa a tela
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CriarTela frame = new CriarTela();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	// cria o frame
	public CriarTela() {
		//frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 250);
		setTitle("Tela de Login");
		//nao permite redimensionar
		setResizable(false);
		//troca icone do java na janela
		ImageIcon icone = new ImageIcon("C:\\Users\\mauro\\Pictures\\cruzmalta2.png");
		setIconImage(icone.getImage());
		//centraliza a janela
		setLocationRelativeTo(null);
		
				
		//componentes
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuário.:");
		lblUsuario.setBounds(130, 50, 100, 20);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha...:");
		lblSenha.setBounds(130, 90, 100, 20);
		contentPane.add(lblSenha);
		
		JTextField txfUsuario = new JTextField();
				txfUsuario.setBounds(190, 50, 100, 20);
		contentPane.add(txfUsuario);
		
		JPasswordField pwfSenha = new JPasswordField();
		pwfSenha.setBounds(190,90, 100, 20);
		contentPane.add(pwfSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(130, 130, 70, 20);
		contentPane.add(btnLogin);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(218, 130, 70, 20);
		contentPane.add(btnSair);
		
		//Eventos
		//<ENTER>
		btnLogin.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int key = (e.getKeyCode());
				if (key == 10){
					dispose();
				}
			}
		});
		//<MOUSE>
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//<ENTER>
		txfUsuario.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int key = (e.getKeyCode());
				if (key == 10){
					pwfSenha.requestFocus();
				}
			}
		});
		//<ENTER>
		btnSair.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int key = (e.getKeyCode());
				if (key == 10){
					dispose();
				}
			}
		});
		//<MOUSE>
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
			
	}
	

}
