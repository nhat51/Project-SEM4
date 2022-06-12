package com.example.englishappbackend.specification;

import com.example.englishappbackend.entity.Word;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class WordSpecification implements Specification<Word> {

    private SearchCriteria searchCriteria;

    public WordSpecification(SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Word> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
         if (searchCriteria.getOperation().equalsIgnoreCase("LIKE")) {
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        return null;
    }
}
