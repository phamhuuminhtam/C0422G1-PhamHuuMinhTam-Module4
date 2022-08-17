package com.email.repository;

import com.email.model.Language;
import com.email.model.PageSize;

import java.util.List;

public interface PageSizeRepository {
    List<PageSize> findAll();
}
