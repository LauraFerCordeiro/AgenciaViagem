package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class cadastroViagem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField data_ida;
	private JTextField data_volta;
	private JTextField valorTotal;
	private JTextField cpfAgente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroViagem frame = new cadastroViagem();
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
	public cadastroViagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 630);
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
		rodape.setBounds(770, 546, 136, 37);
		contentPane.add(rodape);
		
		JLabel subtitulo = new JLabel("Viagem");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setForeground(new Color(128, 128, 128));
		subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		subtitulo.setBounds(374, 95, 148, 24);
		contentPane.add(subtitulo);
		
		
		JLabel dataIda = new JLabel("Data de ida:");
		dataIda.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		dataIda.setBounds(556, 174, 148, 29);
		contentPane.add(dataIda);
		
		data_ida = new JTextField();
		data_ida.setForeground(new Color(128, 128, 128));
		data_ida.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		data_ida.setColumns(10);
		data_ida.setBounds(556, 200, 257, 29);
		contentPane.add(data_ida);
		
		JLabel dataVolta = new JLabel("Data de volta:");
		dataVolta.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		dataVolta.setBounds(556, 245, 148, 29);
		contentPane.add(dataVolta);
		
		data_volta = new JTextField();
		data_volta.setForeground(new Color(128, 128, 128));
		data_volta.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		data_volta.setColumns(10);
		data_volta.setBounds(556, 272, 257, 29);
		contentPane.add(data_volta);
		
		JLabel valor = new JLabel("Valor total:");
		valor.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		valor.setBounds(556, 341, 148, 24);
		contentPane.add(valor);
		
		valorTotal = new JTextField();
		valorTotal.setForeground(new Color(128, 128, 128));
		valorTotal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		valorTotal.setColumns(10);
		valorTotal.setBounds(556, 366, 257, 29);
		contentPane.add(valorTotal);
		
		JLabel agente = new JLabel("CPF do agente:");
		agente.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		agente.setBounds(556, 420, 148, 24);
		contentPane.add(agente);
		
		cpfAgente = new JTextField();
		cpfAgente.setForeground(Color.GRAY);
		cpfAgente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cpfAgente.setColumns(10);
		cpfAgente.setBounds(556, 448, 257, 29);
		contentPane.add(cpfAgente);
		
		
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
		btnVoltar.setBounds(37, 546, 111, 29);
		contentPane.add(btnVoltar);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(69, 159, 434, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel cpfCliente = new JLabel("Selecione o CPF do cliente:");
		cpfCliente.setHorizontalAlignment(SwingConstants.CENTER);
		cpfCliente.setForeground(new Color(255, 255, 255));
		cpfCliente.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cpfCliente.setBounds(20, 10, 393, 32);
		panel.add(cpfCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(20, 48, 393, 110);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "Nome"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(new Color(220, 232, 241));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			String editarCliente = "select cpf, nome from cliente;";
			Statement statement = (Statement)connection.createStatement();
			ResultSet resp = statement.executeQuery(editarCliente);
			while(resp.next()) {
				model.addRow(new Object[] {resp.getString("cpf"), resp.getString("nome")});
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		
		JLabel hosp = new JLabel("Selecione a hospedagem:");
		hosp.setHorizontalAlignment(SwingConstants.CENTER);
		hosp.setForeground(Color.WHITE);
		hosp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hosp.setBounds(20, 180, 393, 32);
		panel.add(hosp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(20, 214, 393, 110);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "País"
			}
		) {
			Class[] columnTypes = new Class[] {
				int.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBackground(new Color(220, 232, 241));
		
		DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
		
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < table_1.getColumnCount(); i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			String editarHosp = "select h.cod_destino, h.nome, h.pais from Hospedagem h;";
			Statement statement = (Statement)connection.createStatement();
			ResultSet resp = statement.executeQuery(editarHosp);
			while(resp.next()) {
				model1.addRow(new Object[] {resp.getInt("cod_destino"), resp.getString("nome"), resp.getString("pais")});
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		JButton cadastro = new JButton("Cadastrar");
		cadastro.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            String cpf = model.getValueAt(table.getSelectedRow(), 0).toString();

		            DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
		            int id = (int) model1.getValueAt(table_1.getSelectedRow(), 0);
		            String nomeHosp = model1.getValueAt(table_1.getSelectedRow(), 1).toString();

		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
		            String queryViagem = "INSERT INTO viagem (cpf_cliente, cod_destino, nome_hosp, data_ida, data_volta, valor, cpf_agente) VALUES (?, ?, ?, ?, ?, ?, ?)";

		            PreparedStatement preparedStatement = connection.prepareStatement(queryViagem);
		            preparedStatement.setString(1, cpf);
		            preparedStatement.setInt(2, id);
		            preparedStatement.setString(3, nomeHosp);

		            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            Date dataIda = new Date(dateFormat.parse(data_ida.getText()).getTime());
		            Date dataVolta = new Date(dateFormat.parse(data_volta.getText()).getTime());

		            preparedStatement.setDate(4, dataIda);
		            preparedStatement.setDate(5, dataVolta);
		            
		            double valor = Double.parseDouble(valorTotal.getText());
		            preparedStatement.setDouble(6, valor);

		            preparedStatement.setString(7, cpfAgente.getText());

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(cadastro, "Viagem cadastrada com sucesso!");
		                data_ida.setText("");
		                data_volta.setText("");
		                valorTotal.setText("");
		                cpfAgente.setText("");
		            } else {
		                JOptionPane.showMessageDialog(cadastro, "Erro ao cadastrar viagem!");
		            }

		            connection.close();
		        } catch (SQLException | ParseException e1) {
		            e1.printStackTrace();
		        }
		    }
		});

		cadastro.setForeground(Color.WHITE);
		cadastro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		cadastro.setBackground(new Color(70, 130, 180));
		cadastro.setBounds(161, 546, 111, 29);
		contentPane.add(cadastro);
	}

}
