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

    public Artigo(String tipo, Estado estado, Avaliação avaliacao, int numeroDonos, String descricao, String marca, String codigo, double precoBase, double correcaoPreco) {
        this.id = nextID++;
        this.tipo = tipo;
        this.estado = estado;
        if(estado == Estado.NOVO){
            this.numeroDonos = 0;
            this.avaliacao = Avaliação.NULL;
        } else{
            this.numeroDonos = numeroDonos;
            this.avaliacao = avaliacao;
        }
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = codigo;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
    }

    // Construtor que recebe um objeto Artigo
    public Artigo(Artigo a){
        this.id = a.getId();
        this.tipo = a.getTipo();
        this.estado = a.getEstado();
        this.numeroDonos = a.getNumeroDonos();
        this.descricao = a.getDescricao();
        this.marca = a.getMarca();
        this.codigo = a.getCodigo();
        this.precoBase = a.getPrecoBase();
        this.correcaoPreco = a.getCorrecaoPreco();
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

    public boolean equals(Object o){
        if(this == o) 
            return true;
        if((o == null) || (this.getClass() != o.getClass())) 
            return false;
        Artigo a = (Artigo) o;
        return (this.id == a.getId() &&
                this.tipo.equals(a.getTipo()) &&
                this.estado == a.getEstado() &&
                this.numeroDonos == a.getNumeroDonos() &&
                this.descricao.equals(a.getDescricao()) &&
                this.marca.equals(a.getMarca()) &&
                this.codigo.equals(a.getCodigo()) &&
                this.precoBase == a.getPrecoBase() &&
                this.correcaoPreco == a.getCorrecaoPreco());
    }

    public String toString() {
        return "ID: " + id + 
                "\nTipo: " + tipo + 
                "\nEstado: " + estado + 
                "\nNúmero de donos: " + numeroDonos + 
                "\nAvaliação: " + avaliacao + 
                "\nDescrição: " + descricao + 
                "\nMarca: " + marca + 
                "\nCódigo: " + codigo +
                "\nPreço base: " + precoBase + 
                "\nCorreção de preço: " + correcaoPreco;
    }

    public Artigo clone(){
        return new Artigo(this);
    }
}