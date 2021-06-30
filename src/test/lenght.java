package test;

import java.lang.reflect.Array;

public class lenght {
	public static Object arrayAddLength(Object oldArray,int addLength) {
		Class c = oldArray.getClass();
		if(!c.isArray())return null;
		Class componentType = c.getComponentType();
		int length = Array.getLength(oldArray);
		int newLength = length + addLength;
		Object newArray = Array.newInstance(componentType,newLength);
		System.arraycopy(oldArray,0,newArray,0,length);
		return newArray;
		} 
	public static void main(String[] args) {
		String a[]= new String[]{"","","","","","1"};
		int b[]= new int[]{0,1,2,3,4,5};
		a = (String[]) arrayAddLength(a,2);
		//out print array lenght
		System.out.println(a.length);
		for (int i=0;i<a.length;i++){
		System.out.print(a[i]);
		}
		System.out.println();

		System.out.println(b.length);
		for (int i=0;i<b.length;i++){
		System.out.print(b[i]);
		} 
	}
	
}
