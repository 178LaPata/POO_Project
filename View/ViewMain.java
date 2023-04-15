package View;

import java.io.Serializable;

public class ViewMain implements Serializable {
    private final Output out;

    public ViewMain() {
        out = new Output();
    }

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

    public void printMenuInicial() {
        out.printMenus((new String[]{"Login/Registar"}),"      MENU PRINCIPAL",0);
    }

    public void printMainMenuLogOut() {
        out.printMenus((new String[]{"Logout","Estatísticas", "Consultas", "Adicionar Novo Produto Para Venda"}),"MENU PRINCIPAL",0);
    }

    public void printMenuArtigo(){
        out.printMenus((new String[]{"Criar T-Shirt", "Criar Mala", "Criar Sapatilha"}),"      REGISTO ARTIGOS",0);

    }

    //Menu para escolher se quer ser vender ou comprar
    public void printMenuEscolha() {
        out.printMenus((new String[]{"Comprar", "Vender"}),"     MENU",1);
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
}