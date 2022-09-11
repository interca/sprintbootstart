package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单接口
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 权限查询
     */
    List<String> selectPermsByUserId(Long userid);
}
