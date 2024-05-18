package hasanalmunawr.Dev.ThirdPartAPIIntegrationInSpringBoot.service.impl;

import hasanalmunawr.Dev.ThirdPartAPIIntegrationInSpringBoot.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    private String baseUrl = "https://jsonplaceholder.typicode.com/";

    private StringBuilder urlBuilder = new StringBuilder(baseUrl);

    private String POST = "/posts";

    private String POSTBYID = "/posts/";

    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity <Void> httpEntity  = new HttpEntity<>(gethttpHeaders());
        String url = urlBuilder.append(POST).toString();
        var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }


    @Override
    public Map<String, Object> getPostById(int id) {
        HttpEntity <Void> httpEntity  = new HttpEntity<>(gethttpHeaders());
        String url = urlBuilder.append(POSTBYID).append(id).toString();
        var response  =  restTemplate.exchange(url , HttpMethod.GET ,httpEntity,Map.class); ;
        return response.getBody();
    }

    @Override
    public Map<String, Object> insertPosts(Map<String, Object> payload) {
        HttpEntity <Map> httpEntity  = new HttpEntity<>(payload,gethttpHeaders());
        String url = urlBuilder.append(POST).toString();
        var response  =  restTemplate.exchange(url , HttpMethod.POST ,httpEntity,Map.class); ;
        return  response.getBody();
    }

    @Override
    public Map<String, Object> updatePosts(Map<String, Object> payload, int id) {
        HttpEntity <Map> httpEntity  = new HttpEntity<>(payload,gethttpHeaders());
        String url = urlBuilder.append(POSTBYID).append(id).toString();
        var response  =  restTemplate.exchange(url , HttpMethod.PUT ,httpEntity,Map.class); ;
        return  response.getBody();
    }

    @Override
    public Map<String, Object> deletePost(int id) {
        HttpEntity <Map> httpEntity  = new HttpEntity<>(gethttpHeaders());
        String url = urlBuilder.append(POSTBYID).append(id).toString();
        var response  =  restTemplate.exchange(url , HttpMethod.DELETE ,httpEntity,Map.class); ;
        return  response.getBody();
    }

    private HttpHeaders gethttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
