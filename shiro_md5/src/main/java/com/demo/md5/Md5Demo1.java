package com.demo.md5;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Demo1 {
	public static void main(String[] args) {
		// 使用md5算法进行加密
		Md5Hash md5Hash = new Md5Hash("1111");
		System.out.println("1111" + ">>" + md5Hash);
		// 加盐
		md5Hash = new Md5Hash("1111", "demo");
		System.out.println("1111" + ">>" + md5Hash);
		// 迭代次数
		md5Hash = new Md5Hash("1111", "demo", 2);
		System.out.println("1111" + ">>" + md5Hash);
	}
}
