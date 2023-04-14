package View;

import java.io.Serializable;
import java.util.List;

public class View implements Serializable {
    private final ViewMain am;
    private final ViewLogin al;
    private final Output out;

    public View() {
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

    public void printTable(String message, List<String> arr) {
        out.printTable(message, arr);
    }

    public void printMessage(String message) {
        out.printMessage(message);
    }

}
