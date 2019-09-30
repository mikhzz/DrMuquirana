package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane = new JDesktopPane();
	private CadastroUsuario cadastroUsuario = null;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTable table;
	private ControladoraUsuario controller = new ControladoraUsuario();
    private ArrayList<UsuarioVO> usuarios = controller.consultarTodosUsuariosController();
    private JComboBox cbUsuarios = new JComboBox();
    private UsuarioVO usuarioVO = null;
	
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

	
	@SuppressWarnings("unchecked")
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		desktopPane.setBounds(0, 44, 552, 400);
		contentPane.add(desktopPane);
		
		JInternalFrame CadastroUsuario = new JInternalFrame("Cadastro de Usuário");
		CadastroUsuario.setBounds(10, 11, 272, 378);
		desktopPane.add(CadastroUsuario);
		CadastroUsuario.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 28, 46, 14);
		CadastroUsuario.getContentPane().add(lblNome);
		
		
		txtNome = new JTextField();
		txtNome.setBounds(57, 25, 178, 20);
		CadastroUsuario.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		String nome = lblNome.getText();
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(10, 69, 46, 14);
		CadastroUsuario.getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(57, 66, 178, 20);
		CadastroUsuario.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		MaskFormatter mascaraCpf;
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
		}
		
		
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 131, 59, 14);
		CadastroUsuario.getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(79, 128, 156, 20);
		CadastroUsuario.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 186, 46, 14);
		CadastroUsuario.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(79, 183, 156, 20);
		CadastroUsuario.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		String login = txtLogin.getText();
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 234, 46, 14);
		CadastroUsuario.getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(79, 231, 156, 20);
		CadastroUsuario.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ControladoraUsuario cliController = new ControladoraUsuario();
				
				String nomeDigitado = txtNome.getText();
				
				String cpfDigitado = txtCpf.getText().replace("-", "").replace(".", "");
				String telefoneDigitado = txtTelefone.getText();
				String loginDigitado = txtLogin.getText();
				String senhaDigitada = txtSenha.getText();
				 
				usuarioVO = new UsuarioVO(0, nomeDigitado, cpfDigitado, telefoneDigitado, loginDigitado, senhaDigitada);
				
				cliController.cadastrarUsuarioController(usuarioVO);
			}
		});
		btnSalvar.setBounds(79, 291, 124, 23);
		CadastroUsuario.getContentPane().add(btnSalvar);
		ControladoraUsuario salvar = new ControladoraUsuario();
		
		
		JInternalFrame internalFrame = new JInternalFrame("Consulta de Usuários");
		internalFrame.setBounds(292, 11, 250, 378);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(226, 333, -213, -204);
		internalFrame.getContentPane().add(table);
		
		
		
		
		internalFrame.getContentPane().add(cbUsuarios);
		
		JLabel lblUsuariosCadastrados = new JLabel("Usuários Cadastrados");
		lblUsuariosCadastrados.setBounds(10, 11, 128, 23);
		internalFrame.getContentPane().add(lblUsuariosCadastrados);
		
		
		cbUsuarios.setBounds(20, 45, 95, 20);
		internalFrame.getContentPane().add(cbUsuarios);
		internalFrame.setVisible(true);
		CadastroUsuario.setVisible(true);
		cbUsuarios = new JComboBox(usuarios.toArray());
		
		JMenu mnDespesas = new JMenu("Despesas");
		mnDespesas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/receita/dollar-stats-icon.png")));
		mnDespesas.setBounds(198, 0, 126, 34);
		contentPane.add(mnDespesas);
		
		JMenuItem mntmCadastrarDesp = new JMenuItem("Cadastro");
		mntmCadastrarDesp.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/receita/flow-market-icon.png")));
		mnDespesas.add(mntmCadastrarDesp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exclusão");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/receita/recycle-bin-icon.png")));
		mnDespesas.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Atualização");
		mntmNewMenuItem_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/receita/dollar-icon.png")));
		mnDespesas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mntmConsulta_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/receita/find-icon.png")));
		mnDespesas.add(mntmConsulta_1);
		
		JMenu mnReceitas = new JMenu("Receitas");
		mnReceitas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/stat-icon.png")));
		mnReceitas.setBounds(391, 0, 107, 34);
		contentPane.add(mnReceitas);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/mobile-statistics-icon.png")));
		mntmCadastro.setSelectedIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/calculation-icon.png")));
		mnReceitas.add(mntmCadastro);
		
		JMenuItem mntmExcluso_1 = new JMenuItem("Exclusão");
		mntmExcluso_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/calendar-icon.png")));
		mnReceitas.add(mntmExcluso_1);
		
		JMenuItem mntmAtualizao_1 = new JMenuItem("Atualização");
		mntmAtualizao_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/calculator-icon.png")));
		mnReceitas.add(mntmAtualizao_1);
		
		JMenuItem mntmConsulta_2 = new JMenuItem("Consulta");
		mntmConsulta_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/despesa/calculation-icon.png")));
		mnReceitas.add(mntmConsulta_2);
		
		JMenu mnUsurio = new JMenu("Usuário");
		mnUsurio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/10303-man-office-worker-light-skin-tone-icon.png")));
		mnUsurio.setBounds(10, 0, 107, 33);
		contentPane.add(mnUsurio);
		
		final JMenuItem mntmCadastroUsuario = new JMenuItem("Cadastro");
		mntmCadastroUsuario.setEnabled(false);
		mntmCadastroUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			//  mntmCadastro_1.setVisible(true); 
				  mntmCadastroUsuario.setVisible(true);
				  mntmCadastroUsuario.enable();  
			  
				
			}
		});
		mntmCadastroUsuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/social-sharing-icon (1).png")));
		mnUsurio.add(mntmCadastroUsuario);
		
		JMenuItem mntmExcluso = new JMenuItem("Exclusão");
		mntmExcluso.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/brainstorming-icon.png")));
		mnUsurio.add(mntmExcluso);
		
		JMenuItem mntmAtualizao = new JMenuItem("Atualização");
		mntmAtualizao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/arrows-icon (1).png")));
		mnUsurio.add(mntmAtualizao);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/contact-icon (1).png")));
		mnUsurio.add(mntmConsulta);
		
	}
}
