package moch.ridwan.sentosa.blog.app.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moch.ridwan.sentosa.blog.app.core.APICustomResponse;
import moch.ridwan.sentosa.blog.app.core.GenericController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/posts")
public class PostController extends GenericController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<APICustomResponse> createPost(
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        UUID postId = postService.createPost(postCreateRequest);
        Post post = postService.getPostByID(postId);
        return createResponse(
                Map.of("post", post),
                "Post has been created successfully",
                CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APICustomResponse> getPostById(
            @PathVariable("id") UUID postId) {
        RetrievePostResponse retrievePostResponse = postService.retrievePostByID(postId);
        return createResponse(
                Map.of("post", retrievePostResponse),
                "Post has been fetched successfully",
                OK);
    }

    @GetMapping()
    public ResponseEntity<APICustomResponse> getAllPosts(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "5") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "title") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "postTitle", required = false) String postTitle)  {

        return createResponse(
                Map.of("Posts", postService.findAllPosts(pages, limit, sortBy, direction, postTitle)),
                "Fetched All Posts",
                OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<APICustomResponse> updateCustomerMeasurements(
            @PathVariable("id") UUID postId,
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        postService.updatePost(postId, postCreateRequest);
        return createResponse(
                null,
                "Post have been updated successfully",
                OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APICustomResponse> deletePostById(
            @PathVariable("id") UUID postId) {
        postService.deletePostById(postId);
        return createResponse(
                null,
                "Post has been deleted successfully",
                OK);
    }


}
