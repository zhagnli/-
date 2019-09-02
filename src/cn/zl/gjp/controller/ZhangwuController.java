package cn.zl.gjp.controller;

import java.util.List;

import cn.zl.gjp.domain.ZhangWu;
import cn.zl.gjp.service.ZhangwuService;

/*
 * ��������
 * ������ͼ������ݣ����ݴ��ݸ�service��
 * ����ĳ�Աλ�û���Ҫ����service����
 * 
 */
public class ZhangwuController {
	private ZhangwuService service=new ZhangwuService();
	
	/*
	 * ���巽����ʵ��ɾ��������
	 * ��ͼ����ã�����int��������
	 * ����service�㷽��������int����
	 */
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽����ʵ�ֱ༭������
	 * ����ͼ����ã����ݲ�����Ҳ��ZhangWu����
	 * ����service��ķ���������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ӹ���
	 * ����ͼ����ã����ݲ���(���ݹ����Ĳ���������5�����ݣ���Ҫ���ݹ�������һ��ZhangWu���͵Ķ���)
	 * ����������service��ķ���������ZhangWu���󣬻�ȡ����Ӻ�Ľ����(��ӳɹ���������int)
	 */
	public void addZhangwu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ѯ����
	 * ��������ͼ����ã������������ڵ��ַ���
	 * ����service��ķ����������������ַ�������ȡ�ṹ�ּ�
	 * ��������ظ���ͼ��controller�����service�㷽��
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate, endDate);
	}
	
	/*
	 * ���Ʋ��ඨ�巽����ʵ�ֲ�ѯ���е���������
	 * ��������ͼ����ã���������service��
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
}
