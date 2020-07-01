package com.gc.goods.service.impl;

import com.gc.goods.mapper.TemplateMapper;
import com.gc.goods.pojo.Album;
import com.gc.goods.pojo.Template;
import com.gc.goods.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Template> findAll() {
        return templateMapper.selectAll();
    }

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    @Override
    public Template findById(Integer id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增品牌数据
     * @param template
     */
    @Override
    public void add(Template template) {
        templateMapper.insertSelective(template);
    }

    /**
     * 修改
     * @param template
     */
    @Override
    public void update(Template template) {
        templateMapper.updateByPrimaryKeySelective(template);
    }

    /**
     * 删除品牌数据
     * @param id
     */
    @Override
    public void delete(Integer id) {
        templateMapper.deleteByPrimaryKey(id);
    }



    /**
     * 条件查询
     * @param template
     * @return
     */
    @Override
    public List<Template> findList(Template template) {
        //构造查询对象
        Example example = createExample(template);
        return templateMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Template> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);

        return new PageInfo<Template>(templateMapper.selectAll());
    }

    /**
     * 条件+分页查询
     * @param template
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Template> findPage(Template template, int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //构造查询对象
        Example example = createExample(template);
        return new PageInfo<Template>(templateMapper.selectByExample(example));
    }

    /**
     * 构建查询对象
     * @param template
     * @return
     */
    public Example createExample(Template template){
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if(template!=null){
            // ID
            if(!StringUtils.isEmpty(template.getId())){
                criteria.andEqualTo("id",template.getId());
            }
            // 模板名称
            if(!StringUtils.isEmpty(template.getName())){
                criteria.andLike("name","%"+template.getName()+"%");
            }
            // 规格数量
            if(!StringUtils.isEmpty(template.getSpecNum())){
                criteria.andEqualTo("specNum",template.getSpecNum());
            }
            // 参数数量
            if(!StringUtils.isEmpty(template.getParaNum())){
                criteria.andEqualTo("paraNum",template.getParaNum());
            }
        }
        return example;
    }
}
