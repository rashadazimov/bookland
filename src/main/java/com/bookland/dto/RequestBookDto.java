package com.bookland.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestBookDto {
    private List<Integer> bookIdList;
    private String userName;
}
