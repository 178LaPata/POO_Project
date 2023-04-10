import java.time.LocalDate;
import java.time.Month;

public class ArtigoTeste {

    public static void main(String[] args) {
        
        Artigo a = new Artigo("Camiseta", Artigo.Estado.NOVO, Artigo.Avaliação.SATISFATÓRIO, 2, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(a.toString());
        System.out.println("\n");

        Artigo b = new Artigo("Brinquedo", Artigo.Estado.USADO, Artigo.Avaliação.SATISFATÓRIO, 2, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(b.toString());
        System.out.println("\n");
        
        TShirt tshirt = new TShirt(TShirt.Tamanho.M, TShirt.Padrao.LISO, Artigo.Estado.USADO, Artigo.Avaliação.BOM, 1, "T-Shirt de algodão", "Nike", "NIK123", 30.0, 1.5);
        
        System.out.println(tshirt.toString());
        System.out.println("\n");
        
        Malas mala1 = new Malas(Malas.Tipos_Malas.NORMAL, 50.0f, "Couro", 2022, Artigo.Estado.NOVO, Artigo.Avaliação.BOM, 0, "Mala preta de couro", "Louis Vuitton", "LV001", 1000.0, 1.0);
        System.out.println(mala1.toString());
        System.out.println("\n");

        
        Sapatilhas sapatilha = new Sapatilhas(42, true, "vermelho", LocalDate.of(2022, Month.JANUARY, 1), Sapatilhas.Tipos_Sapatilhas.NORMAL, Artigo.Estado.USADO, 1, Artigo.Avaliação.IMPECÁVEL, "Sapatilha confortável", "Nike", "NIK123", 100.0, 0.0);
        System.out.println(sapatilha.toString());
        System.out.println("\n");

        //Sapatilhas sap = new Sapatilhas(sapatilha);
        //System.out.println(sapatilha.toString());
        // Neste caso o id mantem-se o mesmo, não sei se deveria ser
        
    }

}