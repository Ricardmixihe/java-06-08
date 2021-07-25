package com.jizhong.test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

import com.jizhong.pojo.Person;
import com.jizhong.pojo.Student;

public class ReflectionTest02 {
	public static void main(String[] args) throws Exception {
		//在不改变原本代码的情况下，执行学生类的睡觉与人类的吃东西（交替执行）
		
		//学生类的睡觉
		//1. 创建学生对象
//		Student stu = new Student();
//		//2. 调用学生睡觉方法
//		stu.sleep();
//		
//		//人类的吃东西
//		//1. 创建人类对象
//		Person p = new Person();
//		//2. 调用人类吃东西方法
//		p.eat();
		
		
		
		
		
		
		//反射方法解决交替执行
		/**
		 * Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
		 * 全类名：包名 + 类名
		 */
		
		//0 创建Properties对象读取properties文件
		Properties pro = new Properties();
		InputStream input = ReflectionTest02.class.getClassLoader().getResourceAsStream("reflection.properties");
		pro.load(input);
		//0.1 获取配置文件中的全类名
		String path = (String) pro.get("path");
		//0.2 获取配置文件中的方法名
		String methodName = (String)pro.get("methodname");
		
		//1. 创建Class字节码对象
		Class cls = Class.forName(path);//com.jizhong.pojo.Student
		//2. 创建构造方法对象
		Constructor constructor = cls.getDeclaredConstructor();
		//2.1 创建真实对象
		Object object = constructor.newInstance();
		//3. 获取方法对象
		Method method = cls.getDeclaredMethod(methodName);
		//3.1 执行method方法
		method.invoke(object);
	}
}	
