package telas;

import java.awt.Dimension;

//import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCadastroFornecedores extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */

	public TelaCadastroFornecedores() {
		setTitle("Cadastro de Fornecedores");
		setMaximumSize(new Dimension(795, 526));
		setPreferredSize(new Dimension(795, 526));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(0, 0, 795, 526);
		getContentPane().setLayout(null);

	}

}
