package com.example.demo.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author
 * @Date 3/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {
    private  static final long serialVersionUID = 0L;

    private String id;
    private Integer tagId;
    private String tagName;
    private String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

}
