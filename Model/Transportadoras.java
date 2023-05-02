package Model;
import java.io.*;


public class Transportadoras implements Serializable{
    private String nome;
    private double imposto;
    private double lucro;
    private boolean premium; // pode vir a ser mudado para enum
    private double volFaturacao;


    public Transportadoras() {
        this.nome = "";
        this.imposto = 0.3;
        this.lucro = 0.10;
        this.premium = false;
        this.volFaturacao = 0.0;
    }

    public Transportadoras(String nome, double imposto, double lucro, boolean premium, double volFaturacao) {
        this.nome = nome;
        this.imposto = imposto;
        this.lucro = lucro;
        this.premium = premium;
        this.volFaturacao = volFaturacao;
    }

    public Transportadoras(Transportadoras t) {
        this.nome = t.getNome();
        this.imposto = t.getImposto();
        this.lucro = t.getLucro();
        this.premium = t.isPremium();
        this.volFaturacao = t.getVolFaturacao();
    }

    public String getNome() {
        return this.nome;
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

    public double getVolFaturacao(){
        return this.volFaturacao;
    }

    public void setVolFaturacao(double vol){
        this.volFaturacao = vol;
    }

    public void addVolFaturacao(double vol){
        this.volFaturacao+=vol;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Imposto: ").append(this.imposto).append("\n");
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
                this.lucro == t.getLucro() &&
                this.premium == t.isPremium() && 
                this.volFaturacao == t.getVolFaturacao();
    }

    public Transportadoras clone() {
        return new Transportadoras(this);
    }




    public double calculaPrecoExpedicao(Long dimensao){
        int valorBase = 0;
        if  (dimensao > 4) valorBase = 50;
        if (dimensao > 1 && dimensao < 5) valorBase = 30;
        if (dimensao == 1) valorBase = 10;
        return (valorBase * this.lucro * (1 + this.imposto)) * 0.9;
    }

}
