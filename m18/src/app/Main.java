package app;

import model.Carro;
import annotations.Tabela;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Honda", "Civic");

        Class<?> clazz = carro.getClass();

        if (clazz.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = clazz.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabela.tabela());
        } else {
            System.out.println("Annotation @Tabela não encontrada.");
        }
    }
}
