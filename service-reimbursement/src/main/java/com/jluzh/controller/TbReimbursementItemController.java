package com.jluzh.controller;


import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.service.TbReimbursementItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbReimbursementItem)表控制层
 *
 * @author makejava
 * @since 2022-10-07 10:36:22
 */
@RestController
@RequestMapping("tbReimbursementItem")
public class TbReimbursementItemController {
    /**
     * 服务对象
     */
    @Resource
    private TbReimbursementItemService tbReimbursementItemService;

    /**
     * 分页查询
     *
     * @param tbReimbursementItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbReimbursementItem>> queryByPage(TbReimbursementItem tbReimbursementItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReimbursementItemService.queryByPage(tbReimbursementItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<TbReimbursementItem> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbReimbursementItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementItem 实体
     * @return 新增结果
     */
    @PostMapping("/post")
    public ResponseEntity<TbReimbursementItem> add(@RequestBody TbReimbursementItem tbReimbursementItem) {
        return ResponseEntity.ok(this.tbReimbursementItemService.insert(tbReimbursementItem));
    }

    /**
     * 编辑数据
     *
     * @param tbReimbursementItem 实体
     * @return 编辑结果
     */
    @PutMapping("/put")
    public ResponseEntity<TbReimbursementItem> edit(@RequestBody TbReimbursementItem tbReimbursementItem) {
        return ResponseEntity.ok(this.tbReimbursementItemService.update(tbReimbursementItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("deleteId") Integer id) {
        return ResponseEntity.ok(this.tbReimbursementItemService.deleteById(id));
    }

    @GetMapping("/write")
    public ResponseEntity<List<TbReimbursementItem>> writeExcel(){
        tbReimbursementItemService.writeExcel();
        return ResponseEntity.ok(this.tbReimbursementItemService.queryAll());
    }

    @PostMapping("/read")
    public void readExcel(){
        tbReimbursementItemService.readExcel();
    }

}

