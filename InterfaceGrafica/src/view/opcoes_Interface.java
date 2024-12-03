package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class opcoes_Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcoes_Interface frame = new opcoes_Interface();
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
	public opcoes_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		iconePrincipal.setBounds(37, 19, 102, 100);
		contentPane.add(iconePrincipal);
		
		
		JLabel tituloPagina = new JLabel("Opções do sistema");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(51, 102, 153));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(255, 45, 623, 49);
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(51, 102, 153));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(950, 516, 136, 37);
		contentPane.add(rodape);
		
		JButton sair = new JButton("LogOut");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_Interface login_Interface = new login_Interface();
				login_Interface.setVisible(true);
		        dispose();
			}
		});
		sair.setForeground(new Color(255, 255, 255));
		sair.setBackground(new Color(51, 102, 153));
		sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		sair.setBounds(44, 498, 104, 37);
		contentPane.add(sair);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroOpcoes_Interface cadastroOpcoes_Interface = new cadastroOpcoes_Interface();
				cadastroOpcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		btnCadastro.setForeground(Color.WHITE);
		btnCadastro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnCadastro.setBackground(new Color(51, 102, 153));
		btnCadastro.setBounds(93, 360, 136, 37);
		contentPane.add(btnCadastro);
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarOpcoes_Interface editarOpcoes_Interface = new editarOpcoes_Interface();
				editarOpcoes_Interface.setVisible(true);
				dispose();
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEditar.setBackground(new Color(51, 102, 153));
		btnEditar.setBounds(290, 360, 136, 37);
		contentPane.add(btnEditar);
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirOpcoes_Interface excluirOpcoes_Interface = new excluirOpcoes_Interface();
				excluirOpcoes_Interface.setVisible(true);
				dispose();
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExcluir.setBackground(new Color(51, 102, 153));
		btnExcluir.setBounds(489, 360, 136, 37);
		contentPane.add(btnExcluir);
		
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirOpcoes_Interface exibirOpcoes_Interface = new exibirOpcoes_Interface();
				exibirOpcoes_Interface.setVisible(true);
				dispose();
			}
		});
		btnExibir.setForeground(Color.WHITE);
		btnExibir.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExibir.setBackground(new Color(51, 102, 153));
		btnExibir.setBounds(685, 360, 136, 37);
		contentPane.add(btnExibir);
		
		JButton relatorio = new JButton("Relatório");
		relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorio relatorio = new relatorio();
				relatorio.setVisible(true);
				dispose();
			}
		});
		relatorio.setForeground(Color.WHITE);
		relatorio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		relatorio.setBackground(new Color(51, 102, 153));
		relatorio.setBounds(881, 360, 136, 37);
		contentPane.add(relatorio);
		
		JLabel iconeCadastrar = new JLabel("");
		iconeCadastrar.setBackground(new Color(240, 240, 240));
		iconeCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 4.png")));
		iconeCadastrar.setBounds(93, 187, 136, 130);
		contentPane.add(iconeCadastrar);
		
		JLabel iconeEditar = new JLabel("");
		iconeEditar.setHorizontalAlignment(SwingConstants.CENTER);
		iconeEditar.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group.png")));
		iconeEditar.setBounds(290, 187, 136, 130);
		contentPane.add(iconeEditar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(login_Interface.class.getResource("/view/icon _trash 2_.png")));
		lblNewLabel.setBounds(489, 187, 136, 130);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Lupa.png")));
		lblNewLabel_1.setBounds(685, 187, 136, 130);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/relatorio.png")));
		lblNewLabel_1_1.setBounds(881, 187, 136, 130);
		contentPane.add(lblNewLabel_1_1);
	}
}
