package com.miku.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.miku.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    public void run(){
        // 实现 config 命令的逻辑
        System.out.println("查看参数信息");

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);

        // 遍历并打印每个字段信息
        for (Field field : fields){
            System.out.println("字段名称："  + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("---");
        }


    }
}
