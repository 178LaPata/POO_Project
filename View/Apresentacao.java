package View;


import Model.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class Apresentacao implements Serializable {
    private final ViewMain am;
    private final ViewLogin al;
    private final Output out;

    public Apresentacao() {
        am = new ViewMain();
        al = new ViewLogin();
        out = new Output();
    }

    // Menu Inicial
    public void welcome() {
        am.welcome();
    }

    public void printMenuInicial() {
        am.printMenuInicial();
    }

    public void printSair() {
        am.printSair();
    }

    public void printMenuArtigo(){
        am.printMenuArtigo();
    }

    public void printMenuEncomenda(){
        am.printMenuEncomenda();
    }


    public void printMainMenuLogOut(){
        am.printMainMenuLogOut();
    }

    public void printMenuConsultas(){
        am.printMenuConsultas();
    }

    public void printMenuEstatisticas(){
        am.printMenuEstatisticas();
    }

    // Login
    public void printMenuLogin() {
        al.printMenuLogin();
    }

    public void printLoginSucesso() {
        al.printLoginSucesso();
    }

    public void printLogoutSucesso() {
        al.printLogoutSucesso();
    }

    public void printRegistoSucesso() {
        al.printRegistoSucesso();
    }

    public void printErroDadosInvalidos() {
        al.printErroDadosInvalidos();
    }

    //Outros


    public void printMessage(String message) {
        out.printMessage(message);
    }

    public void printDouble(Double dou){
        out.printDouble(dou);
    }

    public void printInteiro(int inteiro){
        out.printInteiro(inteiro);
    }


    public void printTransportadoras( Map<String,Transportadoras> t){
        out.printTransportadoras(t);
    }

    public void printArtigos(List<Artigo> a, LocalDate data){
        out.printArtigos(a,data);
    }

    public void printEncomendas(List<Encomenda> e,LocalDate data){
        out.printEncomendas(e,data);
    }

    public void printCarrinho(List<Integer> carrinho){
        out.printCarrinho(carrinho);
    }

}
