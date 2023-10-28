package br.edu.ifba.residencia.cenario1.nuvem.impl;

import java.util.List;

import br.edu.ifba.residencia.cenario1.modelo.ConsumoEnergia;
import br.edu.ifba.residencia.cenario1.nuvem.atuador.Atuador;

public class Diagnostico implements Atuador<ConsumoEnergia, String> {



    private static final Double CONSUMO_ALTA_KHW = 250.6; //Os dados para saber a base de consumo de energia foram tiradas do site aen.pr.gov.br
    private static final Double CONSUMO_BAIXO_KHW = 160.5; //Os dados para saber a base de consumo de energia foram tiradas do site aen.pr.gov.br

    //A complexidade é  linear, O(N) pois possui apenas 1 looping for iterando
    @Override
    public String atuar(List<ConsumoEnergia> leituras) {
        String vereditoConsumoEnergia = "";

        double  indiceConsumo = .0;
        for (ConsumoEnergia leitura: leituras) {
    
            indiceConsumo += leitura.getValor();
        }

  
        indiceConsumo /= leituras.size();


        if (indiceConsumo >= CONSUMO_ALTA_KHW) {
            vereditoConsumoEnergia += "O consumo mensal de energia em kWh é alto nessa residência ";
        } else if (indiceConsumo >= CONSUMO_BAIXO_KHW && indiceConsumo <= CONSUMO_ALTA_KHW) {
            vereditoConsumoEnergia += "O Consumo de energia em kWh está dentro dos padrões nacionais de consumo de enrgia";
        }

        else {
            vereditoConsumoEnergia += "O Consumo de energia em kWh é baixo nessa residência";
        }



        return vereditoConsumoEnergia;
    }
    
}
