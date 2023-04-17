package View;


import Model.*;
import java.io.Serializable;
import java.util.List;

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

    public void printMenuEscolha() {
        am.printMenuEscolha();
    }

    public void printSair() {
        am.printSair();
    }

    public void printMenuArtigo(){
        am.printMenuArtigo();
    }

    public void printMenuTransportadoras(){
        am.printMenuTransportadoras();
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

    public void printArray(String message, List<String> arr) {
        out.printArray(message, arr);
    }

    public void printTable(String message, List<Artigo> arr) {
        out.printTable(message, arr);
    }

    public void printMessage(String message) {
        out.printMessage(message);
    }

    public void printDouble(Double dou){
        out.printDouble(dou);
    }

    public void printInteiro(int inteiro){
        out.printInteiro(inteiro);
    }

}
