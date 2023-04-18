package Model;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Model.Encomenda.Dimensao_Embalagem;

public class Transportadoras {
    private String nome;
    private double imposto;
    private double precoExpedicao;
    private double lucro;
    private boolean premium; // pode vir a ser mudado para enum
    private List<Artigo> artigos;


    public Transportadoras() {
        this.nome = "";
        this.imposto = 0.3;
        this.precoExpedicao = 0;
        this.lucro = 5.5;
        this.premium = false;
        this.artigos = null;
    }

    public Transportadoras(String nome, double imposto, double precoExpedicao, double lucro, boolean premium, List<Artigo> artigos) {
        this.nome = nome;
        this.imposto = imposto;
        this.precoExpedicao = precoExpedicao;
        this.lucro = lucro;
        this.premium = premium;
        setArtigos(artigos);
    }

    public Transportadoras(Transportadoras t) {
        this.nome = t.getNome();
        this.imposto = t.getImposto();
        this.precoExpedicao = t.getPrecoExpedicao();
        this.lucro = t.getLucro();
        this.premium = t.isPremium();
        this.artigos = t.getArtigos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    
    public double getPrecoExpedicao() {
        return precoExpedicao;
    }

    public void setPrecoExpedicao(double precoExpedicao) {
        this.precoExpedicao = precoExpedicao;
    }
    
    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    
    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public List<Artigo> getArtigos(){
        return this.artigos.stream().map(Artigo::clone).collect(Collectors.toList());
    }

    public void setArtigos(List<Artigo> artigos){
        this.artigos = artigos.stream().map(Artigo::clone).collect(Collectors.toList());
    }

    public void addArtigo(Artigo a){
        this.artigos.add(a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Imposto: ").append(this.imposto).append("\n");
        sb.append("Preço de Expedição: ").append(this.precoExpedicao).append("\n");
        sb.append("Lucro: ").append(this.lucro).append("\n");
        sb.append("Premium: ").append(this.premium).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Transportadoras t = (Transportadoras) o;
        return this.nome.equals(t.getNome()) &&
                this.imposto == t.getImposto() &&
                this.precoExpedicao == t.getPrecoExpedicao() &&
                this.lucro == t.getLucro() &&
                this.premium == t.isPremium() && 
                this.artigos.equals(t.getArtigos()); // NAO SEI SE POSSO FAZER ASSIM O EQUALS!
    }

    public Transportadoras clone() {
        return new Transportadoras(this);
    }

    public double calculaPrecoExpedicao(Encomenda e){
        int valorBase = 0;
        if (e.getEmbalagem() == Dimensao_Embalagem.GRANDE) valorBase = 500;
        if (e.getEmbalagem() == Dimensao_Embalagem.MEDIO) valorBase = 300;
        if (e.getEmbalagem() == Dimensao_Embalagem.PEQUENO) valorBase = 100;

        this.precoExpedicao = (valorBase * this.lucro * (1 + this.imposto)) * 0.9;
        return this.precoExpedicao;
    }

}
