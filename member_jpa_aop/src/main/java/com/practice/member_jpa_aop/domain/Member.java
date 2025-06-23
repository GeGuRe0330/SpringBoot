package com.practice.member_jpa_aop.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GEN", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    private int no;
    @Column(name = "id")
    private String id;
    @Column(name = "pw")
    private String pw;
    @Column(name = "name")
    private String name;
    @Column(name = "coin")
    private int coin;
    @Column(name = "reg_date")
    private Date regDate;
    @Column(name = "upd_date")
    private Date updDate;
    @Column(name = "enabled")
    private String enabled;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAuth> authList;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberEmail> emailList;
}
