package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class exibirHospedagem extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exibirHospedagem frame = new exibirHospedagem();
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
	public exibirHospedagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setBounds(37, 19, 102, 100);
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Exibir Hospedagem");
		tituloPagina.setBounds(120, 46, 665, 49);
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setBounds(759, 516, 136, 37);
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(rodape);
		
		JButton btnVoltar= new JButton("Voltar");
		btnVoltar.setBounds(37, 502, 111, 29);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirOpcoes_Interface exibirOpcoes_Interface = new exibirOpcoes_Interface();
				exibirOpcoes_Interface.setVisible(true);
		        dispose();
			}
		});
		btnVoltar.setBackground(new Color(70, 130, 180));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 124, 607, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cidade", "País"
			}
		) {
			Class[] columnTypes = new Class[] {
				int.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(new Color(220, 232, 241));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			String editarHosp = "select h.cod_destino, h.nome, h.cidade, h.pais from Hospedagem h;";
			Statement statement = (Statement)connection.createStatement();
			ResultSet resp = statement.executeQuery(editarHosp);
			while(resp.next()) {
				model.addRow(new Object[] {resp.getInt("cod_destino"), resp.getString("nome"), resp.getString("cidade"), resp.getString("pais")});
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}