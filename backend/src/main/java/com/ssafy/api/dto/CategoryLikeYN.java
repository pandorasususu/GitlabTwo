package com.ssafy.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryLikeYN {
    String category;
    int likeYN;
}
