package com.example.demo.Service.Impl;

import com.example.demo.Mapper.ArticleTagRefMapper;
import com.example.demo.Mapper.TagMapper;
import com.example.demo.Pojo.Tag;
import com.example.demo.Service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Slf4j
public class TagServiceImpl implements TagService {
    @Autowired(required = false)
    private TagMapper tagMapper;

    @Autowired(required = false)
    private ArticleTagRefMapper articleTagRefMapper;

    @Override
    public Integer countTag() {
        return tagMapper.countTag();
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Tag> listTagWithCount() {
        return tagMapper.listTag();
    }


    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public Tag insertTag(Tag tag) {
            tagMapper.insert(tag);
        return tag;
    }

    @Override
    public void updateTag(Tag tag) {
            tagMapper.update(tag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTag(Integer id) {
            tagMapper.deleteById(id);
            articleTagRefMapper.deleteByTagId(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> listTagByArticleId(Integer articleId) {
        return articleTagRefMapper.listTagByArticleId(articleId);
    }
}
