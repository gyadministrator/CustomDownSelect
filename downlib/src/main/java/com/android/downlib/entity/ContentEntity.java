package com.android.downlib.entity;

import java.util.List;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.entity
 * @ClassName: ContentEntity
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 10:49
 */
public class ContentEntity {
    private String id;
    private String title;
    private List<String> content;

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public ContentEntity(String id, String title, List<String> content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
