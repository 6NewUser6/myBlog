package com.example.demo.service.impl;

import com.example.demo.mapper.DiaryMapper;
import com.example.demo.pojo.entity.Diary;
import com.example.demo.service.DiaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryMapper diaryMapper;

    public DiaryServiceImpl(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public Diary saveDiary(Diary diary) {
        if (diary.getId() == null) {
            // 新增日记
            diary.setCreatedAt(LocalDateTime.now());
            diary.setUpdatedAt(LocalDateTime.now());
            diaryMapper.insert(diary);
        } else {
            // 更新日记
            diary.setUpdatedAt(LocalDateTime.now());
            diaryMapper.update(diary);
        }
        return diary;
    }

    @Override
    public Diary getDiaryById(Long id) {
        return diaryMapper.selectById(id);
    }

    @Override
    public List<Diary> getDiariesByPublisher(String publisherId) {
        return diaryMapper.selectByPublisherId(publisherId);
    }

    @Override
    public List<Diary> getDiariesByPublisherAndStatus(String publisherId, String status) {
        return diaryMapper.selectByPublisherIdAndStatus(publisherId, status);
    }

    @Override
    public void deleteDiary(Long id) {
        diaryMapper.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return diaryMapper.existsById(id);
    }
}