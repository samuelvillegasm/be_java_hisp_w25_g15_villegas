package com.mercadolibre.be_java_hisp_w25_g15.service;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountPromoProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoListDto;

public interface IPostService {
    PostDto createPost(PostDto postDto);

    PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder);

    CountPromoProductDto countPromoProductsByUserId(int userId);

    PromoListDto getPostPromoListByUserId(int userId);
}
