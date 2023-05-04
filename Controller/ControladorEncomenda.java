package Controller;

import Model.*;
import View.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControladorEncomenda implements Serializable{
    
    private final Input in;
    
    
    public ControladorEncomenda(){
        in = new Input();
    }

    public List<Integer> adicionarArtigo(Apresentacao a, List<Integer> carrinho, List<Integer> idDisponível){
        boolean id = false;
        
        while(!id){
            Integer idArtigo = in.lerInt(a, "Selecione o ID do artigo:", 0, 10000);
            
            if(idDisponível.contains(idArtigo) && !(carrinho.contains(idArtigo))){
                id = true;
                carrinho.add(idArtigo);
                a.printMessage("Artigo com ID " + idArtigo + " foi adicionado ao carrinho!");
            }
            else if (carrinho.contains(idArtigo)){a.printMessage("Artigo já selecionado.");}
            else{a.printMessage("ID do Artigo não existe.");}
        }
        return carrinho;
    }


    // método auxiliar para as compras
    private List<Integer> getIDArtigosVenda(List<Artigo> artigos){
        return artigos.stream().map(a -> a.getId()).collect(Collectors.toList());
    }


    public List<Integer> removerArtigo(Apresentacao a, List<Integer> carrinho){
        boolean id = false;

        while (!id){
            Integer idArtigo = in.lerInt(a, "Selecione o ID a remover: ", 0, 10000);

            if (carrinho.contains(idArtigo)){
                id = true;
                carrinho.remove(idArtigo);
                a.printMessage("Artigo com ID " + idArtigo + " foi removido do carrinho!");
            }
            else {a.printMessage("ID não existe no carrinho");}
        }
        return carrinho;
    }


    public double calculaCustoExpedicao(List<Artigo> artigosEncomenda, Vintage v){
        Map<String,Transportadoras> transp = v.getTransportadoras(); 
        double custosExpedicao = 0.0;

        for (String t : transp.keySet()){
            Long aux = artigosEncomenda.stream().filter(a -> a.getTransportadora().equals(t)).count();
            if (aux != 0){
            double expedicaoT = transp.get(t).calculaPrecoExpedicao(aux);
                transp.get(t).addVolFaturacao(expedicaoT);
                custosExpedicao+=expedicaoT;
            }
        }
        return custosExpedicao;
    }



    public void interpretador(Apresentacao a, Vintage v){
        boolean b = true;
        int comando;
        Utilizador u = v.getUtilizador(v.getSessaoAtual());
        List<Artigo> artigosVenda = v.getArtigosVenda(); // produtos disponíveis

        List<Integer> carrinho = new ArrayList<>(); // carrinho de compras
        List<Integer> idDisponivel = getIDArtigosVenda(artigosVenda);
        a.printArtigos(artigosVenda,v.getDataPrograma());


            
        while(b){
            a.printMenuEncomenda();
            comando = in.lerInt(a,"Escolha a sua opção:",0,3);
            
            switch(comando){
                case 1: // adicionar produto ao carrinho
                    a.printCarrinho(carrinho);
                    carrinho = adicionarArtigo(a, carrinho, idDisponivel);
                    break;

                case 2: // remover produto do carrinho
                    a.printCarrinho(carrinho);
                    carrinho = removerArtigo(a, carrinho);
                    break;

                
                case 3: // terminar encomenda
                    if (carrinho.isEmpty()){a.printMessage("Carrinho de Compras Vazio!");break;}
                    List<Artigo> artigos = new ArrayList<>();            // guarda a lista de artigos da encomenda
                    Map<Integer,String> vendedores = new HashMap<>();    // guarda o id do produto e o email do vendedor 
                    
                    for (int id : carrinho){
                        for (Utilizador user : v.getUtilizadores().values()){
                                user.getPorVender().stream().filter(art -> art.getId() == id)
                                                            .forEach(art -> {
                                                                artigos.add(art);                       // Adiciona o artigo à lista de artigos da encomenda
                                                                vendedores.put(id, u.getEmail());       // adiciona o id do produto e o email do dono respetivo
                                                            });
                                user.getPorVender().removeAll(artigos);     // Remove todos os artigos da lista de vendas que estão na encomenda
                        }
                    }
                    String dono = v.getSessaoAtual();
                    double custoExpedicao = calculaCustoExpedicao(artigos, v);

                    Encomenda encomenda = new Encomenda(dono, artigos, custoExpedicao, v.getDataPrograma(), vendedores);
                    v.addEncomenda(encomenda);
                    a.printMessage(encomenda.toString());
                    a.printMessage("Encomenda Finalizada com Sucesso!");

                
                case 0:
                    b = false;
                    break;
                default:
                    a.printMessage("Erro! Comando Inválido.");
                    break;
            }
        } 
    }


    public void interpretadorDevolver(Apresentacao a, Vintage v){
        List<Encomenda> encomendas = v.encomendasParaDevolver();
        if (encomendas.size() == 0){
            a.printMessage("Não existem encomendas para devolução.");
            return;
        }

        int encomenda = -1;
        a.printEncomendas(encomendas, v.getDataPrograma());

        List<Integer> idEnc = encomendas.stream().map(enc -> enc.getId()).collect(Collectors.toList());
        boolean b = true;
        while (b){
            encomenda = in.lerInt(a, "Escolha a encomenda que quer devolver: ", 0, 100000);
            if (idEnc.contains(encomenda)){b = false;}
            else{a.printMessage("Encomenda não existe.");}
        }
        v.devolverEncomenda(encomenda);
        a.printMessage("Encomenda foi devolvida.");
    }

        




}
