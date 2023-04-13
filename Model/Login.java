package Model;

public class Login {
    private String email;
    private String password;
    private String nome;

    public Login() {
        this.email = "";
        this.password = "";
        this.nome = "";
    }

    public Login(String email, String password, String nome) {
        this.email = email;
        this.password = password;
        this.nome = nome;
    }

    public Login(Login l) {
        this.email = l.getemail();
        this.password = l.getPassword();
        this.nome = l.getNome();
    }

    public String getemail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if ((o == null) || (this.getClass() != o.getClass())) 
            return false;
        Login l = (Login) o;
        return (this.email.equals(l.getemail()) && 
                this.password.equals(l.getPassword()) && 
                this.nome.equals(l.getNome()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("email: ").append(this.email).append("\n");
        sb.append("Password: ").append(this.password).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        return sb.toString();
    }

    public Login clone() {
        return new Login(this);
    }
}
