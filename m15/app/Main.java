package app;

import factory.CarFactory;
import factory.FiatFactory;
import factory.HondaFactory;
import interfaces.Carro;
import interfaces.Moto;

public class Main {
    public static void main(String[] args) {
        CarFactory fiatFactory = new FiatFactory();
        Carro carroFiat = fiatFactory.criarCarro();
        Moto motoFiat = fiatFactory.criarMoto();

        carroFiat.exibirInfo();
        motoFiat.exibirInfo();

        CarFactory hondaFactory = new HondaFactory();
        Carro carroHonda = hondaFactory.criarCarro();
        Moto motoHonda = hondaFactory.criarMoto();

        carroHonda.exibirInfo();
        motoHonda.exibirInfo();
    }
}
