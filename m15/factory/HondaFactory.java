package factory;

import interfaces.Carro;
import interfaces.Moto;
import modelos.HondaCarro;
import modelos.HondaMoto;

public class HondaFactory implements CarFactory {
    @Override
    public Carro criarCarro() {
        return new HondaCarro();
    }

    @Override
    public Moto criarMoto() {
        return new HondaMoto();
    }
}
