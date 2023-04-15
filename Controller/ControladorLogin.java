package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.*;
import View.*;

public class ControladorLogin {
    private final Input in;

    public ControladorLogin(){
        in = new Input();
    }


    public void interpretador(Apresentacao a){
        boolean b = true;
        int comando;

        while(b){
            a.printMenuLogin();
            comando = in.lerInt(a,"Escolha uma das opções: ",0,3);

            switch(comando){
                case 1:
                    System.out.println("oi");
                    break;
            }
        }
    }
}