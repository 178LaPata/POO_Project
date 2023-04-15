package Controller;


import Model.*;
import View.*;

import java.util.Scanner;

public class Controlador {
    private final Input in;
    private final ControladorArtigo ca;
    private final ControladorLogin cl;

    public Controlador(){
        in = new Input();
        ca = new ControladorArtigo();
        cl = new ControladorLogin();
    }


    public void interpretador (Apresentacao a){
        int comando;
        boolean b = true;
        Login l = null;

        Scanner s = new Scanner(System.in);

        a.welcome();
        s.nextLine();
        while(b){
            if(l == null){
                a.printMenuInicial();
                comando = in.lerInt(a,"Escolhe uma das opcões: ",0,2);
                switch(comando){
                    case 1:
                        cl.interpretador(a);
                        break;
                    case 0:
                        b = false;
                        break;
                }
            }
        }
    }

    
}
