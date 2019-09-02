package cn.zl.gjp.service;

import java.util.List;

import cn.zl.gjp.dao.ZhangwuDao;
import cn.zl.gjp.domain.ZhangWu;

/*
 * ҵ����࣬������һ�㣬���Ʋ�controller������
 * �������㣬���ݸ�dao�㣬�������ݿ�
 * ����dao���е��࣬�����Աλ�ô���Dao�����
 */
public class ZhangwuService {
	private ZhangwuDao dao=new ZhangwuDao();
	
	/*
	 * ���巽����ʵ��ɾ��������
	 * �п��Ʋ���ã���������id
	 * ����dao�㷽������������id
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽����ʵ�ֱ༭����
	 * �ɿ��Ʋ���ã������������
	 * ����dao��ķ���������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ���������
	 * ���ɿ��Ʋ���ã�����ZhangWu���Ͷ���
	 * ����dao�㷽��������ZhangWu����
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ѯ����
	 * �����ɿ��Ʋ�ȥ���ã��������������ַ���
	 * ����dao��ķ����������������ڵ��ַ���
	 * ��ȡ��ѯ�����,service���ǵ���dao��
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	
	
	/*
	 * ���巽����ʵ�ֲ�ѯ������������
	 * �˷����ɿ��Ʋ���ã�ȥ����dao��ķ���
	 * ���ش洢Zhangwu�����List����
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	

	


	
}
