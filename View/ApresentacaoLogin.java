package View;

import java.io.Serializable;

public class ApresentacaoLogin implements Serializable {
    private final Output out;

    public ApresentacaoLogin() {
        out = new Output();
    }

    public void printMenuLogin() {
        out.printMenus((new String[]{"Login", "Registar"}),"     MENU LOGIN",1);
    }

    public void printLoginSucesso() {
        System.out.println("Login efetuado com sucesso");
    }

    public void printLogoutSucesso() {
        System.out.println("Logout efetuado com sucesso");
    }

    public void printRegistoSucesso() {
        System.out.println("Registo efetuado com sucesso");
    }

    public void printErroDadosInvalidos() {
        System.out.println("Dados inválidos");
    }

    public void printUsername() {
        System.out.println("Username: ");
    }

    public void printPassword() {
        System.out.println("Password: ");
    }

    public void printRegisto(){
        System.out.println("Introduza os seus dados");
        System.out.println("Nome: ");
        System.out.println("Email: ");
        System.out.println("Password: "); // isto nao deveria ficar como atributo do utilizador?
        System.out.println("Morada: ");
        System.out.println("NIF: ");
    }
}
    

