package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;
import View.*;

public class ControllerLogin {
    
    private Login login(Vintage c, View a) {
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
    private Utilizador registarUtilizador (View a, String email, String nome){
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
        return new Utilizador(); // nao é assim
    }

    // o estado e a avaliacao nao podem ser strings e falta o id
    private Artigo registarArtigo (View a, int id, String tipo){
        Scanner s = new Scanner(System.in);
        String descricao, marca, codigo, estado, avaliacao;
        double precoBase, correcaoPreco;
        int numeroDonos;

        System.out.println("Insira o tipo do seu artigo: ");
        tipo = s.nextLine();
        System.out.println("Insira o seu estado: ");
        estado = s.nextLine();
        System.out.println("Insira o numero de donos: ");
        numeroDonos = s.nextInt();
        System.out.println("Insira a sua avaliacao: ");
        avaliacao = s.nextLine();
        System.out.println("Insira a sua descricao: ");
        descricao = s.nextLine();
        System.out.println("Insira a sua marca: ");
        marca = s.nextLine();
        System.out.println("Insira o seu codigo: ");
        codigo = s.nextLine();
        System.out.println("Insira o seu preco base: ");
        precoBase = s.nextDouble();
        System.out.println("Insira a sua correcao de preco: ");
        correcaoPreco = s.nextDouble();

        return new Artigo(); // nao é assim
    }
}
