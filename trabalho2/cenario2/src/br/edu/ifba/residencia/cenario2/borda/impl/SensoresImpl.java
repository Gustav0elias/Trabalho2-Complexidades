package br.edu.ifba.residencia.cenario2.borda.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import br.edu.ifba.residencia.cenario2.borda.sensores.Sensores;
import br.edu.ifba.residencia.cenario2.modelo.ConsumoEnergia;

public class SensoresImpl implements Sensores<ConsumoEnergia> {


    private static final double CONSUMONORMAL = 152.2;
 


    private static final int OSCILACAO_MAXIMA_CONSUMO = 90;

    private static final int TOLERANCIA_DE_OSCILACAO_CONSUMO = 5;

    private static final int LIMITE_DE_LEITURAS_PARA_ATUACAO = 15;

    private Queue<ConsumoEnergia> ultimasLeituras = new LinkedList<>();
    private ConsumoEnergia leituraRecente = new ConsumoEnergia(CONSUMONORMAL);

    public SensoresImpl() {
      
    }

      //A complexidade é  linear, O(N) pois possui apenas 1 looping for iterando

    @Override
    public boolean temLeitura() {
        boolean tem = false;

        Random randomizador = new Random();



       int guardarOscilacao = randomizador.nextInt(OSCILACAO_MAXIMA_CONSUMO);
        boolean  somar = randomizador.nextBoolean();
        int consumo = (int) (somar? CONSUMONORMAL + (CONSUMONORMAL * guardarOscilacao / 100):
            CONSUMONORMAL - (CONSUMONORMAL * guardarOscilacao / 100));

        if ((Math.abs(consumo - leituraRecente.getValor()) > TOLERANCIA_DE_OSCILACAO_CONSUMO)) {
            tem = true;

            leituraRecente = new ConsumoEnergia(consumo);
            ultimasLeituras.add(leituraRecente);

            if (ultimasLeituras.size() > LIMITE_DE_LEITURAS_PARA_ATUACAO) {
                ultimasLeituras.remove();
            }

            List<ConsumoEnergia> listaConsumoEnergia = new ArrayList<>();
            listaConsumoEnergia.addAll(ultimasLeituras);

            leituraRecente.setVereditoConsumoEnergia(new DiagnosticoConsumoEnergia().atuar(listaConsumoEnergia));
        }   

        return tem;
    }

    @Override
    public ConsumoEnergia getLeitura() {
        return leituraRecente;
    }
    
}
