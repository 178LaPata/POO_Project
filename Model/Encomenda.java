package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    public enum Dimensao_Embalagem {
        GRANDE, // + de 5 artigos
        MEDIO,  // 2 a 5 artigos
        PEQUENO // 1 artigo
    }
    public enum Estado_Encomenda {
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    private static int nextID = 1;
    private int id;
    private List<Artigo> artigos;
    private Dimensao_Embalagem embalagem;
    private double precoFinal;
    private double taxaSatisfacao; // acho que isto nao devia ser um atributo
    private double custosExpedicao;                 // Dependem da transportadora, na classe Artigo vamos ter de adicionar a transportadora depois
    private Estado_Encomenda estado;
    private LocalDate dataCriacao;
    private int tamanho;  // não sei se é preciso (serve para definir a Dimensão da embalagem)
    
    public Encomenda() {
        this.id = nextID++;
        this.artigos = new ArrayList<>();
        this.embalagem = null;
        this.precoFinal = 0;
        this.taxaSatisfacao = 0.0;
        this.custosExpedicao = 0;
        this.estado = Estado_Encomenda.PENDENTE;
        this.dataCriacao = LocalDate.now();
        this.tamanho = 0;
    }

    public Encomenda(List<Artigo> artigos, double precoFinal, double taxaSatisfacao, double custosExpedicao, Estado_Encomenda estado, LocalDate dataCriacao) {
        setArtigos(artigos);
        this.id = nextID++;
        this.precoFinal = precoFinal;
        this.taxaSatisfacao = taxaSatisfacao;
        this.custosExpedicao = custosExpedicao;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.tamanho = artigos.size();
        if (this.tamanho > 5) this.embalagem = Dimensao_Embalagem.GRANDE;
        if (this.tamanho > 1 && this.tamanho <= 5) this.embalagem = Dimensao_Embalagem.MEDIO;
        if (this.tamanho == 1) this.embalagem = Dimensao_Embalagem.PEQUENO;
    }

    public Encomenda(Encomenda enc) {
        this.id = enc.getId();
        this.artigos = enc.getArtigos();
        this.embalagem = enc.getEmbalagem();
        this.precoFinal = enc.getPrecoFinal();
        this.taxaSatisfacao = enc.getTaxaSatisfacao();
        this.custosExpedicao = enc.getCustosExpedicao();
        this.estado = enc.getEstado();
        this.dataCriacao = enc.getDataCriacao();
        this.tamanho =  enc.getTamanho();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(int t){
        this.tamanho = t;
    }


    public List<Artigo> getArtigos() {
    ArrayList<Artigo> res = new ArrayList<>();
        for(Artigo a: this.artigos){
            res.add(a.clone());
        }
        return res;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = new ArrayList<>(artigos.size());
        for(Artigo a: artigos){
            this.artigos.add(a.clone());
        }
    }

    public Dimensao_Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Dimensao_Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getTaxaSatisfacao() {
        return taxaSatisfacao;
    }

    public void setTaxaSatisfacao(double taxaSatisfacao) {
        this.taxaSatisfacao = taxaSatisfacao;
    }

    public double getCustosExpedicao() {
        return custosExpedicao;
    }

    public void setCustosExpedicao(double custosExpedicao) {
        this.custosExpedicao = custosExpedicao;
    }

    public Estado_Encomenda getEstado() {
        return estado;
    }

    public void setEstado(Estado_Encomenda estado) {
        this.estado = estado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda enc = (Encomenda) o;
        return  this.id == enc.getId() &&
                this.artigos.equals(enc.getArtigos()) &&
                this.embalagem == enc.getEmbalagem() &&
                this.precoFinal == enc.getPrecoFinal() &&
                this.taxaSatisfacao == enc.getTaxaSatisfacao() &&
                this.custosExpedicao == enc.getCustosExpedicao() &&
                this.estado == enc.getEstado() &&
                this.dataCriacao.equals(enc.getDataCriacao());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==========  Encomenda  ==========\n");
        sb.append("ID da Encomenda: " + id + "\n");
        sb.append("Encomenda criada em: " + dataCriacao + "\n");
        sb.append("==========   Artigos   ==========\n");
        for (Artigo artigo : artigos) {
            sb.append(artigo.toString() + "\n");
        }
        sb.append("========== Fim Artigos ==========\n");
        sb.append("Dimensão da embalagem: " + embalagem + "\n");
        sb.append("Preço final: " + precoFinal + "\n");
        sb.append("Estado da encomenda: " + estado + "\n");
        return sb.toString();
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    // Quando adicionamos um produto a uma Encomenda, o seu preço é incrementado
    public void adicionarArtigo(Artigo artigo) {
        this.tamanho++;
        if (this.tamanho > 5) this.embalagem = Dimensao_Embalagem.GRANDE;
        if (this.tamanho > 1 && this.tamanho <= 5) this.embalagem = Dimensao_Embalagem.MEDIO;
        if (this.tamanho == 1) this.embalagem = Dimensao_Embalagem.PEQUENO;
        this.artigos.add(artigo);
        double pf = artigo.getPrecoBase() - (artigo.getPrecoBase() * artigo.getCorrecaoPreco() / 100.0);  // basicamente nós aqui aplicamos o desconto ao preco base do produto
        if (artigo.getEstado() == Artigo.Estado.NOVO){
            pf+=0.5;
        }else{
            pf+=0.25;
        }
        this.precoFinal+=pf;
    }

    // Quando retiramos um produto a uma Encomenda, o seu preço é reduzido
    public void removerArtigo(Artigo artigo) {
        this.tamanho--;
        if (this.tamanho > 5) this.embalagem = Dimensao_Embalagem.GRANDE;
        if (this.tamanho > 1 && this.tamanho <= 5) this.embalagem = Dimensao_Embalagem.MEDIO;
        if (this.tamanho == 1) this.embalagem = Dimensao_Embalagem.PEQUENO;
        this.artigos.remove(artigo);
        double pf = artigo.getPrecoBase() - (artigo.getPrecoBase() * artigo.getCorrecaoPreco() / 100.0);  // basicamente nós aqui aplicamos o desconto ao preco base do produto
        if (artigo.getEstado() == Artigo.Estado.NOVO){
            pf+=0.5;
        }else{
            pf+=0.25;
        }
        this.precoFinal-=pf;
    }

    
}