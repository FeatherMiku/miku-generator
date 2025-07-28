package com.miku.generator;

import com.miku.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException{
        String projectPAth = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPAth).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "miku-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPAth;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPAth + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/miku/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
    public static void main(String[] args) throws TemplateException, IOException {

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("miku");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerate(mainTemplateConfig);

    }
}
