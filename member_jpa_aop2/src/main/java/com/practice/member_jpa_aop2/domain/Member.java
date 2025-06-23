package com.practice.member_jpa_aop2.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "MEMBER_SEQ_GEN", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MEMBER_SEQ_GEN")
    private int no;
    private String id;
    private String pw;
    private String name;
    private int coin;
    @CreationTimestamp
    private Date regDate;
    @CreationTimestamp
    private Date updDate;
    private String enabled = "1";


}
