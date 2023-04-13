package View;

import java.io.Serializable;

public class ApresentacaoMain implements Serializable {
    private final Output out;

    public ApresentacaoMain() {
        out = new Output();
    }

    /**
     * Apresenta menu welcome
     */
    public void welcome() {
        System.out.println("    __      _______ _   _ _______       _____ ______      ");
        System.out.println("    \\ \\    / /_   _| \\ | |__   __|/\\   / ____|  ____| ");
        System.out.println("     \\ \\  / /  | | |  \\| |  | |  /  \\ | |  __| |__    ");
        System.out.println("      \\ \\/ /   | | | . ` |  | | / /\\ \\| | |_ |  __|   ");
        System.out.println("       \\  /   _| |_| |\\  |  | |/ ____ \\ |__| | |____   ");
        System.out.println("        \\/   |_____|_| \\_|  |_/_/    \\_\\_____|______| ");
        System.out.println("                                                          ");
        System.out.println("                                                          ");
        System.out.println("               Bem vindo à aplicação Vintage!             "); 
        System.out.println("                                                          ");
        System.out.println("          Pressione qualquer tecla para continuar         ");
        
    }

    /**
     * Apresenta menu login
     */
    public void printMenuInicial() {
        out.printMenus((new String[]{"Login/Registar", "Gravar para um Ficheiro", "Carregar de um ficheiro"}),"      MENU PRINCIPAL",0);
    }

    /*

    public void printMainMenuLogOut(String type, int numN) {
        out.printMenus((new String[]{"Logout","Menu " + type, "Consultas", "Notificações (" + numN + ")"}),"MENU PRINCIPAL",0);
    }

    public void printMenuConsultas() {
        out.printMenus((new String[]{"Top Utilizadores do Sistema", "Top Transportadoras do Sistema"}),"MENU CONSULTAS",1);
    }

    public void printErroComandoInvalido(){
        System.out.println("Comando Inválido");
    }

    public void printFicheiroCarregado(String file){
        System.out.println("Ficheiro " + file + " carregado");
    }
    
    public void printFicheiroGuardado(String file){
        System.out.println("Ficheiro " + file + " guardado");
    }

    public void printSair() {
        System.out.println("A Sair do Programa");
    }

    */
}