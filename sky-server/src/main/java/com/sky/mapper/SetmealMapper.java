package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    // 查询菜品是否被套餐关联
    @Select("<script>select count(1) from setmeal_dish where dish_id in <foreach collection='dishIds' item='dishId' open='(' separator=',' close=')'>#{dishId}</foreach></script>")
    Integer countByDishIds(List<Long> dishIds);
}
