package dev.ernandorezende.springgraphql.services;

import dev.ernandorezende.springgraphql.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {
    Map<String, Comment> comments = new HashMap<>();

    public Collection<Comment> createComment(String content, String postId) {
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return comments.values();
    }

    public Collection<Comment> findByPost(String postId) {
        return comments.values().stream()
                .filter(comment -> comment.postId().equals(postId))
                .collect(Collectors.toList());
    }
}
