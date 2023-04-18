package Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;
import View.*;

public class ControladorTransportadoras {
    private final Input in;
    
    public ControladorTransportadoras(){
        in = new Input();
    }

    // Método para registar uma Transportadora
    public Transportadoras registarTransportadoras (Apresentacao a){
        Scanner s = new Scanner(System.in);

        a.printMessage("===== Registo da Transportadora ====");
        a.printMessage(">>> Nome da Empresa: ");
        String nome = s.nextLine();
        Double imposto = in.lerDouble(a, ">>> Imposto da Transportadora: ",0,10000);
        Double precoExpedicao = in.lerDouble(a, ">>> Preço da Expedição; ",0,100000);
        Double lucro = in.lerDouble(a, ">>> Margem de lucro da Transportadora: ",0,100000);
        boolean premium = in.lerSN(a,">>> A Transportadora é Premium(S/N): ");
        List<Artigo> artigos = new ArrayList<Artigo>();
        return new Transportadoras(nome, imposto, precoExpedicao, lucro , premium,artigos);

    }


    public void interpretador(Vintage v, Apresentacao a) {
        boolean b = true;
        int comando;
    
        while (b) {
            a.printMenuTransportadoras();
            comando = in.lerInt(a, "Escolha a sua opção:", 0, 1);
            
            switch(comando){
                case 1:
                    Transportadoras t = registarTransportadoras(a);
                    a.printMessage("Transportadora registada com sucesso!");
                    v.adicionarTransportadora(t);
                    a.printMapTransportadoras("Transportadoras disponíveis", v.getTransportadoras());
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

    
}



