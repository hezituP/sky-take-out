package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询关联的套餐id集合
     * @param dishId
     * @return
     */
    List<Long> getSetmealIdsByDishId(Long dishId);

    // 批量插入套餐菜品关系
    void insertBatch(List<SetmealDish> setmealDishes);

    // 根据套餐id批量删除套餐菜品关系
    void deleteBySetmealIds(List<Long> setmealIds);

    // 根据套餐id删除套餐菜品关系
    void deleteBySetmealId(Long setmealId);

    // 根据套餐id查询套餐菜品关系
    List<SetmealDish> getBySetmealId(Long setmealId);
}
