package cn.zl.gjp.service;

import java.util.List;

import cn.zl.gjp.dao.ZhangwuDao;
import cn.zl.gjp.domain.ZhangWu;

/*
 * 业务层类，接收上一层，控制层controller的数据
 * 经过计算，传递给dao层，操作数据库
 * 调用dao层中的类，在类成员位置创建Dao类对象
 */
public class ZhangwuService {
	private ZhangwuDao dao=new ZhangwuDao();
	
	/*
	 * 定义方法，实现删除账务功能
	 * 有控制层调用，传递主键id
	 * 调用dao层方法，传递主键id
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * 定义方法，实现编辑账务
	 * 由控制层调用，传递账务对象
	 * 调用dao层的方法，传递ZhangWu对象
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现添加账务
	 * 是由控制层调用，传递ZhangWu类型对象
	 * 调用dao层方法，传递ZhangWu对象
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现条件查询账务
	 * 方法由控制层去调用，传递两个日期字符串
	 * 调用dao层的方法，传递两个日期的字符串
	 * 获取查询结果集,service层是调用dao层
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	
	
	/*
	 * 定义方法，实现查询所有账务数据
	 * 此方法由控制层调用，去调用dao层的方法
	 * 返回存储Zhangwu对象的List集合
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	

	


	
}
