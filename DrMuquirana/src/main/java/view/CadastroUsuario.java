package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControladoraUsuario;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroUsuario extends JInternalFrame {
	private JTextField textNome;
	private JTextField texCpf;
	private JTextField textTelefone;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private ControladoraUsuario controller = new ControladoraUsuario();

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
		
		textNome = new JTextField();
		textNome.setBounds(66, 32, 171, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 75, 46, 14);
		getContentPane().add(lblCpf);
		
		texCpf = new JTextField();
		texCpf.setBounds(66, 72, 86, 20);
		getContentPane().add(texCpf);
		texCpf.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 121, 46, 14);
		getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(66, 118, 86, 20);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 173, 46, 14);
		getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(66, 170, 86, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 215, 46, 14);
		getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(66, 212, 86, 20);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String nomeDigitado = textNome.getText();
			     String cpfDigitado = texCpf.getText();
			     String telefoneDigitado = textTelefone.getText();
			     String loginDigitado = txtLogin.getText();
			     String senhaDigitada = txtSenha.getText();
				
				//String mensagem = 
						controller.cadastrarUsuarioController(nomeDigitado, cpfDigitado,telefoneDigitado,loginDigitado,senhaDigitada);
				
			}
		});
		    
		 
               
		     
		btnSalvar.setBounds(279, 121, 89, 23);
		getContentPane().add(btnSalvar);

	}
}
