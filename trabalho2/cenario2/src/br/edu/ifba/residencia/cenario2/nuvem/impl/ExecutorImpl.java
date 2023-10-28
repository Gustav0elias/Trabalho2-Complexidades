package br.edu.ifba.residencia.cenario2.nuvem.impl;

import br.edu.ifba.residencia.cenario2.borda.impl.CalculadorSomaConsumoEnergiaComplexidadeCubica;
import br.edu.ifba.residencia.cenario2.borda.impl.DiagnosticoConsumoEnergia;
import br.edu.ifba.residencia.cenario2.borda.impl.SensoresImpl;
import br.edu.ifba.residencia.cenario2.modelo.ConsumoEnergia;
import br.edu.ifba.residencia.cenario2.modelo.Residencia;
import br.edu.ifba.residencia.cenario2.nuvem.executor.Executor;

public class ExecutorImpl extends Executor {

    private Residencia residencia = null;
    private SensoresImpl sensores = null;

    CalculadorSomaConsumoEnergiaComplexidadeCubica calculadorSoma;

    DiagnosticoConsumoEnergia diagnostico = new DiagnosticoConsumoEnergia();

    public ExecutorImpl(
            Residencia residencia, SensoresImpl sensores,
            int totalDeLeituras) {
        super(totalDeLeituras);

        this.residencia = residencia;
        this.sensores = sensores;
        this.calculadorSoma = new CalculadorSomaConsumoEnergiaComplexidadeCubica();
    }

    @Override
    public void processarLeitura(int leituraAtual) {
        if (sensores.temLeitura()) {
            ConsumoEnergia leitura = sensores.getLeitura();
            residencia.onLeitura(leitura);

            double somaConsumo = calculadorSoma.atuar(residencia.getLeituras());
               String verificarConsumo = diagnostico.atuar(residencia.getLeituras());

            System.out.println("Leitura registrada na verificação N-" + leituraAtual + " para a residência número " + residencia.getNome() + ", " +verificarConsumo + ": Soma do consumo de energia = " + somaConsumo + " kWh");
        }
    }

}


