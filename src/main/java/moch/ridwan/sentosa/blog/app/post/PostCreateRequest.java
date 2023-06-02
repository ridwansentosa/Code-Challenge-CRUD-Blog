package moch.ridwan.sentosa.blog.app.post;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequest(
        @NotBlank(message = "title is mandatory")
        String title,
        @NotBlank(message = "body is mandatory")
        String body,
        @NotBlank(message = "author is mandatory")
        String author
) {
}
