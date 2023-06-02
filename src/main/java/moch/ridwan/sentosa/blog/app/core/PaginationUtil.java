package moch.ridwan.sentosa.blog.app.core;

import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationUtil {

    public static <T> ResultPageResponse<T> createResultPage(List<T> dtos, Long totalElements, Integer pages){
        ResultPageResponse<T> result = new ResultPageResponse<T>();
        result.setPages(pages);
        result.setElements(totalElements);
        result.setResult(dtos);
        return result;
    }

    public static Sort.Direction getSortBy(String sortBy){
        if(sortBy.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        }else {
            return Sort.Direction.DESC;
        }
    }

}
