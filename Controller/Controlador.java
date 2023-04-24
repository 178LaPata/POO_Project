package Controller;

import Files.*;
import Model.*;
import View.*;

import java.util.Scanner;
import java.io.*;

public class Controlador implements Serializable{
    private final Input in;
    private final ControladorArtigo ca;
    private final ControladorUtilizador cu;
    private final ControladorTransportadoras ct;

    public Controlador(){
        in = new Input();
        ca = new ControladorArtigo();
        cu = new ControladorUtilizador();
        ct = new ControladorTransportadoras();
    }


    /*
    private void interpretadorEstatisticas (Vintage v, Apresentacao a){
        int comando;
        boolean b = true;

        while(b){
            a.printMenuEstatisticas(); // por fazer
            comando = in.lerInt(a,"Escolha uma das opções:",0,5);

            switch(comando){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    a.printMessage("Erro Comando Inválido");
                    break;
            }
        }
    }
    */




    /*
    private void interpretadorConsultas (Vintage v, Apresentacao a, Utilizador u){
        int comando;
        boolean b = true;

        while(b){
            a.printMenuConsultas();
            comando = in.lerInt(a,"Escolha uma das opções:",0,3);

            switch(comando){
                 case 1: // Ver Produtos que está a Vender       
                    break;
                case 2: // Ver os Produtos que já Comprou
                    break;
                case 3: // Ver os Produtos que já Vendeu
                    break;
                case 4: // Ver transportadoras disponíveis
                    // Sacar o map das transportadoras
                    // Printar esse Map
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    a.printMessage("Erro Comando Inválido!");
            }
        }

    }

    */









    public void interpretador (Vintage v, Apresentacao a) throws ClassNotFoundException, IOException{
        int comando;
        boolean b = true;

        Estados e = new Estados();
        Scanner s = new Scanner(System.in);
        a.welcome();
        s.nextLine();

        while(b){
            if(v.getSessaoAtual() == null){
                
                a.printMenuInicial();
                comando = in.lerInt(a,"Escolhe uma das opcões: ",0,4);
                
                switch(comando){
                    case 1: // Login / Registar
                        a.printMenuLogin();
                        String sessaoAtual = cu.interpretador(v, a);
                        v.SetSessaoAtual(sessaoAtual);
                        break;
                    case 2: // Gravar para um Ficheiro (AINDA A NÂO FUNCIONAR)
                        e.dadosGuardar("Vintage.dat",v);
                        a.printMessage("Dados Guardados com Sucesso!");
                        break;
                    case 3: // Carregar um Ficheiro (AINDA A NÂO FUNCIONAR)
                        v = e.dadoscarregar("Vintage.dat");
                        a.printMessage("Dados Carregados com Sucesso!");
                        break;
                    case 4: // Criar Transportadora
                        ct.interpretador(v,a);
                        break;
                    case 0: // Sair do programa
                        b = false;
                        break;
                    default:
                        a.printMessage("Erro! Comando Inválido.");
                        break;
                }
            }else{
                a.printMainMenuLogOut();
                comando = in.lerInt(a,"Escolhe uma das opções: ",0,5);
                switch(comando){
                    case 1: // Dar logout
                        v.SetSessaoAtual(null);
                        a.printMessage("Logout feito com Sucesso!");
                        break;
                    case 2: // Consultar as Estatisticas
                        //interpretadorEstatisticas(v,a);
                        break;
                    case 3: // Consultar os Produtos
                        //u = v.getUtilizador(l.getemail());
                        // interpretadorConsultas(v,a,u);
                        break;
                    case 4: // Colocar Produto para Vender
                        ca.interpretador(a,v);
                        break;
                    case 5: // Comprar produto
                        a.printArtigos(v.getArtigosVenda());
                        break;
                    case 0: // Sair do programa
                        b = false;
                        break;
                    default:
                        a.printMessage("Erro! Comando Inválido.");
                        break;


                }
            }
        }

        a.printSair();
        s.close();
    }

    
}
