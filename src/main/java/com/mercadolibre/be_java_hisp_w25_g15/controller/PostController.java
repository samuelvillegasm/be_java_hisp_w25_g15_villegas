package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountPromoProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoListDto;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class PostController {
    private final IPostService iPostService;


    @PostMapping("/post")
    ResponseEntity<PostListDto> createPost(@Valid @RequestBody PostDto post){
        return new ResponseEntity<>(iPostService.createPost(post), HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    ResponseEntity<PostGetListDto> getPostsBySellerIdLastTwoWeeks(
            @PathVariable(name = "userId") int userId,
            @RequestParam(name = "order", required = false) DateOrderEnumDto order
            ){
        return new ResponseEntity<>(iPostService.getPostsBySellerIdLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<CountPromoProductDto> getCountPromoProducts(
            @RequestParam int userId
        ){
        return new ResponseEntity<>(
                this.iPostService.countPromoProductsByUserId(userId),
                HttpStatus.OK
        );
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListDto> getPromoProducts(
            @RequestParam int userId
    ){
        return new ResponseEntity<>(
                this.iPostService.getPostPromoListByUserId(userId),
                HttpStatus.OK
        );
    }

}
