package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
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

    // 新增套餐
    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    // 根据id批量查询套餐
    List<Setmeal> getByIds(List<Long> ids);

    // 批量删除套餐
    void deleteByIds(List<Long> ids);

    // 根据id查询套餐
    Setmeal getById(Long id);

    // 修改套餐
    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
