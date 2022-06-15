package com.example.demo_project.entity;

public class Pageable {
    private PageableSort sort;
    private int pageNumber;
    private int pageSize;
    private int offset;
    private boolean paged;
    private boolean unpaged;

    public Pageable() {
    }

    public PageableSort getSort() {
        return sort;
    }

    public void setSort(PageableSort sort) {
        this.sort = sort;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isPaged() {
        return paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public boolean isUnpaged() {
        return unpaged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }
}
