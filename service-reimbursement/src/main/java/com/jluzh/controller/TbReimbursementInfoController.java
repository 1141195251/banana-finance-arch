package com.jluzh.controller;


import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.service.TbReimbursementInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbReimbursementInfo)表控制层
 *
 * @author makejava
 * @since 2022-10-07 10:36:31
 */
@RestController
@RequestMapping("tbReimbursementInfo")
public class TbReimbursementInfoController {
    /**
     * 服务对象
     */
    @Resource
    private TbReimbursementInfoService tbReimbursementInfoService;

    /**
     * 分页查询
     *
     * @param tbReimbursementInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("")
    public ResponseEntity<Page<TbReimbursementInfo>> queryByPage(TbReimbursementInfo tbReimbursementInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReimbursementInfoService.queryByPage(tbReimbursementInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<TbReimbursementInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbReimbursementInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementInfo 实体
     * @return 新增结果
     */
    @PostMapping("/post")
    public ResponseEntity<TbReimbursementInfo> add(@RequestBody TbReimbursementInfo tbReimbursementInfo) {
        return ResponseEntity.ok(this.tbReimbursementInfoService.insert(tbReimbursementInfo));
    }

    /**
     * 编辑数据
     *
     * @param tbReimbursementInfo 实体
     * @return 编辑结果
     */
    @PutMapping("/put")
    public ResponseEntity<TbReimbursementInfo> edit(@RequestBody TbReimbursementInfo tbReimbursementInfo) {
        return ResponseEntity.ok(this.tbReimbursementInfoService.update(tbReimbursementInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("deleteId") Integer id) {
        return ResponseEntity.ok(this.tbReimbursementInfoService.deleteById(id));
    }

    public ResponseEntity<List<TbReimbursementInfo>> increaseBatch(){

        return ResponseEntity.ok(this.tbReimbursementInfoService.insertBatch());
    }

    @GetMapping("/write")
    public ResponseEntity<List<TbReimbursementInfo>> writeExcel(){
        tbReimbursementInfoService.writeExcel();
        return ResponseEntity.ok(this.tbReimbursementInfoService.queryAll());
    }

    @PostMapping("/read")
    public void readExcel(){
        tbReimbursementInfoService.readExcel();
    }

}

