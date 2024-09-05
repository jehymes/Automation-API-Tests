package steps.generic;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenericStepsDefinitions {
	
	public Response getRequisicaoPOST(String uri, Map<String, String> request) {
		return given().
				contentType(ContentType.JSON).
				body(request).
				when().
				post(uri).
				then().
				extract().
				response();
	}

	public Response getRequisicaoPUT(String uri, Map<String, String> request) {
		return given().
				contentType(ContentType.JSON).
				body(request).
				when().
				put(uri).
				then().
				extract().
				response();
	}
	
	public Response getRequisicaoGET(String uri) {
		return given().
				when().
				get(uri).
				then().
				extract().
				response();
	}
	
	public Response getRequisicaoDELETE(String uri) {
		return given().
				when().
				delete(uri).
				then().
				extract().
				response();
	}

	public void esperoReceberCodigo200(Response response) {
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
	}

	public void esperoReceberCodigo204(Response response) {
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
	}
}
