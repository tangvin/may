package com.example.may.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author woniu
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserExcelErrDto extends UserExcelDto {


    //错误信息
    @ExcelProperty(index = 4,value = "错误信息")
    @ColumnWidth(50)
    private String errMsg;


}
