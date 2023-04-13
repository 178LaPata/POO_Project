package Model;

public class Login {
    private String username;
    private String password;
    private String nome;

    public Login() {
        this.username = "";
        this.password = "";
        this.nome = "";
    }

    public Login(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }

    public Login(Login l) {
        this.username = l.getUsername();
        this.password = l.getPassword();
        this.nome = l.getNome();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return (this.username.equals(l.getUsername()) && 
                this.password.equals(l.getPassword()) && 
                this.nome.equals(l.getNome()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(this.username).append("\n");
        sb.append("Password: ").append(this.password).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        return sb.toString();
    }

    public Login clone() {
        return new Login(this);
    }
}
