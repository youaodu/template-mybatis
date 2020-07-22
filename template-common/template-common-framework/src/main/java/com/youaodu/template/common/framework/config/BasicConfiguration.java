package com.youaodu.template.common.framework.config;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.youaodu.template.common.framework.config.mapper"})
@EntityScan({"com.youaodu.template.common.framework.config.entity"})
public class BasicConfiguration {

//    @Bean
//    public DocsConfig docsConfig() {
//        DocsConfig config = new DocsConfig();
//        config.setProjectPath("/Users/yoaotu/youao_project/template-mybatis"); // 项目根目录
//        config.setProjectName("YoaoTu 快速开发"); // 项目名称
//        config.setApiVersion("V1.0");       // 声明该API的版本
//        config.setDocsPath("/apiDoc"); // 生成API 文档所在目录
//        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
//        Docs.buildHtmlDocs(config); // 执行生成文档
//        return config;
//    }
}
