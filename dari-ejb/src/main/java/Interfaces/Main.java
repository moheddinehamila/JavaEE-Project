package Interfaces;

import java.util.ArrayList;
import java.util.List;

import Entities.*;
import Services.*;

public class Main {

	public static void main(String[] args) {
		FurnitureService fs=new FurnitureService();
		System.out.println(fs.GetAll());
//		for (Furniture f : fs.Gettop10expensive()) {
//			System.out.println(f);
//		}

//		VotedService vs=new VotedService();
//		System.out.println(vs.GetAll());
//		System.out.println(vs.isvoted(18));
//		vs.addvote(24, "6035cc13-edae-410b-9519-cf799f71990a",5);
//		List<Furniture> fList =fs.GetAll();
//		for (Furniture myproduct : fList) {
//			
//			System.out.println(myproduct.getNote()+"  "+myproduct.isVirgule());
// 		}

//		FurnitureService fs=new FurnitureService();
//		List<Furniture> fList =fs.GetAll();
//		for (Furniture myproduct : fList) {
//			
//			System.out.println(myproduct);
// 		}
//		System.out.println("---"+fs.Getbyid(24));
//		 
//		System.out.println("*************************************************");
//		System.out.println("*************************************************");
////		
		OrderService os = new OrderService();
//		System.out.println(os.GetAll());
//		System.out.println(os.getalist());
//		for (int i = 1; i <= 4; i++) {
//			System.out.println(i);
//			System.out.println(os.fl(i));
//		}
//		
<<<<<<< HEAD
=======
<<<<<<< HEAD


		FurnitureService fs=new FurnitureService();
		List<Furniture> fList =fs.GetAll();
		for (Furniture myproduct : fList) {
			
			System.out.println(myproduct);
 		}
		//System.out.println("---"+fs.Getbyid(24));
		

		System.out.println("*************************************************");
		System.out.println("*************************************************");
		
		OrderService os=new OrderService();
		List<Order> oList =os.GetAll();
		for (Order myorder : oList) {
			System.out.println(myorder);
 		}

=======
>>>>>>> 05eb23c7ba123e67d2dbbcf0f0071618b4dd7488
		// for (Order myorder : oList) {
//			System.out.println(myorder);
// 		}
//		int nb=1;
//		int num=oList.get(0).getBillId();
//		for (Order order : oList) {
//			if (order.getBillId()!=num) {
//				nb++;
//				num=order.getBillId();
//			}
//		} 
//		
//		ArrayList<ArrayList<Order> > aList =  
//                new ArrayList<ArrayList<Order> >(444); 
//
//			ArrayList<Order> a1 = new ArrayList<Order>(); 
//			 
//		num=oList.get(0).getBillId();
//			for (Order order : oList) {
//				System.out.print(" out ");
//				if (order.getBillId()==num) {
//					a1.add(order);
//					System.out.print(" yes:"+num);
//				}
//				else {
//
//					aList.add(a1);
//			         a1 = new ArrayList<Order>(); 
//			         a1.add(order);
//					System.out.print(" inno "+num);
//					num=order.getBillId();
//
//				} 
//						} 					
//			aList.add(a1);
// 
// System.out.println(aList);
//					 
//        ArrayList<Integer> a1 = new ArrayList<Integer>(); 
//        a1.add(1); 
//        a1.add(2); 
//        aList.add(a1); 
<<<<<<< HEAD
=======
>>>>>>> d6839ab2c575045bf0310a2ce47ea499d2fd043c
>>>>>>> 05eb23c7ba123e67d2dbbcf0f0071618b4dd7488
//		System.out.println("*************************************************");
//		System.out.println("*************************************************");
//		
//		VotedService vs =new VotedService();
//		vs.addvote(14, "6035cc13-edae-410b-9519-cf799f71990a",5);
//		List<Voted> vList =vs.GetAll();
//		for (Voted myvote : vList) {
//			System.out.println(myvote);
// 		}
//		System.out.println(vs.isvoted(2));
//		vs.addvote(2,"6035cc13-edae-410b-9519-cf799f71990a" );
//
//		System.out.println("*************************************************");
//		System.out.println("*************************************************");
//		
//		VotedService vs =new VotedService();
//		List<Voted> vList =vs.GetAll();
//		for (Voted myvote : vList) {
//			System.out.println(myvote);
// 		}
//		System.out.println(vs.isvoted(2));
//		vs.addvote(2,"6035cc13-edae-410b-9519-cf799f71990a" );
// 
//		System.out.println("*************************************************");
//		System.out.println("*************************************************");

//		CommentService cs=new CommentService(); 
//		for (Comment c : cs.Getbyid(1)) {
//			System.out.println(c.getDate());
//		}
//		cs.delcomment(3);

	}
}
