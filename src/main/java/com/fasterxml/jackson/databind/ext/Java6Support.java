package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.util.ClassUtil;

/**
 * To support Java6-incomplete platforms, we will offer support for JDK 6
 * annotations through this class, loaded dynamically; if loading fails,
 * support will be missing. This class is the non-JDK-6-dependent API,
 * and {@link Java6SupportImpl} is JDK6-dependent implementation of
 * functionality.
 */
public abstract class Java6Support
{
    private final static Java6Support IMPL;

    static {
        Java6Support impl = null;
        try {
            Class<?> cls = Class.forName("com.fasterxml.jackson.databind.ext.Java6SupportImpl");
            impl = (Java6Support) ClassUtil.createInstance(cls, false);
        } catch (Throwable t) {
            // 09-Sep-2019, tatu: Used to log earlier, but with 2.10.0 let's not log
//            java.util.logging.Logger.getLogger(Java7Support.class.getName())
//                .warning("Unable to load JDK6 annotations (@ConstructorProperties): no Java6 annotation support added");
        }
        IMPL = impl;
    }

    public static Java6Support instance() {
        return IMPL;
    }

    public abstract Boolean hasCreatorAnnotation(Annotated a);

    public abstract PropertyName findConstructorName(AnnotatedParameter p);
}
