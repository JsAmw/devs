package com.lib.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JINS on 2016/11/19.
 * 程序主入口
 */
public class XMain {

    private static final Logger logger = LoggerFactory.getLogger(XMain.class);

    public static void main(String[] args) {
        logger.info("=====start=====");
        new XMain().new Child();
    }

    /**
     * 子类中父类会初始化的属性时，需要注意，不要赋值
     */
    class Super {
        String superTxt;

        public Super() {
            SerializableUtil.serialize(this);
        }
    }

    class Child extends Super {
        String childTxt = null;

        public Child() {
            super();
            logger.debug("superTxt = {}", superTxt);
            logger.debug("childTxt = {}", childTxt);
        }
    }

    static class SerializableUtil {
        public static void serialize(final Super t) {
           if (t instanceof Child) {
                Child child = (Child) t;
               child.childTxt = "init-child-txt";
           }
           t.superTxt = "init-super-txt";
        }
    }
}
