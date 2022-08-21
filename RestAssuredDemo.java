import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredDemo {

	public static void main(String[] args) throws Exception {


		//String baseUrl="https://github.com/TechyQuicky/1stRepository/blob/main/2022-08-08%2013-51-34.mp4?raw=true";
		
		Response response = RestAssured.get("https://api.assemblyai.com/v2/transcript/oao8i1x379-f47f-462a-90b7-554043ccee5a");
		
		System.out.println("Response : "+response.asString());
		System.out.println("Status Code : "+response.getStatusCode());
		System.out.println("Body : "+response.getBody().asString());
		System.out.println("Time Taken : "+response.getTime());
		System.out.println("Header : "+response.getHeader("content-type"));
		
		
		
		
		//String jsonRequest = response.getContentType(contentType.JSON);
		
		//HttpRequest postRequest = HttpRequest.newBuilder()
		//	.uri(new URI("https://api.assemblyai.com/v2/transcript"))
		//	.header("Authorization", "779cbe36fcca45a2851cfed47c299630") 
		//	.POST(BodyPublishers.ofString(postRequest))
		//	.build();
			
		//("https://api.assemblyai.com/v2/transcript");
				//.given().auth().contentType(ContentType.JSON).accept(ContentType.JSON).body();
				
				
				
	

	}

}
