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
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class editarHospedagem extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarHospedagem frame = new editarHospedagem();
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
	public editarHospedagem() {
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
		
		JLabel tituloPagina = new JLabel("Editar Hospedagem");
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
				editarOpcoes_Interface editarOpcoes_Interface = new editarOpcoes_Interface();
				editarOpcoes_Interface.setVisible(true);
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
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				int id = (int)model.getValueAt(row, 0);
				String nome = model.getValueAt(row, 1).toString();
				editarDados(id, nome);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setBounds(400, 453, 102, 29);
		contentPane.add(btnNewButton);
	}
	
	private void editarDados(int id, String nome) {
        EdicaoHosp edicaoHosp = new EdicaoHosp(id, nome);
        edicaoHosp.setVisible(true);
	}

}

	class EdicaoHosp extends JFrame{
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
		
		public EdicaoHosp(int id, String nome) {
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
			
			JLabel tituloPagina = new JLabel("Editar Hospedagem");
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			tituloPagina.setBounds(135, 46, 626, 49);
			contentPane.add(tituloPagina);
			
			
			JLabel subtitulo = new JLabel(nome);
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(274, 95, 348, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			rodape.setBounds(759, 516, 136, 37);
			contentPane.add(rodape);
			
			
			JLabel Diaria = new JLabel("Valor da diária:");
			Diaria.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Diaria.setBounds(70, 235, 142, 20);
			contentPane.add(Diaria);
			
			campoDiaria = new JTextField("");
			campoDiaria.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoDiaria.setColumns(10);
			campoDiaria.setBounds(70, 255, 235, 29);
			contentPane.add(campoDiaria);
			
			
			JLabel Classificacao = new JLabel("Classificação:");
			Classificacao.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Classificacao.setBounds(272, 160, 180, 20);
			contentPane.add(Classificacao);
			
			campoClassificacao = new JTextField("");
			campoClassificacao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoClassificacao.setColumns(10);
			campoClassificacao.setBounds(272, 180, 179, 29);
			contentPane.add(campoClassificacao);
			
			SimpleDateFormat dataNascimento = new SimpleDateFormat(campoClassificacao.getText());
			
			
			JLabel Tipo = new JLabel("Tipo da hospedagem:");
			Tipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Tipo.setBounds(70, 160, 180, 20);
			contentPane.add(Tipo);
			
			campoTipo = new JTextField("");
			campoTipo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoTipo.setColumns(10);
			campoTipo.setBounds(70, 180, 179, 29);
			contentPane.add(campoTipo);
			
			
			
			JLabel lblEndereoCompleto = new JLabel("Endereço");
			lblEndereoCompleto.setHorizontalAlignment(SwingConstants.CENTER);
			lblEndereoCompleto.setForeground(new Color(255, 255, 255));
			lblEndereoCompleto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblEndereoCompleto.setBounds(603, 203, 183, 24);
			contentPane.add(lblEndereoCompleto);
			
			
			JLabel lblLogradouro = new JLabel("Logradouro:");
			lblLogradouro.setForeground(new Color(255, 255, 255));
			lblLogradouro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			lblLogradouro.setBounds(557, 240, 136, 24);
			contentPane.add(lblLogradouro);
			
			campoLog = new JTextField("");
			campoLog.setForeground(new Color(128, 128, 128));
			campoLog.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoLog.setColumns(10);
			campoLog.setBounds(557, 263, 271, 29);
			contentPane.add(campoLog);
			
			
			JLabel lblNro = new JLabel("Número:");
			lblNro.setForeground(new Color(255, 255, 255));
			lblNro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			lblNro.setBounds(557, 302, 70, 20);
			contentPane.add(lblNro);
			
			campoNro = new JTextField("");
			campoNro.setForeground(new Color(128, 128, 128));
			campoNro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoNro.setColumns(10);
			campoNro.setBounds(557, 322, 70, 29);
			contentPane.add(campoNro);
		
			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setBounds(533, 181, 321, 200);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblbairro = new JLabel("Bairro:");
			lblbairro.setBounds(124, 123, 57, 20);
			lblbairro.setForeground(new Color(255, 255, 255));
			lblbairro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			panel.add(lblbairro);
			
			campoBairro = new JTextField("");
			campoBairro.setBounds(124, 143, 173, 27);
			campoBairro.setForeground(new Color(128, 128, 128));
			campoBairro.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoBairro.setColumns(10);
			panel.add(campoBairro);
			
			JLabel servicos = new JLabel("Serviços disponíveis:");
			servicos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			servicos.setBounds(70, 310, 180, 20);
			contentPane.add(servicos);
			
			campoServicos = new JTextField("");
			campoServicos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoServicos.setColumns(10);
			campoServicos.setBounds(70, 330, 381, 29);
			contentPane.add(campoServicos);
			
			
			JButton btnSave = new JButton("Salvar");
	        btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                atualizarDados(id, nome);
	            }
	        });	        
	        btnSave.setBackground(new Color(70, 130, 180));
	        btnSave.setForeground(new Color(255, 255, 255));
	        btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	        btnSave.setBounds(37, 500, 111, 29);
			contentPane.add(btnSave);
			
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	int res = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação?");
	            	if(res == 0) {
	            		dispose();
	            	} 
	            }
	        });	        
			btnCancelar.setBackground(new Color(70, 130, 180));
			btnCancelar.setForeground(new Color(255, 255, 255));
			btnCancelar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			btnCancelar.setBounds(170, 500, 111, 29);
			contentPane.add(btnCancelar);
			
			
			
		}
		
		
		 private void atualizarDados(int id, String nome) {
		        String novoDiaria = campoDiaria.getText();
		        String novoTipo = campoTipo.getText();
		        String novoClassificacao = campoClassificacao.getText();
		        String novoLogradouro = campoLog.getText();
		        String novoNumero = campoNro.getText();
		        String novoBairro = campoBairro.getText();
		        String novoServico = campoServicos.getText();

		        try {
		        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
		            connection.setAutoCommit(false); 

		            String updateHospQuery = "UPDATE hospedagem SET tipo = ?, valor = ?, classificacao = ?, log = ?, nro = ?, bairro = ? WHERE cod_destino = ? and nome = ?";
		            PreparedStatement hospStatement = connection.prepareStatement(updateHospQuery);
		            hospStatement.setString(1, novoTipo);
		            hospStatement.setString(2, novoDiaria);
		            hospStatement.setString(3, novoClassificacao);
		            hospStatement.setString(4, novoLogradouro);
		            hospStatement.setString(5, novoNumero);
		            hospStatement.setString(6, novoBairro);
		            hospStatement.setInt(7, id);
		            hospStatement.setString(8, nome);
		            hospStatement.executeUpdate();

		            String updateServicoQuery = "UPDATE servico SET servico = ? WHERE cod_destino = ? and nome_hosp = ?";
		            PreparedStatement servicoStatement = connection.prepareStatement(updateServicoQuery);
		            servicoStatement.setString(1, novoServico);
		            servicoStatement.setInt(2, id);
		            servicoStatement.setString(3, nome);
		            servicoStatement.executeUpdate();

		            connection.commit();

		            connection.setAutoCommit(true);

		            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");
		            dispose();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da hospedagem.");
		        }
		 }
}
