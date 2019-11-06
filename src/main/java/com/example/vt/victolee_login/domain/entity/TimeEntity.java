package com.example.vt.victolee_login.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//TimeEntity는 데이터 조작 시 자동으로 날짜를 수정해주는 JPA의 Auditing 기능을 사용합니다.

@Getter

@MappedSuperclass
//테이블로 매핑하지 않고, 자식 클래스(엔티티)에게 매핑정보를 상속하기 위한 어노테이션입니다.
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity {
    @CreatedDate
    //Entity가 처음 저장될때 생성일을 주입하는 어노테이션입니다.
    //이때 생성일은 update할 필요가 없으므로, updatable = false 속성을 추가합니다. ( 참고 )
    //속성을 추가하지 않으면 수정 시, 해당 값은 null이 되어버립니다.
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    //Entity가 수정될때 수정일자를 주입하는 어노테이션입니다.
    private LocalDateTime modifiedDate;
}
