import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ler valor numerico do console
        System.out.print("Digite um numero inteiro: ");
        int valorPrimitivo = sc.nextInt(); // tipo primitivo

        // conversao para wrapper
        Integer valorWrapper = Integer.valueOf(valorPrimitivo);

        // imprimir no console
        System.out.println("Primitivo: " + valorPrimitivo);
        System.out.println("Wrapper: " + valorWrapper);

        sc.close();
    }
}
