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

        a.printMessage(">>> Introduza o Email:");
        email = s.nextLine();

        if(v.existeUtilizador(email)){
            a.printMessage(">>> Introduza a Password:");
            pass = s.nextLine();

            if(v.existePassword(email,pass)){
                return v.getLogin(email);
            }
        }

        return null;
    }


    private Utilizador regista_Utilizador (Vintage v, Apresentacao a){
        Scanner s = new Scanner(System.in);
        String email,password,nome,morada;
        int nif;


        List<Artigo> compras = new ArrayList<>();
        List<Artigo> vendas = new ArrayList<>();
        List<Artigo> porVender = new ArrayList<>();
        
        // Pede o nome, recebe o nome, e mete o nome no Login
        a.printMessage(">>> Introduza o nome:");
        nome = s.nextLine();

        // Pede email, recebe o email, e verifica se o email já esta associado alguma conta
        a.printMessage(">>> Introduza o email: ");
        email = s.nextLine();
        // Ver se o email não existe ja
        if (v.existeUtilizador(email)){
            return null;
        }
        
        a.printMessage(">>> Introduza a Password: ");
        password = s.nextLine();

        a.printMessage(">>> Introduza a Morada: ");
        morada = s.nextLine();

        nif = in.lerInt(a,">>> Introduza um NIF: ",0,99999);

        return new Utilizador(email,password,nome,morada,nif,compras,vendas,porVender);

    }

    private boolean registo(Utilizador u, Apresentacao a,Vintage v){
        Login l = new Login();
        String email,password,nome;
        
        // Pede o nome, recebe o nome, e mete o nome no Login
        nome = u.getNome();
        l.setNome(nome);

        // Pede email, recebe o email, e verifica se o email já esta associado alguma conta
        email = u.getEmail();
        l.setemail(email);
        // Ver se o email não existe ja

        password = u.getPassword();
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
                        a.printMessage("Dados Inválidos");
                    }
                    break;
                case 2:
                    Utilizador u = regista_Utilizador(v,a);
                    if (u == null){
                         a.printMessage("Dados inválidos");
                    }else{
                        v.adicionaUtilizador(u);
                        registo(u,a,v);
                        a.printMessage("Registo Sucesso");
                        v.printAllLogins();
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