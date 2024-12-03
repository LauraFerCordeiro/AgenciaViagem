package view;

import java.awt.Color;
import java.awt.Container;
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
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class cadastroHospedagem extends JFrame {
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoDiaria;
	private JTextField campoClassificacao;
	private JTextField campoTipo;
	private JTextField campoLog;
	private JTextField campoNro;
	private JTextField campoBairro;
	private JTextField campoServicos;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroHospedagem frame = new cadastroHospedagem();
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
	public cadastroHospedagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel subtitulo = new JLabel("hospedagem");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setForeground(new Color(128, 128, 128));
		subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		subtitulo.setBounds(374, 95, 148, 24);
		contentPane.add(subtitulo);
		
		
		
		JLabel Nome = new JLabel("Nome:");
		Nome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Nome.setBounds(70, 145, 57, 20);
		contentPane.add(Nome);
		
		campoNome = new JTextField("");
		campoNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoNome.setColumns(10);
		campoNome.setBounds(70, 165, 333, 29);
		contentPane.add(campoNome);
		
		
		JLabel Diaria = new JLabel("Valor da diária:");
		Diaria.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Diaria.setBounds(70, 209, 142, 20);
		contentPane.add(Diaria);
		
		campoDiaria = new JTextField("");
		campoDiaria.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoDiaria.setColumns(10);
		campoDiaria.setBounds(70, 230, 235, 29);
		contentPane.add(campoDiaria);
		
		
		JLabel Classificacao = new JLabel("Classificação:");
		Classificacao.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Classificacao.setBounds(260, 279, 180, 20);
		contentPane.add(Classificacao);
		
		campoClassificacao = new JTextField("");
		campoClassificacao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoClassificacao.setColumns(10);
		campoClassificacao.setBounds(260, 300, 143, 29);
		contentPane.add(campoClassificacao);
		
		SimpleDateFormat dataNascimento = new SimpleDateFormat(campoClassificacao.getText());
		
		
		JLabel Tipo = new JLabel("Tipo da hospedagem:");
		Tipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		Tipo.setBounds(70, 279, 180, 20);
		contentPane.add(Tipo);
		
		campoTipo = new JTextField("");
		campoTipo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoTipo.setColumns(10);
		campoTipo.setBounds(70, 300, 148, 29);
		contentPane.add(campoTipo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(450, 145, 404, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblbairro = new JLabel("Bairro:");
		lblbairro.setBounds(135, 123, 57, 20);
		lblbairro.setForeground(new Color(255, 255, 255));
		lblbairro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		panel.add(lblbairro);
		
		campoBairro = new JTextField("");
		campoBairro.setBounds(135, 143, 237, 27);
		campoBairro.setForeground(new Color(128, 128, 128));
		campoBairro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoBairro.setColumns(10);
		panel.add(campoBairro);
		
		
		/**JRadioButton servicoComp = new JRadioButton("Serviço completo");
		servicoComp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		servicoComp.setBounds(70, 381, 148, 21);
		contentPane.add(servicoComp);
		
		JRadioButton cafeManh = new JRadioButton("Café da manhã");
		cafeManh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cafeManh.setBounds(70, 408, 148, 21);
		contentPane.add(cafeManh);
		
		JRadioButton servicoQuarto = new JRadioButton("Serviço de quarto");
		servicoQuarto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		servicoQuarto.setBounds(70, 435, 142, 21);
		contentPane.add(servicoQuarto);
		
		JRadioButton restBar = new JRadioButton("Restaurante e bar");
		restBar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		restBar.setBounds(70, 462, 142, 21);
		contentPane.add(restBar);
		
		JRadioButton spa = new JRadioButton("Serviço de spa");
		spa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		spa.setBounds(231, 408, 159, 21);
		contentPane.add(spa);
		
		JRadioButton estacionamento = new JRadioButton("Serviço de estacionamento");
		estacionamento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		estacionamento.setBounds(231, 381, 200, 21);
		contentPane.add(estacionamento);
		
		JRadioButton entretenimento = new JRadioButton("Serviço de entretenimento");
		entretenimento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		entretenimento.setBounds(231, 462, 200, 21);
		contentPane.add(entretenimento);
		
		JRadioButton academia = new JRadioButton("Academia");
		academia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		academia.setBounds(231, 435, 159, 21);
		contentPane.add(academia); **/
		
		JLabel servicos = new JLabel("Serviços disponíveis:");
		servicos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		servicos.setBounds(70, 355, 180, 20);
		contentPane.add(servicos);
		
		campoServicos = new JTextField("");
		campoServicos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoServicos.setColumns(10);
		campoServicos.setBounds(70, 378, 333, 29);
		contentPane.add(campoServicos);
		
		
		
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
		btnVoltar.setBounds(37, 505, 111, 29);
		contentPane.add(btnVoltar);

		
		JLabel lblpais = new JLabel("Destino:");
		lblpais.setBounds(26, 179, 57, 20);
		panel.add(lblpais);
		lblpais.setForeground(new Color(255, 255, 255));
		lblpais.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 209, 346, 130);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table_1.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "País", "Cidade", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				int.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		
		JLabel lblEndereoCompleto = new JLabel("Endereço completo");
		lblEndereoCompleto.setBounds(112, 20, 183, 24);
		panel.add(lblEndereoCompleto);
		lblEndereoCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereoCompleto.setForeground(new Color(255, 255, 255));
		lblEndereoCompleto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(28, 54, 136, 24);
		panel.add(lblLogradouro);
		lblLogradouro.setForeground(new Color(255, 255, 255));
		lblLogradouro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		campoLog = new JTextField("");
		campoLog.setBounds(26, 77, 346, 29);
		panel.add(campoLog);
		campoLog.setForeground(new Color(128, 128, 128));
		campoLog.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoLog.setColumns(10);
		
		
		JLabel lblNro = new JLabel("Número:");
		lblNro.setBounds(26, 123, 70, 20);
		panel.add(lblNro);
		lblNro.setForeground(new Color(255, 255, 255));
		lblNro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		campoNro = new JTextField("");
		campoNro.setBounds(26, 142, 82, 29);
		panel.add(campoNro);
		campoNro.setForeground(new Color(128, 128, 128));
		campoNro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		campoNro.setColumns(10);
		
		JButton btnPrximo = new JButton("Cadastrar");
		btnPrximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					int id = (int)model.getValueAt(table_1.getSelectedRow(), 0);
					String pais = model.getValueAt(table_1.getSelectedRow(), 1).toString();
					String cidade = model.getValueAt(table_1.getSelectedRow(), 2).toString();
					String estado = model.getValueAt(table_1.getSelectedRow(), 3).toString();
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
					String queryHospedagem = "insert into hospedagem values ( '" + id + "','" + campoNome.getText() + "', '" + campoTipo.getText() + "', "
					+ "" + campoDiaria.getText() + ", '" + campoClassificacao.getText() + "', '" + campoLog.getText() + "'," + campoNro.getText() + ",'" + cidade + "', '" + campoBairro.getText() + "', '" + pais + "', '" + estado + "');";
					
					String queryServicos = "insert into servico values ('" + id + "','" + campoNome.getText() + "','" + campoServicos.getText() + "');";	
				
					
					Statement statement = (Statement)connection.createStatement();
					int resp = ((java.sql.Statement) statement).executeUpdate(queryHospedagem);
					int resp1 = ((java.sql.Statement) statement).executeUpdate(queryServicos);
					
					if(resp == 0 && resp1 == 0) {
						JOptionPane.showMessageDialog(btnPrximo, "Erro ao tentar inserir uma hospedagem!");
					} else {
						JOptionPane.showMessageDialog(btnPrximo, "Hospedagem cadastrada com sucesso!");
						campoNome.setText("");
						campoDiaria.setText("");
						campoClassificacao.setText("");
						campoTipo.setText("");
						campoLog.setText("");
						campoNro.setText("");
						campoBairro.setText("");
						campoServicos.setText("");
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
		btnPrximo.setBounds(175, 505, 111, 29);
		contentPane.add(btnPrximo);
	
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM destino;");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("codigo");
				String pais = rs.getString("pais");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.addRow(new Object[]{id, pais, cidade, estado});
			}
			
			connection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

