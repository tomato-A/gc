package com.gc.goods.service;

import com.gc.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    public List<Brand> findAll();

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    public Brand findById(Integer id);

    /**
     * 新增品牌数据
     * @param brand
     */
    public void add(Brand brand);

    /**
     * 修改品牌数据
     * @param brand
     */
    public void update(Brand brand);

    /**
     * 删除品牌数据
     * @param id
     */
    public void delete(Integer id);

    /**
     * 多条件查询
     * @param brand
     * @return
     */
    public List<Brand> findList(Brand brand);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<Brand> findPage(int page, int size);

    /**
     * 条件+分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    public PageInfo<Brand> findPage(Brand brand, int page, int size);

}
