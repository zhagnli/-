package cn.zl.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.zl.gjp.controller.ZhangwuController;
import cn.zl.gjp.domain.ZhangWu;

/*
 * ��ͼ�㣬�û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ȥʵ��
 * ����ĳ�Աλ�ô���һ��controller����
 */
public class MainView {
	private ZhangwuController controller=new ZhangwuController();
	/*
	 * ʵ�ֽ���Ч���������û����롣�������ݣ����ò�ͬ�Ĺ��ܷ���
	 */
	public void run() {
//		����һ��Scanner����󣬷������м�������
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("---------------------�ܼ��ż�ͥ�������----------------------");
			System.out.println("1���������   2���༭����    3��ɾ������    4����ѯ����   5���˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]��");
			
//			�����û��Ĳ˵�ѡ��
			int choose=sc.nextInt();
//			��ѡ��Ĳ˵��жϣ����ò�ͬ�Ĺ���
			switch(choose) {
			case 1:
//				ѡ�����������񣬵����������ķ���
				addZhangWu();
				break;
			case 2:
//				ѡ����Ǳ༭���񣬵��ñ༭����ķ���
				editZhangWu();
				break;
			case 3:
//				ѡ�����ɾ�����񣬵���ɾ������ķ���
				deleteZhangWu();
				break;
			case 4:
//				ѡ����ǲ�ѯ���񣬵��ò�ѯ����ķ���
				select();
				break;
			case 5:
//				�˳�ϵͳ
				System.exit(0);
				break;
			}
		}
	}
	
	/*
	 * ���巽����ʵ������ɾ��
	 * ʵ��˼�룺�����û����룬����һ����������
	 * ���ÿ��Ʋ㷽��������һ������
	 */
	public void deleteZhangWu() {
//		���ò�ѯ�����������ݵĹ��ܣ���ʾ����
//		�����������ݣ�����ѡ��һ�����ɾ��
		selectAll();
		System.out.println("ѡ�����ɾ�����ܣ�������ţ�");
		int zwid=new Scanner(System.in).nextInt();
//		���ÿ��Ʋ㷽������������id����
		controller.deleteZhangWu(zwid);
		System.out.println("ɾ������ɹ�");
	}
	
	/*
	 * ���巽����ʵ�ֶ�����ı༭����
	 * ʵ��˼�룺�����û������룻���ݵ���Ϣ����װ��ZhangWu���󣻵��ÿ��Ʋ�ķ���������ZhangWu����ʵ�ֱ༭
	 */
	public void editZhangWu() {
//		���ò�ѯ�����������ݵĹ��ܣ���ʾ����
//		�����������ݣ�����ѡ��һ������޸�
		selectAll();
		System.out.println("ѡ����Ǳ༭���ܣ�����������");
		Scanner sc=new Scanner(System.in);
//		�����û�������
		System.out.print("����ID��");
		int zwid=sc.nextInt();
		System.out.print("����������֣�");	
		String flname=sc.next();
		System.out.println("������");
		double money=sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu=sc.next();
		System.out.println("�������ڣ���ʽxxxx-xx-xx");
		String createtime=sc.next();
		System.out.println("������������");
		String description=sc.next();
//		�����е��û���������ݣ���װ��ZhangWu������
//		�����ID�������װ����
		ZhangWu zw=new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
//		����controller��ķ�����ʵ�ֱ༭����
		controller.editZhangWu(zw);
		System.out.println("����༭�ɹ�");
	}
	
	/*
	 * ���巽��addZhangWu
	 * �������ĵķ������û��ڽ�����ѡ��˵�1��ʱ�����
	 * ʵ��˼�룺���ռ������룬�����û���5�����룬����controller�㷽��
	 */
	public void addZhangWu() {
		System.out.println("ѡ�����������ܣ�������һ������");
		Scanner sc=new Scanner(System.in);
		System.out.println("������������");
		String flname=sc.next();
		System.out.println("������");
		double money=sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu=sc.next();
		System.out.println("�������ڣ���ʽxxxx-xx-xx");
		String createtime=sc.next();
		System.out.println("������������");
		String description=sc.next();
//		�������û���������ݣ���װ��ZhangWu������
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		
//		�����յ������ݣ�����controller��ķ��������ݲ���
//		���û���������в�������װ��ZhangWu����
		controller.addZhangwu(zw);
		System.out.println("��ϲ���������ɹ�");
	}
	
	/*
	 * ���巽��selectZhangwu()
	 * ��ʾ��ѯ�ķ�ʽ��1 ���в�ѯ    2 ������ѯ��
	 * �����û���ѡ��
	 */
	public void selectZhangwu() {
		System.out.println("1 ��ѯ����   2 ������ѯ");
		Scanner sc=new Scanner(System.in);
		int selectChooser=sc.nextInt();
		
//		�жϸ����û���ѡ�񣬵��ò�ͬ�Ĺ���
		switch(selectChooser) {
		case 1:
//			ѡ���ѯ���У����ò�ѯ���еķ���
			selectAll();
			break;
		case 2:
//			ѡ��������ѯ�����ô��в�ѯ�����ķ���
			break;
		}
	}
	
//	���巽����ʵ�ֲ�ѯ���е���������
	public void selectAll() {
//		���ÿ��Ʋ��еķ�������ѯ������������
		List<ZhangWu> list =controller.selectAll();
		print(list);
	}

//	����������ݷ���������List���ϣ���������������
	private void print(List<ZhangWu> list) {
		//		�����ͷ
				System.out.println("ID\t���\t�˻�\t���\tʱ��\t˵��");
		//		�������ϣ�����������̨
				for(ZhangWu zw:list) {
					System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"+
									   zw.getMoney()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
				}
	}
	
/*	
 * ���巽����ʵ��������ѯ�������ݡ��ṩ�û����������ڡ�����ʼ���ںͽ�������
 * �ṩ�û����������ڣ���ʼ���ںͽ�������
 * ���������ڣ�����controller��
 * ����controller�ķ���������2�����ڲ���
 * ��ȡ��controller���ѯ�Ľ��������ӡ����
 */
	public void select() {
		System.out.println("ѡ��Ĳ�ѯ�������������ڸ�ʽΪXXXX-XX-XX");
		Scanner sc=new Scanner(System.in);
		System.out.println("�����뿪ʼ���ڣ�");
		String startDate=sc.nextLine();
		System.out.println("������������ڣ�");
		String endDate=sc.nextLine();
		
//		����Controller��ķ������������ڣ���ȡ��ѯ�����
		List<ZhangWu> list=controller.select(startDate, endDate);
		if(list.size()!=0) {
			print(list);
		}else
			System.out.println("û�в�ѯ������");
	}
}
