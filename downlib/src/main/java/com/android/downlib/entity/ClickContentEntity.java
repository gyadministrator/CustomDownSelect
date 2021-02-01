package com.android.downlib.entity;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.entity
 * @ClassName: ContentEntity
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/1/18 10:49
 */
public class ClickContentEntity {
    private String id;
    private String title;
    private ContentItemEntity content;

    public ContentItemEntity getContent() {
        return content;
    }

    public void setContent(ContentItemEntity content) {
        this.content = content;
    }

    public ClickContentEntity() {
    }

    public ClickContentEntity(String id, String title, ContentItemEntity content) {
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

    @Override
    public String toString() {
        return "ClickContentEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
