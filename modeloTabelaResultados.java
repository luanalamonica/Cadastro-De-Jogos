package consultaproduto;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

// Classe que modela os resultados da consulta em uma tabela
public class ModeloTabelaResultados extends AbstractTableModel {
private List&lt;Object[]&gt; dados; // Lista para armazenar os dados das linhas
private String[] colunas; // Array para armazenar os nomes das colunas

// Construtor da classe que inicializa a lista de dados
public ModeloTabelaResultados() {
dados = new ArrayList&lt;&gt;();
}

// Método que define o ResultSet para o modelo
public void setResultSet(ResultSet resultados) {
try {
// Obtém os metadados do ResultSet para extrair o número e nomes das
colunas
ResultSetMetaData metadados = resultados.getMetaData();
int numeroDeColunas = metadados.getColumnCount();
colunas = new String[numeroDeColunas];

for (int i = 0; i &lt; numeroDeColunas; i++) {
colunas[i] = metadados.getColumnName(i + 1);
}

// Limpa a lista de dados e preenche com os resultados da consulta
dados.clear();
while (resultados.next()) {
Object[] linha = new Object[numeroDeColunas];
for (int i = 0; i &lt; numeroDeColunas; i++) {

linha[i] = resultados.getObject(i + 1);
}
dados.add(linha);
}

fireTableStructureChanged(); // Notifica a tabela sobre a mudança na estrutura
} catch (SQLException e) {
e.printStackTrace();
}
}

// Método que retorna o número de linhas da tabela
@Override
public int getRowCount() {
return dados.size();
}

// Método que retorna o número de colunas da tabela
@Override
public int getColumnCount() {
if (colunas == null) {
return 0;
}
return colunas.length;
}

// Método que retorna o valor de uma célula específica
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
return dados.get(rowIndex)[columnIndex];
}

// Método que retorna o nome de uma coluna específica
@Override
public String getColumnName(int column) {
if (colunas == null) {
return &quot;&quot;;
}
return colunas[column];
}
}