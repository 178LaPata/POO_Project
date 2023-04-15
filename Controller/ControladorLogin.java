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


    private Login login(Vintage v, Apresentacao a){
        Scanner s = new Scanner(System.in);
        String email,pass;

        a.printMessage("Email pff");
        email = s.nextLine();

        if(v.existeUtilizador(email)){
            a.printMessage("Pass pff");
            pass = s.nextLine();

            if(v.existePassword(email,pass)){
                return v.getLogin(email);
            }
        }

        return null;
    }


    private boolean registo(Vintage v, Apresentacao a){
        Scanner s = new Scanner(System.in);
        Login l = new Login();
        String email,password,nome;
        
        // Pede o nome, recebe o nome, e mete o nome no Login
        a.printMessage(">>> Submete o nome:");
        nome = s.nextLine();
        l.setNome(nome);

        // Pede email, recebe o email, e verifica se o email já esta associado alguma conta
        a.printMessage(">>> Submete o email: ");
        email = s.nextLine();
        // Ver se o email não existe ja
        if (!v.existeUtilizador(email)){
            l.setemail(email);
        }else{
            return false;
        }

        a.printMessage(">>> Submete a Password: ");
        password = s.nextLine();
        l.setPassword(password);

        v.adicionaLogin(l);

        return true;


    }


    public Login interpretador(Vintage v, Apresentacao a){
        boolean b = true;
        int comando;
        Login l = null;

        while(b){
            a.printMenuLogin();
            comando = in.lerInt(a,"Escolha uma das opções: ",0,2);

            switch(comando){
                case 1:
                    if((l = login(v,a)) != null){
                        a.printMessage("Login Sucesso");
                        b = false;
                    }else{
                        a.printMessage("Dados inválidos oiiii");
                    }
                    break;
                case 2:
                    if (registo(v,a)){
                        a.printMessage("Registo Sucesso");
                        v.printAllLogins();
                    } else{
                        a.printMessage("Dados inválidos");
                    }
                    break;
                case 0:
                    l = null;
                    b = false;
                    break;
                default:
                    a.printMessage("Comando Inválido");
                    break;
            }
        }

        return l;
    }
}