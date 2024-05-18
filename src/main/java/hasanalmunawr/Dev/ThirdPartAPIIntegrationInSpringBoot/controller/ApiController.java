package hasanalmunawr.Dev.ThirdPartAPIIntegrationInSpringBoot.controller;

import hasanalmunawr.Dev.ThirdPartAPIIntegrationInSpringBoot.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/get-posts")
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(apiService.getPosts());
    }

    @GetMapping("/get-posts-by-id/{id}")
    public  ResponseEntity<?> getPostById(@PathVariable int id){
        return ResponseEntity.ok(apiService.getPostById(id));
    }

    @PostMapping("/insert-posts")
    public ResponseEntity<?> insertPost(@RequestBody Map<String,Object> payload){
        return ResponseEntity.ok(apiService.insertPosts(payload));
    }

    @PutMapping("/update-posts/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Map<String,Object> payload , @PathVariable int id){
        return ResponseEntity.ok(apiService.updatePosts(payload, id));
    }

    @DeleteMapping("/delete-posts/{id}")
    public ResponseEntity<?> deletePosts(@PathVariable int id){
        return ResponseEntity.ok(apiService.deletePost(id));
    }

}
