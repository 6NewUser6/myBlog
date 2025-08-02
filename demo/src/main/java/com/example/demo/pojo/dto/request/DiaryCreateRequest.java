package com.example.demo.pojo.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiaryCreateRequest {
    private String publisherName;
    private String publisherId;
    private String title;
    private String content;
    private String status; // 0/1/2
    private String pin;
}