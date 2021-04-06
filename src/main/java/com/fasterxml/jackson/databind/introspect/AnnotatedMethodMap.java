package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Simple helper class used to keep track of collection of
 * {@link AnnotatedMethod}s, accessible by lookup. Lookup
 * is usually needed for augmenting and overriding annotations.
 */
public final class AnnotatedMethodMap
    implements Iterable<AnnotatedMethod>
{
    protected Map<MemberKey,AnnotatedMethod> _methods;

    public AnnotatedMethodMap() { }

    /**
     * @since 2.9
     */
    public AnnotatedMethodMap(Map<MemberKey,AnnotatedMethod> m) {
        _methods = m;
    }

    public int size() {
        return (_methods == null) ? 0 : _methods.size();
    }

    public AnnotatedMethod find(String name, Class<?>[] paramTypes)
    {
        if (_methods == null) {
            return null;
        }
        return _methods.get(new MemberKey(name, paramTypes));
    }

    public AnnotatedMethod find(Method m)
    {
        if (_methods == null) {
            return null;
        }
        return _methods.get(new MemberKey(m));
    }

    /*
    /**********************************************************
    /* Iterable implementation (for iterating over values)
    /**********************************************************
     */

    private final static List<AnnotatedMethod> EMPTY_LIST = Collections.emptyList();

    @Override
    public Iterator<AnnotatedMethod> iterator()
    {
        if (_methods == null) {
            // JDK 7+
            // return Collections.emptyIterator();
            return EMPTY_LIST.iterator();
        }
        return _methods.values().iterator();
    }
}
