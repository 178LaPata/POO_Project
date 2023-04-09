public class ArtigoTeste {

    public static void main(String[] args) {
        
        Artigo a = new Artigo("Camiseta", Artigo.Estado.NOVO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(a.toString());

        Artigo b = new Artigo("Mala", Artigo.Estado.USADO, 2, Artigo.Avaliação.SATISFATÓRIO, "Camiseta branca de algodão", "Nike", "NIK123", 20.0, 1.2);

        System.out.println(b.toString());

        TShirt tshirt = new TShirt(TShirt.Tamanho.M, TShirt.Padrao.LISO, Artigo.Estado.USADO, 1, Artigo.Avaliação.BOM, "T-Shirt de algodão", "Nike", "NIK123", 30.0, 1.5);
        System.out.println(tshirt.toString());
    }

}