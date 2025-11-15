package modelos;

import interfaces.Carro;

public class FiatCarro implements Carro {
    @Override
    public void exibirInfo() {
        System.out.println("Carro Fiat Cronos 1.3");
    }
}
