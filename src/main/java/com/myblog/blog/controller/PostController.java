package com.myblog.blog.controller;
import com.myblog.blog.payload.PostDto;
import com.myblog.blog.payload.PostResponse;
import com.myblog.blog.service.PostService;
import com.myblog.blog.utiles.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    //@Autowired
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
   public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
     return new ResponseEntity<>( postService.createPost(postDto), HttpStatus.CREATED );
    }
    @GetMapping
    public PostResponse getAllPost(
            @RequestParam(value = "pageNo",defaultValue = AppConstants. DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pagesize",defaultValue = AppConstants. DEFAULT_PAGE_SIZE,required = false)int pageSize,
            @RequestParam(value="sortBy",defaultValue=AppConstants.DEFAULT_SORT_BY,required=false)String sortBy,
            @RequestParam(value="sortDir",defaultValue=AppConstants.DEFAULT_SORT_DIR,required=false)String sortDir
    ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable("id") long id){
        PostDto dto = postService.updatePost(postDto, id);
        return new ResponseEntity<>(dto ,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post entity deleted sucessfully",HttpStatus.OK);
    }
}
