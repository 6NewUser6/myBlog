package com.example.demo.mapper;

import com.example.demo.pojo.entity.Diary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiaryMapper {
    @Insert("INSERT INTO  diaries(publisher_id, title, content, status, pin, created_at, updated_at,publisher_name) " +
            "VALUES (#{publisherId}, #{title}, #{content}, #{status}, #{pin}, #{createdAt}, #{updatedAt},#{publisherName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Diary diary);

    @Update("UPDATE diaries SET " +
            "title = #{title}, " +
            "content = #{content}, " +
            "status = #{status}, " +
            "pin = #{pin}, " +
            "updated_at = #{updatedAt} " +
            "WHERE id = #{id}")
    void update(Diary diary);

    @Select("SELECT * FROM diaries WHERE id = #{id}")
    Diary selectById(Long id);

    @Select("SELECT * FROM diaries WHERE publisher_id = #{publisherId} ORDER BY created_at DESC")
    List<Diary> selectByPublisherId(String publisherId);

    @Select("SELECT * FROM diaries WHERE publisher_id = #{publisherId} AND status = #{status} ORDER BY created_at DESC")
    List<Diary> selectByPublisherIdAndStatus(String publisherId, String status);

    @Delete("DELETE FROM diaries WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT COUNT(*) > 0 FROM diaries WHERE id = #{id}")
    boolean existsById(Long id);
}