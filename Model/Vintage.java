package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Model.Encomenda.Estado_Encomenda;

import java.io.*;
import java.time.LocalDate;

public class Vintage implements Serializable{
    private String sessaoAtual; // é a pessoa na qual damos o login fica com o email associado para conseguir associar os artigos que comprar ou vender a ela
    private Map<String, Utilizador> utilizadores;
    private List<Encomenda> encomendas;
    private Map<String, Transportadoras> transportadoras;
    private LocalDate dataPrograma;

    public Vintage() {
        this.sessaoAtual = null;
        this.utilizadores = new HashMap<>();
        this.encomendas = new ArrayList<>();
        this.transportadoras = new HashMap<>();
        this.dataPrograma = LocalDate.now();
    }








    // nao sei se faz sentido fazer clone das transportadoras porque se vamos alterar algo nelas aqui tipo adicionar 
    // um artigo ou assim não faz sentido fazer clone porque iriamos estar a adicionar ao clone e nao à transportadora
    public Map<String, Transportadoras> getTransportadoras() {
        return transportadoras;
    }






    // PERGUNTAR AO PROFESSOR
    public List<Artigo> getArtigosVenda(){
        List<Artigo> artigos = new ArrayList<>();
        for (Map.Entry<String,Utilizador> entry: utilizadores.entrySet()){
            if (entry.getKey() != this.sessaoAtual){
                entry.getValue().getPorVender().stream()/* .map(Artigo :: clone)*/.forEach(artigos::add);
            } 
        }
        return artigos;
    }


    
    public void setDataPrograma(LocalDate data){
        this.dataPrograma = data;
    }

    public LocalDate getDataPrograma(){
        return this.dataPrograma;
    }




    // Aqui tirei o clone porque supostamente vamos querer adicionar produtos ao Utilizador original e não a uma clone dele
    public Utilizador getUtilizador(String email) {
        return utilizadores.get(email);
    }

    public void setUtilizador(String email, Utilizador u) {
        utilizadores.replace(u.getEmail(), u);
    }

    public void adicionaUtilizador(Utilizador user){
        utilizadores.put(user.getEmail(),user);
    }


    public void adicionarTransportadora(Transportadoras t){
        transportadoras.put(t.getNome(), t);
    }

    public Transportadoras getTransportadora(String t){
        return this.transportadoras.get(t);
    }

    public String getSessaoAtual(){
        return this.sessaoAtual;
    }

    public void SetSessaoAtual(String s){
        this.sessaoAtual = s;
    }

    public boolean existeEmail(String email){
        return this.utilizadores.containsKey(email);
    }


    public boolean existeUser(String email, String password){
        Utilizador user = this.utilizadores.get(email);
        if (user != null){
        return this.utilizadores.get(email).getPassword().equals(password);
        }
        return false;
    }

    // temos que fazer clone provavelmente
    public Map<String,Utilizador> getUtilizadores(){
        return this.utilizadores;
    }

    public void addEncomenda(Encomenda e){
        this.encomendas.add(e);
    }

    public void avancarTempo(){
        for (Encomenda e : this.encomendas){
            int comparar = this.dataPrograma.compareTo(e.getPrazoLimite());
            if (comparar > 0){
                e.setEstado(Estado_Encomenda.FINALIZADA);
                Utilizador u = this.getUtilizador(e.getDono());
                for(Artigo a : e.getArtigos()){
                    u.adicionaCompra(a);
                }
            }

        }
    }


    public List<Encomenda> encomendasParaDevolver(){
        return this.encomendas.stream().filter(e -> e.getPrazoLimite().isAfter(dataPrograma)).map(e -> e.clone()).collect(Collectors.toList());
    }


    public void devolverEncomenda(int id){
        Encomenda enc = null;
        for (Encomenda e : this.encomendas){
            if (id == e.getId()){
                for (Map.Entry<Integer,String> dono : e.getVendedores().entrySet()){
                    adicionaArtigoVenda(dono.getKey(), dono.getValue(), e);
                }
                enc = e;
                e.setEstado(Estado_Encomenda.DEVOLVIDA);
                break;
            }
        }
        this.encomendas.remove(enc);
    }

    private void adicionaArtigoVenda(int id, String email, Encomenda e){
        for(Artigo a : e.getArtigos()){
            if (a.getId() == id){
                for(String u : this.utilizadores.keySet()){
                    if (email.equals(u)){ this.utilizadores.get(u).getPorVender().add(a.clone()); }
                }
            }
        }
    }


    



}
