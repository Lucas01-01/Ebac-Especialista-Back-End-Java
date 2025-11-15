import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes separados por vírgula:");
        String entrada = scanner.nextLine();

        // divide a string em partes usando a vírgula como separador
        String[] nomes = entrada.split(",");

        // remove espaços extras e coloca em uma lista
        List<String> lista = new ArrayList<>();
        for (String nome : nomes) {
            lista.add(nome.trim());
        }

        // ordena em ordem alfabética
        Collections.sort(lista);

        // imprime o resultado
        System.out.println("Nomes em ordem alfabética:");
        for (String nome : lista) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
