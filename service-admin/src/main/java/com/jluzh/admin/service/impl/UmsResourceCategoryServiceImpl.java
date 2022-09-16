package com.jluzh.admin.service.impl;

import com.jluzh.admin.model.UmsResourceCategory;
import com.jluzh.admin.mapper.UmsResourceCategoryMapper;
import com.jluzh.admin.service.UmsResourceCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements UmsResourceCategoryService {
//    @Autowired
//    private UmsResourceCategoryMapper resourceCategoryMapper;
//
//    @Override
//    public List<UmsResourceCategory> listAll() {
//        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
//        example.setOrderByClause("sort desc");
//        return resourceCategoryMapper.selectByExample(example);
//    }
//
//    @Override
//    public int create(UmsResourceCategory umsResourceCategory) {
//        umsResourceCategory.setCreateTime(new Date());
//        return resourceCategoryMapper.insert(umsResourceCategory);
//    }
//
//    @Override
//    public int update(Long id, UmsResourceCategory umsResourceCategory) {
//        umsResourceCategory.setId(id);
//        return resourceCategoryMapper.updateByPrimaryKeySelective(umsResourceCategory);
//    }
//
//    @Override
//    public int delete(Long id) {
//        return resourceCategoryMapper.deleteByPrimaryKey(id);
//    }
}
