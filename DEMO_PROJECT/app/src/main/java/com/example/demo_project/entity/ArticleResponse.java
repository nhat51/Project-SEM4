package com.example.demo_project.entity;

import java.util.List;

public class ArticleResponse {
    private List<Article> content;
    private int totalPage;
    private int totalElement;
    private int size;
    private int currentPage;

    public ArticleResponse(List<Article> content, int totalPage, int totalElement, int size, int currentPage) {
        this.content = content;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.size = size;
        this.currentPage = currentPage;
    }

    public ArticleResponse() {
    }

    public List<Article> getContent() {
        return content;
    }

    public void setContent(List<Article> content) {
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
        return "ArticleResponse{" +
                "content=" + content +
                ", totalPage=" + totalPage +
                ", totalElement=" + totalElement +
                ", size=" + size +
                ", currentPage=" + currentPage +
                '}';
    }
}
