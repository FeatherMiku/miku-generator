package com.miku.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager() {
        // 私有构造函数，防止外部实例化
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    public static Meta initMeta() {
        String mataJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(mataJson, Meta.class);
        // 校验和处理默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;
    }
}
