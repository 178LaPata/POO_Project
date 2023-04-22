package View;

import java.io.Serializable;

public class ViewLogin implements Serializable {
    private final Output out;

    public ViewLogin() {
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
}
    

