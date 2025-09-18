import java.util.*;

class User {
    private String nome;
    private String email;
    private String senha;
    private int idUser;

    Scanner scanner = new Scanner(System.in);

    User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUser = idUser;
    }

    Map<Integer, User> userMap = new HashMap<>();

    public User cadastroUser(String nome, String email, String senha) {
        User novoUser = new User(idUser++, nome, email, senha);
        userMap.put(idUser, novoUser);
        System.out.println("Usuário criado com sucesso!");
        return novoUser;
    }

    public int login(String nome, String email, String senha) {
        if (userMap.containsKey(nome) || userMap.containsKey(email)){
            if(userMap.get(nome).equals(senha)){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            return 2;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return idUser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mudarSenha(User user) {
        if (user != null) {
            System.out.print("Agora, digite a sua nova senha: ");
            String senhaNova = scanner.nextLine();
            user.setSenha(senhaNova);
            System.out.println("Senha alterada com sucesso!");
            System.out.println("Pressione Enter para continuar...");
        } else {
            System.out.println("Não foi possível alterar a senha. Usuário inválido.");
            return;
        }
    }

    public void mudarEmail(User user) {
        if (user != null) {
            System.out.print("Digite o seu novo e-mail: ");
            String emailNovo = scanner.nextLine();
            user.setEmail(emailNovo);
            System.out.println("Email alterado com sucesso!");
            System.out.println("Pressione Enter para continuar...");
        } else {
            System.out.println("Não foi possível alterar a senha. Usuário inválido");
        }
    }

}

class Conta {
    private User user;
    private double saldo;
    private String senhaT;
    private int contaId;

    Scanner scanner = new Scanner(System.in);

    Conta(User user, double saldo, String senhaT, int idConta) {
        this.user = user;
        this.saldo = saldo;
        this.senhaT = senhaT;
        this.contaId = contaId;
    }

    Map<Double, Conta> contaMap = new HashMap<>();

    public Conta criarConta(double saldo, String senhaT){
        Conta contaNova = new Conta(user, saldo, senhaT, contaId++);
        contaMap.put(saldo, contaNova);
        System.out.println("Conta criada com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
        return contaNova;
    }

    public void deposito(double valor, String senhaT){
        if(valor <= 0){
            System.out.println("Valor inválido. Digite novamente outro valor.");
        }
        else{
            Conta contaDeposito = contaMap.get(contaId);
            saldo += valor;
        }
    }

    public void saque(double valor, String senhaT){
        if(valor <= 0){
            System.out.println("Valor inválido. Digite novamente outro valor.");
        }
        if(valor > saldo){
            System.out.println("Valor inválido. Saldo insuficiente.");
        }
        else{
            Conta contaDeposito = contaMap.get(contaId);
            saldo -= valor;
        }
    }

    public void transferencia(int destino, double valor, String senhaT){
        if(!contaMap.containsKey(destino)){
            System.out.println("Destino inválido. Tente novamente outro ID.");
        }
        if(valor <= 0){
            System.out.println("Valor inválido. Digite novamente outro valor.");
        }
        if(valor > saldo){
            System.out.println("Valor inválido. Saldo insuficiente.");
        }
        else{
            Conta contaDeposito = contaMap.get(contaId);
            saldo -= valor;
        }
    }

    public void mudarSenhaT(String senhaT){
        if(contaMap.get(contaId).equals(senhaT)){
            System.out.print("Digite a sua nova senha: ");
            String senhaNovaT = scanner.nextLine();
            senhaT = senhaNovaT;
            System.out.println("Senha de transação alterada com sucesso!");
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
        }
        else{
            System.out.println("Senha incorreta. Tente novamente!");
        }
    }

}


public class Main {
    public static void main(String[] args) {
        byte op = 0;
        Scanner scanner = new Scanner(System.in);

        Map<Integer, User> userMap = new HashMap<>();
        Map<Double, Conta> contaMap = new HashMap<>();

        while(op != 9){
            System.out.println("================BankOS 1.0===============");
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("9. Sair");
            op = Byte.parseByte(scanner.nextLine());

            switch(op){
                case 1:
                    System.out.println("Digite o seu nome de usuário: ");
                    String nomeCadastro = scanner.nextLine();
                    System.out.println("Digite o seu e-mail:");
                    String emailCadastro = scanner.nextLine();
                    System.out.println("Digite a sua senha:");
                    String senhaCadastro = scanner.nextLine();
                    User novoUser = new User(nomeCadastro, emailCadastro, senhaCadastro);
                    novoUser.cadastroUser(nomeCadastro, emailCadastro, senhaCadastro);

            }

        }
    }
}
