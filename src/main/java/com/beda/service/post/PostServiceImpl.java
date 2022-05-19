package com.beda.service.post;

import com.beda.model.Post;
import com.beda.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Post> findAllByStatus(int status) {
        return postRepository.findAllByStatus(status);
    }

    @Override
    public Iterable<Post> findAllByTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    @Override
    public Iterable<Post> findAllByCategoryId(Long id) {
        return postRepository.findAllByCategoryId(id);
    }

    @Override
    public Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id) {
        return postRepository.findByTitleContainingAndCategoryId(title, id);
    }

    @Override
    public Iterable<Post> findAllByUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }
}
