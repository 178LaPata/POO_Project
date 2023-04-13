package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;
import View.*;

public class ControllerLogin {
    
    private Login login(Vintage c, Apresentacao a) {
        Scanner s = new Scanner(System.in);
        String email, pass;

        System.out.println("Insira o seu email: ");
        email = s.nextLine();
        
        if(c.existeUtilizador(email)) {
            System.out.println("Insira a sua password: ");
            pass = s.nextLine();

            if(c.existePassword(email, pass)) {
                return c.getLogin(email);
            }
        }
        return null;
    }

    // a questao do id aqui nao esta bem
    private Utilizador registarUtilizador (Apresentacao a, String email, String nome){
        Scanner s = new Scanner(System.in);
        String password, morada, email2;
        int nif, id;
        List<Artigo> compras = new ArrayList<>();
        List<Artigo> vendas = new ArrayList<>();
        List<Artigo> porVender = new ArrayList<>();

        System.out.println("Insira o seu email: ");
        email2 = s.nextLine();
        System.out.println("Insira a sua password: ");
        password = s.nextLine();
        System.out.println("Insira o seu nome: ");
        nome = s.nextLine();
        System.out.println("Insira a sua morada: ");
        morada = s.nextLine();
        System.out.println("Insira o seu nif: ");
        nif = s.nextInt();
        return new Utilizador(id, email2, password, nome,  morada, nif, compras, vendas, porVender);
    }


    private Artigo registarArtigo (Apresentacao a, int id, String tipo){
        Scanner s = new Scanner(System.in);
        String descricao, categoria;
        double preco;

        
        System.out.println("Insira a sua descricao: ");
        descricao = s.nextLine();
        System.out.println("Insira a sua categoria: ");
        categoria = s.nextLine();
        System.out.println("Insira o seu preco: ");
        preco = s.nextDouble();
        return new Artigo();
    }
}
