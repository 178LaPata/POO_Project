public class Malas extends Artigo {
    public enum Tipos_Malas {
        NORMAL,
        PREMIUM
    }

    private Tipos_Malas tipo_mala;
    private float dim;
    private String material;
    private int ano_da_colecao;


    public Malas(Tipos_Malas tipo_mala,float dim,String material,int ano_da_colecao, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca,
            String codigo, double precoBase, double correcaoPreco) {

    // mudar depois ao criar a tshirt
    super("Mala", estado, numeroDonos, avaliacao, descricao, marca, codigo, precoBase, correcaoPreco);
    this.tipo_mala = tipo_mala;
    this.dim = dim;
    this.material = material;
    this.ano_da_colecao = ano_da_colecao;
    }

    public Malas(Malas mala) {
        super("Mala",mala.getEstado(), mala.getNumeroDonos(), mala.getAvaliacao(), mala.getDescricao(), mala.getMarca(),
                mala.getCodigo(), mala.getPrecoBase(), mala.getCorrecaoPreco());
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


    @Override
    public String toString() {
        return super.toString() +
            "\nTipo de Mala : " + tipo_mala +
            "\nDimensão : " + dim +
            "\nMaterial :" + material +
            "\nAno da Coleção :" + ano_da_colecao;
    }

}