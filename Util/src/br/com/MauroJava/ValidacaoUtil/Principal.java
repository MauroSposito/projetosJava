package br.com.MauroJava.ValidacaoUtil;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String cpf = JOptionPane.showInputDialog("Digite um CPF (Apenas numeros)");
				if (ValidacaoUtil.validaCpf(cpf) == true){
					JOptionPane.showMessageDialog(null,"CPF Válido");
				}else{
					JOptionPane.showMessageDialog(null,"CPF Inválido");
				}
	}		
}
