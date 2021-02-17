package jerseyfilters;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class Filter implements ContainerResponseFilter {
	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {

		response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
		response.getHttpHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
		return response;
	}
}