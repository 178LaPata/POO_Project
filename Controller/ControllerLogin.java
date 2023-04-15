package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;
import View.*;

public class ControllerLogin {

    private final Input in;

    public ControllerLogin(){
        in = new Input();
    }
    
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
    public TShirt registarTshirt (Apresentacao a){
        Scanner s = new Scanner(System.in);

        int numDonos;
        TShirt.Avaliação avaliacao;

        a.printMessage("===== Registo de T-Shirt ====");
        a.printMessage("===> Tipo da TShirt(S,M,L,XL): ");
        String tamanho_string = s.nextLine();
        TShirt.Tamanho tamanho = TShirt.Tamanho.valueOf(tamanho_string);
        a.printMessage("===> Padrão da TShirt(LISO,RISCAS,PALMEIRAS): ");
        String padrao_string = s.nextLine();
        TShirt.Padrao padrao = TShirt.Padrao.valueOf(padrao_string);
        a.printMessage("===> Estado da TShirt(NOVO,USADO): ");
        String estado_string = s.nextLine();
        Artigo.Estado estado = Artigo.Estado.valueOf(estado_string);
        if (estado != Artigo.Estado.NOVO){
            numDonos = in.lerInt(a,"===> Número de Donos: ",0,1000);
            a.printMessage("===> Avaliação da TShirt(IMPECÁVEL,BOM,SATISFATÓRIO,): ");
            String avaliacao_string = s.nextLine();
            avaliacao = TShirt.Avaliação.valueOf(avaliacao_string);
        }else{
            numDonos = 0;
            avaliacao = null;
        }
        String desc = in.lerString(a,"==> Descrição da TShirt: ");
        String marca = in.lerString(a,"==> Marca da TShirt: ");
        String cod = in.lerString(a,"==> Código da TShirt: ");
        Double precoB = in.lerDouble(a,"==> Preço da TShirt: ",0,10000000);
        Double correcaoP = in.lerDouble(a,"==> Correção da TShirt: ",0,1000000);

        return new TShirt(tamanho, padrao,"TShirt", estado, numDonos, avaliacao, desc, marca, cod, precoB,correcaoP);
    }


        public Malas registarMala (Apresentacao a){
        Scanner s = new Scanner(System.in);

        a.printMessage("===== Registo de Mala ====");
        a.printMessage("===> Tipo da Mala(NORMAL,PREMIUM): ");
        String tipo_string = s.nextLine();
        Malas.Tipos_Malas tipo = Malas.Tipos_Malas.valueOf(tipo_string);
        float dim = in.lerFloat(a,"===> Dimensão da Mala: ",0,10000);
        String material = in.lerString(a,"===> Material da Mala: ");
        int ano = in.lerInt(a,"===> Ano da Coleção: ",0,100000);
        a.printMessage("===> Estado da TShirt(NOVO,USADO): ");
        String estado_string = s.nextLine();
        Artigo.Estado estado = Artigo.Estado.valueOf(estado_string);
        int numDonos = in.lerInt(a,"===> Número de Donos: ",0,1000);
        a.printMessage("===> Avaliação da TShirt(IMPECÁVEL,BOM,SATISFATÓRIO,): ");
        String avaliacao_string = s.nextLine();
        TShirt.Avaliação avaliacao = TShirt.Avaliação.valueOf(avaliacao_string);
        String desc = in.lerString(a,"==> Descrição da TShirt: ");
        String marca = in.lerString(a,"==> Marca da TShirt: ");
        String cod = in.lerString(a,"==> Código da TShirt: ");
        Double precoB = in.lerDouble(a,"==> Preço da TShirt: ",0,10000000);
        Double correcaoP = in.lerDouble(a,"==> Correção da TShirt: ",0,1000000);

        return new Malas(tipo, dim, material, ano, "Mala" ,estado, numDonos, avaliacao, desc, marca, cod, precoB, correcaoP);

    }

    public void interpretador(Apresentacao a){
        boolean b = true;
        int comando;

        while(b){
            a.printMenuArtigo();
            comando = (int) in.lerDouble(a,"Escolha a sua opção:",0,2);

            switch(comando){
                case 1:
                    TShirt oi = registarTshirt(a);
                    a.printMessage("TSHIRT REGISTADO COM SUCESSO");
                    System.out.println(oi.toString());
                    break;
                case 2:
                    registarMala(a);
                    a.printMessage("MALA REGISTADA COM SUCESSO");
                default:
                    break;
            }
        }
    }

    
}
