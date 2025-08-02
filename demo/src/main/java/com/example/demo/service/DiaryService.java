package com.example.demo.service;

import com.example.demo.pojo.entity.Diary;

import java.util.List;

public interface DiaryService {
    public abstract Diary saveDiary(Diary diary);

    public abstract Diary getDiaryById(Long id);

    public abstract List<Diary> getDiariesByPublisher(String publisherId);

    public abstract List<Diary> getDiariesByPublisherAndStatus(String publisherId, String status);

    public abstract void deleteDiary(Long id);

    public abstract boolean existsById(Long id);
}
