package com.fasterxml.jackson.databind.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Skip Java version compatibility checks.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface IgnoreJRERequirement {
}
