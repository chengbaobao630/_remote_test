/*
 * Copyright © 2010 www.myctu.cn. All rights reserved.
 */

package cc.home.exporter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * User: pippo
 * Date: 13-12-19-08:57
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface Exporter {

    String name();

    String version() default "SNAPSHOT";

}
