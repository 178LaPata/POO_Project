package Model;

import java.util.HashMap;
import java.util.Map;

public class Vintage {
    private Map<String, Utilizador> utilizadores;
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
    
    public void printAllLogins() {
    for (String email : login.keySet()) {
        Login l = login.get(email);
        System.out.println("Email: " + email + ", Password: " + l.getPassword());
    }
    }



    public Utilizador getUtilizador(String email) {
        return utilizadores.get(email).clone();
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

    public Login getLogin(String user) {
        return login.get(user).clone();
    }

    public boolean existeUtilizador(String email) {
        return login.containsKey(email);
    }

    public boolean existePassword(String user, String password) {
        return login.get(user).getPassword().equals(password);
    }

    public void adicionaLogin(Login l){
        login.put(l.getemail(),l);
    }
}
