package com.jluzh;

import static org.junit.Assert.assertTrue;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.jluzh.dao.TbReimbursementInfoDao;
import com.jluzh.entity.TbReimbursementInfo;
import com.jluzh.listener.TbReimbursementInfoListener;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@MapperScan("com.jluzh.dao")
public class ReimbursementApplicationTest
{

    @Autowired
    private TbReimbursementInfoDao tbReimbursementInfoDao;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void fillData(){

    }

    @Test
    public void readData(){

        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；"d:\\杭州黑马在线202003班学员信息.xls"
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("d:\\reimbursement.xlsx", TbReimbursementInfo.class, new TbReimbursementInfoListener(tbReimbursementInfoDao));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }


    @Test
    public void test03(){
        System.out.println(tbReimbursementInfoDao);
    }

}
