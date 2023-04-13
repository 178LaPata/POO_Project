package Model;

public class Malas extends Artigo {
    public enum Tipos_Malas {
        NORMAL,
        PREMIUM
    }
    private Tipos_Malas tipo_mala;
    private float dim;
    private String material;
    private int ano_da_colecao;

    public Malas(){
        super();
        this.tipo_mala = null; // nao sei se é null
        this.dim = 0;
        this.material = "";
        this.ano_da_colecao = 0;
    }

    public Malas(Tipos_Malas tipo_mala, float dim, String material, int ano_da_colecao, String tipo, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca, String codigo, double precoBase, double correcaoPreco) {
        super(tipo, estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco);
        this.tipo_mala = tipo_mala;
        this.dim = dim;
        this.material = material;
        this.ano_da_colecao = ano_da_colecao;
    }

    public Malas(Malas mala) {
        super(mala);
        this.tipo_mala = mala.getTipo_mala();
        this.dim = mala.getDim();
        this.material = mala.getMaterial();
        this.ano_da_colecao = mala.getAno_da_colecao();
    }

    public Tipos_Malas getTipo_mala() {
        return tipo_mala;
    }

    public void setTipo_mala(Tipos_Malas tipo_mala) {
        this.tipo_mala = tipo_mala;
    }

    public float getDim() {
        return dim;
    }

    public void setDim(float dim) {
        this.dim = dim;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAno_da_colecao() {
        return ano_da_colecao;
    }

    public void setAno_da_colecao(int ano_da_colecao) {
        this.ano_da_colecao = ano_da_colecao;
    }

    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if((o == null) || (this.getClass() != o.getClass())) 
            return false;
        Artigo a = (Malas) o;
        return (this.tipo_mala == ((Malas) o).getTipo_mala() &&
                this.dim == ((Malas) o).getDim() &&
                this.material.equals(((Malas) o).getMaterial()) &&
                this.ano_da_colecao == ((Malas) o).getAno_da_colecao());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de mala: ").append(this.tipo_mala).append("\n");
        sb.append("Dimensões: ").append(this.dim).append("\n");
        sb.append("Material: ").append(this.material).append("\n");
        sb.append("Ano da coleção: ").append(this.ano_da_colecao).append("\n");
        sb.append("Preco Final: ").append(this.precoFinal()).append("\n");
        return sb.toString();
    }
    
    public Malas clone() {
        return new Malas(this);
    }

    public double precoFinal() {
        double pf = getPrecoBase();
        double c = getCorrecaoPreco();
        pf -= pf * c;
        return pf;
    }
}

