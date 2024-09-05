package steps.controller;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import steps.generic.GenericStepsDefinitions;

public class RestricoesStepsDefinitions {
//	String msgResposta = "O CPF " + getCpfConsulta() + " tem problema";
//  Assert.assertEquals(msgResposta, response.jsonPath().getString("mensagem"));
	
	private Response response;
	private GenericStepsDefinitions generics = new GenericStepsDefinitions();

	@Quando("eu consulto pelo cpf {string} em {word}")
	public void euConsultoPeloCPF(String cpf, String endpoint) {
		response = generics.getRequisicaoGET(endpoint+cpf);
	}

	@Entao("espero receber o codigo 200 da restricao")
	public void esperoReceberCodigo200() {
		generics.esperoReceberCodigo200(response);
	}

	@Entao("espero receber o codigo 204 da restricao")
	public void esperoReceberCodigo204() {
		generics.esperoReceberCodigo204(response);
	}

}
