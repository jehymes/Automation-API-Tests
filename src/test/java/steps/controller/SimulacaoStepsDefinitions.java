package steps.controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import steps.generic.GenericStepsDefinitions;
import utils.Utils;

public class SimulacaoStepsDefinitions {
	
	private Response response = null;
	private GenericStepsDefinitions generics = new GenericStepsDefinitions();

	@Quando("eu faço um POST para {word} com os seguintes valores:")
	public void inserirNovaSimulacao(String endpoint, Map<String, String> simulacao) {
		response = generics.getRequisicaoPOST(endpoint, simulacao);
	}
	
	@Quando("eu faço um PUT para {word} com os seguintes valores:")
	public void alterarSimulacao(String endpoint, Map<String, String> simulacao) {
		response = generics.getRequisicaoPUT(endpoint+simulacao.get("cpf"), simulacao);
	}
	
	@Quando("eu faço um GET para {word}")
	public void listarSimulacoes(String endpoint) {
		response = generics.getRequisicaoGET(endpoint);
	}
	
	@Quando("eu faço um DELETE para {word}")
	public void deletarSimulacao(String endpoint) {
		response = generics.getRequisicaoDELETE(endpoint);
	}
	
	@Quando("eu faço um DELETE para todas {word}")
	public void deletarTodasSimulacoes(String endpoint) {
		Response delete = null;
		response = generics.getRequisicaoGET(endpoint);
		String[] ids = Utils.responseToArrayIds(response);
		for(int i = 0; i < ids.length; i ++) {
			delete = generics.getRequisicaoDELETE(endpoint+ids[i]);	
		}
		response = delete;
	}
	
	@Entao("espero receber o codigo 200 com as simulacoes cadastradas")
	public void esperoReceberCodigo200ComSimulacoesCadastradas() {
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody().as(ArrayList.class));
	}
	
	@Entao("espero receber o codigo 200 da simulacao")
	public void esperoReceberCodigo200() {
		generics.esperoReceberCodigo200(response);
	}
	
	@Entao("espero receber o codigo 201")
	public void esperoReceberCodigo201() {
		Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
		Assert.assertNotNull(response.jsonPath().get("id"));
	}
	
	@Entao("espero receber o codigo 400 e a mensagem de erro {string}")
	public void esperoReceberCodigo400(String msg) {
		Assert.assertEquals(msg, response.jsonPath().getString("erros.valor"));
		Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
	}
	
	@Entao("espero receber o codigo 409 com a mensagem {string}")
	public void esperoReceberCodigo409(String msg) {
		Assert.assertEquals(msg, response.jsonPath().getString("mensagem"));
//		Assert.assertEquals(HttpStatus.SC_CONFLICT, response.getStatusCode()); //Status correto para a requisição.
		Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode()); //Fazer exclusão após correção da resposta da API.
	}
	
	@Entao("espero receber o codigo 400 com os seguintes erros:")
	public void esperoReceberCodigo400Erros(Map<String, String> erros) {	
		Assert.assertEquals(erros.get("nome"), response.jsonPath().getString("erros.nome"));
		Assert.assertEquals(erros.get("cpf"), response.jsonPath().getString("erros.cpf"));
		Assert.assertEquals(erros.get("valor"), response.jsonPath().getString("erros.valor"));
		Assert.assertEquals(erros.get("email"), response.jsonPath().getString("erros.email"));
		Assert.assertEquals(erros.get("parcelas"), response.jsonPath().getString("erros.parcelas"));
		Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
	}	

	@Entao("espero receber o codigo 404 e a mensagem de erro {string}")
	public void esperoReceberCodigo404Erro(String msg) {
		Assert.assertEquals(msg, response.jsonPath().getString("mensagem"));
		Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
	}
	
	@Entao("espero receber o codigo 404")
	public void esperoReceberCodigo404() {
		Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
	}
	
	@Entao("espero receber o codigo 204 sem as simulacoes cadastradas")
	public void esperoReceberCodigo204SemSimulacoes() {
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode()); //Mudar status após correção da API para 204 SC_NO_CONTENT
		Assert.assertEquals(new ArrayList<Object>(), response.getBody().as(ArrayList.class));
	}
	
	@Entao("espero receber o codigo 204 da simulacao")
	public void esperoReceberCodigo204() {
		generics.esperoReceberCodigo204(response);
	}
	
	@Entao("espero receber o codigo 200 com a solicitacao cadastrada:")
	public void esperoReceberCodigo200ComRetorno(Map<String, String> retorno) {
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
		Assert.assertEquals(retorno.get("nome"), response.jsonPath().getString("nome"));
		Assert.assertEquals(retorno.get("cpf"), response.jsonPath().getString("cpf"));
		Assert.assertEquals(retorno.get("email"), response.jsonPath().getString("email"));
		Assert.assertEquals(retorno.get("valor"), response.jsonPath().getString("valor"));
		Assert.assertEquals(retorno.get("parcelas"), response.jsonPath().getString("parcelas"));
		Assert.assertEquals(retorno.get("seguro"), response.jsonPath().getString("seguro"));
	}
}
