package com.diddl.minipjt3.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass //멤버 변수가 컬럼이 되도록 한다.
@EntityListeners(AuditingEntityListener.class) //변경 시 자동 기록 ->
public abstract class Timestamped {
    @CreatedDate
    private String createAt; //글작성 최초 시점

    @PrePersist
    public void onPrePersist(){
        this.createAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}