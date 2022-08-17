package com.email.repository.impl;

import com.email.model.PageSize;
import com.email.repository.PageSizeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PageSizeRepositoryImpl implements PageSizeRepository {
    private static List<PageSize> pageSizeList =new ArrayList<>();
    static {
        pageSizeList.add(new PageSize("5"));
        pageSizeList.add(new PageSize("10"));
        pageSizeList.add(new PageSize("15"));
        pageSizeList.add(new PageSize("25"));
        pageSizeList.add(new PageSize("50"));
        pageSizeList.add(new PageSize("100"));
    }

    @Override
    public List<PageSize> findAll() {
        return pageSizeList;
    }
}
