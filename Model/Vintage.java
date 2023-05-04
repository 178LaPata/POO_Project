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
    private String sessaoAtual;
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


    public String getSessaoAtual(){
        return this.sessaoAtual;
    }

    public void SetSessaoAtual(String s){
        this.sessaoAtual = s;
    }

    // nao podemos fazer clone porque estamos a alterar mesmo o estado do utilizador (retirar artigos da lista do user)
    public Map<String,Utilizador> getUtilizadores(){
        Map<String,Utilizador> aux = new HashMap<>();
        for (Map.Entry<String,Utilizador> a : this.utilizadores.entrySet()){
            aux.put(a.getKey(), a.getValue().clone());
        }
        return aux;
    }

    


    // nao podemos fazer clone porque vamos querer alterar a transportadora diretamente (adicionar o volume de faturacao à transportadora e não ao clone)
    public Map<String, Transportadoras> getTransportadoras() {
        Map<String,Transportadoras> aux = new HashMap<>();
        for (Map.Entry<String,Transportadoras> e : this.transportadoras.entrySet()){
            aux.put(e.getKey(), e.getValue().clone());
        }
        return aux;
    }






    // Aqui usamos clone (VISTO) (usamos apenas para mostrar quais os artigos que estão à venda)
    public List<Artigo> getArtigosVenda(){
        List<Artigo> artigos = new ArrayList<>();
        for (Map.Entry<String,Utilizador> entry: utilizadores.entrySet()){
            if (entry.getKey() != this.sessaoAtual){
                entry.getValue().getPorVender().stream().forEach(artigos::add);
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



    public void adicionaUtilizador(Utilizador user){
        utilizadores.put(user.getEmail(),user);
    }


    public void adicionarTransportadora(Transportadoras t){
        transportadoras.put(t.getNome(), t);
    }

    public Transportadoras getTransportadora(String t){
        return this.transportadoras.get(t).clone();
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

    public void addEncomenda(Encomenda e){
        this.encomendas.add(e);
    }

    public void avancarTempo(){
        for (Encomenda e : this.encomendas){
            int comparar = this.dataPrograma.compareTo(e.getPrazoLimite());
            if (comparar > 0){
                e.setEstado(Estado_Encomenda.FINALIZADA);
                Utilizador u = this.utilizadores.get(e.getDono());
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
                    if (email.equals(u)){ adicionarPorVender(a, u); }
                }
            }
        }
    }


    public void trataEncomenda(List<Integer> carrinho, List<Artigo> artigos, Map<Integer,String> vendedores){
        for (int id: carrinho){
            adicionaArtigo(id, artigos, vendedores);
        }
    }

    private void adicionaArtigo(int id,List<Artigo> artigos,Map<Integer,String> vendedores){

        for (Map.Entry<String,Utilizador> user : this.utilizadores.entrySet()){
            if (user.getValue().getPorVender().stream().anyMatch(artigo -> artigo.getId() == id)){
                Artigo a = user.getValue().removePorVender(id);
                artigos.add(a.clone());
                vendedores.put(id, user.getKey());
            }
        }
    }

    public double calculaCustoExpedicao(List<Artigo> artigosEncomenda){
        double custosExpedicao = 0.0;

        for (String t : this.transportadoras.keySet()){
            Long aux = artigosEncomenda.stream().filter(a -> a.getTransportadora().equals(t)).count();
            if (aux != 0){
                double expedicaoT = this.transportadoras.get(t).calculaPrecoExpedicao(aux);
                custosExpedicao +=expedicaoT;
            }
        }
        return custosExpedicao;
    }

    public void adicionarPorVender(Artigo a,String user){
        this.utilizadores.get(user).adicionarPorVender(a);
    }




}
