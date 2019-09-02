package cn.zl.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.zl.gjp.controller.ZhangwuController;
import cn.zl.gjp.domain.ZhangWu;

/*
 * 视图层，用户看到和操作的界面
 * 数据传递给controller层去实现
 * 在类的成员位置创建一个controller对象
 */
public class MainView {
	private ZhangwuController controller=new ZhangwuController();
	/*
	 * 实现界面效果，接收用户输入。根据数据，调用不同的功能方法
	 */
	public void run() {
//		创建一个Scanner类对象，反复进行键盘输入
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("---------------------管家婆家庭记账软件----------------------");
			System.out.println("1、添加账务   2、编辑账务    3、删除账务    4、查询账务   5、退出系统");
			System.out.println("请输入要操作的功能序号[1-5]：");
			
//			接收用户的菜单选择
			int choose=sc.nextInt();
//			对选择的菜单判断，调用不同的功能
			switch(choose) {
			case 1:
//				选择的是添加账务，调用添加账务的方法
				addZhangWu();
				break;
			case 2:
//				选择的是编辑账务，调用编辑账务的方法
				editZhangWu();
				break;
			case 3:
//				选择的是删除账务，调用删除账务的方法
				deleteZhangWu();
				break;
			case 4:
//				选择的是查询账务，调用查询账务的方法
				select();
				break;
			case 5:
//				退出系统
				System.exit(0);
				break;
			}
		}
	}
	
	/*
	 * 定义方法，实现账务删除
	 * 实现思想：接收用户输入，输入一个主键数据
	 * 调用控制层方法，传递一个主键
	 */
	public void deleteZhangWu() {
//		调用查询所有账务数据的功能，显示出来
//		看的所有数据，从中选择一项，进行删除
		selectAll();
		System.out.println("选择的是删除功能，输入序号：");
		int zwid=new Scanner(System.in).nextInt();
//		调用控制层方法，传递主键id即可
		controller.deleteZhangWu(zwid);
		System.out.println("删除账务成功");
	}
	
	/*
	 * 定义方法，实现对账务的编辑功能
	 * 实现思想：接收用户的输入；数据的信息，封装成ZhangWu对象；调用控制层的方法，传递ZhangWu对象，实现编辑
	 */
	public void editZhangWu() {
//		调用查询所有账务数据的功能，显示出来
//		看到所有数据，从中选择一项，进行修改
		selectAll();
		System.out.println("选择的是编辑功能，请输入数据");
		Scanner sc=new Scanner(System.in);
//		接收用户的数据
		System.out.print("输入ID：");
		int zwid=sc.nextInt();
		System.out.print("输入分类名字：");	
		String flname=sc.next();
		System.out.println("输入金额");
		double money=sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu=sc.next();
		System.out.println("输入日期：格式xxxx-xx-xx");
		String createtime=sc.next();
		System.out.println("输入具体的描述");
		String description=sc.next();
//		将所有的用户输入的数据，封装到ZhangWu对象中
//		输入的ID，必须封装对象
		ZhangWu zw=new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
//		调用controller层的方法，实现编辑账务
		controller.editZhangWu(zw);
		System.out.println("账务编辑成功");
	}
	
	/*
	 * 定义方法addZhangWu
	 * 添加账务的的方法，用户在界面中选择菜单1的时候调用
	 * 实现思想：接收键盘输入，接收用户的5项输入，调用controller层方法
	 */
	public void addZhangWu() {
		System.out.println("选择的添加账务功能，请输入一下内容");
		Scanner sc=new Scanner(System.in);
		System.out.println("输入分类的名称");
		String flname=sc.next();
		System.out.println("输入金额");
		double money=sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu=sc.next();
		System.out.println("输入日期：格式xxxx-xx-xx");
		String createtime=sc.next();
		System.out.println("输入具体的描述");
		String description=sc.next();
//		将所有用户输入的数据，封装到ZhangWu对象中
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		
//		将接收到的数据，调用controller层的方法，传递参数
//		将用户输入的所有参数，封装成ZhangWu对象
		controller.addZhangwu(zw);
		System.out.println("恭喜！添加账务成功");
	}
	
	/*
	 * 定义方法selectZhangwu()
	 * 显示查询的方式“1 所有查询    2 条件查询”
	 * 接收用户的选择
	 */
	public void selectZhangwu() {
		System.out.println("1 查询所有   2 条件查询");
		Scanner sc=new Scanner(System.in);
		int selectChooser=sc.nextInt();
		
//		判断根据用户的选择，调用不同的功能
		switch(selectChooser) {
		case 1:
//			选择查询所有，调用查询所有的方法
			selectAll();
			break;
		case 2:
//			选择条件查询，调用带有查询条件的方法
			break;
		}
	}
	
//	定义方法，实现查询所有的账务数据
	public void selectAll() {
//		调用控制层中的方法，查询所有账务数据
		List<ZhangWu> list =controller.selectAll();
		print(list);
	}

//	输出账务数据方法，接收List集合，遍历集合输出表格
	private void print(List<ZhangWu> list) {
		//		输出表头
				System.out.println("ID\t类别\t账户\t金额\t时间\t说明");
		//		遍历集合，结果输出控制台
				for(ZhangWu zw:list) {
					System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"+
									   zw.getMoney()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
				}
	}
	
/*	
 * 定义方法，实现条件查询账务数据。提供用户的输入日期——开始日期和结束日期
 * 提供用户的输入日期，开始日期和结束日期
 * 就两个日期，传到controller层
 * 调用controller的方法，传递2个日期参数
 * 获取到controller层查询的结果集，打印出来
 */
	public void select() {
		System.out.println("选择的查询条件，输入日期格式为XXXX-XX-XX");
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入开始日期：");
		String startDate=sc.nextLine();
		System.out.println("请输入结束日期：");
		String endDate=sc.nextLine();
		
//		调用Controller层的方法，传递日期，获取查询结果集
		List<ZhangWu> list=controller.select(startDate, endDate);
		if(list.size()!=0) {
			print(list);
		}else
			System.out.println("没有查询到数据");
	}
}
