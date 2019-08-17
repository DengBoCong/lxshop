package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_message", schema = "lxshop", catalog = "")
public class LMessageEntity {
    private int id;
    private String content;
    private byte isRead;
    private String url;
    private byte toRole;
    private int addTime;
    private String title;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "is_read", nullable = false)
    public byte getIsRead() {
        return isRead;
    }

    public void setIsRead(byte isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 1000)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "to_role", nullable = false)
    public byte getToRole() {
        return toRole;
    }

    public void setToRole(byte toRole) {
        this.toRole = toRole;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LMessageEntity that = (LMessageEntity) o;

        if (id != that.id) return false;
        if (isRead != that.isRead) return false;
        if (toRole != that.toRole) return false;
        if (addTime != that.addTime) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) isRead;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (int) toRole;
        result = 31 * result + addTime;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
