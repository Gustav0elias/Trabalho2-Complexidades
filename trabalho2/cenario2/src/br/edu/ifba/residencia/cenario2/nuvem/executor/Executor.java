package br.edu.ifba.residencia.cenario2.nuvem.executor;

import java.util.Random;

public abstract class Executor implements Runnable {
    
    protected int totalDeLeituras = 0;

    public Executor(int totalDeLeituras) {
        this.totalDeLeituras = totalDeLeituras;
    }

    //A complexidade é  linear, O(N) pois possui apenas 1 looping for iterando
    @Override
    public void run() {
        Random randomizador = new Random();

        for (int i = 0; i < totalDeLeituras; i++) {
            this.processarLeitura(i + 1);

            try {
                Thread.sleep(randomizador.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void processarLeitura(int leituraAtual);

}
