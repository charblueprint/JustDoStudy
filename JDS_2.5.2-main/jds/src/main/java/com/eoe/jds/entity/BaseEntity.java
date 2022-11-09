package com.eoe.jds.entity;
//@MappedSuperclass : 엔티티를 별도로 생성하지 않는 클래스

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
//@EntityListeners : JPA를 감시하고 있다가 동작하도록 설정
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    //생성한 날짜
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    // 컬럼의 이름이 regdate / 수정 불가능 설정
    private LocalDateTime regDate;

    //수정한 날짜
    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}