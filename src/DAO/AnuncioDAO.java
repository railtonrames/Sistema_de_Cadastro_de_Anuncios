//Classe de acesso aos dados.
package DAO;

import DTO.AnuncioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnuncioDAO {

    //Cria as variáveis de conexão e de retorno de dados.
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AnuncioDTO> lista = new ArrayList<>();

    //Método que insere os dados no banco.
    public void cadastrarAnuncio(AnuncioDTO objanunciodto) {
        //Atribui a consulta sql à variável sql.
        String sql = "INSERT INTO TB_ANUNCIO (NO_ANUNC, NO_CLIENTE, DT_INIC, DT_TERM, VL_INVST_DIA) VALUES (?, ?, ?, ?, ?)";
        //Conecta ao banco.
        conn = new ConexaoDAO().conector();

        try {
            //Prepara conexão e passa o comando sql.
            pstm = conn.prepareStatement(sql);
            //Preenche o comando sql com as informações da DTO.
            pstm.setString(1, objanunciodto.getNO_ANUNC());
            pstm.setString(2, objanunciodto.getNO_CLIENTE());
            pstm.setString(3, objanunciodto.getDT_INIC());
            pstm.setString(4, objanunciodto.getDT_TERM());
            pstm.setString(5, objanunciodto.getVL_INVST_DIA());
            //Executa o comando sql e fecha a conexão em seguida.
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !");
            pstm.close();

        } catch (SQLException erro) {
            //Exibe uma janela com o erro gerado.
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar (AnuncioDAO|Cadastrar):" + erro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Método que retorna todos os registros.
    public ArrayList<AnuncioDTO> retornaTodos() {
        //Atribui a consulta sql à variável sql.
        String sql = "SELECT ID_ANUNC, NO_ANUNC, NO_CLIENTE, DATE_FORMAT(DT_INIC, \"%d/%m/%Y\") AS DT_INIC, DATE_FORMAT(DT_TERM, \"%d/%m/%Y\") AS DT_TERM, VL_INVST_DIA, DATEDIFF(DT_TERM, DT_INIC) * VL_INVST_DIA AS VL_TOTAL FROM TB_ANUNCIO";
        //Conecta ao banco.
        conn = new ConexaoDAO().conector();

        try {
            //Prepara conexão e passa o comando sql.
            pstm = conn.prepareStatement(sql);
            //Atribui o resultado da query para a variável Resultset.
            rs = pstm.executeQuery();
            //Percorre a tabela de dados e atribui valores aos objetos do AnuncioDTO.
            while (rs.next()) {
                AnuncioDTO objanunciodto = new AnuncioDTO();
                objanunciodto.setID_ANUNC(rs.getInt("ID_ANUNC"));
                objanunciodto.setNO_ANUNC(rs.getString("NO_ANUNC"));
                objanunciodto.setNO_CLIENTE(rs.getString("NO_CLIENTE"));
                objanunciodto.setDT_INIC(rs.getString("DT_INIC"));
                objanunciodto.setDT_TERM(rs.getString("DT_TERM"));
                objanunciodto.setVL_INVST_DIA(rs.getString("VL_INVST_DIA"));
                objanunciodto.setVL_TOTAL(rs.getString("VL_TOTAL"));
                //Adiciona os objanunciodto a lista.
                lista.add(objanunciodto);
            }

        } catch (SQLException erro) {
            //Abre uma janela de diálogo informando o erro. 
            JOptionPane.showInputDialog(null, "AnuncioDAO|Pesquisar: " + erro);
        }
        return lista;
    }

    //Retorna um relatório baseado em nomes do cliente e datas.
    public ArrayList<AnuncioDTO> retornaRelatorio(String nome, String data1, String data2) {
        //Cria uma variável.
        String sql;
        //Altera a consulta sql caso a data esteja preenchida e nome vazio.
        if (!data1.isEmpty() && !data2.isEmpty() && nome.isEmpty()) {
            sql = "SELECT ID_ANUNC, NO_ANUNC, NO_CLIENTE, DATE_FORMAT(DT_INIC, \"%d/%m/%Y\") AS DT_INIC, DATE_FORMAT(DT_TERM, \"%d/%m/%Y\") AS DT_TERM, VL_INVST_DIA, DATEDIFF(DT_TERM, DT_INIC) * VL_INVST_DIA AS VL_TOTAL FROM TB_ANUNCIO "
                    + "WHERE DT_INIC >= ? AND DT_INIC <= ?";
            //Altera a consulta sql caso a data e o nome estejam preenchidos.
        } else if (!data1.isEmpty() && !data2.isEmpty() && !nome.isEmpty()) {
            sql = "SELECT ID_ANUNC, NO_ANUNC, NO_CLIENTE, DATE_FORMAT(DT_INIC, \"%d/%m/%Y\") AS DT_INIC, DATE_FORMAT(DT_TERM, \"%d/%m/%Y\") AS DT_TERM, VL_INVST_DIA, DATEDIFF(DT_TERM, DT_INIC) * VL_INVST_DIA AS VL_TOTAL FROM TB_ANUNCIO "
                    + "WHERE NO_CLIENTE LIKE ? AND DT_INIC >= ? AND DT_INIC <= ?";
            //Altera a consulta sql caso a data esteja vazia e o nome preenchido.
        } else if (data1.isEmpty() && data2.isEmpty() && !nome.isEmpty()) {
            sql = "SELECT ID_ANUNC, NO_ANUNC, NO_CLIENTE, DATE_FORMAT(DT_INIC, \"%d/%m/%Y\") AS DT_INIC, DATE_FORMAT(DT_TERM, \"%d/%m/%Y\") AS DT_TERM, VL_INVST_DIA, DATEDIFF(DT_TERM, DT_INIC) * VL_INVST_DIA AS VL_TOTAL FROM TB_ANUNCIO "
                    + "WHERE NO_CLIENTE LIKE ?";
            //Caso não se enquadre nas condições anteriores retorna a lista vazia e uma mensagem de erro.
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos de data e/ou nome !", "Campos em branco !", JOptionPane.ERROR_MESSAGE);
            return lista;
        }
        //Conecta ao banco.
        conn = new ConexaoDAO().conector();

        try {
            //Prepara conexão e passa o comando sql.
            pstm = conn.prepareStatement(sql);
            //Preenche os valores '?' da query da variável sql de acordo com a entrada de dados.
            //Se a data estiver preenchida e o nome vazio.
            if (!data1.isEmpty() && !data2.isEmpty() && nome.isEmpty()) {
                pstm.setString(1, data1);
                pstm.setString(2, data2);
                //Se a date e o nome estiverem preenchidos.
            } else if (!data1.isEmpty() && !data2.isEmpty() && !nome.isEmpty()) {
                pstm.setString(1, "%" + nome + "%");
                pstm.setString(2, data1);
                pstm.setString(3, data2);
                //Se a data estiver vazia e o nome preenchido.
            } else if (data1.isEmpty() && data2.isEmpty() && !nome.isEmpty()) {
                pstm.setString(1, "%" + nome + "%");
            }
            //Atribui o resultado da query para a variável Resultset.
            rs = pstm.executeQuery();

            //Verifica se o ResultSet tem algum registro.
            if (!rs.isBeforeFirst()) {
                //Abre uma janela de diálogo informando o erro. 
                JOptionPane.showMessageDialog(null, "Não foi encontrado registros. !", "Não Encontrado !", JOptionPane.ERROR_MESSAGE);
            }
            //Percorre a tabela de dados e atribui valores aos objetos do AnuncioDTO.
            while (rs.next()) {
                AnuncioDTO objanunciodto = new AnuncioDTO();
                objanunciodto.setID_ANUNC(rs.getInt("ID_ANUNC"));
                objanunciodto.setNO_ANUNC(rs.getString("NO_ANUNC"));
                objanunciodto.setNO_CLIENTE(rs.getString("NO_CLIENTE"));
                objanunciodto.setDT_INIC(rs.getString("DT_INIC"));
                objanunciodto.setDT_TERM(rs.getString("DT_TERM"));
                objanunciodto.setVL_INVST_DIA(rs.getString("VL_INVST_DIA"));
                objanunciodto.setVL_TOTAL(rs.getString("VL_TOTAL"));

                lista.add(objanunciodto);
            }

        } catch (SQLException erro) {
            //Abre uma janela de diálogo informando o erro. 
            JOptionPane.showMessageDialog(null, "AnuncioDAO|Relatorio_Nome: " + erro);
        }
        return lista;
    }

    //Realiza a alteração no banco de dados.
    public void alterarAnuncio(AnuncioDTO objanunciodto) {
        //Atribui a consulta sql à variável sql.
        String sql = "UPDATE TB_ANUNCIO SET NO_ANUNC = ?, NO_CLIENTE = ?, DT_INIC = ?, DT_TERM = ?,"
                + "VL_INVST_DIA = ? WHERE ID_ANUNC = ?";

        //Conecta ao banco.
        conn = new ConexaoDAO().conector();

        try {
            //Prepara conexão e passa o comando sql.
            pstm = conn.prepareStatement(sql);
            //Preenche os valores '?' da query da variável sql de acordo com os valores na DTO.
            pstm.setString(1, objanunciodto.getNO_ANUNC());
            pstm.setString(2, objanunciodto.getNO_CLIENTE());
            pstm.setString(3, objanunciodto.getDT_INIC());
            pstm.setString(4, objanunciodto.getDT_TERM());
            pstm.setString(5, objanunciodto.getVL_INVST_DIA());
            pstm.setInt(6, objanunciodto.getID_ANUNC());
            //Executa o comando sql e fecha a conexão em seguida.
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso !", "Alteração concluída", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();

        } catch (SQLException erro) {
            //Abre uma janela de diálogo informando o erro. 
            JOptionPane.showMessageDialog(null, "Erro (AnuncioDAO|alterarAnuncio): " + erro);
        }
    }

    //Realiza a exclusão no banco de dados.
    public void excluirAnuncio(AnuncioDTO objanunciodto) {
        //Atribui a consulta sql à variável sql.
        String sql = "DELETE FROM TB_ANUNCIO WHERE ID_ANUNC = ?";

        //Conecta ao banco.
        conn = new ConexaoDAO().conector();

        try {
            //Prepara conexão e passa o comando sql.
            pstm = conn.prepareStatement(sql);
            //Preenche o valor '?' da query da variável sql de acordo com o valor na DTO.
            pstm.setInt(1, objanunciodto.getID_ANUNC());
            //Executa o comando sql e fecha a conexão em seguida.
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso !", "Exclusão realizada", JOptionPane.INFORMATION_MESSAGE);
            pstm.close();

        } catch (SQLException erro) {
            //Abre uma janela de diálogo informando o erro. 
            JOptionPane.showMessageDialog(null, "Erro (AnuncioDAO|excluirrAnuncio): " + erro);
        }
    }
}
