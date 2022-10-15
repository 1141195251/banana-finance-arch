package com.jluzh.controller;

import com.jluzh.entity.TbReimbursementItem;
import com.jluzh.entity.TbReimbursementRecord;
import com.jluzh.service.TbReimbursementRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbReimbursementRecord)表控制层
 *
 * @author makejava
 * @since 2022-10-07 10:36:28
 */
@RestController
@RequestMapping("tbReimbursementRecord")
public class TbReimbursementRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TbReimbursementRecordService tbReimbursementRecordService;

    /**
     * 分页查询
     *
     * @param tbReimbursementRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbReimbursementRecord>> queryByPage(TbReimbursementRecord tbReimbursementRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbReimbursementRecordService.queryByPage(tbReimbursementRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseEntity<TbReimbursementRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tbReimbursementRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbReimbursementRecord 实体
     * @return 新增结果
     */
    @PostMapping("/post")
    public ResponseEntity<TbReimbursementRecord> add(@RequestBody TbReimbursementRecord tbReimbursementRecord) {
        return ResponseEntity.ok(this.tbReimbursementRecordService.insert(tbReimbursementRecord));
    }

    /**
     * 编辑数据
     *
     * @param tbReimbursementRecord 实体
     * @return 编辑结果
     */
    @PutMapping("/put")
    public ResponseEntity<TbReimbursementRecord> edit(@RequestBody TbReimbursementRecord tbReimbursementRecord) {
        return ResponseEntity.ok(this.tbReimbursementRecordService.update(tbReimbursementRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("deleteId")Integer id) {
        return ResponseEntity.ok(this.tbReimbursementRecordService.deleteById(id));
    }

    @GetMapping("/write")
    public ResponseEntity<List<TbReimbursementRecord>> writeExcel(){
        tbReimbursementRecordService.writeExcel();
        return ResponseEntity.ok(this.tbReimbursementRecordService.queryAll());

    }

    @PostMapping("/read")
    public void readExcel(){
        tbReimbursementRecordService.readExcel();
    }
}

