package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class Vintage implements Serializable{
    private String sessaoAtual; // é a pessoa na qual damos o login fica com o email associado para conseguir associar os artigos que comprar ou vender a ela
    private Map<String, Utilizador> utilizadores;
    private Map<Integer, Encomenda> encomendas;
    private Map<String, Transportadoras> transportadoras;

    public Vintage() {
        this.sessaoAtual = null;
        this.utilizadores = new HashMap<>();
        this.encomendas = new HashMap<>();
        this.transportadoras = new HashMap<>();
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
                entry.getValue().getPorVender().stream().map(Artigo :: clone).forEach(artigos::add);
            } 
        }
        return artigos;
    }



    

    // REMOVER ISTO
    public void printUtilizadores() {
    for (Utilizador u : utilizadores.values()) {
        System.out.println("UTI" + u);
    }
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

    public Encomenda getEncomenda(int id) {
        return encomendas.get(id).clone();
    }

    public void setEncomenda(int id, Encomenda e) {
        encomendas.replace(e.getId(), e);
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

}
