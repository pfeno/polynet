package com.polytech.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="story")
public class Story {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    Long Id;

    @Column(name = "horodate")
    Timestamp horodate;

    @Column(name = "content")
    String Content;

    //@ManyToMany
    //List<Comment> commentList;
    public Story() {
    }

    public Story(String content){
        this.Content=content;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Timestamp getHorodate() {
        return horodate;
    }

    public void setHorodate(Timestamp horodate) {
        this.horodate = horodate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
