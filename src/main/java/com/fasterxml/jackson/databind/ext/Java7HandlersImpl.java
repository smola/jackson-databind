package com.fasterxml.jackson.databind.ext;

import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.IgnoreJRERequirement;

/**
 * @since 2.10
 */
@IgnoreJRERequirement
public class Java7HandlersImpl extends Java7Handlers
{
    private final Class<?> _pathClass;
    
    public Java7HandlersImpl() {
        // 19-Sep-2019, tatu: Important to do this here, because otherwise
        //    we get [databind#2466]
        _pathClass = Path.class;
    }
    
    @Override
    public Class<?> getClassJavaNioFilePath() {
        return _pathClass;
    }

    @Override
    public JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> rawType) {
        if (rawType == _pathClass) {
            return new NioPathDeserializer();
        }
        return null;
    }

    @Override
    public JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> rawType) {
        if (_pathClass.isAssignableFrom(rawType)) {
            return new NioPathSerializer();
        }
        return null;
    }
}
