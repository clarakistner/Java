package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JTextField textFieldCodigo;
	private JTextField textFieldPesquisa;
	private JTextField textFieldCaixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		lblNome.setBounds(24, 74, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Arial", Font.BOLD, 15));
		lblPreco.setBounds(24, 99, 46, 14);
		contentPane.add(lblPreco);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(102, 72, 245, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(102, 97, 245, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Código:\r\n\t\t\r\n\r\n\r\n");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCodigo.setBounds(24, 46, 55, 20);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(102, 47, 245, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblPesquisa = new JLabel("Consulte:");
		lblPesquisa.setFont(new Font("Arial", Font.BOLD, 15));
		lblPesquisa.setBounds(24, 160, 68, 14);
		contentPane.add(lblPesquisa);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(94, 158, 182, 20);
		contentPane.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(279, 157, 68, 23);
		contentPane.add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExcluir.setBounds(350, 157, 68, 23);
		contentPane.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditar.setBounds(423, 157, 61, 23);
		contentPane.add(btnEditar);
		
		textFieldCaixa = new JTextField();
		textFieldCaixa.setBounds(24, 206, 460, 311);
		contentPane.add(textFieldCaixa);
		textFieldCaixa.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(383, 71, 101, 23);
		contentPane.add(btnCadastrar);
		
		
		btnCadastrar.addActionListener(e -> {
		    String nome = textFieldNome.getText().trim();
		    String codigo = textFieldCodigo.getText().trim();
		    String precoStr = textFieldPreco.getText().trim();
		    float preco;

		    // Validação do nome
		    if (nome.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Informe o nome do produto", "Erro", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // Validação do código
		    if (codigo.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Informe o código do produto", "Erro", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // Validação do preço
		    if (precoStr.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Informe o preço do produto", "Erro", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    try {
		        preco = Float.parseFloat(precoStr);
		        if (preco < 0) {
		            JOptionPane.showMessageDialog(null, "O preço não pode ser negativo", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    // Atribuição aos atributos do Produto
		    Produto.nome = nome;
		    Produto.codigo = codigo;
		    Produto.preco = preco;

		    // Feedback para o usuário (opcional)
		    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		});

		btnCadastrar.addActionListener(e -> {
			String nome = textFieldNome.getText();
			//Produto codigo = Produto.buscarPorCodigo(codigo);
			String preco = textFieldPreco.getText();
			
			if (nome.trim() == null) {
				JOptionPane.showMessageDialog(null, "Produto inválido," , "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		//	if (codigo.trim())
		}); 
		
		btnBuscar.addActionListener(e -> {
			String nomeProduto = textFieldNome.getText();
			
			Produto produto = Produto.buscarPorNome(nomeProduto);
			if (produto != null) {
				String nome = textFieldNome.getText();
				String codigo = textFieldCodigo.getText();
				String preco = textFieldPreco.getText();
				String total = codigo + " | " + nome + " | " + " R$" + preco;
				
				textFieldCaixa.setText(total);
			}
			
			
			
		});
	}

}
