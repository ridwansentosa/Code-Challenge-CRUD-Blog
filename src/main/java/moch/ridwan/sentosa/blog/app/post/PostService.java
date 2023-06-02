package moch.ridwan.sentosa.blog.app.post;

import moch.ridwan.sentosa.blog.app.core.ResultPageResponse;

import java.util.UUID;

public interface PostService {

    UUID createPost(PostCreateRequest postCreateRequest);

    Post getPostByID(UUID postId);

    RetrievePostResponse retrievePostByID(UUID postId);

    void updatePost(UUID postId, PostCreateRequest postCreateRequest);

    void deletePostById(UUID postId);

    ResultPageResponse<RetrievePostResponse> findAllPosts(Integer pages, Integer limit, String sortBy, String direction, String postTitle);

}
