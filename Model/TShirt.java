
// falta ver a cena dos descontos e de ser LISO e assim
public class TShirt extends Artigo {
    public enum Tamanho {
        S, 
        M, 
        L, 
        XL
    }

    public enum Padrao {
        LISO, 
        RISCAS, 
        PALMEIRAS
    }

    private Tamanho tamanho;
    private Padrao padrao;

    public TShirt() {
        super();
        this.tamanho = null;
        this.padrao = null;
    }

    public TShirt(Tamanho tamanho, Padrao padrao, String tipo, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca, String codigo, double precoBase, double correcaoPreco) {
        super(tipo, estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(TShirt t) {
        super(t);
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if((o == null) || (this.getClass() != o.getClass())) 
            return false;
        Artigo a = (TShirt) o;
        return (this.tamanho == ((TShirt) o).getTamanho() &&
                this.padrao == ((TShirt) o).getPadrao());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tamanho: ").append(this.tamanho).append("\n");
        sb.append("Padrao: ").append(this.padrao).append("\n");
        sb.append("Preço Final: ").append(this.precoFinal()).append("\n");
        return sb.toString();
    }

    public TShirt clone() {
        return new TShirt(this);
    }

    public double precoFinal() {
        double preco = getPrecoBase();
        double correcao = getCorrecaoPreco();
        if (this.padrao == Padrao.RISCAS || this.padrao == Padrao.PALMEIRAS) {
            correcao = 0.5 * preco;
            return correcao;
        } else  
            return preco;
    }
}