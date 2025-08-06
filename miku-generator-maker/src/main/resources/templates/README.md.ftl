# ${name}

> ${description}
>
> 作者：${author}
>
> 基于 FeatherMiku的 [miku代码生成器项目](https://github.com/FeatherMiku/miku-generator) 制作，感谢您的使用！

可以通过命令行交互式输入的方式动态生成想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：

'''
generator <命令> <选项参数>
'''

示例命令：

'''
generator generate <#list modelConfig.models as modelInfo><#if modelInfo.abbr??>-${modelInfo.abbr}</#if> </#list>
'''

## 参数说明：

<#list modelConfig.models as modelInfo>
<#-- 判断：这是一个真正的模型吗？ -->
    <#if modelInfo.fieldName??>
${modelInfo?index + 1}）${modelInfo.fieldName}

类型：${modelInfo.type}

描述：${modelInfo.description}

默认值：${modelInfo.defaultValue?c}

<#if modelInfo.abbr??>
缩写： -${modelInfo.abbr}
</#if>

    <#-- 判断：这是一个分组吗？ -->
    <#elseif modelInfo.groupKey??>
${modelInfo?index + 1}）${modelInfo.groupName} (核心模板分组)

描述：${modelInfo.description}

    <#-- 在这里，还可以选择性地遍历并显示分组内的模型 -->
    <#if modelInfo.models?? && modelInfo.models?has_content>
包含的选项：
        <#list modelInfo.models as subModel>
- **${subModel.fieldName}**: ${subModel.description}<#if subModel.abbr??> (缩写: -${subModel.abbr})</#if>
        </#list>
    </#if>

    </#if>
</#list>
