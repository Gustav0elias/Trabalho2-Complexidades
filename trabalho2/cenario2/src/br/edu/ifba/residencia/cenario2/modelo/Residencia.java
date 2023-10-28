package br.edu.ifba.residencia.cenario2.modelo;

import java.util.ArrayList;
import java.util.List;


// constante, O(1)
public class Residencia implements Comparable<Residencia> {

    private String id = "";
    private int nome;

    private List<ConsumoEnergia> leituras = new ArrayList<>();
    private ConsumoEnergia leituraRecente = null;

    public Residencia(int nome, String id) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

        public List<ConsumoEnergia> getLeituras() {
        return leituras;
    }

    public void setLeituras(List<ConsumoEnergia> leituras) {
        this.leituras = leituras;
    }

    public ConsumoEnergia getleituraRecente() {
        return leituraRecente;
    }

    public void setleituraRecente(ConsumoEnergia leituraRecente) {
        this.leituraRecente = leituraRecente;
    }

    public void onLeitura(ConsumoEnergia leitura) {
        this.leituras.add(leitura);
        this.leituraRecente = leitura;
    }

    @Override
    public int compareTo(Residencia outroPaciente) {
        return id.compareTo(outroPaciente.getId());
    }

}
