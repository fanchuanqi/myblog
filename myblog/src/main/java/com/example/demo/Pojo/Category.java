package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @author
 * @Date 3/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = -6328020666866757010L;

    private Integer categoryId;
    private Integer categoryPid;

    private String categoryName;
    private String categoryDescription;
    private Integer categoryOrder;

    private String categoryIcon;

    /**
     * 非数据库字段
     */
    private Integer articleCount;

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public static Category Default() {
        return new Category(100000000, "未分类");
    }
}
