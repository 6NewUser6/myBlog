package com.example.demo.pojo.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiaryUpdateRequest {
    private String title;
    private String content;
    private String status;
    private String pin;
}