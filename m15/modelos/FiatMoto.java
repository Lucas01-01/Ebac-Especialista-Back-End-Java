package modelos;

import interfaces.Moto;

public class FiatMoto implements Moto {
    @Override
    public void exibirInfo() {
        System.out.println("Moto Fiat Concept Scooter");
    }
}
