package com.android.downlib.entity;

/**
 * @ProjectName: CustomDownSelect
 * @Package: com.android.downlib.entity
 * @ClassName: ContentItemEntity
 * @Author: 1984629668@qq.com
 * @CreateDate: 2021/2/1 11:24
 */
public class ContentItemEntity {
    private String id;
    private String title;

    public ContentItemEntity(String id, String title) {
        this.id = id;
        this.title = title;
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
        return "ContentItemEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
