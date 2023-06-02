package moch.ridwan.sentosa.blog.app.core;

import lombok.Data;

import java.util.List;
@Data
public class ResultPageResponse<T> {
    private List<T> result;

    private Integer pages;

    private Long elements;
}
