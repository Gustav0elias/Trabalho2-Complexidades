package br.edu.ifba.residencia.cenario1.nuvem.atuador;

import java.util.List;

public interface Atuador<Leitura, Resultado> {

    Resultado atuar(List<Leitura> leituras);
    
}
