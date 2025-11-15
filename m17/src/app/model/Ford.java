package app.model;

public class Ford extends Carro {
    public Ford(String modelo) {
        super("Ford", modelo);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Marca: " + getMarca() + " | Modelo: " + getModelo());
    }
}