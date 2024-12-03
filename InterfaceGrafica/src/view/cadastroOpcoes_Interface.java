package view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.border.EmptyBorder;

public class cadastroOpcoes_Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroOpcoes_Interface frame = new cadastroOpcoes_Interface();
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
	public cadastroOpcoes_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		iconePrincipal.setBounds(37, 19, 102, 100);
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Opções de cadastro");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(151, 46, 626, 49);
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(759, 516, 136, 37);
		contentPane.add(rodape);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcoes_Interface opcoes_Interface = new opcoes_Interface();
				opcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		voltar.setForeground(new Color(255, 255, 255));
		voltar.setBackground(new Color(51, 102, 153));
		voltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		voltar.setBounds(44, 498, 104, 37);
		contentPane.add(voltar);
		
		JButton cliente = new JButton("Cadastrar cliente");
		cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroCliente_Interface CadastroCliente_Interface = new cadastroCliente_Interface();
				CadastroCliente_Interface.setVisible(true);
				dispose();
			}
		});
		cliente.setForeground(Color.WHITE);
		cliente.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cliente.setBackground(new Color(51, 102, 153));
		cliente.setBounds(77, 343, 232, 37);
		contentPane.add(cliente);
		
		JButton viagem = new JButton("Cadastrar viagem");
		viagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroViagem cadastroViagem = new cadastroViagem();
				cadastroViagem.setVisible(true);
				dispose();
			}
		});
		viagem.setForeground(Color.WHITE);
		viagem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		viagem.setBackground(new Color(51, 102, 153));
		viagem.setBounds(343, 343, 232, 37);
		contentPane.add(viagem);
		
		JButton hospedagem = new JButton("Cadastrar hospedagem");
		hospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroHospedagem CadastroHosp = new cadastroHospedagem();
				CadastroHosp.setVisible(true);
				dispose();
			}
		});
		hospedagem.setForeground(Color.WHITE);
		hospedagem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		hospedagem.setBackground(new Color(51, 102, 153));
		hospedagem.setBounds(610, 343, 232, 37);
		contentPane.add(hospedagem);
		
		JLabel iconeCadastrar = new JLabel("");
		iconeCadastrar.setBackground(new Color(240, 240, 240));
		iconeCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 17(5).png")));
		iconeCadastrar.setBounds(129, 183, 136, 130);
		contentPane.add(iconeCadastrar);
		
		JLabel iconeCadastrar_1 = new JLabel("");
		iconeCadastrar_1.setBackground(new Color(240, 240, 240));
		iconeCadastrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 4.png")));
		iconeCadastrar_1.setBounds(393, 183, 136, 130);
		contentPane.add(iconeCadastrar_1);
		
		JLabel iconeCadastrar_1_1 = new JLabel("");
		iconeCadastrar_1_1.setBackground(new Color(240, 240, 240));
		iconeCadastrar_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrar_1_1.setIcon(new ImageIcon(login_Interface.class.getResource("/view/Group 17(3).png")));
		iconeCadastrar_1_1.setBounds(658, 183, 136, 130);
		contentPane.add(iconeCadastrar_1_1);

	}
}
