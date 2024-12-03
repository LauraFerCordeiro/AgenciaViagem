package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class login_Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_Interface frame = new login_Interface();
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
	public login_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		iconePrincipal.setBounds(37, 19, 102, 100);
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Faça sua viagem do sonho aqui!");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(128, 47, 665, 49);
		contentPane.add(tituloPagina);
		
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(759, 516, 136, 37);
		contentPane.add(rodape);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(228, 208, 420, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cpf.setBounds(228, 169, 80, 29);
		contentPane.add(cpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblSenha.setBounds(228, 275, 80, 29);
		contentPane.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(228, 314, 420, 37);
		contentPane.add(textField_1);
		
		JButton entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcoes_Interface opcoes_Interface = new opcoes_Interface();
				opcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		entrar.setForeground(new Color(255, 255, 255));
		entrar.setBackground(new Color(70, 130, 180));
		entrar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		entrar.setBounds(385, 393, 104, 37);
		contentPane.add(entrar);

	}
}
