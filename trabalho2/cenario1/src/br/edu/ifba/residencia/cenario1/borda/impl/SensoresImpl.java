package br.edu.ifba.residencia.cenario1.borda.impl;

import java.util.Random;

import br.edu.ifba.residencia.cenario1.borda.sensores.Sensores;
import br.edu.ifba.residencia.cenario1.modelo.ConsumoEnergia;

public class SensoresImpl implements Sensores<ConsumoEnergia> {

    private static final double CONSUMONORMAL = 152.2;
 

    private static final int OSCILACAO_MAXIMA_CONSUMO = 80;


    private ConsumoEnergia leituraRecente = new ConsumoEnergia(CONSUMONORMAL);

    // constante, O(1)
    @Override
    public boolean temLeitura() {
        Random randomizador = new Random();

        int guardarOscilacao = randomizador.nextInt(OSCILACAO_MAXIMA_CONSUMO);
        boolean somar = randomizador.nextBoolean();
   


        double consumo = (double) (somar? CONSUMONORMAL + (CONSUMONORMAL * guardarOscilacao / 100):
            CONSUMONORMAL - (CONSUMONORMAL * guardarOscilacao / 100));

        leituraRecente = new ConsumoEnergia( consumo);

        return true;
    }

    @Override
    public ConsumoEnergia getLeitura() {
        return leituraRecente;
    }
    
}
