package app.model;

public class Toyota extends Carro {
    public Toyota(String modelo) {
        super("Toyota", modelo);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Marca: " + getMarca() + " | Modelo: " + getModelo());
    }
}