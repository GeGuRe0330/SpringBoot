package com.mybatis.memberproject.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private int no;
    private String id;
    private String pw;
    private String name;
    private int coin;
    private Date regDate;
    private Date updDate;
    private String enabled;

    private List<MemberAuth> authList;
    private List<MemberEmail> emailList;
}
