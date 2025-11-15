import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double soma = 0;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Digite a nota " + i + ": ");
            soma += sc.nextDouble();
        }

        double media = soma / 4;
        System.out.println("A média é: " + media);

        sc.close();
    }
}