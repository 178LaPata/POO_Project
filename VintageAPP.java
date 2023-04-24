import Model.*;
import View.*;
import Controller.*;


import java.util.*;
import java.io.*;

public class VintageAPP {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        List<Artigo> compras = new ArrayList<>();
        List<Artigo> vendas = new ArrayList<>();
        List<Artigo> porVender = new ArrayList<>();

        Utilizador utilizador = new Utilizador("email@example.com", "password", "Nome Sobrenome", "Rua Nome da Rua, Número 123", 123456789, compras, vendas, porVender);

        Vintage v = new Vintage();
        Apresentacao a = new Apresentacao();
 

        Controlador c = new Controlador();
        c.interpretador(v,a);

        
    }
}
