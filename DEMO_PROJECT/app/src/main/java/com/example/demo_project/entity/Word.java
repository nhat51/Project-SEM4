package com.example.demo_project.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Word{
    public int id;
    public String name;
    public String content;
    public String pronounce;
    public String part_of_speech;
    public int user_id;
    public String last_remind;
    public int category_type;
    public int success_time;
    public String created_at;
    public String updated_at;

    public Word() {
    }

    public Word(int id, String name, String content, String pronounce, String part_of_speech) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pronounce = pronounce;
        this.part_of_speech = part_of_speech;
    }

    public Word(int id, String name, String content, String part_of_speech) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.part_of_speech = part_of_speech;
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

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLast_remind() {
        return last_remind;
    }

    public void setLast_remind(String last_remind) {
        this.last_remind = last_remind;
    }

    public int getCategory_type() {
        return category_type;
    }

    public void setCategory_type(int category_type) {
        this.category_type = category_type;
    }

    public int getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(int success_time) {
        this.success_time = success_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", pronounce='" + pronounce + '\'' +
                ", part_of_speech='" + part_of_speech + '\'' +
                ", user_id=" + user_id +
                ", last_remind=" + last_remind +
                ", category_type=" + category_type +
                ", success_time=" + success_time +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
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
