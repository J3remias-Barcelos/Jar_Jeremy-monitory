package projeto.conexao;

import projeto.captura.Monitoramento;
import projeto.menu.Menu;
import projeto.Logs;
import java.sql.*;

public class Conectar {


    private String url = "jdbc:mysql://localhost:3306/NEXUS";
    private String user = "root";
    private String passwd = "01032002";

    private Logs informacoes = new Logs();
    private Menu menu = new Menu();

    private String email;
    private String pass;
    private Boolean logado;

    public Boolean Logar(String email, String pass) {
        this.email = email;
        this.pass = pass;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, user, passwd);

            Statement statement = conexao.createStatement();

            String sqlSelect = "SELECT emailCorporativo, token FROM Funcionario;";

            ResultSet resposta = statement.executeQuery(sqlSelect);

            while (resposta.next()) {
                String username = resposta.getString("emailCorporativo");
                String token = resposta.getString("token");
                Monitoramento monitoramento = new Monitoramento();

                if (this.email.equals(username) && this.pass.equals(token)) {
                    logado = true;
                    System.out.println("""
                            Login Realizado com Sucesso!
                            
                                Seja Bem-Vindo
                            """);
                    System.out.println(username);
                    monitoramento.monitor(username);

                } else {
                    logado = false;
                }
            }

            resposta.close();
            statement.close();
            conexao.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("""
                                        
                    Nenhum usuario encontrado
                                        
                    Por favor verifique as credenciais
                    """);
            logado = false;
        }
        return logado;
    }

    public Conectar DadosDisco(String modelo, Double capMax, Double usoAtual, String montagem, String endIPV4, Integer fkAlerta, Integer fkComponente, String email) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);
            String cadastro = "INSERT INTO Registro (modelo, capacidadeMax, usoAtual, montagem, enderecoIPV4, dataHora, fkAlerta, fkComponente, fkMaquina) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, (SELECT idMaquina FROM Maquina JOIN Funcionario ON Maquina.fkFuncionario = idFuncionario WHERE emailCorporativo = ?));";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, modelo);
            instrucao.setDouble(2, capMax);
            instrucao.setDouble(3, usoAtual);
            instrucao.setString(4, montagem);
            instrucao.setString(5, endIPV4);
            instrucao.setInt(6, fkAlerta);
            instrucao.setInt(7, fkComponente);
            instrucao.setString(8, email);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirProcessos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Registro (modelo, capacidadeMax, usoAtual, montagem, enderecoIPV4, dataHora, fkAlerta, fkComponente, fkMaquina) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, ?);";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirMemoria(String modelo, Double capMax, Double usoAtual, String montagem, String endIPV4, Integer fkAlerta, Integer fkComponente, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Registro (modelo, capacidadeMax, usoAtual, montagem, enderecoIPV4, dataHora, fkAlerta, fkComponente, fkMaquina) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, (SELECT idMaquina FROM Maquina JOIN Funcionario ON Maquina.fkFuncionario = idFuncionario WHERE emailCorporativo = ?));";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, modelo);
            instrucao.setDouble(2, capMax);
            instrucao.setDouble(3, usoAtual);
            instrucao.setString(4, montagem);
            instrucao.setString(5, endIPV4);
            instrucao.setInt(6, fkAlerta);
            instrucao.setInt(7, fkComponente);
            instrucao.setString(8, email);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }

    public Conectar inserirProcessador(String modelo, Double capMax, Double usoAtual, String montagem, String endIPV4, Integer fkAlerta, Integer fkComponente, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, user, passwd);

            String cadastro = "INSERT INTO Registro (modelo, capacidadeMax, usoAtual, montagem, enderecoIPV4, dataHora, fkAlerta, fkComponente, fkMaquina) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, (SELECT idMaquina FROM Maquina JOIN Funcionario ON Maquina.fkFuncionario = idFuncionario WHERE emailCorporativo = ?));";

            PreparedStatement instrucao = conexao.prepareStatement(cadastro);

            instrucao.setString(1, modelo);
            instrucao.setDouble(2, capMax);
            instrucao.setDouble(3, usoAtual);
            instrucao.setString(4, montagem);
            instrucao.setString(5, endIPV4);
            instrucao.setInt(6, fkAlerta);
            instrucao.setInt(7, fkComponente);
            instrucao.setString(8, email);

            instrucao.execute();

            instrucao.close();
            conexao.close();
        } catch (
                SQLException | ClassNotFoundException throwables) {
            System.err.println("conexao nao estabelecida");
            throwables.printStackTrace();
        }
        return null;
    }
}
