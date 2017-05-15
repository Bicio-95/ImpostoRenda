package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controller.*;



public class PessoaFisicaTest {
	private CalculaImposto calculaImposto;
	private PessoaFisica pessoa;
	
	@Before
	public void setup(){
		calculaImposto = new CalculaImposto();
		pessoa = new PessoaFisica("Teste", "99999999999");
	}
	
	@Test
	public void testeBaseDeCalculo(){
		pessoa.setTotalDeRendimentos(16000);
		pessoa.setContribuicaoPrevidenciaraOficial(3000);
		double resultadoDoCalculoBase = calculaImposto.calculaBase(pessoa);
		assertEquals(13650.0, resultadoDoCalculoBase, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoInferiorA12Mil(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMenosQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMenosQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMenosQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(6);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMaiorQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMaiorQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoCompletaComBaseDeCalculoInferiorA12MilContribuinteMaiorQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(15000);
		pessoa.setContribuicaoPrevidenciaraOficial(4000);
		pessoa.setNumeroDependetes(6);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 0.005);
	}
	
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24Mil(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1035.0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMenosQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 954.0);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMenosQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 994.5);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMenosQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 994.5);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMaiorQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 981.0);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMaiorQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 1021.5);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA12MilEInferiorA24MilContribuinteMaiorQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(24000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(6);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 1064.0);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24Mil(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 0.005);
	}
	
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMenosQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(1665.0, impostoAPagar, 1566.0);
	}
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMenosQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 1615.5);
	}
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMenosQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(6);
		pessoa.setIdade(64);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 1665.0);
	}
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMaiorQue65AnosAte2Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(2);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 1599.0);
	}
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMaiorQue65AnosEntre3E5Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(4);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 1648.5);
	}
	@Test
	public void calculaDeclaracaoSimplificadaComBaseDeCalculoSuperiorA24MilContribuinteMaiorQue65AnosMaisDe5Dependentes(){
		pessoa.setTotalDeRendimentos(28000);
		pessoa.setContribuicaoPrevidenciaraOficial(6000);
		pessoa.setNumeroDependetes(6);
		pessoa.setIdade(66);
		double impostoAPagar = calculaImposto.calculaImpostoAPagar(pessoa);
		assertEquals(0, impostoAPagar, 1698.0);
	}
	
}