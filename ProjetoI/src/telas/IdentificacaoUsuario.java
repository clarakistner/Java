 package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class IdentificacaoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdentificacaoUsuario frame = new IdentificacaoUsuario();
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
	public IdentificacaoUsuario() {
		setTitle("Identificação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnNao.setBounds(24, 200, 109, 23);
		contentPane.add(rdbtnNao);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnSim.setBounds(24, 174, 56, 23);
		contentPane.add(rdbtnSim);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(93, 101, 183, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(93, 66, 183, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		lblNome.setBounds(24, 68, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.BOLD, 15));
		lblCPF.setBounds(24, 103, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblAdm = new JLabel("É administrador?");
		lblAdm.setFont(new Font("Arial", Font.BOLD, 15));
		lblAdm.setBounds(24, 150, 120, 23);
		contentPane.add(lblAdm);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastro.setBounds(185, 22, 69, 14);
		contentPane.add(lblCadastro);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Arial", Font.BOLD, 13));
		btnProximo.setBounds(174, 227, 91, 23);
		contentPane.add(btnProximo);
		
		ButtonGroup grupoAdm = new ButtonGroup();
		grupoAdm.add(rdbtnSim);
		grupoAdm.add(rdbtnNao);
		
		ArrayList<Usuario> usuarios = new ArrayList();
				
		btnProximo.addActionListener(e -> {
			
			String nome = lblNome.getText();
			String cpf = lblCPF.getText();
			String adm = rdbtnSim.isSelected() ? "Sim" :
						 rdbtnNao.isSelected() ? "Não" : "";
			
			if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite o seu nome", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (cpf.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Digite o seu CPF", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (adm.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Escolha uma opção", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Usuario.nome = nome;
			Usuario.cpf = cpf;
			Usuario.adm = adm;
			
			if (rdbtnSim.isSelected()) {
				CadastroProdutos cadastroProdutosFrame = new CadastroProdutos();
				cadastroProdutosFrame.setVisible(true);
				dispose();
			} else if (rdbtnNao.isSelected()) {
				Compra compraFrame = new Compra();
				compraFrame.setVisible(true);
				dispose();
			}
			
			
		});
		
	}
}
