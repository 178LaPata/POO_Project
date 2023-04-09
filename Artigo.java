public class Artigo {
    // Atributos

    public enum Estado{
        NOVO,
        USADO
    }

    public enum Avaliação{
        IMPECÁVEL,
        BOM,
        SATISFATÓRIO,
        NULL
    }
    private static int nextID = 1;
    private int id;                     // Id do Produto
    private String tipo;                // Tipo do Produto
    private Estado estado;              // Estado do Produto
    private Avaliação avaliacao;
    private int numeroDonos;            // Número de Donos
    private String descricao;           // Descrição do Produto
    private String marca;               // Marca do Produto
    private String codigo;              // Código Alfa-Númerico
    private double precoBase;           // Preço Base
    private double correcaoPreco;       // Correção do Preço


    // Construtor que recebe um objeto Artigo
    public Artigo(Artigo a) {
        this.id = a.getId();
        this.tipo = a.getTipo();
        this.estado = a.getEstado();
        this.avaliacao = a.getAvaliacao();
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.codigo = a.getCodigo();
        this.precoBase = a.getPrecoBase();
        this.correcaoPreco = a.getCorrecaoPreco();
    }

    // Construtor que recebe todos os atributos como parâmetros
    public Artigo(String tipo, Estado estado, int numeroDonos, Avaliação avaliacao, String descricao, String marca,
            String codigo, double precoBase, double correcaoPreco) {
        this.id = nextID++;
        this.tipo = tipo;
        this.estado = estado;
        if (estado == Estado.NOVO){
            this.numeroDonos = 0;
            this.avaliacao = Avaliação.NULL;
        }else{
            this.numeroDonos = numeroDonos;
            this.avaliacao = avaliacao;
        }
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = codigo;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Avaliação getAvaliacao(){
        return avaliacao;
    }

    public void setAvaliacao(Avaliação avaliacao){
        this.avaliacao = avaliacao;
    }

    public int getNumeroDonos() {
        return numeroDonos;
    }

    public void setNumeroDonos(int numeroDonos) {
        this.numeroDonos = numeroDonos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getCorrecaoPreco() {
        return correcaoPreco;
    }

    public void setCorrecaoPreco(double correcaoPreco) {
        this.correcaoPreco = correcaoPreco;
    }

    // método toString
    public String toString() {
        return "ID: " + id + "\n" +
                "Tipo: " + tipo + "\n" +
                "Estado: " + estado + "\n" +
                "Número de donos: " + numeroDonos + "\n" +
                "Avaliação: " + avaliacao + "\n" +
                "Descrição: " + descricao + "\n" +
                "Marca: " + marca + "\n" +
                "Código: " + codigo + "\n" +
                "Preço base: " + precoBase + "\n" +
                "Correção de preço: " + correcaoPreco;
    }
}