package com.miku.maker.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class DataModel {

    // 1. 开头添加作者注释（添加代码）
    // 2. 修改程序输出的信息提示（替换代码）
    // 3. 将循环读取输入改为单次读取（可选代码）

    /**
     * 字符串、填充值
     */
    private String author = "miku";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 是否循环（开关）
     */
    private boolean loop;


}
