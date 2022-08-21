
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class RestApiTest {
	
	public static void main (String[] args) throws Exception {
		
		Transcript transcript = new Transcript();
		
		transcript.setAudio_url("https://github.com/TechyQuicky/1stRepository/blob/main/2022-08-08%2013-51-34.mp4?raw=true");
		
		Gson gson = new Gson();
		
		String jsonRequest = gson.toJson(transcript);
		
		System.out.println(jsonRequest);
		
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.assemblyai.com/v2/transcript"))
			.header("Authorization", "779cbe36fcca45a2851cfed47c299630")
				.POST(BodyPublishers.ofString(jsonRequest))
				.build();
				
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse <String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		
			System.out.println(postResponse.body());	
			
			transcript = gson.fromJson(postResponse.body(), Transcript.class);
			
			System.out.println(transcript.getId());
			
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
				    .header("Authorization", "779cbe36fcca45a2851cfed47c299630")
					.build();
			
			while(true) {
			
			HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
			transcript = gson.fromJson(getResponse.body(), Transcript.class);
			
			System.out.println(transcript.getStatus());
			
			if("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())) {
				break;
			}	
			 Thread.sleep(1000);
		}
			
			System.out.println("Transcript Completed");
			System.out.println(transcript.getText());
			
	}
}
