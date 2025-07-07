package com.example.Practice.utilities;

import jakarta.persistence.EntityExistsException;

public interface ExistenceCheckStrategy<T> {
    boolean exists(Class<T> entityClass, String fieldName, Object value) throws EntityExistsException;
}

