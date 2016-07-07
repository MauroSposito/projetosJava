package telas;

import java.awt.Dimension;

//import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCadastroProdutos extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdutos frame = new TelaCadastroProdutos();
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

	public TelaCadastroProdutos() {
		setTitle("Cadastro de Produtos");
		setMaximumSize(new Dimension(795, 526));
		setPreferredSize(new Dimension(795, 526));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(0,0, 795, 526);
		getContentPane().setLayout(null);

	}

}
