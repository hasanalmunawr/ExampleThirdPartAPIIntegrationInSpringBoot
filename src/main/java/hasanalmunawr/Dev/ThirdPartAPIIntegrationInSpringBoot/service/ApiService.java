package hasanalmunawr.Dev.ThirdPartAPIIntegrationInSpringBoot.service;

import java.util.List;
import java.util.Map;

public interface ApiService {


    List<Map<String, Object>> getPosts();

    Map<String ,Object> getPostById(int id);

    Map<String ,Object> insertPosts(Map<String ,Object> payload);

    Map<String ,Object> updatePosts(Map<String ,Object> payload , int id);

    Map<String ,Object> deletePost( int id);
}
