package moch.ridwan.sentosa.blog.app.post;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import moch.ridwan.sentosa.blog.app.core.PaginationUtil;
import moch.ridwan.sentosa.blog.app.core.ResultPageResponse;
import moch.ridwan.sentosa.blog.app.core.exception.ResourceNotFoundException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostRetrieveResponseMapper retrieveResponseMapper;

    private Post findOrThrow(final UUID postId) {
        return postRepository.
                findById(postId)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UUID createPost(PostCreateRequest postCreateRequest) {
        Post post = Post.builder()
                .title(postCreateRequest.title())
                .body(postCreateRequest.body())
                .author(postCreateRequest.author())
                .build();
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public Post getPostByID(UUID postId) {
        return findOrThrow(postId);
    }

    @Override
    public RetrievePostResponse retrievePostByID(UUID postId) {
        return postRepository
                .findById(postId)
                .map(retrieveResponseMapper)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void updatePost(UUID postId, PostCreateRequest postCreateRequest) {
        Post post = findOrThrow(postId);
        post.setTitle(postCreateRequest.title());
        post.setBody(postCreateRequest.body());
        post.setAuthor(postCreateRequest.author());
        postRepository.save(post);
    }

    @Override
    public void deletePostById(UUID postId) {
        Post post = findOrThrow(postId);
        postRepository.delete(post);

    }

    @Override
    public ResultPageResponse<RetrievePostResponse> findAllPosts(Integer pages, Integer limit, String sortBy, String direction, String postTitle) {
        postTitle = StringUtils.isBlank(postTitle) ? "%" : postTitle + "%";

        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));

        Pageable pageable = PageRequest.of(pages, limit, sort);

        Page<Post> pageResult = postRepository.findByTitleLikeIgnoreCase(postTitle, pageable);

        List<RetrievePostResponse> retrievePostResponses = pageResult
                .stream()
                .map((post) -> {
                    RetrievePostResponse retrievePostResponse = new RetrievePostResponse(
                            post.getId(),
                            post.getTitle(),
                            post.getBody(),
                            post.getAuthor(),
                            post.getCreatedAt(),
                            post.getUpdatedAt()
                    );
                    return retrievePostResponse;
                }).collect(Collectors.toList());
        return PaginationUtil.createResultPage(retrievePostResponses, pageResult.getTotalElements(), pageResult.getTotalPages());
    }
}
