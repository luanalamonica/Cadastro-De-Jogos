package consultaproduto;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

// Classe responsável pela janela de consulta de jogos
public class MostrarResultadosConsulta extends JFrame {
private JTable tabela; // Tabela para exibir os resultados
private ModeloTabelaResultados modelo; // Modelo da tabela

// Construtor da classe que configura a interface gráfica
public MostrarResultadosConsulta() {
super(&quot;Consulta de Jogos&quot;); // Título da janela

modelo = new ModeloTabelaResultados();
tabela = new JTable(modelo);

// Define o layout da janela e adiciona a tabela dentro de um JScrollPane

setLayout(new BorderLayout());
add(new JScrollPane(tabela), BorderLayout.CENTER);

// Configurações da janela
setSize(800, 600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

carregarDados(); // Chama o método para carregar os dados do banco de dados
}

// Método que carrega os dados do banco de dados
private void carregarDados() {
// Tenta estabelecer a conexão e realizar a consulta
try (Connection conexao = ConexaoBD.getConexao()) {
String consulta = &quot;SELECT * FROM jogos&quot;; // Comando SQL para consulta
Statement declaracao = conexao.createStatement();
ResultSet resultados = declaracao.executeQuery(consulta);
modelo.setResultSet(resultados); // Define o ResultSet no modelo da tabela
} catch (SQLException e) {
e.printStackTrace();
}
}
}