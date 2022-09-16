package com.jluzh.admin.service.impl;

import com.jluzh.admin.dto.UmsMenuNode;
import com.jluzh.admin.model.UmsMenu;
import com.jluzh.admin.mapper.UmsMenuMapper;
import com.jluzh.admin.service.UmsMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements UmsMenuService {
    @Autowired
    private UmsMenuMapper menuMapper;
//
//    @Override
//    public int create(UmsMenu umsMenu) {
//        umsMenu.setCreateTime(new Date());
//        updateLevel(umsMenu);
//        return menuMapper.insert(umsMenu);
//    }
//
//    /**
//     * 修改菜单层级
//     */
//    private void updateLevel(UmsMenu umsMenu) {
//        if (umsMenu.getParentId() == 0) {
//            //没有父菜单时为一级菜单
//            umsMenu.setLevel(0);
//        } else {
//            //有父菜单时选择根据父菜单level设置
//            UmsMenu parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
//            if (parentMenu != null) {
//                umsMenu.setLevel(parentMenu.getLevel() + 1);
//            } else {
//                umsMenu.setLevel(0);
//            }
//        }
//    }
//
//    @Override
//    public int update(Long id, UmsMenu umsMenu) {
//        umsMenu.setId(id);
//        updateLevel(umsMenu);
//        return menuMapper.updateByPrimaryKeySelective(umsMenu);
//    }
//
//    @Override
//    public UmsMenu getItem(Long id) {
//        return menuMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public int delete(Long id) {
//        return menuMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        UmsMenuExample example = new UmsMenuExample();
//        example.setOrderByClause("sort desc");
//        example.createCriteria().andParentIdEqualTo(parentId);
//        return menuMapper.selectByExample(example);
//    }
//
    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList =  baseMapper.selectList(null);
        List<UmsMenuNode> result = menuList.stream()
                // 先筛选出一级菜单
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }
//
//    @Override
//    public int updateHidden(Long id, Integer hidden) {
//        UmsMenu umsMenu = new UmsMenu();
//        umsMenu.setId(id);
//        umsMenu.setHidden(hidden);
//        return menuMapper.updateByPrimaryKeySelective(umsMenu);
//    }
//

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     * @param menu 需要转换为节点的一级菜单
     * @param menuList 源菜单列表
     * @return 包含子菜单的菜单节点
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                // 迭代
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
