package com.praise.push.post.adapter.in.web;

import com.praise.push.post.application.port.in.CreatePostCommand;
import com.praise.push.post.application.port.in.PostUseCase;
import com.praise.push.post.application.port.out.PostResponse;
import com.praise.push.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praise-push/api/v1")
@RequiredArgsConstructor
public class PostController {
    private final PostUseCase postUseCase;

    @PostMapping
    void createPost(@RequestBody CreatePostCommand command) {
        postUseCase.createPost(command);
    }

    @GetMapping
    PostResponse findPost(@RequestParam(name = "postId") Long postId) {
        Post post = postUseCase.findPost(postId);
        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .imageUrl(post.getImageUrl())
                .keyword(post.getKeyword().getKeyword())
                .visible(post.getVisible())
                .build();
    }
}