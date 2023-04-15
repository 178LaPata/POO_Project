import Model.*;
import View.*;
import Controller.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class ArtigoTeste {
    public static void main(String[] args) {

        //Artigo a = new Artigo("Camiseta", Artigo.Estado.NOVO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);
        //Artigo b = new Artigo("Brinquedo", Artigo.Estado.USADO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);
        //System.out.println(a.toString());
        //System.out.println("\n");
        //System.out.println(b.toString());
        //System.out.println("\n");

        TShirt tshirt = new TShirt(TShirt.Tamanho.M, TShirt.Padrao.RISCAS, "TShirt", Artigo.Estado.USADO, 1, Artigo.Avaliação.BOM, "T-Shirt de algodão", "Nike", "NIK123", 30.0, 1.5);
        //System.out.println(tshirt.toString());

        Malas mala1 = new Malas(Malas.Tipos_Malas.NORMAL, 50.0f, "Couro", 2022, "Mala" ,Artigo.Estado.NOVO, 0, Artigo.Avaliação.BOM, "Mala preta de couro", "Louis Vuitton", "LV001", 1000.0, 1.0);
        //System.out.println(mala1.toString());

        
        Sapatilhas sapatilha = new Sapatilhas(42, true, "vermelho", LocalDate.of(2022, Month.JANUARY, 1), Sapatilhas.Tipos_Sapatilhas.PREMIUM, "Sapatilhas", Artigo.Estado.USADO, 1, Artigo.Avaliação.IMPECÁVEL, "Sapatilha confortável", "Nike", "NIK123", 100.0, 0.0);
        //System.out.println(sapatilha.toString());

        Encomenda en = new Encomenda();
        en.adicionarArtigo(tshirt);
        en.adicionarArtigo(mala1);
        //System.out.println(en.toString());
        en.removerArtigo(tshirt);
        en.adicionarArtigo(sapatilha);
        System.out.println(en.toString());


        Transportadoras t = new Transportadoras();
        System.out.println(t.calculaPrecoExpedicao(en));


        Apresentacao v = new Apresentacao();
        //Output out = new Output();
        //am.welcome();
        //out.screenClear();
        //am.printMenuInicial();
        //out.screenClear();
        //al.printMenuLogin();
        //am.printMenuEscolha();
        //am.printSair();

        ControllerLogin cl = new ControllerLogin();
        //cl.registaoi(v);
        //TShirt xdxd = cl.registarTshirt(v);
        //System.out.println(xdxd.toString());
        cl.interpretador(v);

        //TShirt teste = new TShirt();
        //System.out.println(teste.toString());
        





        //Sapatilhas sap = new Sapatilhas(sapatilha);
        //System.out.println(sapatilha.toString());
        //Neste caso o id mantem-se o mesmo, não sei se deveria ser
    }
}
