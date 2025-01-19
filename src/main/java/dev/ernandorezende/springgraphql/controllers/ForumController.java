package dev.ernandorezende.springgraphql.controllers;

import dev.ernandorezende.springgraphql.domain.Comment;
import dev.ernandorezende.springgraphql.domain.Post;
import dev.ernandorezende.springgraphql.services.CommentService;
import dev.ernandorezende.springgraphql.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ForumController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

//    @SchemaMapping(typeName = "Query", value = "getPost")
    @QueryMapping
    public Post getPost(@Argument String id) {
        return postService.getPost(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> comments(Post post) {
        return commentService.findByPost(post.id());
    }

}
