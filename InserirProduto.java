package consultaproduto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe responsável pela janela de inserção de jogos
public class InserirProduto extends JFrame {
// Campos de texto e botão para inserção dos dados do jogo
private JTextField campoTitulo;
private JTextField campoGenero;
private JTextField campoPlataforma;
private JTextField campoPreco;

private JTextField campoQuantidade;
private JButton botaoInserir;

// Construtor da classe que configura a interface gráfica
public InserirProduto() {
super(&quot;Inserir Jogo&quot;); // Título da janela

// Inicializa os campos de texto e o botão
campoTitulo = new JTextField(20);
campoGenero = new JTextField(20);
campoPlataforma = new JTextField(20);
campoPreco = new JTextField(10);
campoQuantidade = new JTextField(5);
botaoInserir = new JButton(&quot;Inserir&quot;);

// Define o layout da janela e adiciona os componentes
setLayout(new GridLayout(6, 2));
add(new JLabel(&quot;Título:&quot;));
add(campoTitulo);
add(new JLabel(&quot;Gênero:&quot;));
add(campoGenero);
add(new JLabel(&quot;Plataforma:&quot;));
add(campoPlataforma);
add(new JLabel(&quot;Preço:&quot;));
add(campoPreco);
add(new JLabel(&quot;Quantidade:&quot;));
add(campoQuantidade);
add(botaoInserir);

// Adiciona um listener para o botão de inserção
botaoInserir.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
inserirJogo(); // Chama o método para inserir o jogo no banco de dados
}
});

// Configurações da janela
setSize(300, 250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

// Método que insere o jogo no banco de dados
private void inserirJogo() {
String titulo = campoTitulo.getText();
String genero = campoGenero.getText();
String plataforma = campoPlataforma.getText();
String preco = campoPreco.getText();
String quantidade = campoQuantidade.getText();

// Tenta estabelecer a conexão e inserir o jogo
try (Connection conexao = ConexaoBD.getConexao()) {
// Comando SQL para inserção
String sql = &quot;INSERT INTO jogos (titulo, genero, plataforma, preco, quantidade)
VALUES (?, ?, ?, ?, ?)&quot;;
PreparedStatement ps = conexao.prepareStatement(sql);
ps.setString(1, titulo);
ps.setString(2, genero);
ps.setString(3, plataforma);
ps.setString(4, preco);
ps.setInt(5, Integer.parseInt(quantidade));

ps.executeUpdate();
JOptionPane.showMessageDialog(this, &quot;Jogo inserido com sucesso!&quot;);
new MostrarResultadosConsulta(); // Abre a janela de consulta de jogos
dispose(); // Fecha a janela atual
} catch (SQLException ex) {
ex.printStackTrace();
JOptionPane.showMessageDialog(this, &quot;Erro ao inserir jogo!&quot;);
}
}
}