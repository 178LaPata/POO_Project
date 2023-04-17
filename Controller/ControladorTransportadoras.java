package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        a.printMessage(">>> A Transportadora é Premium: (true,false)");
        Boolean premium = s.nextBoolean();

        return new Transportadoras(nome, imposto, precoExpedicao, lucro , premium);

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



