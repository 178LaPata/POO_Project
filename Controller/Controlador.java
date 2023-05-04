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
    private final ControladorEncomenda ce;

    public Controlador(){
        in = new Input();
        ca = new ControladorArtigo();
        cu = new ControladorUtilizador();
        ct = new ControladorTransportadoras();
        ce = new ControladorEncomenda();
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
                comando = in.lerInt(a,"Escolhe uma das opcões: ",0,5);
                
                switch(comando){
                    case 1: // Login / Registar
                        a.printMenuLogin();
                        String sessaoAtual = cu.interpretador(v, a);
                        v.SetSessaoAtual(sessaoAtual);
                        break;
                    case 2: // Gravar para um Ficheiro
                        String ficheiroG = in.lerString(a, "Nome do ficheiro que pretende guardar: ");
                        e.dadosGuardar(ficheiroG + ".dat",v);
                        a.printMessage("Dados Guardados com Sucesso em " + ficheiroG + ".dat");
                        break;
                    case 3: // Carregar um Ficheiro
                        String ficheiroA = in.lerString(a, "Nome do ficheiro que prentede carregar: ");
                        v = e.dadoscarregar(ficheiroA + ".dat");
                        a.printMessage("Dados Carregados com Sucesso em " + ficheiroA + ".dat");
                        break;
                    case 4: // Criar Transportadora
                        ct.interpretador(v,a);
                        break;
                    case 5: // Avançar no Tempo
                        Input in = new Input();
                        a.printMessage("Data do Programa: " + v.getDataPrograma());
                        int dias= in.lerInt(a, "Selecione quantos dias pretende avançar: ",0,1000);
                        v.setDataPrograma(v.getDataPrograma().plusDays(dias));
                        v.avancarTempo();
                        a.printMessage("Data do Programa Atualizada: " + v.getDataPrograma());
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
                comando = in.lerInt(a,"Escolhe uma das opções: ",0,6);
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
                    case 5: // Fazer encomenda
                        ce.interpretador(a,v);
                        break;
                    case 6: // Devolver encomenda
                        ce.interpretadorDevolver(a,v);
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
