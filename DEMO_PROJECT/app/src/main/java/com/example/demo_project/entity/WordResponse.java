package com.example.demo_project.entity;

import java.util.List;

public class WordResponse {
    private List<Word> content;
    private int totalPage;
    private int totalElement;
    private int size;
    private int currentPage;

    public WordResponse() {
    }

    public WordResponse(List<Word> content, int totalPage, int totalElement, int size, int currentPage) {
        this.content = content;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.size = size;
        this.currentPage = currentPage;
    }

    public List<Word> getContent() {
        return content;
    }

    public void setContent(List<Word> content) {
        this.content = content;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "WordResponse{" +
                "content=" + content +
                ", totalPage=" + totalPage +
                ", totalElement=" + totalElement +
                ", size=" + size +
                ", currentPage=" + currentPage +
                '}';
    }
}
