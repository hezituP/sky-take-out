package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {


    // 批量插入口味数据
    void insertBatchFlavor (List<DishFlavor> flavors);

    // 根据菜品id批量删除口味数据
    void deleteByDishIds(List<Long> dishIds);

    // 根据菜品id查询口味数据
    List<DishFlavor> getByDishId(Long dishId);

    // 根据菜品id删除口味数据
    void deleteByDishId(Long dishId);
}
