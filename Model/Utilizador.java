package Model;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Utilizador implements Serializable{
    private static int nextID = 1;
    private int id;
    private String email;
    private String password;
    private String nome;
    private String morada;
    private int nif;
    private List<Artigo> compras;
    private List<Artigo> vendas;
    private List<Artigo> porVender;

    public Utilizador() {
        this.id = nextID++;
        this.email = "";
        this.password = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.compras = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.porVender = new ArrayList<>();
    }

    public Utilizador(String email, String password, String nome, String morada, int nif, List<Artigo> compras, List<Artigo> vendas, List<Artigo> porVender) {
        this.id = nextID++;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.compras = compras;
        this.vendas = vendas;
        this.porVender = porVender;
    }

    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.compras = u.getCompras();
        this.vendas = u.getVendas();
        this.porVender = u.getPorVender();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public List<Artigo> getCompras() {
        ArrayList<Artigo> aux = new ArrayList<Artigo>();
        for(Artigo a : compras){
            aux.add(a.clone());
        }
        return aux;
    }

    public void setCompras(List<Artigo> compras) {
        this.compras = new ArrayList<>(compras.size());
        for(Artigo a: compras){
            this.compras.add(a.clone());
        }
    }

    public List<Artigo> getVendas() {
        ArrayList<Artigo> aux = new ArrayList<Artigo>();
        for(Artigo a : vendas){
            aux.add(a.clone());
        }
        return aux;
    }

    public void setVendas(List<Artigo> vendas) {
        this.vendas = new ArrayList<>(vendas.size());
        for(Artigo a: vendas){
            this.vendas.add(a.clone());
        }
    }

    public List<Artigo> getPorVender() {
        ArrayList<Artigo> aux = new ArrayList<Artigo>();
        for(Artigo a : porVender){
            aux.add(a.clone());
        }
        return aux;
    }

    public void setPorVender(List<Artigo> porVender) {
        this.porVender = new ArrayList<>(porVender.size());
        for(Artigo a: porVender){
            this.porVender.add(a.clone());
        }
    }

    public void adicionarPorVender(Artigo a){
        this.porVender.add(a);
    }



    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if((o == null) || (this.getClass() != o.getClass())) 
            return false;
        if (!super.equals(o)) 
            return false;
        Utilizador u = (Utilizador) o;
        return (this.id == u.getId() &&
                this.email.equals(u.getEmail()) &&
                this.password.equals(u.getPassword()) &&
                this.nome.equals(u.getNome()) &&
                this.morada.equals(u.getMorada()) &&
                this.nif == u.getNif() &&
                this.compras.equals(u.getCompras()) &&
                this.vendas.equals(u.getVendas()) &&
                this.porVender.equals(u.getPorVender()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------\n");
        sb.append("               UTILIZADOR               \n");
        sb.append("----------------------------------------\n");
        sb.append("Utilizador: ").append(this.id).append("\n");
        sb.append("Email: ").append(this.email).append("\n");
        sb.append("Password: ").append(this.password).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Morada: ").append(this.morada).append("\n");
        sb.append("NIF: ").append(this.nif).append("\n");
        sb.append("Compras: ").append(this.compras).append("\n");
        sb.append("Vendas: ").append(this.vendas).append("\n");
        sb.append("Por Vender: ").append(this.porVender).append("\n");
        return sb.toString();
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }
}