package View;

import Model.*;
import java.io.Serializable;
import java.util.List;

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

    public void printArray(String message, List<String> arr) {
        System.out.println("\n" + message);

        for(String line : arr)
            System.out.println(line);

        System.out.print("\n");
    }

    public void printTable(String message, List<Artigo> arr) {
        System.out.println("\n" + message);

        for(int i=0; i<arr.size(); i++)
            System.out.println(String.format("%2d %1s",(i+1), ") ") + arr.get(i).toString());

        System.out.print("\n");
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
}