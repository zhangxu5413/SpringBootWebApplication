package org.example;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
