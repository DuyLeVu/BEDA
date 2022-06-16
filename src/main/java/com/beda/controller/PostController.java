package com.beda.controller;

import com.beda.model.Post;
import com.beda.model.User;
import com.beda.service.UserService;
import com.beda.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    IPostService postService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<Post>> showAllPost() {
        Iterable<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/public/{status}")
    public ResponseEntity<Iterable<Post>> getAllPostByStatus(@PathVariable("status") int status) {
        Iterable<Post> posts = this.postService.findAllByStatus(status);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Post>> getAllPostByTitle(@RequestParam(name = "title") String title) {
        Iterable<Post> posts = this.postService.findAllByTitle(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Iterable<Post>> getAllByCategoryId(@PathVariable Long categoryId) {
        Iterable<Post> posts = postService.findAllByCategoryId(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("search/categories/{categoryId}")
    public ResponseEntity<Iterable<Post>> getAllByCategoryId(@RequestParam(name = "title") String title, @PathVariable Long categoryId) {
        Iterable<Post> posts = postService.findByTitleContainingAndCategoryId(title, categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Iterable<Post>> getAllByUserId(@PathVariable Long userId) {
        Iterable<Post> posts = postService.findAllByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        post.setCreateAt(date);
//        post.setLikes((long) 0);
        postService.save(post);
        User user = post.getUser();
        Long oldPosts = user.getPosts();
        oldPosts = oldPosts == null ? Long.valueOf(0) : oldPosts;
        user.setPosts(oldPosts + Long.valueOf(1));
        userService.save(user);
        return new ResponseEntity(post, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        post.setCreateAt(date);
        post.setId(id);
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        post.get().setStatus(0);
        postService.save(post.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}