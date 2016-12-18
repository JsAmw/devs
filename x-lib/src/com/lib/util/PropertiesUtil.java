package com.lib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by JINS on 2016/11/21.
 */
public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public Map<String, Object> getFilters() {
        Properties properties = null;
        InputStream inputStream = null;
        List<String> filters = new ArrayList<>();
        try {
            inputStream = PropertiesUtil.class.getResourceAsStream("/conf/lib.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {

        } catch (Exception e1) {

        }

        return null;
    }
}
