package com.example.demo.controller;

import com.example.demo.pojo.dto.request.DiaryCreateRequest;
import com.example.demo.pojo.dto.request.DiaryUpdateRequest;
import com.example.demo.pojo.dto.response.DiaryResponse;
import com.example.demo.pojo.entity.Diary;
import com.example.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    /**
     * 创建新日记
     */
    @PostMapping
    public ResponseEntity<DiaryResponse> createDiary(@RequestBody DiaryCreateRequest request) {
        Diary diary = Diary.builder()
                .publisherId(request.getPublisherId())
                .publisherName(request.getPublisherName())
                .title(request.getTitle())
                .content(request.getContent())
                .status(request.getStatus() != null ? request.getStatus() : "1")
                .pin(request.getPin() != null ? request.getPin() : "0") // 默认不置顶
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Diary savedDiary = diaryService.saveDiary(diary);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapToResponse(savedDiary));
    }

    /**
     * 更新日记
     */
    @PutMapping("/{id}")
    public ResponseEntity<DiaryResponse> updateDiary(
            @PathVariable Long id,
            @RequestBody DiaryUpdateRequest request) {

        Diary existingDiary = diaryService.getDiaryById(id);
        if (existingDiary == null) {
            return ResponseEntity.notFound().build();
        }

        existingDiary.setTitle(request.getTitle());
        existingDiary.setContent(request.getContent());
        existingDiary.setStatus(request.getStatus());
        existingDiary.setPin(request.getPin());
        existingDiary.setUpdatedAt(LocalDateTime.now());

        Diary updatedDiary = diaryService.saveDiary(existingDiary);

        return ResponseEntity.ok(mapToResponse(updatedDiary));
    }

    /**
     * 获取用户所有日记
     */
    @GetMapping("/user/{publisherId}")
    public ResponseEntity<List<DiaryResponse>> getUserDiaries(
            @PathVariable String publisherId,
            @RequestParam(required = false) String status) {

        List<Diary> diaries;
        if (status != null) {
            diaries = diaryService.getDiariesByPublisherAndStatus(publisherId, status);
        } else {
            diaries = diaryService.getDiariesByPublisher(publisherId);
        }

        List<DiaryResponse> responses = diaries.stream()
                .map(this::mapToResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    /**
     * 获取单个日记详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<DiaryResponse> getDiary(@PathVariable Long id) {
        Diary diary = diaryService.getDiaryById(id);
        if (diary == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToResponse(diary));
    }

    /**
     * 删除日记
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 实体转响应DTO
     */
    private DiaryResponse mapToResponse(Diary diary) {
        return DiaryResponse.builder()
                .id(String.valueOf(diary.getId()))
                .publisherId(diary.getPublisherId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .status(diary.getStatus())
                .pin(diary.getPin())
                .createdAt(diary.getCreatedAt())
                .updatedAt(diary.getUpdatedAt())
                .build();
    }
}
