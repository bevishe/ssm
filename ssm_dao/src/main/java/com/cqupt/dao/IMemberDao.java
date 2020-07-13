package com.cqupt.dao;

import com.cqupt.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{memberId}")
    public Member findByMemberId(String memberId) throws Exception;
}
