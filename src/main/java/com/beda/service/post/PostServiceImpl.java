package com.beda.service.post;

import com.beda.model.Post;
import com.beda.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
//        this.cutString(post.getDetail());
//        String abc = this.cutString(post.getDetail());
//        post.setDetail(abc);
        return postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        int size = pageable.getPageSize();
        int page = pageable.getPageNumber();
        if (page >= 1) {
            page = page - 1;
        } else if (page < 0) {
            page = 0;
        }
        Pageable pageDefault = PageRequest.of(page, size);
        return postRepository.findAll(pageDefault);
    }

    @Override
    public Iterable<Post> getAllPostByIndex(int index) {
        return postRepository.getAllPostByIndex(index);
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
    public Iterable<Post> findAllByCategoryIdAndIndex(Long id, int index) {
        return postRepository.findAllByCategoryIdAndIndex(id, index);
    }

    @Override
    public Iterable<Post> findByTitleContainingAndCategoryId(String title, Long id) {
        return postRepository.findByTitleContainingAndCategoryId(title, id);
    }

    @Override
    public Iterable<Post> findAllByUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public Page<Post> findAllByCategoryId(Long categoryId, Pageable pageable) {
        int size = pageable.getPageSize();
        int page = pageable.getPageNumber();
        if (page >= 1) {
            page = page - 1;
        } else if (page < 0) {
            page = 0;
        }
        Pageable pageDefault = PageRequest.of(page, size);
        List<Post> posts = postRepository.findAllByCategoryId(categoryId, pageDefault.getOffset(), pageDefault.getPageSize());
        return new PageImpl<>(posts, pageDefault, posts.size());
    }

    @Override
    public Iterable<Post> findTop6ByCategoryId(Long categoryId) {
        return postRepository.findTop6NewByCategory(categoryId);
    }

    @Override
    public Iterable<Post> findTop6New() {
        return postRepository.findTop6New();
    }

    private String cutString(String input) {
        try {
            String result = "";
            String[] strs = input.split("(?<=img)");
            for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
                result += strs[i] + " style=\"width: 750px; height: 375px\"";
//            System.out.println(result);
            }
            return result;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
