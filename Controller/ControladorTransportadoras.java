package Controller;
import java.util.ArrayList;
import java.util.List;
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
        Double imposto = in.lerDouble(a, ">> Imposto da Transportadora: ",0,10000);
        Double precoExpedicao = in.lerDouble(a, ">> Preço da Expedição; ",0,100000);
        Double lucro = in.lerDouble(a, ">> Margem de lucro da Transportadora: ",0,100000);
        boolean premium = in.lerSN(a,">> A Transportadora é Premium(S/N): ");
        List<Artigo> artigos = new ArrayList<Artigo>();
        return new Transportadoras(nome, imposto, precoExpedicao, lucro , premium,artigos);

    }





    public void interpretador(Vintage v, Apresentacao a){
        Transportadoras t = registarTransportadoras(a);
        a.printMessage("Transportadora registada com sucesso!");
        v.adicionarTransportadora(t);
    }

}



