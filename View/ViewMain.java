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
        out.printMenus((new String[]{"Login/Registar", "Gravar para um Ficheiro", "Carregar de um ficheiro"}),"MENU PRINCIPAL",0);
    }

    public void printMainMenuLogOut() {
        out.printMenus((new String[]{"Logout","Estatísticas", "Consultas", "VENDER - Adicionar Produto para Vender","COMPRAR - Fazer Encomenda"}),"      MENU PRINCIPAL",0);
    }

    public void printMenuArtigo(){
        out.printMenus((new String[]{"Anunciar T-Shirt", "Anunciar Mala", "Anunciar Sapatilha"}),"      REGISTO ARTIGOS",0);

    }

    public void printMenuTransportadoras(){
        out.printMenus((new String[]{"Criar Transportadora"}),"      REGISTO TRANSPORTADORAS" , 0);
    }
    

    public void printMenuConsultas(){
        out.printMenus((new String[]{"Consultar meus Produtos a Vender", "Consultar Produtos Comprados", "Consultar Produtos Vendidos","Consultar Transportadoras Disponíveis"}),"      CONSULTAS",0);
    }

    public void printMenuEstatisticas(){
        out.printMenus((new String[]{"Qual é o vendedor que mais facturou num período ou desde sempre", 
                                    "Qual o transportador com maior volume de facturação", 
                                    "Listar as encomendas emitidas por um vendedor",
                                    "Fornecer uma ordenação dos maiores compradores/vendedores do sistema durante um período a determinar",
                                    "Determinar quanto dinheiro ganhou o Vintage no seu funcionamento"
                                    }),"      ESTATISTICAS",0);
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