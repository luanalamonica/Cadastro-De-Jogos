package consultaproduto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por gerenciar a conexão com o banco de dados
public class ConexaoBD {
// Constantes para a URL do banco de dados, usuário e senha
private static final String URL = &quot;jdbc:mysql://localhost:3306/jogosdb&quot;;
private static final String USUARIO = &quot;root&quot;;
private static final String SENHA = &quot;123&quot;;

// Método para obter a conexão com o banco de dados
public static Connection getConexao() throws SQLException {
try {
// Carrega o driver do MySQL
Class.forName(&quot;com.mysql.cj.jdbc.Driver&quot;);
} catch (ClassNotFoundException e) {

e.printStackTrace();
throw new SQLException(&quot;Driver do banco de dados não encontrado&quot;, e);
}
// Retorna a conexão estabelecida com o banco de dados
return DriverManager.getConnection(URL, USUARIO, SENHA);
}
}