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



public class cadastroCliente_Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField campoCPF;
	private JTextField campoRG;
	private JTextField campoNome;
	private JTextField campoEmail;
	private JTextField campoNascimento;
	private JTextField campoTelefone1;
	private JTextField campoTelefone2;
	private JTextField campoLog;
	private JTextField campoNro;
	private JTextField campoCidade;
	private JTextField campoBairro;
	private JTextField campoPais;
	private JTextField campoEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroCliente_Interface frame = new cadastroCliente_Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public cadastroCliente_Interface() {
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
		
		JLabel tituloPagina = new JLabel("Cadastro");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(135, 46, 626, 49);
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(759, 516, 136, 37);
		contentPane.add(rodape);
		
		JLabel subtitulo = new JLabel("do Cliente");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setForeground(new Color(128, 128, 128));
		subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		subtitulo.setBounds(374, 95, 148, 24);
		contentPane.add(subtitulo);
		
		
		JLabel CPF = new JLabel("CPF:");
		CPF.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		CPF.setBounds(70, 145, 45, 20);
		contentPane.add(CPF);
		
		campoCPF = new JTextField("");
		campoCPF.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoCPF.setBounds(70, 171, 180, 29);
		contentPane.add(campoCPF);
		campoCPF.setColumns(10);
		
		
		JLabel RG = new JLabel("RG:");
		RG.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		RG.setBounds(271, 145, 45, 20);
		contentPane.add(RG);
		
		campoRG = new JTextField("");
		campoRG.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoRG.setColumns(10);
		campoRG.setBounds(271, 170, 180, 29);
		contentPane.add(campoRG);
		
		
		JLabel Nome = new JLabel("Nome:");
		Nome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Nome.setBounds(70, 210, 57, 20);
		contentPane.add(Nome);
		
		campoNome = new JTextField("");
		campoNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoNome.setColumns(10);
		campoNome.setBounds(70, 233, 381, 29);
		contentPane.add(campoNome);
		
		
		JLabel Email = new JLabel("Email:");
		Email.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Email.setBounds(70, 272, 78, 20);
		contentPane.add(Email);
		
		campoEmail = new JTextField("");
		campoEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoEmail.setColumns(10);
		campoEmail.setBounds(70, 294, 381, 29);
		contentPane.add(campoEmail);
		
		
		JLabel DataDeNascimento = new JLabel("Data de nascimento:");
		DataDeNascimento.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		DataDeNascimento.setBounds(70, 340, 180, 20);
		contentPane.add(DataDeNascimento);
		
		campoNascimento = new JTextField("");
		campoNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoNascimento.setColumns(10);
		campoNascimento.setBounds(70, 362, 208, 29);
		contentPane.add(campoNascimento);
		
		SimpleDateFormat dataNascimento = new SimpleDateFormat(campoNascimento.getText());
		
		
		JLabel Telefone = new JLabel("Telefone 1:");
		Telefone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Telefone.setBounds(70, 408, 180, 20);
		contentPane.add(Telefone);
		
		campoTelefone1 = new JTextField("");
		campoTelefone1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoTelefone1.setColumns(10);
		campoTelefone1.setBounds(70, 427, 180, 29);
		contentPane.add(campoTelefone1);
		
		
		JLabel Telefone_2 = new JLabel("Telefone 2:");
		Telefone_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Telefone_2.setBounds(271, 408, 180, 20);
		contentPane.add(Telefone_2);
		
		campoTelefone2 = new JTextField("");
		campoTelefone2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoTelefone2.setColumns(10);
		campoTelefone2.setBounds(271, 427, 180, 29);
		contentPane.add(campoTelefone2);
		
		
		
		JLabel lblEndereoCompleto = new JLabel("Endereço completo");
		lblEndereoCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereoCompleto.setForeground(new Color(255, 255, 255));
		lblEndereoCompleto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEndereoCompleto.setBounds(603, 163, 183, 24);
		contentPane.add(lblEndereoCompleto);
		
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setForeground(new Color(255, 255, 255));
		lblLogradouro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblLogradouro.setBounds(557, 204, 136, 24);
		contentPane.add(lblLogradouro);
		
		campoLog = new JTextField("");
		campoLog.setForeground(new Color(128, 128, 128));
		campoLog.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoLog.setColumns(10);
		campoLog.setBounds(557, 227, 271, 29);
		contentPane.add(campoLog);
		
		
		JLabel lblNro = new JLabel("Número:");
		lblNro.setForeground(new Color(255, 255, 255));
		lblNro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNro.setBounds(557, 266, 70, 20);
		contentPane.add(lblNro);
		
		campoNro = new JTextField("");
		campoNro.setForeground(new Color(128, 128, 128));
		campoNro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoNro.setColumns(10);
		campoNro.setBounds(557, 286, 70, 29);
		contentPane.add(campoNro);
		
		
		JLabel lblcidade = new JLabel("Cidade:");
		lblcidade.setForeground(new Color(255, 255, 255));
		lblcidade.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblcidade.setBounds(645, 266, 70, 20);
		contentPane.add(lblcidade);
		
		campoCidade = new JTextField("");
		campoCidade.setForeground(new Color(128, 128, 128));
		campoCidade.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoCidade.setColumns(10);
		campoCidade.setBounds(645, 286, 183, 29);
		contentPane.add(campoCidade);
		
		
		JLabel lblbairro = new JLabel("Bairro:");
		lblbairro.setForeground(new Color(255, 255, 255));
		lblbairro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblbairro.setBounds(557, 325, 57, 20);
		contentPane.add(lblbairro);
		
		campoBairro = new JTextField("");
		campoBairro.setForeground(new Color(128, 128, 128));
		campoBairro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoBairro.setColumns(10);
		campoBairro.setBounds(557, 346, 271, 29);
		contentPane.add(campoBairro);
		
		
		JLabel lblpais = new JLabel("País:");
		lblpais.setForeground(new Color(255, 255, 255));
		lblpais.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblpais.setBounds(557, 388, 57, 20);
		contentPane.add(lblpais);
		
		campoPais = new JTextField("");
		campoPais.setForeground(new Color(128, 128, 128));
		campoPais.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoPais.setColumns(10);
		campoPais.setBounds(557, 409, 183, 29);
		contentPane.add(campoPais);
		
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(new Color(255, 255, 255));
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblEstado.setBounds(759, 388, 57, 20);
		contentPane.add(lblEstado);
		
		campoEstado = new JTextField("");
		campoEstado.setForeground(new Color(128, 128, 128));
		campoEstado.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoEstado.setColumns(10);
		campoEstado.setBounds(758, 409, 70, 29);
		contentPane.add(campoEstado);
		
		
		JButton btnVoltar= new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroOpcoes_Interface CadastroOpcoes_Interface = new cadastroOpcoes_Interface();
				CadastroOpcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		btnVoltar.setBackground(new Color(70, 130, 180));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.setBounds(37, 502, 111, 29);
		contentPane.add(btnVoltar);
		
		
		JButton btnPrximo = new JButton("Cadastrar");
		btnPrximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
					String queryCliente = "insert into cliente values ('" + campoCPF.getText() + "','" + campoRG.getText() + "','" + campoNome.getText()+"' ,'" + 
					campoNascimento.getText() + "','" + campoLog.getText() + "','" + campoNro.getText() + "','" + campoCidade.getText() + "','" + campoBairro.getText() + 
					"','" + campoPais.getText() + "','" + campoEstado.getText() + "');";
					
					String queryTelefone1 = "insert into telefone values ('" + campoCPF.getText() + "','" + campoTelefone1.getText() + "');";
					
					String queryTelefone2 = "insert into telefone values ('" + campoCPF.getText() + "','" + campoTelefone2.getText() + "');";
					
					String queryEmail = "insert into email values ('" + campoCPF.getText() + "','" + campoEmail.getText() + "');";
					
					
					Statement statement = (Statement)connection.createStatement();
					int resp1 = ((java.sql.Statement) statement).executeUpdate(queryCliente);
					int resp2 = ((java.sql.Statement) statement).executeUpdate(queryTelefone1);
					int resp3= ((java.sql.Statement) statement).executeUpdate(queryTelefone2);
					int resp4 = ((java.sql.Statement) statement).executeUpdate(queryEmail);
					
					if(resp1 == 0 && resp2 == 0 && resp3 == 0 && resp4 == 0) {
						JOptionPane.showMessageDialog(btnPrximo, "Erro ao tentar inserir um cliente!");
					} else {
						JOptionPane.showMessageDialog(btnPrximo, "Cliente cadastrado com sucesso!");
						campoCPF.setText("");
						campoRG.setText("");
						campoNome.setText("");
						campoNascimento.setText("");
						campoLog.setText("");
						campoNro.setText("");
						campoCidade.setText("");
						campoBairro.setText("");
						campoPais.setText("");
						campoEstado.setText("");
						campoTelefone1.setText("");
						campoTelefone2.setText("");
						campoEmail.setText("");
						
						}
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPrximo.setBackground(new Color(70, 130, 180));
		btnPrximo.setForeground(new Color(255, 255, 255));
		btnPrximo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnPrximo.setBounds(175, 502, 111, 29);
		contentPane.add(btnPrximo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(533, 145, 321, 320);
		contentPane.add(panel);
		
	}
}
