package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.info.UserInfo;

import java.util.List;

/**
 * Class Description:
 * @author zxcvb
 */
@Mapper
public interface UserMapper {
    /**
     * 1
     * @return 1
     */
    @Select("select * from my_user")
    List<UserInfo> selectAll();

    /**
     * 1
     * @param id 1
     * @return 1
     */
    @Select("select * from my_user where id = #{id}")
    UserInfo selectById(@Param("id") String id);

    @Insert("insert into my_user (id, name) values (#{info.id}, #{info.name})")
    int insert(@Param("info") UserInfo userInfo);

    @Update("update my_user set id=#{info.id}, name=#{info.name} where id=#{info.id}")
    int update(@Param("info") UserInfo userInfo);

    @Delete("delete from my_user where id=#{info.id}")
    int delete(@Param("info") UserInfo userInfo);
}
