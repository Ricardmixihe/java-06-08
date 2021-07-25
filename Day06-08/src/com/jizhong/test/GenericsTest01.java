package com.jizhong.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;

import com.jizhong.pojo.Student;

/**
 * 泛型通配符：?
	 通配符泛型不单可以向下限制，如<? extends Collection>，
	 还可以向上限制，如<? super Collection>，
	 表示类型只能接受Double及其上层父类类型，如Number、Object类型的实例。
	 
	 泛型通配符：
    	?：代表任意的数据类型
	使用方式：
	    不能创建对象使用
	    只能作为方法的参数使用
 */
public class GenericsTest01 {
	public static void main(String[] args) {
		//调用方法遍历一个数组，数组类型不确定
		ArrayList<String> arrStr = new ArrayList<>();
		arrStr.add("a");
		arrStr.add("b");
		arrStr.add("c");
		ArrayList<Integer> arrInt = new ArrayList<>();
		arrInt.add(1);
		arrInt.add(2);
		arrInt.add(3);
		ArrayList<Double> arrDou = new ArrayList<>();
		arrDou.add(1.1);
		arrDou.add(2.2);
		arrDou.add(3.3);
		
		
		ArrayList<Object> arrObj = new ArrayList<>();
		arrObj.add(new Student());
		arrObj.add(new Student());
		arrObj.add(new Student());
		/**
	 		泛型通配符：
			?：代表任意的数据类型
		 */
		//arrStr arrInt  arrDou
		//ArrayList<? extends Number>
		showItem1(arrStr);//ArrayList<String extends Number> x
		showItem1(arrInt);//ArrayList<Integer extends Number> √
		showItem1(arrDou);//ArrayList<Double extends Number> √
		showItem1(arrObj);//ArrayList<Object extends Number> x
		
		showItem2(arrStr);//ArrayList<String super Number> x
		showItem2(arrInt);//ArrayList<Integer super Number> x
		showItem2(arrDou);//ArrayList<Double super Number> x
		showItem2(arrObj);//ArrayList<Object super Number> √
	}
	
	public static void showItem1(ArrayList<? extends Number> arr){
		//1. 创建迭代器
		Iterator iterator = arr.iterator();
		//2. 遍历数组
		while(iterator.hasNext()){
			System.out.println(iterator.next());;
		}
	}
	public static void showItem2(ArrayList<? super Number> arr){
		//1. 创建迭代器
		Iterator iterator = arr.iterator();
		//2. 遍历数组
		while(iterator.hasNext()){
			System.out.println(iterator.next());;
		}
	}

}
