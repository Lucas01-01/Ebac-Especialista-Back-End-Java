package app;

import annotations.Tabela;

@Tabela(tabela = "carros")
public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Main.class;

        if (clazz.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = clazz.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabela.tabela());
        } else {
            System.out.println("Annotation @Tabela não encontrada.");
        }
    }
}
