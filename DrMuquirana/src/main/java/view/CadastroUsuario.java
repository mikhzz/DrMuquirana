package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroUsuario extends JInternalFrame {
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setTitle("Cadastro de Usuário");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 35, 46, 14);
		getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(66, 32, 171, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 75, 46, 14);
		getContentPane().add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(66, 72, 86, 20);
		getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 121, 46, 14);
		getContentPane().add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(66, 118, 86, 20);
		getContentPane().add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 173, 46, 14);
		getContentPane().add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(66, 170, 86, 20);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 215, 46, 14);
		getContentPane().add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(66, 212, 86, 20);
		getContentPane().add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(279, 121, 89, 23);
		getContentPane().add(btnSalvar);

	}
}
