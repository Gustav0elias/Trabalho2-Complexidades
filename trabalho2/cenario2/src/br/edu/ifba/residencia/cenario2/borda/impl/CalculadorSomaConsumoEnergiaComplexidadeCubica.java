package br.edu.ifba.residencia.cenario2.borda.impl;

import java.util.List;

import br.edu.ifba.residencia.cenario2.borda.atuador.Atuador;
import br.edu.ifba.residencia.cenario2.modelo.ConsumoEnergia;


public class CalculadorSomaConsumoEnergiaComplexidadeCubica implements Atuador<ConsumoEnergia, Double> {

    // Método para calcular a soma do consumo de energia com complexidade O(N^3)
    @Override
    public Double atuar(List<ConsumoEnergia> leituras) {
        double somaConsumo = 0.0;
        int n = leituras.size();
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    somaConsumo += leituras.get(k).getValor();
                }
            }
        }
        
        return somaConsumo;
    }
}
