package com.kh.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.domain.MyBatisMember;
import com.kh.mybatis.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService{

    @Autowired
    private MemberDAO md;

    @Override
    public void insert(MyBatisMember member) throws Exception {
        md.insert(member);
    }

    @Override
    public MyBatisMember select(MyBatisMember member) throws Exception {
        return md.select(member);
    }

    @Override
    public void update(MyBatisMember member) throws Exception {
        md.update(member);
    }

    @Override
    public void delete(MyBatisMember member) throws Exception {
        md.delete(member);
    }

    @Override
    public List<MyBatisMember> selectAll() throws Exception {
        return md.selectAll();
    }


}