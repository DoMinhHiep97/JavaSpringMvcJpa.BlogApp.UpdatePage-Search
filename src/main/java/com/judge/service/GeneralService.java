package com.judge.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<E> {


    void addHaveBusiness(E e);


}
