package Model;

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

    public  Sapatilhas(){
        super();
        this.tamanho_numerico = 0;
        this.atilhos = false;
        this.cor = "";
        this.data_lancamento = LocalDate.of(0, Month.JANUARY, 1);
        this.tipos_sapatilhas = null;
    }

    public Sapatilhas(int tamanho_numerico, boolean atilhos, String cor, LocalDate data_lancamento, Tipos_Sapatilhas tipos_sapatilhas, String tipo, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca, String codigo, double precoBase, double correcaoPreco, Transportadoras t){
        // mudar depois ao criar a tshirt
        super(tipo, estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco, t);
        this.tamanho_numerico = tamanho_numerico;
        this.atilhos = atilhos;
        this.cor = cor;
        this.data_lancamento = data_lancamento;
        this.tipos_sapatilhas = tipos_sapatilhas;
    }

    public Sapatilhas(Sapatilhas sap) {
        super(sap);
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

    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if((o == null) || (this.getClass() != o.getClass())) 
            return false;
        if (!super.equals(o)) 
            return false;

        Artigo a = (Sapatilhas) o;
        return (this.tamanho_numerico == ((Sapatilhas) o).getTamanhoNumerico() &&
                this.atilhos == ((Sapatilhas) o).getAtilhos() &&
                this.cor.equals(((Sapatilhas) o).getCor()) &&
                this.data_lancamento.equals(((Sapatilhas) o).getDataLancamento()) &&
                this.tipos_sapatilhas.equals(((Sapatilhas) o).getTiposSapatilhas()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tamanho Numerico: ").append(this.tamanho_numerico).append("\n");
        sb.append("Atilhos: ").append(this.atilhos).append("\n");
        sb.append("Cor: ").append(this.cor).append("\n");
        sb.append("Data de Lancamento: ").append(this.data_lancamento).append("\n");
        sb.append("Tipo de Sapatilhas: ").append(this.tipos_sapatilhas).append("\n");
        sb.append("Preco Final: ").append(this.precoFinal()).append("\n");
        return sb.toString();
    }

    public Sapatilhas clone() {
        return new Sapatilhas(this);
    }

    // nao e bem assim, o desconto nao esta bem ig
    public double precoFinal() {
        double pf = getPrecoBase();
        double c = getCorrecaoPreco();
        if(tamanho_numerico > 45 || this.getEstado() == Estado.USADO) {
            pf -= c*pf;                
            return pf;
        } else 
            return pf;
    }
    
    // nao sei bem que valor é suposto aumentar
    public double valorMercado() {
        double vm = getPrecoBase();
        if(tipos_sapatilhas == Tipos_Sapatilhas.PREMIUM) {
            vm *= 1.1;
        }
        return vm;
    }
}