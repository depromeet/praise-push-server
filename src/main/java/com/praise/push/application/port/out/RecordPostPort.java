package com.praise.push.application.port.out;

import com.praise.push.domain.Post;

public interface RecordPostPort {
    void createPost(Post post);

    void deletePost(Long postId);

    void updatePost(Long postId, Post post);
}
