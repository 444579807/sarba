package org.sarba.java.bean;

import org.sarba.java.bean.entity.Parant;
import org.sarba.java.bean.entity.Sub;

import java.beans.*;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-05-15 14:49
 * @description: jdk beans包详细实例
 **/
public class Main {
    public static void main(String[] args) {

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Parant.class,Object.class);
            //JavaBean的属性信息
            for(PropertyDescriptor pd :beanInfo.getPropertyDescriptors()){
                System.out.println("属性名称 -----"+pd.getName());
                System.out.println("属性类型 -----"+pd.getPropertyType().toGenericString());
                System.out.println("属性的get方法 -----"+pd.getReadMethod().toGenericString());
                System.out.println("属性的set方法 -----"+pd.getWriteMethod().toGenericString());
            }
            //JavaBean的方法信息
            for(MethodDescriptor md:beanInfo.getMethodDescriptors()){
                System.out.println(md.getDisplayName());
            }
            for(BeanInfo bi :beanInfo.getAdditionalBeanInfo()){
                System.out.println("关联的类--"+bi.toString());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
}
