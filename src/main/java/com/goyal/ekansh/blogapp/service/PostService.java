package com.goyal.ekansh.blogapp.service;

import com.goyal.ekansh.blogapp.dto.PostDto;
import com.goyal.ekansh.blogapp.model.Post;
import com.goyal.ekansh.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PostRepository postRepository;

    public void createPost(PostDto postDto){

        Post post=mapFromPostToDto(postDto);
        postRepository.save(post);


    }

    public List<PostDto> showAllPosts() {
    List<Post> posts=postRepository.findAll();
    return posts.stream().map(this::mapFromPostToDto).collect(toList());

    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUserName(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());

        postRepository.save(post);
    }

    public Object readSinglePost(Long id) {
    }
}
