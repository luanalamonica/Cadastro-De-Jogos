package consultaproduto;
import javax.swing.SwingUtilities;

// Classe principal que inicia o programa
public class Main {
public static void main(String[] args) {
// Cria e exibe a janela de inserção de produtos na thread de despacho de
eventos
SwingUtilities.invokeLater(() -&gt; new InserirProduto());
}
}