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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class editarViagem extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarViagem frame = new editarViagem();
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
	public editarViagem() {
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
		
		JLabel tituloPagina = new JLabel("Viagens cadastradas");
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
		scrollPane.setBounds(108, 140, 696, 299);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Destino", "Hospedagem", "Data de Ida", "Data de Volta"
			}
		) {
			Class[] columnTypes = new Class[] {
				    String.class, int.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(new Color(220, 232, 241));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			String exibirViagem = "select cpf_cliente, cod_destino, nome_hosp, data_ida, data_volta from viagem;";
			Statement statement = (Statement)connection.createStatement();
			ResultSet resp = statement.executeQuery(exibirViagem);
			while(resp.next()) {
				model.addRow(new Object[] {resp.getString("cpf_cliente"), resp.getInt("cod_destino"), resp.getString("nome_hosp"), resp.getString("data_ida"), resp.getString("data_volta")});
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				String cpf = model.getValueAt(row, 0).toString();
				int id_dest = (int)model.getValueAt(row, 1);
				String nome_hosp = model.getValueAt(row, 2).toString();
				String data_ida = model.getValueAt(row, 3).toString();
				String data_volta = model.getValueAt(row, 4).toString();
				editarDados(cpf, id_dest, nome_hosp, data_ida, data_volta);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setBounds(400, 449, 102, 29);
		contentPane.add(btnNewButton);
	}

		
		private void editarDados(String cpf, int id, String nome, String dataI, String dataV) {
	       EdicaoViagem EdicaoViagem = new EdicaoViagem(cpf, id, nome, dataI, dataV);
	        EdicaoViagem.setVisible(true);
		}

	}

		class EdicaoViagem extends JFrame{
			private JPanel contentPane;
			private JTextField data_ida;
			private JTextField data_volta;
			private JTextField valorTotal;
			private JTextField cpfAgente;
			
			public EdicaoViagem(String cpf, int id, String nome, String dataI, String dataV) {
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
				
				JLabel tituloPagina = new JLabel("Editar Viagem");
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
				
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(211, 211, 211));
				panel.setBounds(90, 181, 356, 239);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel cpfCli = new JLabel("CPF cliente:");
				cpfCli.setForeground(new Color(0, 0, 0));
				cpfCli.setBounds(28, 81, 162, 29);
				panel.add(cpfCli);
				cpfCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				
				JLabel codDest = new JLabel("Código destino:");
				codDest.setForeground(new Color(0, 0, 0));
				codDest.setBounds(179, 81, 162, 29);
				panel.add(codDest);
				codDest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				
				JLabel hosp = new JLabel("Hospedagem:");
				hosp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				hosp.setBounds(28, 155, 162, 29);
				panel.add(hosp);
				
				JLabel cpfC = new JLabel(cpf);
				cpfC.setFont(new Font("Times New Roman", Font.ITALIC, 18));
				cpfC.setBounds(28, 107, 162, 29);
				panel.add(cpfC);
				
				JLabel idDest = new JLabel();
				idDest.setFont(new Font("Times New Roman", Font.ITALIC, 18));
				idDest.setBounds(185, 107, 162, 29);
				panel.add(idDest);
				
				JLabel nomeH = new JLabel(nome);
				nomeH.setFont(new Font("Times New Roman", Font.ITALIC, 18));
				nomeH.setBounds(28, 181, 162, 29);
				panel.add(nomeH);
				
				JLabel subtitulo = new JLabel("Informações importantes:");
				subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
				subtitulo.setForeground(Color.BLACK);
				subtitulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
				subtitulo.setBounds(56, 30, 248, 29);
				panel.add(subtitulo);
				
				
				
				JLabel dataIda = new JLabel("Data de ida:");
				dataIda.setFont(new Font("Times New Roman", Font.ITALIC, 20));
				dataIda.setBounds(524, 146, 148, 29);
				contentPane.add(dataIda);
				
				data_ida = new JTextField();
				data_ida.setForeground(new Color(128, 128, 128));
				data_ida.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				data_ida.setColumns(10);
				data_ida.setBounds(524, 175, 273, 29);
				contentPane.add(data_ida);
				
				JLabel dataVolta = new JLabel("Data de volta:");
				dataVolta.setFont(new Font("Times New Roman", Font.ITALIC, 20));
				dataVolta.setBounds(524, 214, 148, 29);
				contentPane.add(dataVolta);
				
				data_volta = new JTextField();
				data_volta.setForeground(new Color(128, 128, 128));
				data_volta.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				data_volta.setColumns(10);
				data_volta.setBounds(524, 245, 273, 29);
				contentPane.add(data_volta);
				
				JLabel valor = new JLabel("Valor total:");
				valor.setFont(new Font("Times New Roman", Font.ITALIC, 20));
				valor.setBounds(524, 317, 148, 24);
				contentPane.add(valor);
				
				valorTotal = new JTextField();
				valorTotal.setForeground(new Color(128, 128, 128));
				valorTotal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				valorTotal.setColumns(10);
				valorTotal.setBounds(524, 346, 273, 29);
				contentPane.add(valorTotal);
				
				JLabel agente = new JLabel("CPF do agente:");
				agente.setFont(new Font("Times New Roman", Font.ITALIC, 20));
				agente.setBounds(524, 396, 148, 24);
				contentPane.add(agente);
				
				cpfAgente = new JTextField();
				cpfAgente.setForeground(Color.GRAY);
				cpfAgente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				cpfAgente.setColumns(10);
				cpfAgente.setBounds(524, 425, 273, 29);
				contentPane.add(cpfAgente);
				
				
				
				JButton btnSave = new JButton("Salvar");
		        btnSave.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	atualizarDados(cpf, id, nome, dataI, dataV);
		            	EdicaoViagem frame = new EdicaoViagem(dataV, id, dataV, dataV, dataV);
						frame.setVisible(true);
						editarViagem frame2 = new editarViagem();
						frame.setVisible(false);
		            	
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
			
			
			private void atualizarDados(String cpf, int id, String nome, String dataI, String dataV) {
				String novaDataI = data_ida.getText();
				String novaDataV = data_volta.getText();
		        String novoValor = valorTotal.getText();
		        String novoAgente = cpfAgente.getText();

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
			        connection.setAutoCommit(false); 

			        String updateViagem = "UPDATE viagem SET data_ida = ?, data_volta = ?, valor = ?, cpf_agente = ? WHERE cpf_cliente = ? AND cod_destino = ? AND nome_hosp = ? AND data_ida = ? AND data_volta = ?";
			        PreparedStatement ViagemStatement = connection.prepareStatement(updateViagem);
			        ViagemStatement.setString(1, novaDataI);
			        ViagemStatement.setString(2, novaDataV);
			        ViagemStatement.setString(3, novoValor);
			        ViagemStatement.setString(4, novoAgente);
			        ViagemStatement.setString(5, cpf);
			        ViagemStatement.setInt(6, id);
			        ViagemStatement.setString(7, nome);
			        ViagemStatement.setString(8, dataI);
			        ViagemStatement.setString(9, dataV);
			        ViagemStatement.executeUpdate();
			            
			        connection.commit();
			        connection.setAutoCommit(true);

			        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");
				} catch (SQLException e) {
					e.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da hospedagem.");
			     }
			}
}
