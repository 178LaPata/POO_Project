package View;

import Model.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Output implements Serializable {

    // esta não da clear ao ecra todo
    //public void clear() {
    //    for(int i = 0; i<5; i++)
    //        System.out.println("");
    //}

    public void screenClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printLine(int size) {
        for(int i=0; i<size; i++)
            System.out.print("-");

        System.out.println("");
    }

    public void printMenus(String []menu, String message, int type){

        int size, length=message.length();

        for(String linha: menu)
            if(linha.length() + 4 > length)
                length = linha.length() + 4;

        if(length < 20)
            length = 20;

        printLine(length);
        System.out.println(message);
        printLine(length);

        size = menu.length;
        for(int i = 0;i < size;i++)
            System.out.println(i+1+" | "+menu[i]);
        if(type == 0)
            System.out.println("0 | Sair");
        else
            System.out.println("0 | Voltar atrás");
        printLine(length);
    }


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printDouble(Double dou){
        System.out.println(dou);
    }

    public void printInteiro(int inteiro){
        System.out.println(inteiro);
    }



    public void printTransportadoras(Map<String, Transportadoras> transportadoras){
        System.out.println("+------------------------------+\n|        Transportadoras       |\n+------------------------------+");
        for (Transportadoras a : transportadoras.values()){
            System.out.print(a);
            System.out.println("+------------------------------+");
        }
    }



    public void printArtigos(List<Artigo> artigos,LocalDate data){
        System.out.println("+--------------------------+\n|          Artigos         |\n+--------------------------+");
        for (Artigo a : artigos){
            System.out.print(a.toString(data));
            System.out.println("+--------------------------+");
        }
    }

    public void printEncomendas(List<Encomenda> encomendas, LocalDate data){
        System.out.println("+-----------------------------+\n|          Encomendas         |\n+-----------------------------+");
        for (Encomenda e : encomendas){
            System.out.println("+-----------------------------+");
        }
    }

    public void printCarrinho(List<Integer> carrinho){
        System.out.print("[CARRINHO] : ");
        for (int i : carrinho){
            System.out.print("[" + i + "] ");
        }
        System.out.println();
    }
}