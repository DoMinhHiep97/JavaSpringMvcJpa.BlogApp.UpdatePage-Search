package com.judge.model;

import javax.persistence.*;

@Entity
@Table(name="Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String topic;
    private String content;

    public Blog() {
    }

    public Blog(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return String.format("Blog[id=%d,topic='%s',content='%s']",id,topic,content);
    }
}
