package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class exibirOpcoes_Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					excluirOpcoes_Interface frame = new excluirOpcoes_Interface();
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
	public exibirOpcoes_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		iconePrincipal.setBounds(37, 19, 102, 100);
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Opções para exibição de dados");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(118, 46, 665, 49);
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(759, 516, 136, 37);
		contentPane.add(rodape);
		
		JButton btnVoltar= new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcoes_Interface opcoes_Interface = new opcoes_Interface();
				opcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		btnVoltar.setBackground(new Color(70, 130, 180));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.setBounds(37, 502, 111, 29);
		contentPane.add(btnVoltar);
		
		JButton btnExibirCliente = new JButton("Exibir Cliente");
		btnExibirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirCliente_Interface exibirCliente_Interface = new exibirCliente_Interface();
				exibirCliente_Interface.setVisible(true);
		        dispose();
			}
		});
		btnExibirCliente.setForeground(new Color(255, 255, 255));
		btnExibirCliente.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExibirCliente.setBackground(new Color(70, 130, 180));
		btnExibirCliente.setBounds(85, 335, 220, 42);
		contentPane.add(btnExibirCliente);
		
		JButton btnExibirViagem = new JButton("Exibir Viagem");
		btnExibirViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirViagem exibirViagem = new exibirViagem();
				exibirViagem.setVisible(true);
				dispose();
			}
		});
		btnExibirViagem.setForeground(Color.WHITE);
		btnExibirViagem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExibirViagem.setBackground(new Color(70, 130, 180));
		btnExibirViagem.setBounds(344, 335, 220, 42);
		contentPane.add(btnExibirViagem);
		
		JButton btnExibirHospedagem = new JButton("Exibir Hospedagem");
		btnExibirHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirHospedagem exibirHospedagem = new exibirHospedagem();
				exibirHospedagem.setVisible(true);
		        dispose();
			}
		});
		btnExibirHospedagem.setForeground(Color.WHITE);
		btnExibirHospedagem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnExibirHospedagem.setBackground(new Color(70, 130, 180));
		btnExibirHospedagem.setBounds(597, 335, 220, 42);
		contentPane.add(btnExibirHospedagem);
		
		
		JLabel iconeCadastrar = new JLabel("");
		iconeCadastrar.setBackground(new Color(240, 240, 240));
		iconeCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 17(5).png")));
		iconeCadastrar.setBounds(125, 183, 136, 130);
		contentPane.add(iconeCadastrar);
		
		JLabel iconeCadastrar_1 = new JLabel("");
		iconeCadastrar_1.setBackground(new Color(240, 240, 240));
		iconeCadastrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 4.png")));
		iconeCadastrar_1.setBounds(383, 183, 136, 130);
		contentPane.add(iconeCadastrar_1);
		
		JLabel iconeCadastrar_1_1 = new JLabel("");
		iconeCadastrar_1_1.setBackground(new Color(240, 240, 240));
		iconeCadastrar_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar_1_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 17(3).png")));
		iconeCadastrar_1_1.setBounds(634, 183, 136, 130);
		contentPane.add(iconeCadastrar_1_1);

	}
}
