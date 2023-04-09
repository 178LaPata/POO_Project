
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

    public TShirt(Tamanho tamanho, Padrao padrao, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca,
            String codigo, double precoBase, double correcaoPreco) {
    super("T-Shirt", estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco);
    this.tamanho = tamanho;
    this.padrao = padrao;
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

    @Override
    public String toString() {
        return super.toString() +
            "\nTamanho: " + tamanho +
            "\nPadrão: " + padrao;
    }

}