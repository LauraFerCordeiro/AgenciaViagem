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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class relatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorio frame = new relatorio();
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
	public relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setBounds(37, 19, 102, 100);
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Relatório");
		tituloPagina.setBounds(100, 47, 685, 49);
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		contentPane.add(tituloPagina);
		
		JLabel subtitulo = new JLabel("consultas");
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setForeground(new Color(128, 128, 128));
		subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		subtitulo.setBounds(369, 94, 148, 24);
		contentPane.add(subtitulo);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setBounds(745, 516, 136, 37);
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(rodape);
		
		JButton btnVoltar= new JButton("Voltar");
		btnVoltar.setBounds(37, 502, 111, 29);
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
		contentPane.add(btnVoltar);
		
		
		
		JPanel relatorio1 = new JPanel();
		relatorio1.setBackground(new Color(220, 220, 220));
		relatorio1.setBounds(100, 149, 330, 89);
		contentPane.add(relatorio1);
		relatorio1.setLayout(null);
		
		JButton busca1 = new JButton("Buscar");
		busca1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta1();
			}
	    });	
		busca1.setForeground(Color.WHITE);
		busca1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca1.setBackground(new Color(105, 105, 105));
		busca1.setBounds(221, 51, 99, 28);
		relatorio1.add(busca1);
		
		JLabel texto1 = new JLabel("Todos os clientes cadastrados que ainda");
		texto1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		texto1.setBounds(20, 10, 279, 31);
		relatorio1.add(texto1);
		
		JLabel lblNoSistemaQue = new JLabel("não realizaram uma viagem");
		lblNoSistemaQue.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNoSistemaQue.setBounds(20, 33, 184, 28);
		relatorio1.add(lblNoSistemaQue);
		
		JPanel relatorio2 = new JPanel();
		relatorio2.setBackground(new Color(220, 220, 220));
		relatorio2.setBounds(100, 260, 330, 89);
		contentPane.add(relatorio2);
		relatorio2.setLayout(null);
		
		JButton busca2 = new JButton("Buscar");
		busca2.setBounds(221, 51, 99, 28);
		relatorio2.add(busca2);
		busca2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta2();
			}
	    });	
		busca2.setForeground(Color.WHITE);
		busca2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca2.setBackground(new Color(105, 105, 105));
		
		JLabel lblTodosOsEmails = new JLabel("Todos os emails dos clientes que estão  ");
		lblTodosOsEmails.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTodosOsEmails.setBounds(21, 10, 278, 31);
		relatorio2.add(lblTodosOsEmails);
		
		JLabel lblCadastradosNoSistema = new JLabel("cadastrados no sistema");
		lblCadastradosNoSistema.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCadastradosNoSistema.setBounds(21, 34, 183, 28);
		relatorio2.add(lblCadastradosNoSistema);
		
		JPanel relatorio3 = new JPanel();
		relatorio3.setBackground(new Color(220, 220, 220));
		relatorio3.setBounds(100, 372, 330, 89);
		contentPane.add(relatorio3);
		relatorio3.setLayout(null);
		
		JButton busca3 = new JButton("Buscar");
		busca3.setBounds(221, 51, 99, 28);
		relatorio3.add(busca3);
		busca3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta3();
			}
	    });	
		busca3.setForeground(Color.WHITE);
		busca3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca3.setBackground(new Color(105, 105, 105));
		
		JLabel lblTodasAsHospedagens = new JLabel("Todas as hospedagens cadastradas e");
		lblTodasAsHospedagens.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTodasAsHospedagens.setBounds(20, 10, 300, 31);
		relatorio3.add(lblTodasAsHospedagens);
		
		JLabel lblDisponveisAosClientes = new JLabel("disponíveis aos clientes ");
		lblDisponveisAosClientes.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDisponveisAosClientes.setBounds(20, 33, 186, 31);
		relatorio3.add(lblDisponveisAosClientes);
		
		JPanel relatorio4 = new JPanel();
		relatorio4.setBackground(new Color(220, 220, 220));
		relatorio4.setBounds(455, 149, 330, 89);
		contentPane.add(relatorio4);
		relatorio4.setLayout(null);
		
		JButton busca4 = new JButton("Buscar");
		busca4.setBounds(221, 51, 99, 28);
		relatorio4.add(busca4);
		busca4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta4();
			}
	    });	
		busca4.setForeground(Color.WHITE);
		busca4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca4.setBackground(new Color(105, 105, 105));
		
		JLabel lblTodosOsServios = new JLabel("Todos os serviços disponíveis de uma");
		lblTodosOsServios.setBounds(21, 10, 279, 31);
		relatorio4.add(lblTodosOsServios);
		lblTodosOsServios.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		JLabel lblHospedagem = new JLabel("hospedagem cadastrada");
		lblHospedagem.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblHospedagem.setBounds(21, 32, 184, 28);
		relatorio4.add(lblHospedagem);
		
		JPanel relatorio5 = new JPanel();
		relatorio5.setBackground(new Color(220, 220, 220));
		relatorio5.setBounds(455, 260, 330, 89);
		contentPane.add(relatorio5);
		relatorio5.setLayout(null);
		
		JButton busca5 = new JButton("Buscar");
		busca5.setBounds(221, 51, 99, 28);
		relatorio5.add(busca5);
		busca5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta5();
			}
	    });	
		busca5.setForeground(Color.WHITE);
		busca5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca5.setBackground(new Color(105, 105, 105));
		
		JLabel lblTodasAsViagens = new JLabel("Todas as viagens vendidas por um ");
		lblTodasAsViagens.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTodasAsViagens.setBounds(20, 10, 279, 31);
		relatorio5.add(lblTodasAsViagens);
		
		JLabel lblAgenteDeViagem = new JLabel("agente de viagem");
		lblAgenteDeViagem.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAgenteDeViagem.setBounds(20, 34, 184, 28);
		relatorio5.add(lblAgenteDeViagem);
		
		JPanel relatorio6 = new JPanel();
		relatorio6.setBackground(new Color(220, 220, 220));
		relatorio6.setBounds(455, 372, 330, 89);
		contentPane.add(relatorio6);
		relatorio6.setLayout(null);
		
		JButton busca6 = new JButton("Buscar");
		busca6.setBounds(221, 51, 99, 28);
		relatorio6.add(busca6);
		busca6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta6();
			}
	    });	
		busca6.setForeground(Color.WHITE);
		busca6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		busca6.setBackground(new Color(105, 105, 105));
		
		JLabel lblExibirTodosOs = new JLabel("Todos os clientes que viajaram para um ");
		lblExibirTodosOs.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblExibirTodosOs.setBounds(20, 10, 279, 31);
		relatorio6.add(lblExibirTodosOs);
		
		JLabel lblCliente = new JLabel("determinado destino");
		lblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCliente.setBounds(20, 32, 184, 28);
		relatorio6.add(lblCliente);
	}
	
	private void consulta1() {
        C1 C1 = new C1();
        C1.setVisible(true);
	}
	
	private void consulta2() {
        C2 C2 = new C2();
        C2.setVisible(true);
	}
	
	private void consulta3() {
        C3 C3 = new C3();
        C3.setVisible(true);
	}
	
	private void consulta4() {
		cons4 cons4 = new cons4();
		cons4.setVisible(true);
	}
	
	private void consulta5() {
		cons5 cons5 = new cons5();
		cons5.setVisible(true);
	}
	
	private void consulta6() {
		cons6 cons6 = new cons6();
		cons6.setVisible(true);
	}
}
	
	class cons4 extends JFrame{
		private JPanel contentPane;
		private JTextField textFieldCpf;
		
		public cons4() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 432, 276);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		    
		    JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(0, 10, 398, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			contentPane.add(tituloPagina);
	
		    JLabel lblNewLabel = new JLabel("Informe nome da hospedagem");
		    lblNewLabel.setForeground(new Color(0, 0, 0));
		    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel.setBounds(30, 93, 200, 20);
		    contentPane.add(lblNewLabel);
	
		    textFieldCpf = new JTextField();
		    textFieldCpf.setForeground(new Color(128, 128, 128));
		    textFieldCpf.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    textFieldCpf.setBounds(30, 119, 358, 30);
		    contentPane.add(textFieldCpf);
		    textFieldCpf.setColumns(10);
	
		    JButton btnNewButton = new JButton("Confirmar");
		    btnNewButton.setForeground(new Color(255, 255, 255));
		    btnNewButton.setBackground(new Color(70, 130, 180));
		    btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    btnNewButton.setBounds(24, 188, 112, 30);
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String nomeHosp = textFieldCpf.getText();
		            C4 frame = new C4(nomeHosp);
		            frame.setVisible(true);
		            dispose();
		    	}
		    });
		    contentPane.add(btnNewButton);	
		    
		    JLabel rodape_1 = new JLabel("FLY Turismo");
		    rodape_1.setHorizontalAlignment(SwingConstants.CENTER);
		    rodape_1.setForeground(new Color(70, 130, 180));
		    rodape_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    rodape_1.setBounds(272, 188, 136, 37);
		    contentPane.add(rodape_1);
		    
		    JLabel lblNewLabel_1 = new JLabel("_______________________________________");
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setForeground(Color.BLACK);
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel_1.setBounds(10, 42, 408, 20);
		    contentPane.add(lblNewLabel_1);
		}
	}

//	class cons4 extends JFrame{
//		private JPanel contentPane;
//		private JTable table;
//		private JTable table_1;
//		
//		public cons4() {
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			setBounds(100, 100, 830, 600);
//			contentPane = new JPanel();
//			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//			
//			setContentPane(contentPane);
//			contentPane.setLayout(null);
//			
//			JLabel iconePrincipal = new JLabel("");
//			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
//			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
//			iconePrincipal.setBounds(37, 19, 102, 100);
//			contentPane.add(iconePrincipal);
//			
//			
//			JLabel tituloPagina = new JLabel("Relatório - consultas");
//			tituloPagina.setBounds(71, 47, 665, 49);
//			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
//			tituloPagina.setForeground(new Color(70, 130, 180));
//			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
//			contentPane.add(tituloPagina);
//			
//			JLabel subtitulo = new JLabel("Servoços disponíveis");
//			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
//			subtitulo.setForeground(new Color(128, 128, 128));
//			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
//			subtitulo.setBounds(149, 95, 510, 24);
//			contentPane.add(subtitulo);
//			
//			JLabel rodape = new JLabel("FLY Turismo");
//			rodape.setBounds(670, 516, 136, 37);
//			rodape.setForeground(new Color(70, 130, 180));
//			rodape.setHorizontalAlignment(SwingConstants.CENTER);
//			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
//			contentPane.add(rodape);
//			
//			JButton btnVoltar= new JButton("Voltar");
//			btnVoltar.setBounds(37, 516, 111, 29);
//			btnVoltar.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					relatorio relatorio = new relatorio();
//					relatorio.setVisible(true);
//			        dispose();
//				}
//			});
//			btnVoltar.setBackground(new Color(70, 130, 180));
//			btnVoltar.setForeground(new Color(255, 255, 255));
//			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
//			contentPane.add(btnVoltar);
//			
//			
//			JScrollPane scrollPane = new JScrollPane();
//			scrollPane.setBounds(128, 161, 562, 295);
//			contentPane.add(scrollPane);
//			
//			table = new JTable();
//			scrollPane.setViewportView(table);
//			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//			table.setModel(new DefaultTableModel(
//				new Object[][] {
//				},
//				new String[] {
//					"Código destino", "Nome"
//				}
//			) {
//				Class[] columnTypes = new Class[] {
//					int.class, String.class, String.class, String.class
//				};
//				public Class getColumnClass(int columnIndex) {
//					return columnTypes[columnIndex];
//				}
//			});
//			table.setBackground(new Color(220, 232, 241));
//			
//			DefaultTableModel model = (DefaultTableModel) table.getModel();
//			try {
//				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
//				String selecionar = "SELECT cod_destino, nome FROM hospedagem;";
//				Statement statement = (Statement)connection.createStatement();
//				ResultSet resp = statement.executeQuery(selecionar);
//				while(resp.next()) {
//					model.addRow(new Object[] {resp.getString("cod_destino"), resp.getString("nome")});
//				}
//					
//			} catch(SQLException e){
//				e.printStackTrace();
//			}
//		}
//	}
	
	class cons5 extends JFrame{
		private JPanel contentPane;
		private JTextField textFieldCpf;
		
		public cons5() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 432, 276);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		    
		    JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(0, 10, 398, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			contentPane.add(tituloPagina);

		    JLabel lblNewLabel = new JLabel("Informe o CPF do agente:");
		    lblNewLabel.setForeground(new Color(0, 0, 0));
		    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel.setBounds(30, 93, 200, 20);
		    contentPane.add(lblNewLabel);

		    textFieldCpf = new JTextField();
		    textFieldCpf.setForeground(new Color(128, 128, 128));
		    textFieldCpf.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    textFieldCpf.setBounds(30, 119, 358, 30);
		    contentPane.add(textFieldCpf);
		    textFieldCpf.setColumns(10);

		    JButton btnNewButton = new JButton("Confirmar");
		    btnNewButton.setForeground(new Color(255, 255, 255));
		    btnNewButton.setBackground(new Color(70, 130, 180));
		    btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    btnNewButton.setBounds(24, 188, 112, 30);
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String cpfAgente = textFieldCpf.getText();
		            C5 frame = new C5(cpfAgente);
		            frame.setVisible(true);
		            dispose();
		    	}
		    });
		    contentPane.add(btnNewButton);	
		    
		    JLabel rodape_1 = new JLabel("FLY Turismo");
		    rodape_1.setHorizontalAlignment(SwingConstants.CENTER);
		    rodape_1.setForeground(new Color(70, 130, 180));
		    rodape_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    rodape_1.setBounds(272, 188, 136, 37);
		    contentPane.add(rodape_1);
		    
		    JLabel lblNewLabel_1 = new JLabel("_______________________________________");
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setForeground(Color.BLACK);
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel_1.setBounds(10, 42, 408, 20);
		    contentPane.add(lblNewLabel_1);
		}

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						cons5 frame = new cons5();
		                frame.setVisible(true);
		            } catch (Exception e) {
		            	e.printStackTrace();
		            }
				}
			});
		}
	}
	
	class cons6 extends JFrame{
		private JPanel contentPane;
		private JTextField textFieldCpf;
		public cons6() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 432, 276);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		    
		    JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(0, 10, 398, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			contentPane.add(tituloPagina);

		    JLabel lblNewLabel = new JLabel("Informe o cod do destino:");
		    lblNewLabel.setForeground(new Color(0, 0, 0));
		    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel.setBounds(30, 93, 200, 20);
		    contentPane.add(lblNewLabel);

		    textFieldCpf = new JTextField();
		    textFieldCpf.setForeground(new Color(128, 128, 128));
		    textFieldCpf.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    textFieldCpf.setBounds(30, 119, 358, 30);
		    contentPane.add(textFieldCpf);
		    textFieldCpf.setColumns(10);

		    JButton btnNewButton = new JButton("Confirmar");
		    btnNewButton.setForeground(new Color(255, 255, 255));
		    btnNewButton.setBackground(new Color(70, 130, 180));
		    btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    btnNewButton.setBounds(24, 188, 112, 30);
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String codDestino = textFieldCpf.getText();
		            C6 frame = new C6(codDestino);
		            frame.setVisible(true);
		            dispose();
		    	}
		    });
		    contentPane.add(btnNewButton);	
		    
		    JLabel rodape_1 = new JLabel("FLY Turismo");
		    rodape_1.setHorizontalAlignment(SwingConstants.CENTER);
		    rodape_1.setForeground(new Color(70, 130, 180));
		    rodape_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    rodape_1.setBounds(272, 188, 136, 37);
		    contentPane.add(rodape_1);
		    
		    JLabel lblNewLabel_1 = new JLabel("_______________________________________");
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setForeground(Color.BLACK);
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    lblNewLabel_1.setBounds(10, 42, 408, 20);
		    contentPane.add(lblNewLabel_1);
		}

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						cons6 frame = new cons6();
		                frame.setVisible(true);
		            } catch (Exception e) {
		            	e.printStackTrace();
		            }
				}
			});
		}
	}
	


	class C1 extends JFrame{
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		
		public C1() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel("Clientes que ainda não fizeram uma viagem");
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(128, 161, 562, 295);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CPF", "Nome"
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
				String selecionar = "SELECT CPF,nome FROM cliente c LEFT JOIN viagem v ON c.CPF = v.cpf_cliente WHERE v.cpf_cliente IS NULL;";
				Statement statement = (Statement)connection.createStatement();
				ResultSet resp = statement.executeQuery(selecionar);
				while(resp.next()) {
					model.addRow(new Object[] {resp.getString("CPF"), resp.getString("nome")});
				}
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	class C2 extends JFrame{
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		
		public C2() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel("Todos os emails dos clientes cadastrados");
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(128, 161, 562, 295);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Email"
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
				String selecionar = "SELECT c.nome, e.email FROM cliente c JOIN email e ON e.cpf_pessoa = cpf;";
				Statement statement = (Statement)connection.createStatement();
				ResultSet resp = statement.executeQuery(selecionar);
				while(resp.next()) {
					model.addRow(new Object[] {resp.getString("nome"), resp.getString("email")});
				}
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	class C3 extends JFrame{
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		
		public C3() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel("Todas as hospedagens disponíveis");
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(128, 161, 562, 295);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nome", "Cidade", "Estado", "País"
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
				String selecionar = "SELECT h.nome, d.cidade, d.estado, d.pais FROM hospedagem h JOIN destino d ON d.codigo = h.cod_destino;";
				Statement statement = (Statement)connection.createStatement();
				ResultSet resp = statement.executeQuery(selecionar);
				while(resp.next()) {
					model.addRow(new Object[] {resp.getString("nome"), resp.getString("cidade"), resp.getString("estado"), resp.getString("pais")});
				}
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	class C4 extends JFrame{
		private JPanel contentPane;
		private String nomeDestino;
		private JTable table;
		private JTable table_1;
		
		public C4(String nomeHosp) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel();
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(108, 140, 696, 317);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setRowSelectionAllowed(false);
			scrollPane.setViewportView(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Hospedagem", "Serviços"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, List.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.setBackground(new Color(220, 232, 241));
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
				String exibirClienteDestino = "SELECT h.nome, s.servico\r\n"
						+ "FROM Hospedagem h\r\n"
						+ "INNER JOIN Servico s ON h.cod_destino = s.cod_destino AND h.nome = s.nome_hosp\r\n"
						+ "WHERE h.nome = ?;";
				 try (PreparedStatement statement = connection.prepareStatement(exibirClienteDestino)) {
					 statement.setString(1, nomeHosp);
					 
					 try (ResultSet resp = statement.executeQuery()) {
						 while (resp.next()) {
							 model.addRow(new Object[]{resp.getString("h.nome"), resp.getString("s.servico")});
						 }
					 }
				 }
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	/*class C4 extends JFrame{
		private JPanel contentPane;
		private JTable table;
		private JTable table_1;
		
		public C4() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel("Serviços disponíveis");
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(211, 211, 211));
			panel.setBounds(382, 158, 361, 319);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel subtitulo_1 = new JLabel("Serviços disponíveis");
			subtitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo_1.setForeground(new Color(105, 105, 105));
			subtitulo_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			subtitulo_1.setBounds(10, 10, 341, 24);
			panel.add(subtitulo_1);
			
			JLabel hospedagem = new JLabel("Hospedagem:");
			hospedagem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			hospedagem.setBounds(62, 158, 290, 37);
			contentPane.add(hospedagem);
			
			JLabel nomeHosp = new JLabel();
			nomeHosp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			nomeHosp.setBounds(62, 192, 290, 37);
			contentPane.add(nomeHosp);
			
			JLabel cidade = new JLabel("Cidade:");
			cidade.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cidade.setBounds(62, 251, 290, 37);
			contentPane.add(cidade);
			
			JLabel cidadeHosp = new JLabel();
			cidadeHosp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			cidadeHosp.setBounds(62, 282, 290, 37);
			contentPane.add(cidadeHosp);
			
			JLabel pais = new JLabel("País:");
			pais.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			pais.setBounds(62, 407, 290, 37);
			contentPane.add(pais);
			
			JLabel paisHosp = new JLabel();
			paisHosp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			paisHosp.setBounds(62, 440, 290, 37);
			contentPane.add(paisHosp);
			
			JLabel estado = new JLabel("Estado:");
			estado.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			estado.setBounds(62, 327, 290, 37);
			contentPane.add(estado);
			
			JLabel estadoHosp = new JLabel();
			estadoHosp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			estadoHosp.setBounds(62, 357, 290, 37);
			contentPane.add(estadoHosp);
			
			
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
				String selecionar = "SELECT h.nome, s.serviço\r\n"
						+ "FROM Hospedagem h\r\n"
						+ "INNER JOIN Serviço s ON h.cod_destino = s.cod_destino AND h.nome = s.nome_hosp\r\n"
						+ "WHERE h.nome = ?;";
				Statement statement = (Statement)connection.createStatement();
				ResultSet resp = statement.executeQuery(selecionar);
				
				 List<String>servicos = new ArrayList<>();
				List<String>hosp = new ArrayList<>();
				List<List<String>>hospedagemS = new ArrayList<>();
				
				while(resp.next()) {
					servicos = new ArrayList<>();
					hosp = new ArrayList<>();
					
					hosp.add(resp.getString("nome"));
					hosp.add(resp.getString("cidade"));
					hosp.add(resp.getString("estado"));
					hosp.add(resp.getString("pais"));
					servicos.add(resp.getString("servico"));
					hospedagemS.add(hosp);
					hospedagemS.add(servicos);
				}
				//System.out.println(hospedagemS);
				
				for(List<String> item : hospedagemS) {
					
				}
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	} 
	*/
	
	class C5 extends JFrame{
		private JPanel contentPane;
		private String cpfAgente;
		private JTable table;
		private JTable table_1;
		
		public C5(String cpfAgente) {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 905, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setBounds(37, 19, 102, 100);
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			contentPane.add(iconePrincipal);
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(100, 47, 685, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel("Viagens vendidas pelo(a) ..." );
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(310, 94, 248, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(745, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 502, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(108, 140, 696, 317);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setRowSelectionAllowed(false);
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
				String exibirViagem = "select cpf_cliente, cod_destino, nome_hosp, data_ida, data_volta from viagem where cpf_agente = ?;";
				 try (PreparedStatement statement = connection.prepareStatement(exibirViagem)) {
					 statement.setString(1, cpfAgente);
					 
					 try (ResultSet resp = statement.executeQuery()) {
						 while (resp.next()) {
							 model.addRow(new Object[]{resp.getString("cpf_cliente"), resp.getInt("cod_destino"),
				             resp.getString("nome_hosp"), resp.getString("data_ida"), resp.getString("data_volta")});
						 }
					 }
				 }
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	class C6 extends JFrame{
		private JPanel contentPane;
		private String codDestino;
		private JTable table;
		private JTable table_1;
		
		public C6(String codDestino) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 830, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			
			JLabel tituloPagina = new JLabel("Relatório - consultas");
			tituloPagina.setBounds(71, 47, 665, 49);
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel();
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(149, 95, 510, 24);
			contentPane.add(subtitulo);
			
			JLabel rodape = new JLabel("FLY Turismo");
			rodape.setBounds(670, 516, 136, 37);
			rodape.setForeground(new Color(70, 130, 180));
			rodape.setHorizontalAlignment(SwingConstants.CENTER);
			rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contentPane.add(rodape);
			
			JButton btnVoltar= new JButton("Voltar");
			btnVoltar.setBounds(37, 516, 111, 29);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					relatorio relatorio = new relatorio();
					relatorio.setVisible(true);
			        dispose();
				}
			});
			btnVoltar.setBackground(new Color(70, 130, 180));
			btnVoltar.setForeground(new Color(255, 255, 255));
			btnVoltar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			contentPane.add(btnVoltar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(108, 140, 696, 317);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setRowSelectionAllowed(false);
			scrollPane.setViewportView(table);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cliente", "Hospedagem", "Destino", "Data de Ida", "Data de Volta"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, int.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.setBackground(new Color(220, 232, 241));
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
				String exibirClienteDestino = "SELECT Cliente.nome, Hospedagem.nome, Viagem.cod_destino, Viagem.data_ida, Viagem.data_volta FROM Cliente JOIN Viagem ON Cliente.CPF = Viagem.cpf_cliente JOIN Hospedagem ON Viagem.cod_destino = Hospedagem.cod_destino WHERE Viagem.cod_destino = ?;";
				 try (PreparedStatement statement = connection.prepareStatement(exibirClienteDestino)) {
					 statement.setString(1, codDestino);
					 
					 try (ResultSet resp = statement.executeQuery()) {
						 while (resp.next()) {
							 model.addRow(new Object[]{resp.getString("Cliente.nome"), resp.getString("Hospedagem.nome"), resp.getInt("Viagem.cod_destino"),
				             resp.getString("Viagem.data_ida"), resp.getString("Viagem.data_volta")});
						 }
					 }
				 }
					
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
			
	