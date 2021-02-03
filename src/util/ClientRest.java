package util;

import java.io.IOException;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientRest<T> {
	private final String url = "http://localhost:8080/EWalletBiblioteca/rest/";
	private Class<T> tipo;
	private String dao;

	public ClientRest(Class<T> tipo,String dao) {
		this.tipo = tipo;
		this.dao = dao;
	}

	@SuppressWarnings("hiding")
	public <T> T get(String azione, MultivaluedMap<String, String> queryParams) throws JsonParseException,
			JsonMappingException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Client client = Client.create();

		//String dao = tipo.toString().split("Response")[1];

		String path = url + dao + "/" + azione;

		// queryParams.add(dataType, path);

		WebResource webResource = client.resource(path);

		ClientResponse responseJson = webResource.queryParams(queryParams).accept("application/json")
				.get(ClientResponse.class);

		if (responseJson.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + responseJson.getStatus());
		}

		String output = responseJson.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		T result = (T) mapper.readValue(output, this.tipo);

		return result;
	}

	@SuppressWarnings("hiding")
	public <T> T post(Object obj) throws JsonParseException, JsonMappingException, IOException,
			InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Client client = Client.create();
		
		String azione = "insert";


		String path = url + dao + "/" + azione;

		// queryParams.add(dataType, path);
		ObjectMapper objectMapper = new ObjectMapper();
		String objectAsJson = objectMapper.writeValueAsString(obj);

		WebResource webResource = client.resource(path);

		ClientResponse responseJson = webResource.type("application/json").accept("application/json")
				.post(ClientResponse.class, objectAsJson);

		if (responseJson.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + responseJson.getStatus());
		}

		String output = responseJson.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		T result = (T) mapper.readValue(output, this.tipo);

		return result;
	}

	@SuppressWarnings("hiding")
	public <T> T delete(Object obj) throws JsonParseException,
			JsonMappingException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Client client = Client.create();

		String azione = "remove";
		

		String path = url + dao + "/" + azione;

		// queryParams.add(dataType, path);
		ObjectMapper objectMapper = new ObjectMapper();
		String objectAsJson = objectMapper.writeValueAsString(obj);
		
		WebResource webResource = client.resource(path);

		ClientResponse responseJson = webResource.type("application/json").accept("application/json")
				.delete(ClientResponse.class,objectAsJson);

		if (responseJson.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + responseJson.getStatus());
		}

		String output = responseJson.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		T result = (T) mapper.readValue(output, this.tipo);

		return result;
	}

	@SuppressWarnings("hiding")
	public <T> T put(Object obj) throws JsonParseException,
			JsonMappingException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Client client = Client.create();

		String azione = "update";
		

		String path = url + dao + "/" + azione;

		// queryParams.add(dataType, path);
		ObjectMapper objectMapper = new ObjectMapper();
		String objectAsJson = objectMapper.writeValueAsString(obj);

		WebResource webResource = client.resource(path);

		ClientResponse responseJson = webResource.type("application/json").accept("application/json")
				.put(ClientResponse.class,objectAsJson);

		if (responseJson.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + responseJson.getStatus());
		}

		String output = responseJson.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		T result = (T) mapper.readValue(output, this.tipo);

		return result;
	}
}
