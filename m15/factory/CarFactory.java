package factory;

import interfaces.Carro;
import interfaces.Moto;

public interface CarFactory {
    Carro criarCarro();
    Moto criarMoto();
}
