package telas;

//import java.awt.EventQueue;//necessario para rodar a janela independente.
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import br.com.MauroJava.ValidacaoUtil.ValidacaoUtil;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.Timer;

import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;

import java.awt.SystemColor;


@SuppressWarnings("restriction")// para tirar o alerta foi criado automatico
public class TelaPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;// para tirar o alerta foi criado automatico
	private Timer timer; 
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastro;
	public static JMenuItem mntmUsurios;
	private JMenuItem mntmFornecedores;
	private JMenuItem mntmProdutos;
	public static JMenu mnVendas;
	private JMenu mnReltorios;
	private JMenu mnSair;
	private JSeparator separator;
	private JMenu mnAjuda;
	private JMenuItem mntmSobre;
	private JLabel lblBarraStatus;
	public static JLabel lblPerfilUsuario;
	private JLabel lblData;
	private JLabel lblLogadoData;
	private JLabel lblHorario;
	private JLabel lblRelogio;
	private JDesktopPane desktop;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */

	public TelaPrincipal() {
		setResizable(false);
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		//centraliza o JFrame.
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("Cadastro");
		int vkC = KeyEvent.VK_C;
		mnCadastro.setMnemonic(vkC);
		menuBar.add(mnCadastro);
		
		mntmUsurios = new JMenuItem("Usuários");
		mntmUsurios.setEnabled(false);
		
		mntmUsurios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
				telaCadastroUsuarios.setVisible(true);
				desktop.add(telaCadastroUsuarios);
			}
		});
		mnCadastro.add(mntmUsurios);
		
		mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroFornecedores telaCadastroFornecedores = new TelaCadastroFornecedores();
				telaCadastroFornecedores.setVisible(true);
				desktop.add(telaCadastroFornecedores);
			}
		});
		mnCadastro.add(mntmFornecedores);
		
		mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos();
				telaCadastroProdutos.setVisible(true);
				desktop.add(telaCadastroProdutos);
			}
		});
		mnCadastro.add(mntmProdutos);
		
		mnVendas = new JMenu("Vendas");
		mnVendas.setEnabled(false);
		int vkV = KeyEvent.VK_V;
		mnVendas.setMnemonic(vkV);
		menuBar.add(mnVendas);
		
		mnReltorios = new JMenu("Relátorios");
		int vkR = KeyEvent.VK_R;
		mnReltorios.setMnemonic(vkR);
		menuBar.add(mnReltorios);
		
		mnAjuda = new JMenu("Ajuda");
		int vkA = KeyEvent.VK_A;
		mnAjuda.setMnemonic(vkA);
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { 
				TelaSobre telaSobre = new TelaSobre();
				telaSobre.setVisible(true);
				
			}
		});
				 
		
		mnAjuda.add(mntmSobre);
		
		mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair","Atenção",JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		menuBar.add(mnSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(0, 545, 800, 1);
		contentPane.add(separator);
		
		separator = new JSeparator();
		separator.setBounds(0, 530, 800, 1);
		contentPane.add(separator);
		
		lblBarraStatus = new JLabel("Usuário:");
		lblBarraStatus.setBounds(26, 530, 80, 14);
		contentPane.add(lblBarraStatus);
		
		
		String perfilUsuario = Perfil.getLogUsuario();
		lblPerfilUsuario = new JLabel(perfilUsuario);
		lblPerfilUsuario.setBounds(80, 530, 200, 14);
		contentPane.add(lblPerfilUsuario);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(480,530,70,14);
		contentPane.add(lblData);
		
		String LogadoData = ValidacaoUtil.hoje();
		lblLogadoData = new JLabel(LogadoData);
		lblLogadoData.setBounds(520,530,70,14);
		contentPane.add(lblLogadoData);
		
		lblHorario = new JLabel("Horário:");
		lblHorario.setBounds(646, 530, 46, 14);
		contentPane.add(lblHorario);
		
		lblRelogio = new JLabel();		
		contentPane.add(lblRelogio);
		disparaRelogio();
		
		desktop = new JDesktopPane();
		desktop.setBackground(SystemColor.inactiveCaption);
		desktop.setBounds(0, 0, 800, 526);
		contentPane.add(desktop);
	
	}	
	
/*
 * Metodos para o relogio funcionar
 */
	public void disparaRelogio(){
		if (timer == null) {   
			timer = new Timer(1000,this);   
			timer.setInitialDelay(0);   
			timer.start();   
		} else if (!timer.isRunning()) {   
			timer.restart();   
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Date hora = new Date(); 
		SimpleDateFormat hora_formato = new SimpleDateFormat("HH:mm:ss"); 
		lblRelogio.setBounds(700, 530, 70, 14);
		lblRelogio.setText(hora_formato.format(hora));
	}

	
	
}
