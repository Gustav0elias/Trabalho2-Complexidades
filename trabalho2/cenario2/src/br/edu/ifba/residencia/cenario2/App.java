package br.edu.ifba.residencia.cenario2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.github.javafaker.Faker;

import br.edu.ifba.residencia.cenario2.borda.impl.SensoresImpl;
import br.edu.ifba.residencia.cenario2.modelo.Residencia;
import br.edu.ifba.residencia.cenario2.nuvem.impl.ExecutorImpl;

public class App {
    private static final int TOTAL_DE_RESIDENCIAS = 10;
    private static final int TOTAL_DE_LEITURAS = 100;

    private static List<Thread> executores = new ArrayList<>();
    
    //A complexidade deste processo é linear, O(N), onde N é o número de residências.
    public static void iniciarProcessamentoDeLeituras(Map<Residencia, SensoresImpl> pacientes) {
        for (Entry<Residencia, SensoresImpl> item : pacientes.entrySet()) {
            Residencia paciente = item.getKey();
            SensoresImpl sensores = item.getValue();

            Thread executor = new Thread(new ExecutorImpl(paciente, sensores, TOTAL_DE_LEITURAS));
            executores.add(executor);

            executor.start();
        }
    } 

    //  A complexidade deste processo é linear, O(N), onde N é o número de residências.
    public static void esperarFinalizacaoDeProcessamento() throws InterruptedException {
        for (Thread executor : executores) {
            executor.join();
        }
    }

    //  A complexidade deste processo é linear, O(N), onde N é o número de residências.
    public static Map<Residencia, SensoresImpl> gerarResidencias() {
        Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));
    
        Map<Residencia, SensoresImpl> pacientes = new TreeMap<>();
        for (int i = 0; i < TOTAL_DE_RESIDENCIAS; i++) {
          int numeroResidencia = faker.number().numberBetween(1, 1000);
            Residencia paciente = new Residencia(numeroResidencia, "Endereço #" + numeroResidencia);
    
            pacientes.put(paciente, new SensoresImpl());
        }
    
        return pacientes;
    }
    
    public static void main(String[] args) throws Exception {
        Map<Residencia, SensoresImpl> pacientes = gerarResidencias();

        System.out.println("iniciando o processamento");
        iniciarProcessamentoDeLeituras(pacientes);
        esperarFinalizacaoDeProcessamento();

        System.out.println("processamento finalizado");
    }
}

