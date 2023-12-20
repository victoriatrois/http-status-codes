package com.httpstatuscodes.httpstatuscodesstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.httpstatuscodes.httpstatuscodesstudy.entity.HttpStatusCode;
public interface HttpStatusCodeRepository extends JpaRepository<HttpStatusCode, Long> {
}
