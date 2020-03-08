package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTagRef {
    private static final long serialVersionUID = -5816783232020910492L;

    private Integer articleId;

    private Integer tagId;
}
