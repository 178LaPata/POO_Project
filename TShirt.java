
// falta ver a cena dos descontos e de ser LISO e assim
// falta o clone

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

    public TShirt(Tamanho tamanho, Padrao padrao, Estado estado, Avaliação avaliacao, int numeroDonos, String descricao, String marca, String codigo, double precoBase, double correcaoPreco) {
        super("TShirt", estado, avaliacao, numeroDonos, descricao, marca, codigo, precoBase, correcaoPreco);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(TShirt t) {
        super("TShirt", t.getEstado(), t.getAvaliacao(), t.getNumeroDonos(), t.getDescricao(), t.getMarca(), t.getCodigo(), t.getPrecoBase(), t.getCorrecaoPreco()); 
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
        if (!super.equals(o)) 
            return false;
        TShirt t = (TShirt) o;
        return (this.tamanho == t.getTamanho() &&
                this.padrao == t.getPadrao());
    }

    public String toString() {
        return super.toString() + 
            "\nTamanho: " + this.tamanho +
            "\nPadrão: " + this.padrao;
    }

    public TShirt clone() {
        return new TShirt(this);
    }
}