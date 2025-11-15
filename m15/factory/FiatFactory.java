package factory;

import interfaces.Carro;
import interfaces.Moto;
import modelos.FiatCarro;
import modelos.FiatMoto;

public class FiatFactory implements CarFactory {
    @Override
    public Carro criarCarro() {
        return new FiatCarro();
    }

    @Override
    public Moto criarMoto() {
        return new FiatMoto();
    }
}
