
import java.io.Serializable;

public class Apresentacao implements Serializable {
    private final Output out;

    public Apresentacao() {
        out = new Output();
    }

    /**
     * Apresenta menu login
     */
    public void printMenuLogin() {
                out.printMenus((new String[]{"Login", "Registar"}),"MENU LOGIN",1);
    }
}