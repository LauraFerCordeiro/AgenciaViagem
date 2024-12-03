package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class excluirHospedagem extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					excluirHospedagem frame = new excluirHospedagem();
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
	public excluirHospedagem() {
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
		
		JLabel tituloPagina = new JLabel("Excluir Hospedagem");
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
				excluirOpcoes_Interface excluirOpcoes_Interface = new excluirOpcoes_Interface();
				excluirOpcoes_Interface.setVisible(true);
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
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				int id = (int)model.getValueAt(row, 0);
				String nome = model.getValueAt(row, 1).toString();
				delHosp(id, nome);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setBounds(400, 453, 102, 29);
		contentPane.add(btnNewButton);
	}
	
	
	private void delHosp(int id, String nome) {
		int res = JOptionPane.showConfirmDialog(null, "Deseja mesmo deletar o cadastro dessa hospedagem?");
		if (res == 0) {
			int sucesso = 0;
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
				PreparedStatement stmt;
				stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM viagem WHERE cod_destino = ? and nome_hosp = ?;");
				stmt.setInt(1, id);
				stmt.setString(2, nome);
				sucesso = stmt.executeUpdate();
		
				stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM servico WHERE cod_destino = ? and nome_hosp = ?;");
				stmt.setInt(1, id);
				stmt.setString(2, nome);
				sucesso = stmt.executeUpdate();
				
				stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM hospedagem WHERE cod_destino = ? and nome = ?;");
				stmt.setInt(1, id);
				stmt.setString(2, nome);
				sucesso = stmt.executeUpdate();
					
				
				stmt.close();
				
			} catch(SQLException e){
				e.printStackTrace();
			}
			if (sucesso == 1) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int j=0; j < model.getRowCount(); j++) {
					if ((int)model.getValueAt(j, 0) == id && model.getValueAt(j, 1).toString() == nome) {
						model.removeRow(j);
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "Dados deletados com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao deletar!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
		}
		
	}
}
