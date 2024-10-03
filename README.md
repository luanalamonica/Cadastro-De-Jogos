Cadastro de Jogos (Java + MySQL)
Este projeto é uma aplicação Java Swing que permite realizar o cadastro de jogos, armazenando-os em um banco de dados MySQL. A aplicação utiliza JTable para exibir os dados e oferece funcionalidades como inserção e consulta de registros.

Funcionalidades
Cadastro de Jogos: O usuário pode inserir novos jogos, informando o nome, categoria, desenvolvedor e data de lançamento.
Consulta de Jogos: Exibe todos os jogos cadastrados diretamente de uma tabela no banco de dados MySQL.
Interface Amigável: A interface foi desenvolvida utilizando componentes Swing, como JLabel, JTextField, JButton e JTable, proporcionando uma experiência intuitiva.
Tecnologias Utilizadas
Java (Swing): Para criação da interface gráfica (GUI).
MySQL: Banco de dados relacional para armazenar os jogos cadastrados.
JDBC (Java Database Connectivity): Para realizar a conexão e interações com o banco de dados.
Pré-requisitos
Antes de executar o projeto, você precisará ter instalado:

Java JDK (versão 8 ou superior)
MySQL (ou qualquer outro banco de dados compatível com JDBC)
Connector/J (biblioteca JDBC para conectar o Java ao MySQL)
Configuração do Banco de Dados
Crie um banco de dados no MySQL:

sql
Copiar código
CREATE DATABASE cadastro_jogos;
Crie a tabela para armazenar os dados dos jogos:

sql
Copiar código
CREATE TABLE jogos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    desenvolvedor VARCHAR(50),
    data_lancamento DATE
);
Insira as informações de conexão no código Java:

No arquivo src/ConnectionFactory.java, configure o usuário, senha e URL do banco de dados:
java
Copiar código
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost/cadastro_jogos", "usuario", "senha");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
Instruções de Uso
1. Tela de Cadastro de Jogos
Na primeira tela, o usuário pode inserir os detalhes do jogo:

Nome do Jogo
Categoria
Desenvolvedor
Data de Lançamento
Ao preencher as informações, basta clicar em Cadastrar para salvar os dados no banco.



2. Confirmação de Cadastro
Após a inserção bem-sucedida, o sistema exibe uma mensagem de confirmação. Os dados são gravados no banco de dados MySQL.



3. Consulta de Jogos Cadastrados
Nesta tela, o sistema exibe todos os jogos cadastrados em uma JTable, trazendo os dados diretamente do banco de dados.



Como Executar o Projeto
Clone este repositório:

bash
Copiar código
git clone https://github.com/luanalamonica/Cadastro-De-Jogos.git
Importe o projeto em sua IDE Java favorita (como IntelliJ IDEA ou Eclipse).

Compile e execute o projeto.

Utilize a interface gráfica para inserir e consultar os jogos.

Estrutura do Projeto
src/ - Contém os arquivos Java do projeto.
ConnectionFactory.java - Responsável pela conexão com o banco de dados.
JogoDAO.java - Implementa as operações CRUD (Create, Read, Update, Delete) para a tabela de jogos.
Main.java - Inicializa a interface gráfica (telas) e integra as funcionalidades.
Melhorias Futuras
Implementar funcionalidades de edição e exclusão de jogos.
Adicionar tratamento de erros e validação de dados nos formulários.
Implementar filtros de pesquisa para facilitar a consulta de jogos.
Desenvolver testes automatizados para as funcionalidades principais.
Contribuições
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades! Para contribuir, siga os passos:

Faça um fork do projeto.
Crie uma nova branch para suas alterações (git checkout -b feature/nova-funcionalidade).
Envie suas alterações para o repositório (git push origin feature/nova-funcionalidade).
Abra um pull request para revisão.
