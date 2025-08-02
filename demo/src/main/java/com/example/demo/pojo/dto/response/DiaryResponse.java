package com.example.demo.pojo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DiaryResponse {
    private String publisherName;
    private String id;
    private String publisherId;
    private String title;
    private String content;
    private String status;
    private String pin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}