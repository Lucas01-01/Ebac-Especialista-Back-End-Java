package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.Pessoa;
import service.PessoaService;

public class CadastroGUI extends JFrame {
    private PessoaService service = new PessoaService();
    private JTextField nomeField, emailField, idField;
    private JTextArea listaArea;

    public CadastroGUI() {
        setTitle("Cadastro CRUD - Swing");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Dados da Pessoa"));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Cadastrar");
        JButton updateButton = new JButton("Atualizar");
        JButton deleteButton = new JButton("Deletar");
        JButton listButton = new JButton("Listar");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        listaArea = new JTextArea();
        listaArea.setEditable(false);
        add(new JScrollPane(listaArea), BorderLayout.SOUTH);

        addButton.addActionListener(e -> cadastrar());
        updateButton.addActionListener(e -> atualizar());
        deleteButton.addActionListener(e -> deletar());
        listButton.addActionListener(e -> listar());
    }

    private void cadastrar() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        if (nome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }
        service.cadastrarPessoa(nome, email);
        JOptionPane.showMessageDialog(this, "Pessoa cadastrada!");
        limparCampos();
        listar();
    }

    private void atualizar() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nome = nomeField.getText();
            String email = emailField.getText();
            if (service.atualizarPessoa(id, nome, email)) {
                JOptionPane.showMessageDialog(this, "Pessoa atualizada!");
            } else {
                JOptionPane.showMessageDialog(this, "Pessoa não encontrada!");
            }
            listar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido!");
        }
    }

    private void deletar() {
        try {
            int id = Integer.parseInt(idField.getText());
            if (service.deletarPessoa(id)) {
                JOptionPane.showMessageDialog(this, "Pessoa deletada!");
            } else {
                JOptionPane.showMessageDialog(this, "Pessoa não encontrada!");
            }
            listar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido!");
        }
    }

    private void listar() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : service.listarPessoas()) {
            sb.append(p).append("\n");
        }
        listaArea.setText(sb.toString());
    }

    private void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CadastroGUI().setVisible(true);
        });
    }
}
