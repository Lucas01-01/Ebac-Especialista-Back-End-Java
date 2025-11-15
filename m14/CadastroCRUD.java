import service.PessoaService;
import model.Pessoa;
import java.util.Scanner;

public class CadastroCRUD {
    public static void main(String[] args) {
        PessoaService service = new PessoaService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== CRUD Cadastro ===");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Atualizar pessoa");
            System.out.println("4. Deletar pessoa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    service.cadastrarPessoa(nome, email);
                    System.out.println("Pessoa cadastrada!");
                    break;
                case 2:
                    for(Pessoa p : service.listarPessoas()) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("ID da pessoa: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    if(service.atualizarPessoa(idAtualizar, novoNome, novoEmail)) {
                        System.out.println("Pessoa atualizada!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("ID da pessoa: ");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine();
                    if(service.deletarPessoa(idDeletar)) {
                        System.out.println("Pessoa deletada!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        scanner.close();
    }
}
