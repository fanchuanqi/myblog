package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategoryRef {
    private static final long serialVersionUID = -6809206515467725995L;

    private Integer articleId;

    private Integer categoryId;
}
