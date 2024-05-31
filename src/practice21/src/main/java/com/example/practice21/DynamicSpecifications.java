package com.example.practice21;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class DynamicSpecifications {
    public static <T> Specification<T> byFilter(Map<String, Object> filters) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                String key = filter.getKey();
                Object value = filter.getValue();
                if (value instanceof String) {
                    predicate = cb.and(predicate, cb.like(root.get(key), "%" + value + "%"));
                } else {
                    predicate = cb.and(predicate, cb.equal(root.get(key), value));
                }
            }
            return predicate;
        };
    }
}
