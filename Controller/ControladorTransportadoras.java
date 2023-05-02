package Controller;
import java.io.*;

import Model.*;
import View.*;

public class ControladorTransportadoras implements Serializable{
    private final Input in;
    
    public ControladorTransportadoras(){
        in = new Input();
    }

    // Método para registar uma Transportadora
    public Transportadoras registarTransportadoras (Apresentacao a){

        String nome = in.lerString(a, ">> Nome da Empresa: ");
        Double lucro = in.lerDouble(a, ">> Margem de lucro da Transportadora: ",0,100000);
        boolean premium = in.lerSN(a,">> A Transportadora é Premium(S/N): ");
        return new Transportadoras(nome, 0.23, lucro, premium, 0.0);    // imposto e valor base de expedição já vem definido no arranque

    }





    public void interpretador(Vintage v, Apresentacao a){
        Transportadoras t = registarTransportadoras(a);
        a.printMessage("Transportadora registada com sucesso!");
        v.adicionarTransportadora(t);
    }

}



