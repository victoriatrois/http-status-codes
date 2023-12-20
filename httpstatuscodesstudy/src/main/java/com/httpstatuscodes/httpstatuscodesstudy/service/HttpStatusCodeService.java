package com.httpstatuscodes.httpstatuscodesstudy.service;

import com.httpstatuscodes.httpstatuscodesstudy.entity.HttpStatusCode;
import com.httpstatuscodes.httpstatuscodesstudy.repository.HttpStatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpStatusCodeService {
    private final HttpStatusCodeRepository httpStatusCodeRepository;

    @Autowired
    public HttpStatusCodeService(HttpStatusCodeRepository repository) {
        this.httpStatusCodeRepository = repository;
    }

    public List<HttpStatusCode> getAllHttpStatusCodes() {
        return httpStatusCodeRepository.findAll();
    }

    public HttpStatusCode saveHttpStatusCode(HttpStatusCode httpStatusCode) {
        return httpStatusCodeRepository.save(httpStatusCode);
    }
}
