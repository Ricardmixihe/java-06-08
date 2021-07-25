package com.jizhong.test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import com.jizhong.pojo.Reflection;

/**
 * 获取Class对象的三种方式：
	1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
		* 多用于配置文件，将类名定义在配置文件中，读取文件、加载类
	2. 类名.class：通过类名的属性class获取
		* 多用于做参数的传递
	3. 对象.getClass()：getClass()方法在Object类中定义着。
		* 多用于对象的获取字节码的方式
	同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。



	1. 获取成员变量们
		* Field getField(String name)  //获取public修饰的指定名称的成员变量
		* Field[] getFields()  //获取public修饰的所有的成员变量
		
		* Field getDeclaredField(String name)  //获取所有指定名称的成员变量
		* Field[] getDeclaredFields()  //获取所有成员变量
	2. 获取成员方法们
		* Method getMethod(String name, Class<?>... parameterTypes)  
		* Method[] getMethods()  
		
		* Method getDeclaredMethod(String name, Class<?>... parameterTypes)  
		* Method[] getDeclaredMethods()  
	3. 获取构造方法们
		* Constructor<T> getConstructor(Class<?>... parameterTypes) 
		* Constructor<?>[] getConstructors()
		
		* Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)  
		* Constructor<?>[] getDeclaredConstructors()  
	4. 获取类名
		* String getName()  
 */
public class ReflectionTest01 {
	public static void main(String[] args) throws Exception {
		//1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
		//全类名：类的全部包名 + 类名
		Class cls = Class.forName("com.jizhong.pojo.Reflection");
		
		//2. 类名.class：通过类名的属性class获取,返回Class对象
		Class cls2 = Reflection.class;
		
		//3. 对象.getClass()：getClass()方法在Object类中定义着。返回Class对象
		Reflection re = new Reflection();
		Class cls3 = re.getClass();
		
		
//		System.out.println(cls == cls2);//true
//		System.out.println(cls == cls3);//true
		
		
		
		/**
	 		1. 获取成员变量们
			* Field getField(String name)  //获取public修饰的指定名称的成员变量
			* Field[] getFields()  //获取public修饰的所有的成员变量
			
			* Field getDeclaredField(String name)  //获取所有指定名称的成员变量
			* Field[] getDeclaredFields()  //获取所有成员变量
		 */
//		Field[] fields = cls.getFields();//获取public修饰的所有的成员变量
//		Field[] fields = cls.getDeclaredFields();//获取所有成员变量
//		for(Field field : fields){
//			System.out.println(field);//private java.lang.String com.jizhong.pojo.Reflection.name
//		}
//		
////		Field field = cls.getField("name");//获取public修饰的指定名称的成员变量
//		Field field = cls.getDeclaredField("name");//获取所有指定名称的成员变量
//		System.out.println(field);
//		
//		
//		/**
//		 2. 获取构造方法们：创建对象
//			* Constructor<T> getConstructor(Class<?>... parameterTypes) //获取public修饰指定参数的构造方法
//			* Constructor<?>[] getConstructors()	//获取public修饰所有的构造方法
//			
//			* Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)  //获取定参数的构造方法
//			* Constructor<?>[] getDeclaredConstructors()  //获取所有的构造方法
//		 */
//		Constructor[] cs = cls.getDeclaredConstructors(); //获取所有的构造方法
//		for(Constructor c : cs){
//			System.out.println(c);//构造方法
//		}
//		//Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
//		Constructor c1 = cls.getDeclaredConstructor();//无参构造方法
//		System.out.println(c1);
//		//parameterTypes：参数类型的Class对象
//		Constructor c2 = cls.getDeclaredConstructor(String.class);//有参构造方法
//		System.out.println(c2);
		
		/**
		 3. 获取成员方法们：执行方法
			* Method getMethod(String name, Class<?>... parameterTypes)  
			* Method[] getMethods()  
			
			* Method getDeclaredMethod(String name, Class<?>... parameterTypes)  //获取所有成员方法
			* Method[] getDeclaredMethods()  //获取所有成员方法
		 */
//		Method[] methods = cls.getDeclaredMethods();//获取所有成员方法
//		for(Method method : methods){
//			System.out.println(method);
//		}
//		//getDeclaredMethod(String name, Class<?>... parameterTypes)
//		
//		Method method = cls.getDeclaredMethod("show");
//		System.out.println(method);
//		
//		//4. 获取类名
//		System.out.println(cls.getName());
		
		
		
		
		
		/**
		  	Field：成员变量
			* 操作
				1. 设置值
					* voie set(Object obj,Object value)
					* obj：你要为哪个对象设置值
					* value：成员变量设置的值
				2. 获取值
					* get(Object obj)
					* obj：你要获取那个对象的成员变量
			忽略访问权限修饰符的安全检查
		 		setAccessible(true)：暴力反射
		 */
		
//		Properties pro = new Properties();
//		InputStream in = cls.getClassLoader().getResourceAsStream("application.properties");
//		pro.load(in);
//		Reflection r = new Reflection();
//		Field field = cls.getDeclaredField(pro.getProperty("field"));//配置文件中获取
//		
//		/**
//		 * 忽略访问权限修饰符的安全检查
//		 * setAccessible(true)：暴力反射
//		 */
//		field.setAccessible(true);//暴力反射
//		field.set(r, pro.getProperty("name"));//配置文件中获取
//		System.out.println(field.get(r));
//		System.out.println(r);
		
		/**
		 	* Constructor：构造方法
			* 创建对象：
				* T newInstance(Object... initargs)
				* initargs：构造方法传递参数
			* 如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法
			* 
			* 
			* Constructor<T> getConstructor(Class<?>... parameterTypes) 
			* Constructor<?>[] getConstructors()
			//parameterTypes：参数列表的class文件 如： String  String.class
			* Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)  
			* Constructor<?>[] getDeclaredConstructors()  
		 */
		//无参构造对象
		Constructor<Reflection> c = cls.getDeclaredConstructor();//无参构造
		Reflection r = c.newInstance();
		System.out.println(r);
		
		//有参构造对象
		Constructor<Reflection> c1 = cls.getDeclaredConstructor(String.class);//有参构造
		Reflection r1 = c1.newInstance("张三");
		System.out.println(r1);
		
		
		/**
		 	* Method：方法对象
			* 执行方法：
				* Object invoke(Object obj,Object... args)
				* obj：指定要执行方法的对象
				* args：方法传递的参数
			* 获取方法名称：
				* String getName：获取方法名
				 
				
				 
			* Method getMethod(String name, Class<?>... parameterTypes)  
			* Method[] getMethods()  
			
			* Method getDeclaredMethod(String name, Class<?>... parameterTypes)  
			* Method[] getDeclaredMethods()  
		 */
		
		/**
		 	* Method：成员方法对象
			* 执行方法：
				* Object invoke(Object obj,Object... args)
				* obj：指定要执行方法的对象
				* args：方法传递的参数
			* 获取方法名称：
				* String getName：获取方法名
		 */
		Method method = cls.getDeclaredMethod("show");
		method.setAccessible(true);
		//invoke(obj, args)：执行obj对象的method方法
		method.invoke(r);
	}
}
