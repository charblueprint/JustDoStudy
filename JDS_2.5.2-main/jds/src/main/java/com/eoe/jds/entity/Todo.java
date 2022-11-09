package com.eoe.jds.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "todo")
public class ToDo extends BaseEntity {
        //기본키로 사용
        //uuid를 이용해 임의적으로 랜덤 글자열을 만듦
        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        private String id;

        //사용자 식별용
        @Column(length = 100, nullable = false)
        private String userId;

        //제목
        @Column(length = 500, nullable = false)
        //-> title varchar(500) not null 같은것
        private String title;

        //수행 여부
        @Column(nullable = false)
        private boolean done;
    }

