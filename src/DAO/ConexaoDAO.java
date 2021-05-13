//Classe de conexão ao banco de dados.
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    //Método que conecta o Java ao banco de dados.
    public Connection conector() {
        //Cria e inicializa a variável conn.
        Connection conn = null;

        try {
            //Passa as informações do banco de dados para a variável url.
            String url = "jdbc:mysql://localhost:3306/db_cadastro_anuncios?user=root&password=";
            //Faz a conexão com o banco de dados passando a variável url e armazenando na variável conn.
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            //Abri uma janela que informa a exceção gerada.
            JOptionPane.showMessageDialog(null, "ConexãoDAO" + erro.getMessage());
        }
        return conn;
    }
}
