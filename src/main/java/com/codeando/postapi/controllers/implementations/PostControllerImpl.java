package com.codeando.postapi.controllers.implementations;

import com.codeando.postapi.controllers.PostController;
import com.codeando.postapi.dto.requests.PostCreateDto;
import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.entity.Post;
import com.codeando.postapi.entity.User;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import com.codeando.postapi.mappers.PostMapper;
import com.codeando.postapi.repository.ExposureRepository;
import com.codeando.postapi.services.ExposureService;
import com.codeando.postapi.services.PostService;
import com.codeando.postapi.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class PostControllerImpl implements PostController {

    PostMapper MAPPER = PostMapper.INSTANCE;

    private final UserService userService;

    private final PostService service;

    private final ExposureService exposureService;

    public PostControllerImpl(UserService userService, PostService service, ExposureService exposureService) {
        this.userService = userService;
        this.service = service;
        this.exposureService = exposureService;
    }

    @Override
    @PostMapping
    public PostResponseDto createPost(PostCreateDto dto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Post post = MAPPER.toPost(dto);

        post.setUser(userService.findByEmail(authentication.getPrincipal().toString()));
        post.setExposure(exposureService.findById(dto.getExposureId()));

        return MAPPER.toDto(service.createPost(post));
    }

    @Override
    @GetMapping
    public Page<PostResponseDto> findAllByUser(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getPrincipal().toString());

        return service.findAllByUser(user, pageable).map(MAPPER::toDto);

    }

    @Override
    @GetMapping("/last-public")
    public Page<PostResponseDto> findLastPublic(Pageable pageable) {
        Exposure exposure = exposureService.findByName("Publico");
        return service.findLastPublic(exposure, pageable).map(MAPPER::toDto);
    }

}
