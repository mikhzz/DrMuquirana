package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane = new JDesktopPane();
	private CadastroUsuario cadastroUsuario = null;

	
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

	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 122, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuário");
		mnNewMenu.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/10303-man-office-worker-light-skin-tone-icon.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewCadastroUsuario = new JMenuItem("Cadastro");
		mntmNewCadastroUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroUsuario = new CadastroUsuario();
				desktopPane.add(cadastroUsuario);
				cadastroUsuario.show();
			}
		});
		mntmNewCadastroUsuario.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/contact-icon (1).png")));
		mnNewMenu.add(mntmNewCadastroUsuario);
		
		JMenuItem mntmExcluso = new JMenuItem("Exclusão");
		mntmExcluso.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/social-sharing-icon (1).png")));
		mnNewMenu.add(mntmExcluso);
		
		JMenuItem mntmAtualizao = new JMenuItem("Atualização");
		mntmAtualizao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/arrows-icon (1).png")));
		mnNewMenu.add(mntmAtualizao);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icons/usuario/brainstorming-icon.png")));
		mnNewMenu.add(mntmConsulta);
		
		
		desktopPane.setBounds(0, 52, 434, 209);
		contentPane.add(desktopPane);
		
		JMenuBar menu_bar_desp = new JMenuBar();
		menu_bar_desp.setBounds(161, 0, 97, 21);
		contentPane.add(menu_bar_desp);
		
		JMenu mnDespesas = new JMenu("Despesas");
		mnDespesas.setBounds(151, -1, 107, 22);
		contentPane.add(mnDespesas);
		
		JMenuItem mntmCadastrarDesp = new JMenuItem("Cadastro");
		mnDespesas.add(mntmCadastrarDesp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exclusão");
		mnDespesas.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Atualização");
		mnDespesas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mnDespesas.add(mntmConsulta_1);
		
	}
}
