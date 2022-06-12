package com.example.englishappbackend.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WordFilter {
    public static final String NAME = "name";
    public static final String IS_REMEMBER = "is_member";
    public static final String SUCCESS_TIME = "success_time";

    private String name;
    private boolean isRemember;
    private int successTime;
    private int page;
    private int size;


    public static final class WordFilterBuilder {
        private String name;
        private boolean isRemember;
        private int successTime;
        private int page;
        private int size;

        private WordFilterBuilder() {
        }

        public static WordFilterBuilder aWordFilter() {
            return new WordFilterBuilder();
        }

        public WordFilterBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public WordFilterBuilder withIsRemember(boolean isRemember) {
            this.isRemember = isRemember;
            return this;
        }

        public WordFilterBuilder withSuccessTime(int successTime) {
            this.successTime = successTime;
            return this;
        }

        public WordFilterBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public WordFilterBuilder withSize(int size) {
            this.size = size;
            return this;
        }

        public WordFilter build() {
            WordFilter wordFilter = new WordFilter();
            wordFilter.setName(name);
            wordFilter.setSuccessTime(successTime);
            wordFilter.setPage(page);
            wordFilter.setSize(size);
            wordFilter.isRemember = this.isRemember;
            return wordFilter;
        }
    }
}
