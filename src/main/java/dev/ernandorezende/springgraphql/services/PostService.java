package dev.ernandorezende.springgraphql.services;

import dev.ernandorezende.springgraphql.domain.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {
    private Map<String, Post> posts = new HashMap<>();

    public Collection<Post> createPost(String content ) {
        var newPost = new Post(UUID.randomUUID().toString(), content);

        posts.put(newPost.id(), newPost);
        return posts.values();
    }

    public Post getPost(String id) {
        return posts.get(id);
    }
}
