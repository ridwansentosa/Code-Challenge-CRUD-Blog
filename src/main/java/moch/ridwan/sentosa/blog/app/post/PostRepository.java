package moch.ridwan.sentosa.blog.app.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    Page<Post>findByTitleLikeIgnoreCase(String postTitle, Pageable pageable);

}
