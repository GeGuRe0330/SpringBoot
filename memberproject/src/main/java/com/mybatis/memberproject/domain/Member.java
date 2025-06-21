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

    // 1 대 N 구조 중 첫번째 도매인 객체 삽입 ( memberAuth )
    private List<MemberAuth> authList;
    
    // 1 대 N 구조 중 두번째 도매인 객체 삽입 ( memberEmail )
    private List<MemberEmail> emailList;
}
