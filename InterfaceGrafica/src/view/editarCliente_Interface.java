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

public class editarCliente_Interface extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarCliente_Interface frame = new editarCliente_Interface();
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
	public editarCliente_Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel iconePrincipal = new JLabel("");
		iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
		iconePrincipal.setBounds(37, 19, 102, 100);
		contentPane.add(iconePrincipal);
		
		JLabel tituloPagina = new JLabel("Editar cliente");
		tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPagina.setForeground(new Color(70, 130, 180));
		tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		tituloPagina.setBounds(120, 46, 665, 49);
		contentPane.add(tituloPagina);
		
		JLabel rodape = new JLabel("FLY Turismo");
		rodape.setForeground(new Color(70, 130, 180));
		rodape.setHorizontalAlignment(SwingConstants.CENTER);
		rodape.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rodape.setBounds(759, 516, 136, 37);
		contentPane.add(rodape);
		
		JButton btnVoltar= new JButton("Voltar");
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
		btnVoltar.setBounds(37, 502, 111, 29);
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
		
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				String cpf = model.getValueAt(row, 0).toString();
				String nome = model.getValueAt(row, 1).toString();
				
				editarDados(cpf, nome);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setBounds(400, 453, 102, 29);
		contentPane.add(btnNewButton);
	}
	
	private void editarDados(String cpf, String nome) {
        EdicaoCliente edicaoCliente = new EdicaoCliente(cpf, nome);
        edicaoCliente.setVisible(true);
    }
}

	class EdicaoCliente extends JFrame {
	    private JTextField textFieldNome;
	    private JTextField textFieldOutroDado;
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
		
	
	    public EdicaoCliente(String cpf, String nome) {
	    	setBounds(80, 80, 900, 570);
	        JPanel contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	
			JLabel iconePrincipal = new JLabel("");
			iconePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			iconePrincipal.setIcon(new ImageIcon(login_Interface.class.getResource("/view/aviaomodificado.png")));
			iconePrincipal.setBounds(37, 19, 102, 100);
			contentPane.add(iconePrincipal);
			
			JLabel tituloPagina = new JLabel("Editar cliente");
			tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
			tituloPagina.setForeground(new Color(70, 130, 180));
			tituloPagina.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
			tituloPagina.setBounds(120, 46, 665, 49);
			contentPane.add(tituloPagina);
			
			JLabel subtitulo = new JLabel(nome);
			subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			subtitulo.setForeground(new Color(128, 128, 128));
			subtitulo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			subtitulo.setBounds(274, 95, 348, 24);
			contentPane.add(subtitulo);
			
	
	        JLabel Nome = new JLabel("Nome:");
			Nome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Nome.setBounds(70, 180, 57, 20);
			contentPane.add(Nome);
			
			campoNome = new JTextField("");
			campoNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoNome.setColumns(10);
			campoNome.setBounds(70, 203, 381, 29);
			contentPane.add(campoNome);
			
			
			JLabel Email = new JLabel("Email:");
			Email.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Email.setBounds(70, 242, 78, 20);
			contentPane.add(Email);
			
			campoEmail = new JTextField("");
			campoEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoEmail.setColumns(10);
			campoEmail.setBounds(70, 264, 381, 29);
			contentPane.add(campoEmail);
			
			
			JLabel DataDeNascimento = new JLabel("Data de nascimento:");
			DataDeNascimento.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			DataDeNascimento.setBounds(70, 310, 180, 20);
			contentPane.add(DataDeNascimento);
			
			campoNascimento = new JTextField("");
			campoNascimento.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoNascimento.setColumns(10);
			campoNascimento.setBounds(70, 332, 208, 29);
			contentPane.add(campoNascimento);
			
			SimpleDateFormat dataNascimento = new SimpleDateFormat(campoNascimento.getText());
			
			
			JLabel Telefone = new JLabel("Telefone 1:");
			Telefone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Telefone.setBounds(70, 378, 180, 20);
			contentPane.add(Telefone);
			
			campoTelefone1 = new JTextField("");
			campoTelefone1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoTelefone1.setColumns(10);
			campoTelefone1.setBounds(70, 397, 180, 29);
			contentPane.add(campoTelefone1);
			
			
			JLabel Telefone_2 = new JLabel("Telefone 2:");
			Telefone_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
			Telefone_2.setBounds(271, 378, 180, 20);
			contentPane.add(Telefone_2);
			
			campoTelefone2 = new JTextField("");
			campoTelefone2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			campoTelefone2.setColumns(10);
			campoTelefone2.setBounds(271, 398, 180, 29);
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
	
	        JButton btnSave = new JButton("Salvar");
	        btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                atualizarDados(cpf);
	                EdicaoCliente frame = new EdicaoCliente("a", "nome");
	                frame.setVisible(false);
	                editarCliente_Interface frame2 = new editarCliente_Interface();
					frame2.setVisible(true);
	                
	                
	            }
	        });	        
	        btnSave.setBackground(new Color(70, 130, 180));
	        btnSave.setForeground(new Color(255, 255, 255));
	        btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	        btnSave.setBounds(37, 470, 111, 29);
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
			btnCancelar.setBounds(170, 470, 111, 29);
			contentPane.add(btnCancelar);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setBounds(533, 145, 321, 320);
			contentPane.add(panel);
	    }

		
	    private void atualizarDados(String cpf) {
	        String novoNome = campoNome.getText();
	        String novoEmail = campoEmail.getText();
	        String novaDataNascimento = campoNascimento.getText();
	        String novoTelefone1 = campoTelefone1.getText();
	        String novoTelefone2 = campoTelefone2.getText();
	        String novoLogradouro = campoLog.getText();
	        String novoNumero = campoNro.getText();
	        String novaCidade = campoCidade.getText();
	        String novoBairro = campoBairro.getText();
	        String novoPais = campoPais.getText();
	        String novoEstado = campoEstado.getText();

	        try {
	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "Felix102030_");
	            connection.setAutoCommit(false); 

	            String updatePessoaQuery = "UPDATE cliente SET nome = ?, data_nasc = ?, log = ?, nro = ?, cidade = ?, bairro = ?, pais = ?, estado = ? WHERE cpf = ?";
	            PreparedStatement pessoaStatement = connection.prepareStatement(updatePessoaQuery);
	            pessoaStatement.setString(1, novoNome);
	            pessoaStatement.setString(2, novaDataNascimento);
	            pessoaStatement.setString(3, novoLogradouro);
	            pessoaStatement.setString(4, novoNumero);
	            pessoaStatement.setString(5, novaCidade);
	            pessoaStatement.setString(6, novoBairro);
	            pessoaStatement.setString(7, novoPais);
	            pessoaStatement.setString(8, novoEstado);
	            pessoaStatement.setString(9, cpf);
	            pessoaStatement.executeUpdate();

	            PreparedStatement stmt;
	            stmt = (PreparedStatement) connection.prepareStatement("DELETE FROM telefone WHERE cpf_pessoa = ?");
	            stmt.setString(1, cpf);
	            stmt.executeUpdate();
	            
	            String updateTelefoneQuery = "INSERT INTO telefone VALUES ('" + cpf + "','" + campoTelefone1.getText() + "');";
	            String updateTelefone2Query = "INSERT INTO telefone VALUES ('" + cpf + "','" + campoTelefone2.getText() + "');";

	            Statement statement = (Statement)connection.createStatement();
				((java.sql.Statement) statement).executeUpdate(updateTelefoneQuery);
				((java.sql.Statement) statement).executeUpdate(updateTelefone2Query);

	            String updateEmailQuery = "UPDATE email SET email = ? WHERE cpf_pessoa = ?";
	            PreparedStatement emailStatement = connection.prepareStatement(updateEmailQuery);
	            emailStatement.setString(1, novoEmail);
	            emailStatement.setString(2, cpf);
	            emailStatement.executeUpdate();

	            connection.commit();

	            connection.setAutoCommit(true);

	            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do cliente.");
	        }
	    }
}
