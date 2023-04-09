public class ArtigoTeste {

    public static void main(String[] args) {
        
        Artigo a = new Artigo("Camiseta", Artigo.Estado.NOVO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(a.toString());
        System.out.println("\n");

        Artigo b = new Artigo("Brinquedo", Artigo.Estado.USADO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(b.toString());
        System.out.println("\n");
        
        TShirt tshirt = new TShirt(TShirt.Tamanho.M, TShirt.Padrao.LISO, Artigo.Estado.USADO, 1, Artigo.Avaliação.BOM, "T-Shirt de algodão", "Nike", "NIK123", 30.0, 1.5);
        
        System.out.println(tshirt.toString());
        System.out.println("\n");
        
        Malas mala1 = new Malas(Malas.Tipos_Malas.NORMAL, 50.0f, "Couro", 2022, Artigo.Estado.NOVO, 0, Artigo.Avaliação.BOM, "Mala preta de couro", "Louis Vuitton", "LV001", 1000.0, 1.0);
        System.out.println(mala1.toString());
    }

}