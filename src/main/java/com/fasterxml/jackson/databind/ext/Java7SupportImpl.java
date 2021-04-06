package com.fasterxml.jackson.databind.ext;

import java.beans.Transient;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.util.IgnoreJRERequirement;

/**
 * @since 2.8
 */
@IgnoreJRERequirement
public class Java7SupportImpl extends Java7Support
{
    @SuppressWarnings("unused") // compiler warns, just needed side-effects
    private final Class<?> _bogus;

    public Java7SupportImpl() {
        // Trigger loading of annotations that only JDK 7 has, to trigger
        // early fail (see [databind#2466])
        _bogus = Transient.class;
    }

    @Override
    public Boolean findTransient(Annotated a) {
        Transient t = a.getAnnotation(Transient.class);
        if (t != null) {
            return t.value();
        }
        return null;
    }

}
