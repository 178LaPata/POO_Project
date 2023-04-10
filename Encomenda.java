import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    
    public enum Dimensao_Embalagem {
        GRANDE,
        MEDIO,
        PEQUENO
    }
    
    public enum Estado_Encomenda {
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    
    private List<Artigo> artigos;
    private Dimensao_Embalagem embalagem;
    private double precoFinal;
    private double taxaSatisfacao;                  // 0,5 caso seja novo, 0.25 nos outros casos
    private double custosExpedicao;                 // Dependem da transportadora, na classe Artigo vamos ter de adicionar a transportadora depois
    private Estado_Encomenda estado;
    private LocalDate dataCriacao;
    

    // Construtor vazio
    public Encomenda() {
        this.artigos = new ArrayList<>();
        this.precoFinal = 0;
        this.taxaSatisfacao = 0.5;
        this.custosExpedicao = 0;
        this.estado = Estado_Encomenda.PENDENTE;
        this.dataCriacao = LocalDate.now();
    }

    // Falta o construtor a receber outra encomenda



    //getters e setters


    // Quando adicionamos um produto a uma Encomenda, o seu preço é incrementado
    public void adicionarArtigo(Artigo artigo) {
        this.artigos.add(artigo);
        double pf = artigo.getPrecoBase() - (artigo.getPrecoBase() * artigo.getCorrecaoPreco() / 100.0);  // basicamente nós aqui aplicamos o desconto ao preco base do produto
        if (artigo.getEstado() == Artigo.Estado.NOVO){
            pf+=0.5;
        }else{
            pf+=0.25;
        }
        this.precoFinal+=pf;
    }
    
    // Quando retiramos um produto a uma Encomenda, o seu preço é reduzido
    public void removerArtigo(Artigo artigo) {
        this.artigos.remove(artigo);
        double pf = artigo.getPrecoBase() - (artigo.getPrecoBase() * artigo.getCorrecaoPreco() / 100.0);  // basicamente nós aqui aplicamos o desconto ao preco base do produto
        if (artigo.getEstado() == Artigo.Estado.NOVO){
            pf+=0.5;
        }else{
            pf+=0.25;
        }
        this.precoFinal-=pf;
    }




    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("Encomenda criada em: " + dataCriacao + "\n");
    
    sb.append("==========Artigos===================\n");
    for (Artigo artigo : artigos) {
        sb.append(artigo.toString() + "\n");
    }
    sb.append("=====================================\n");
    
    sb.append("Dimensão da embalagem: " + embalagem + "\n");
    
    sb.append("Preço final: " + precoFinal + "\n");
    
    sb.append("Estado da encomenda: " + estado + "\n");
    
    return sb.toString();
    }
}