package br.edu.ifba.residencia.cenario2.modelo;
import java.text.DecimalFormat;

// constante, O(1)
public class ConsumoEnergia {
    private Integer id = 0;
    private Double valor = 0.0; // Alterado para Double para representar o consumo em kWh
    private Residencia residencia; // Adicionamos uma referência à Residencia

    private String  vereditoConsumoEnergia = "";
    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public Double getValor() {
        return valor;
    }



    public void setValor(Double valor) {
        this.valor = valor;
    }



    public Residencia getResidencia() {
        return residencia;
    }



    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }



    public String getVereditoConsumoEnergia() {
        return vereditoConsumoEnergia;
    }



    public void setVereditoConsumoEnergia(String vereditoConsumoEnergia) {
        this.vereditoConsumoEnergia = vereditoConsumoEnergia;
    }

    private int totalDePadroes = 0;

    public ConsumoEnergia(double valor) {
        this.valor =valor;
    
    }

   

    public int getTotalDePadroes() {
        return totalDePadroes;
    }

    public void setTotalDePadroes(int totalDePadroes) {
        this.totalDePadroes = totalDePadroes;
    }

    @Override
    public String toString() {
        // Crie um DecimalFormat para limitar o número de casas decimais
        DecimalFormat df = new DecimalFormat("#.##");

        // Formate o valor com duas casas decimais e inclua na string de saída
        return "Consumo de energia em kWh/h: " + df.format(valor) + " relacionado à " + residencia.getNome();
    }

}
