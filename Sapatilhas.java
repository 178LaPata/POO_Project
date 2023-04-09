import java.time.LocalDate;
import java.time.Month;

public class Sapatilhas extends Artigo {

    public enum Tipos_Sapatilhas{
        NORMAL,
        PREMIUM
    }
    private int tamanho_numerico;
    private boolean atilhos;
    private String cor;
    private LocalDate data_lancamento;
    private Tipos_Sapatilhas tipos_sapatilhas;

    public Sapatilhas(int tamanho_numerico,boolean atilhos,String cor,LocalDate data_lancamento,Tipos_Sapatilhas tipos_sapatilhas, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca,
            String codigo, double precoBase, double correcaoPreco) {

        // mudar depois ao criar a tshirt
        super("Sapatilha", estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco);
        this.tamanho_numerico = tamanho_numerico;
        this.atilhos = atilhos;
        this.cor = cor;
        this.data_lancamento = data_lancamento;
        this.tipos_sapatilhas = tipos_sapatilhas;
    }

    public Sapatilhas(Sapatilhas sap) {
        super("Sapatilha",sap.getEstado(), sap.getNumeroDonos(), sap.getAvaliacao(), sap.getDescricao(), sap.getMarca(),
                sap.getCodigo(), sap.getPrecoBase(), sap.getCorrecaoPreco());
        this.tamanho_numerico = sap.getTamanhoNumerico();
        this.atilhos = sap.getAtilhos();
        this.cor = sap.getCor();
        this.data_lancamento = sap.getDataLancamento();
        this.tipos_sapatilhas = sap.getTiposSapatilhas();
    }


    public int getTamanhoNumerico() {
        return tamanho_numerico;
    }

    public void setTamanhoNumerico(int tamanho_numerico) {
        this.tamanho_numerico = tamanho_numerico;
    }

    public boolean getAtilhos() {
        return atilhos;
    }

    public void setAtilhos(boolean atilhos) {
        this.atilhos = atilhos;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDate getDataLancamento() {
        return data_lancamento;
    }

    public void setDataLancamento(LocalDate data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Tipos_Sapatilhas getTiposSapatilhas() {
        return tipos_sapatilhas;
    }

    public void setTiposSapatilhas(Tipos_Sapatilhas tipos_sapatilhas) {
        this.tipos_sapatilhas = tipos_sapatilhas;
    }


    @Override
    public String toString() {
        return super.toString() +
        "\nTamanho Numérico: " + tamanho_numerico +
        "\nPossui atilhos: " + atilhos +
        "\nCor: " + cor +
        "\nData de lançamento da coleção: " + data_lancamento +
        "\nTipo de sapatilhas: " + tipos_sapatilhas;
    }

    @Override
    public Sapatilhas clone() {
        return new Sapatilhas(this.getTamanhoNumerico(), this.getAtilhos(), this.getCor(), this.getDataLancamento(), 
                            this.getTiposSapatilhas(), this.getEstado(), this.getNumeroDonos(), this.getAvaliacao(),
                            this.getDescricao(), this.getMarca(), this.getCodigo(), this.getPrecoBase(), this.getCorrecaoPreco());
    }



}