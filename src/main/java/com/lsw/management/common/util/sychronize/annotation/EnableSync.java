package com.lsw.management.common.util.sychronize.annotation;

import com.lsw.management.common.util.sychronize.core.TableSynchronize;
import com.lsw.management.common.util.sychronize.core.scanner.CustomScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lsw
 * @Date 2023/3/24 10:43
 * @desc 开启SQL同步
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import({CustomScannerRegistrar.class, TableSynchronize.class})
@Documented
public @interface EnableSync {
    String[] basePackage();
}
