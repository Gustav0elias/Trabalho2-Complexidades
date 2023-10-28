package br.edu.ifba.residencia.cenario2.borda.atuador;

import java.util.List;

public interface Atuador<Leitura, Resultado> {

    Resultado atuar(List<Leitura> leituras);

}
