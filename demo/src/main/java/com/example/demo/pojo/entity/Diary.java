package com.example.demo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    private Long id;                // 自增ID
    private String publisherId;     // 发布者ID，关联User.id
    private String publisherName;
    private String title;          // 日记标题
    private String content;        // 日记内容(Markdown格式)
    private String status;         // 状态：draft/published/archived
    private String pin;           // 是否置顶
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
}