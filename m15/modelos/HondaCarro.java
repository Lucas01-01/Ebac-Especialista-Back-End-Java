package modelos;

import interfaces.Carro;

public class HondaCarro implements Carro {
    @Override
    public void exibirInfo() {
        System.out.println("Carro Honda Civic 2.0");
    }
}
