package com.robertkoch.imperialassault.web.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by robert.koch on 2017/02/16.
 */
public class PagingBuilder {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10, 20 };

    public Integer initialPageSize(Integer pageSize) {
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        return pageSize == null ? INITIAL_PAGE_SIZE : pageSize;
    }

    public Integer initialPage(Integer page) {
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        return (page == null || page < 1) ? INITIAL_PAGE : page - 1;
    }

    public Pageable getPageable(Integer page, Integer size) {
        return new PageRequest(initialPage(page), initialPageSize(size));
    }

    public Pageable getPageable() {
        return getPageable(null, null);
    }

    public <T> ModelAndView getModelAndView(String viewName, Page<T> collection, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(viewName);

        Pager pager = new Pager(collection.getTotalPages(), collection.getNumber(), BUTTONS_TO_SHOW);

        String selectedSort = "";
        if(pageable.getSort() != null) {
            for(Sort.Order orders : pageable.getSort()) {
                selectedSort = orders.getProperty();
            }
        }
        modelAndView.addObject("collection", collection);
        modelAndView.addObject("selectedPageSize", pageable.getPageSize());
        modelAndView.addObject("selectedSort", selectedSort);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

}
