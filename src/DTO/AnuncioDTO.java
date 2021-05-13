//Classe de transferencia de dados.
package DTO;

public class AnuncioDTO {

    //Declaração de variáveis.
    private String NO_ANUNC, NO_CLIENTE, DT_INIC, DT_TERM, VL_INVST_DIA, VL_TOTAL, MAX_VIS, MAX_CLI, MAX_COM;
    private int ID_ANUNC;

    //Gets e Sets das variáveis.
    public String getNO_ANUNC() {
        return NO_ANUNC;
    }

    public void setNO_ANUNC(String NO_ANUNC) {
        this.NO_ANUNC = NO_ANUNC;
    }

    public String getNO_CLIENTE() {
        return NO_CLIENTE;
    }

    public void setNO_CLIENTE(String NO_CLIENTE) {
        this.NO_CLIENTE = NO_CLIENTE;
    }

    public String getDT_INIC() {
        return DT_INIC;
    }

    public void setDT_INIC(String DT_INIC) {
        this.DT_INIC = DT_INIC;
    }

    public String getDT_TERM() {
        return DT_TERM;
    }

    public void setDT_TERM(String DT_TERM) {
        this.DT_TERM = DT_TERM;
    }

    public String getVL_INVST_DIA() {
        return VL_INVST_DIA;
    }

    public void setVL_INVST_DIA(String VL_INVST_DIA) {
        this.VL_INVST_DIA = VL_INVST_DIA;
    }

    public int getID_ANUNC() {
        return ID_ANUNC;
    }

    public void setID_ANUNC(int ID_ANUNC) {
        this.ID_ANUNC = ID_ANUNC;
    }

    public String getVL_TOTAL() {
        return VL_TOTAL;
    }

    public void setVL_TOTAL(String VL_TOTAL) {
        this.VL_TOTAL = VL_TOTAL;
    }

    public String getMAX_CLI() {
        return MAX_CLI;
    }

    public String getMAX_COM() {
        return MAX_COM;
    }

    //Método que calcula o máximo de cliques, compartilhamentos e visualizações. 
    public String calculaValorInvestido() {
        double valor = Double.parseDouble(VL_INVST_DIA);
        //Criação  das variáveis.
        double visualizacoes, cliques, compartilhamentos, novasVisualizacoes, max_cliques, max_compartilhamentos, max_visualizacoes;
        //Regra 1: 30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.
        visualizacoes = valor * 30;
        //Inicializa as variáveis.
        max_visualizacoes = visualizacoes;
        max_cliques = 0;
        max_compartilhamentos = 0;

        //Regra 5: o mesmo anúncio é compartilhado no máximo 4 vezes em sequência;
        //Repete as funções 3 vezes e calcula o alcance do anúncio quando compartilhado 4 vezes em sequência.
        for (int i = 1; i <= 3; i++) {
            //Regra 2: a cada 100 pessoas que visualizam o anúncio 12 clicam nele.
            cliques = visualizacoes * 0.12;
            //Regra 3:a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
            compartilhamentos = cliques * 0.15;
            //Regra 4:cada compartilhamento nas redes sociais gera 40 novas visualizações.
            novasVisualizacoes = compartilhamentos * 40;
            //Atribui novasVisualizacoes para a variável visualizacoes.
            visualizacoes = novasVisualizacoes;
            //Soma as visualizações, cliques e compartilhamentos.
            max_visualizacoes += novasVisualizacoes;
            max_cliques += cliques;
            max_compartilhamentos += compartilhamentos;
        }
        //Formata as variáveis.
        MAX_CLI = String.format("%.2f", max_cliques);
        MAX_COM = String.format("%.2f", max_compartilhamentos);
        MAX_VIS = String.format("%.2f", max_visualizacoes);
        return MAX_VIS;
    }

}
