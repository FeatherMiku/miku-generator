package com.miku.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * 静态文件生成器
 */
public class StaticFileGenerator {


    /**
     * 拷贝文件（Hutool 实训，会将输入目录完整拷贝到输出目录下）
     * @param inputPath 输入路径
     * @param outputPAth 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPAth){
        FileUtil.copy(inputPath, outputPAth, false);
    }
}