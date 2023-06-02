package moch.ridwan.sentosa.blog.app.post;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostRetrieveResponseMapper implements Function<Post, RetrievePostResponse> {
    @Override
    public RetrievePostResponse apply(Post post) {
        return new RetrievePostResponse(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                post.getAuthor(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
