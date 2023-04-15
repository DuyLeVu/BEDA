package com.beda.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date createAt;

//    private Long likes;

//    @OneToMany(targetEntity = Comment.class, cascade = {CascadeType.ALL})
//    private List<Comment> childrenComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
