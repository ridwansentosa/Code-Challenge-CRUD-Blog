package moch.ridwan.sentosa.blog.app.post;

import java.time.LocalDateTime;
import java.util.UUID;

public record RetrievePostResponse(
        UUID id,
        String title,
        String body,
        String author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
