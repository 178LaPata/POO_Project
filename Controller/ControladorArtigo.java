package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Model.*;
import View.*;

public class ControladorArtigo {

    private final Input in;

    public ControladorArtigo(){
        in = new Input();
    }
    
    // Método para registar uma TShirt
    public TShirt registarTshirt (Apresentacao a){
        Scanner s = new Scanner(System.in);

        int numDonos;
        TShirt.Avaliação avaliacao;

        a.printMessage("===== Registo de T-Shirt ====");
        a.printMessage(">>> Tipo da TShirt(S,M,L,XL): ");
        String tamanho_string = s.nextLine();
        TShirt.Tamanho tamanho = TShirt.Tamanho.valueOf(tamanho_string);
        a.printMessage(">>> Padrão da TShirt(LISO,RISCAS,PALMEIRAS): ");
        String padrao_string = s.nextLine();
        TShirt.Padrao padrao = TShirt.Padrao.valueOf(padrao_string);
        a.printMessage(">>> Estado da TShirt(NOVO,USADO): ");
        String estado_string = s.nextLine();
        Artigo.Estado estado = Artigo.Estado.valueOf(estado_string);
        if (estado != Artigo.Estado.NOVO){
            numDonos = in.lerInt(a,">>> Número de Donos: ",0,1000);
            a.printMessage(">>> Avaliação da TShirt(IMPECÁVEL,BOM,SATISFATÓRIO): ");
            String avaliacao_string = s.nextLine();
            avaliacao = TShirt.Avaliação.valueOf(avaliacao_string);
        }else{
            numDonos = 0;
            avaliacao = null;
        }
        String desc = in.lerString(a,">>> Descrição da TShirt: ");
        String marca = in.lerString(a,">>> Marca da TShirt: ");
        String cod = in.lerString(a,">>> Código da TShirt: ");
        Double precoB = in.lerDouble(a,">>> Preço da TShirt: ",0,10000000);
        Double correcaoP = in.lerDouble(a,">>> Correção da TShirt: ",0,1000000);

        return new TShirt(tamanho, padrao,"TShirt", estado, numDonos, avaliacao, desc, marca, cod, precoB,correcaoP);
    }

    // Método para registar uma Mala
    public Malas registarMala (Apresentacao a){
        Scanner s = new Scanner(System.in);

        int numDonos;
        TShirt.Avaliação avaliacao;

        a.printMessage("===== Registo da Mala ====");
        a.printMessage(">>> Tipo da Mala(NORMAL,PREMIUM): ");
        String tipo_string = s.nextLine();
        Malas.Tipos_Malas tipo = Malas.Tipos_Malas.valueOf(tipo_string);
        float dim = in.lerFloat(a,">>> Dimensão da Mala: ",0,10000);
        String material = in.lerString(a,">>> Material da Mala: ");
        int ano = in.lerInt(a,">>> Ano da Coleção: ",0,100000);
        a.printMessage(">>> Estado da Mala(NOVO,USADO): ");
        String estado_string = s.nextLine();
        Artigo.Estado estado = Artigo.Estado.valueOf(estado_string);
        if (estado != Artigo.Estado.NOVO){
            numDonos = in.lerInt(a,">>> Número de Donos: ",0,1000);
            a.printMessage(">>> Avaliação da Mala(IMPECÁVEL,BOM,SATISFATÓRIO): ");
            String avaliacao_string = s.nextLine();
            avaliacao = TShirt.Avaliação.valueOf(avaliacao_string);
        }else{
            numDonos = 0;
            avaliacao = null;
        }
        String desc = in.lerString(a,">>> Descrição da Mala: ");
        String marca = in.lerString(a,">>> Marca da Mala: ");
        String cod = in.lerString(a,">>> Código da Mala: ");
        Double precoB = in.lerDouble(a,">>> Preço da Mala: ",0,10000000);
        Double correcaoP = in.lerDouble(a,">>> Correção da Mala: ",0,1000000);


        return new Malas(tipo, dim, material, ano, "Mala" ,estado, numDonos, avaliacao, desc, marca, cod, precoB, correcaoP);

    }

    // Método para registar uma Sapatilha
    public Sapatilhas registarSapatilha (Apresentacao a){
        Scanner s = new Scanner(System.in);

        int numDonos;
        TShirt.Avaliação avaliacao;

        a.printMessage("===== Registo da Sapatilha ====");
        a.printMessage(">>> Tipo da Sapatilha(NORMAL,PREMIUM): ");
        String tipo_string = s.nextLine();
        Sapatilhas.Tipos_Sapatilhas tipo = Sapatilhas.Tipos_Sapatilhas.valueOf(tipo_string);
        int tamanho_sapatilha = in.lerInt(a,">>> Tamanho da Sapatilha: ",0,10000);
        boolean tem_atilhos = in.lerSN(a,">>> Tem atilhos(S/N): ");
        String cor = in.lerString(a,">>> Cor da Sapatilha: ");
        LocalDate data = in.lerData(a, ">>> Data de lançamento da Sapatilha(Formato dd-mm-yyyy): ");
        a.printMessage(">>> Estado da Sapatilha(NOVO,USADO): ");
        String estado_string = s.nextLine();
        Artigo.Estado estado = Artigo.Estado.valueOf(estado_string);
        if (estado != Artigo.Estado.NOVO){
            numDonos = in.lerInt(a,">>> Número de Donos: ",0,1000);
            a.printMessage(">>> Avaliação da Sapatilha(IMPECÁVEL,BOM,SATISFATÓRIO): ");
            String avaliacao_string = s.nextLine();
            avaliacao = TShirt.Avaliação.valueOf(avaliacao_string);
        }else{
            numDonos = 0;
            avaliacao = null;
        }
        String desc = in.lerString(a,">>> Descrição da Mala: ");
        String marca = in.lerString(a,">>> Marca da Mala: ");
        String cod = in.lerString(a,">>> Código da Mala: ");
        Double precoB = in.lerDouble(a,">>> Preço da Mala: ",0,10000000);
        Double correcaoP = in.lerDouble(a,">>> Correção da Mala: ",0,1000000);

        return new Sapatilhas(tamanho_sapatilha,tem_atilhos,cor,data,tipo,"Sapatilhas",estado,numDonos,avaliacao,desc,marca,cod,precoB,correcaoP);
        

    }




    public void interpretador(Utilizador u,Apresentacao a){
        boolean b = true;
        int comando;

        while(b){
            a.printMenuArtigo();
            comando = in.lerInt(a,"Escolha a sua opção:",0,3);

            switch(comando){
                case 1:
                    TShirt oi = registarTshirt(a);
                    a.printMessage("T-Shirt registada com sucesso!");
                    u.adicionarPorVender(oi);
                    if(u.getPorVender().isEmpty()){
                        System.out.println("ESTA VAZIA");
                    }else{
                        System.out.println("NAO ESTA VAZIA");
                    }
                    u.printArtigos();
                    break;
                case 2:
                    registarMala(a);
                    a.printMessage("Mala registada com sucesso!");
                    break;
                case 3:
                    Sapatilhas sap = registarSapatilha(a);
                    a.printMessage("Sapatilha registada com sucesso!");
                    System.out.println(sap.toString());
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    a.printMessage("Erro Comando Inválido");
                    break;
            }
        }
    }

    
}
