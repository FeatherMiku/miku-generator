package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {

    /**
     * 生成文件
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 文件不存在则创建文件和父目录
        File outputFile = new File(outputPath);
        if (!outputFile.exists()) {
            FileUtil.mkdir(outputFile.getParentFile());
            outputFile.createNewFile();
        }

        // 使用 OutputStreamWriter 显式设置 UTF-8 编码
        try (OutputStream fos = new FileOutputStream(outputFile); Writer out = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            template.process(model, out);
        }

    }


}
