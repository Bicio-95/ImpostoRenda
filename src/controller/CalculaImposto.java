package controller;

public class CalculaImposto {
	
	public double calculaBase(PessoaFisica p) {
		double totalDeRendimentosMenosContribuicaoPrevidenciaria = p.getTotalDeRendimentos() - p.getContribuicaoPrevidenciaraOficial();
		double percentual;
		if(p.isImpostoSimples()){
			percentual = 0.05;
		} else {
			percentual = verificaDescontoPorIdade(p);
		}
		return totalDeRendimentosMenosContribuicaoPrevidenciaria + (percentual * totalDeRendimentosMenosContribuicaoPrevidenciaria);
	}

	private double verificaDescontoPorIdade(PessoaFisica p) {
		if(p.getIdade() < 65){
			if(p.getNumeroDependetes() <= 2){
				return 0.02;
			} else if(p.getNumeroDependetes() <= 5){
				return 0.035;
			} else {
				return 0.05;
			}
		} else {
			if(p.getNumeroDependetes() <= 2){
				return 0.03;
			} else if(p.getNumeroDependetes() <= 5){
				return 0.045;
			} else {
				return 0.06;
			}
		}
	}

	public double calculaImpostoAPagar(PessoaFisica p) {
			double totalCalculado = calculaBase(p);
			double impostoAPagar = 0;
			double valorExcedente;
			if(totalCalculado <= 12000){
				return impostoAPagar;
			} else if (totalCalculado > 12000 && totalCalculado < 24000){
				valorExcedente = totalCalculado - 12000;
				return calculaValor(valorExcedente, 0.15);
			} else { //verificar!
				valorExcedente = totalCalculado - 24000;
				return calculaValor(valorExcedente, 0.275);
			}
	}

	private double calculaValor(double valor, double porcentagem){
		return valor * porcentagem;
	}

}
