package controller;



public class PessoaFisica {
	private String nome;
	private String cpf;
	private int idade;
	private int numeroDependetes;
	private double contribuicaoPrevidenciaraOficial;
	private double totalDeRendimentos;
	
	public PessoaFisica(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public PessoaFisica(String nome, String cpf, double totalDeRendimentos, double contribuicaoPrevidenciaraOficial) {
		this.nome = nome;
		this.cpf = cpf;
		if(contribuicaoPrevidenciaraOficial != 0 && totalDeRendimentos != 0){
			this.contribuicaoPrevidenciaraOficial = contribuicaoPrevidenciaraOficial;
			this.totalDeRendimentos = totalDeRendimentos;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public PessoaFisica(String nome, String cpf, int idade, int numeroDependetes, double totalDeRendimentos, double contribuicaoPrevidenciaraOficial) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.numeroDependetes = numeroDependetes;
		this.contribuicaoPrevidenciaraOficial = contribuicaoPrevidenciaraOficial;
		this.totalDeRendimentos = totalDeRendimentos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNumeroDependetes() {
		return numeroDependetes;
	}

	public void setNumeroDependetes(int numeroDependetes) {
		this.numeroDependetes = numeroDependetes;
	}

	public double getContribuicaoPrevidenciaraOficial() {
		return contribuicaoPrevidenciaraOficial;
	}

	public void setContribuicaoPrevidenciaraOficial(double contribuicaoPrevidenciaraOficial) {
		this.contribuicaoPrevidenciaraOficial = contribuicaoPrevidenciaraOficial;
	}

	public double getTotalDeRendimentos() {
		return totalDeRendimentos;
	}

	public void setTotalDeRendimentos(double totalDeRendimentos) {
		this.totalDeRendimentos = totalDeRendimentos;
	}

	public double declaracaoSimplificada(){
		return 1;
	}
	
	public double declaracaoCompleta(){
		
		return 1;
	}

	public boolean isImpostoSimples() {
		if(this.idade != 0 && this.numeroDependetes != 0){
			return false;
		} else {
			return true;
		}
	}
}