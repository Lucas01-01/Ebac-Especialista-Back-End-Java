import java.util.ArrayList;
import java.util.Scanner;

public class  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> masculino = new ArrayList<>();
        ArrayList<String> feminino = new ArrayList<>();
        
        String continuar;
        
        do {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite o sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();
            
            if (sexo.equals("M")) {
                masculino.add(nome);
            } else if (sexo.equals("F")) {
                feminino.add(nome);
            } else {
                System.out.println("Sexo inválido! Use M ou F.");
            }
            
            System.out.print("Deseja adicionar outra pessoa? (S/N): ");
            continuar = scanner.nextLine().toUpperCase();
            
        } while (continuar.equals("S"));
        
        System.out.println("\nGrupo Masculino:");
        for (String nome : masculino) {
            System.out.println(nome);
        }
        
        System.out.println("\nGrupo Feminino:");
        for (String nome : feminino) {
            System.out.println(nome);
        }
        
        scanner.close();
    }
}
