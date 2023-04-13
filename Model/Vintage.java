package Model;

import java.util.HashMap;
import java.util.Map;

public class Vintage {
    private Map<Integer, Utilizador> utilizadores;
    private Map<Integer, Encomenda> encomendas;
    private Map<Integer, Artigo> artigos;
    private Map<String, Login> login;
    private Map<String, Transportadoras> transportadoras;

    public Vintage() {
        this.utilizadores = new HashMap<>();
        this.encomendas = new HashMap<>();
        this.artigos = new HashMap<>();
        this.login = new HashMap<>();
        this.transportadoras = new HashMap<>();
    }
    
    public Utilizador getUtilizador(int id) {
        return utilizadores.get(id).clone();
    }

    public void setUtilizador(int id, Utilizador u) {
        utilizadores.replace(u.getId(), u);
    }

    public void adicionaUtilizador(Utilizador u) {
        utilizadores.put(u.getId(), u);
    }

    public Encomenda getEncomenda(int id) {
        return encomendas.get(id).clone();
    }

    public void setEncomenda(int id, Encomenda e) {
        encomendas.replace(e.getId(), e);
    }

    public Login getLogin(String user) {
        return login.get(user).clone();
    }

    public boolean existeUtilizador(String user) {
        return login.containsKey(user);
    }

    public boolean existePassword(String user, String password) {
        return login.get(user).getPassword().equals(password);
    }
}
