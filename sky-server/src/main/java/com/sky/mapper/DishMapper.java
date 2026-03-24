package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);


    // 插入菜品数据
    @AutoFill(value = OperationType.INSERT)
    void insert (DishDTO dishDTO);

    // 菜品分页查询
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    // 根据id批量查询菜品
    List<Dish> getByIds(List<Long> ids);

    // 批量删除菜品
    void deleteByIds(List<Long> ids);

    // 根据id查询菜品
    Dish getById(Long id);

    // 修改菜品
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 动态条件查询菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);
}
