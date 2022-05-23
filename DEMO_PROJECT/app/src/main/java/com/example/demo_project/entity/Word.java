package com.example.demo_project.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.demo_project.entity.enums.WordCategory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Word{
    public int id;
    public String name;
    public String content;
    public String example;
    public String translatedExample;
    public String pronounce;
    public String partOfSpeech;
    public int userId;
    public String lastRemind;
    public WordCategory categoryType;
    public int successTime;
    public String createdAt;
    public String updatedAt;

    public Word() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getTranslatedExample() {
        return translatedExample;
    }

    public void setTranslatedExample(String translatedExample) {
        this.translatedExample = translatedExample;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastRemind() {
        return lastRemind;
    }

    public void setLastRemind(String lastRemind) {
        this.lastRemind = lastRemind;
    }

    public WordCategory getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(WordCategory categoryType) {
        this.categoryType = categoryType;
    }

    public int getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(int successTime) {
        this.successTime = successTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class DateConverter {
        @TypeConverter
        public static Date toDate(Long timestamp) {
            return timestamp == null ? null : new Date(timestamp);
        }
        @TypeConverter
        public static Long toTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
    }
}
