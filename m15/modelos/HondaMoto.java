package modelos;

import interfaces.Moto;

public class HondaMoto implements Moto {
    @Override
    public void exibirInfo() {
        System.out.println("Moto Honda CB 500");
    }
}
