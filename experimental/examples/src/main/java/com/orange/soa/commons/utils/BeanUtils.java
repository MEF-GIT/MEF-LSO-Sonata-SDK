package com.orange.soa.commons.utils;

import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 *
 * @author maig7313
 */
public class BeanUtils {

	private static final PropertyUtilsBean PUB = new PropertyUtilsBean();


	/**
	 *
	 * @param bean
	 * @param name
	 * @return
	 */
	public static Object getNestedProperty(Object bean, String name) {
		try {
			return PUB.getNestedProperty(bean, name);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *
	 * @param bean
	 * @param name
	 * @param value
	 */
	public static void setNestedProperty(Object bean, String name,
			Object value) {
		try {
			PUB.setNestedProperty(bean, name, value);
		}
		catch (Exception ex) {
		}
	}

}