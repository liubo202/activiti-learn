package com.ysdrzp.f_history;

import java.util.List;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.junit.Test;

/**
 * 查询历史流程实例、查询历史活动、查询历史任务、查询历史流程变量
 * @author ysdrzp
 */
public class TestHistoryQuery {

	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	/**
	 * 1、查询历史流程实例。涉及的表：act_hi_procinst
	 */
	@Test
	public void historyProcessInstince() {
		HistoryService historyService = this.processEngine.getHistoryService();

		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
				//条件
		//		.processDefinitionId(processDefinitionId)
		//		.processDefinitionKey(processDefinitionKey)
		//		.processDefinitionKeyIn(processDefinitionKeys)
		//		.processDefinitionName(processDefinitionName)
		//		.processDefinitionVersion(processDefinitionVersion)
		//		.processInstanceBusinessKey(processInstanceBusinessKey)
		//		.processInstanceId(processInstanceId)
		//		.processInstanceIds(processInstanceIds)

				//排序
		//		.orderByProcessDefinitionId()
		//		.orderByProcessInstanceBusinessKey()
		//		.orderByProcessInstanceDuration()
		//		.orderByProcessInstanceStartTime()
		//		.orderByProcessInstanceId()

				//结果集
				.list();
		//		.listPage(firstResult, maxResults)
		//		.count()
		//		.singleResult();
		
		if(null!=list&&list.size()>0) {
			for (HistoricProcessInstance hpi : list) {
				System.out.println("历史流程实例ID:" + hpi.getId());
				System.out.println("流程定义ID:" + hpi.getProcessDefinitionId());
				System.out.println("历史流程实例的业务ID:" + hpi.getBusinessKey());
				System.out.println("流程部署ID:" + hpi.getDeploymentId());
				System.out.println("流程定义KEY:" + hpi.getProcessDefinitionKey());
				System.out.println("开始活动ID:" + hpi.getStartActivityId());
				System.out.println("结束活动ID:" + hpi.getEndActivityId());
				System.out.println("########################");
			}
		}
	}

	/**
	 * 2、查询历史活动。涉及的表：act_hi_actinst
	 */
	@Test
	public void queryHistoryAct() {
		HistoryService historyService = this.processEngine.getHistoryService();

		List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
				//条件
		//		.activityId(activityId)
		//		.activityInstanceId(activityInstanceId)
		//		.activityName(activityName)

				//排序
		//		.orderByActivityId()
		//		.orderByActivityName()

				//结果集
				.list();

		if(null!=list&&list.size()>0) {
			for (HistoricActivityInstance hai : list) {
				System.out.println("ID:"+hai.getId());
				System.out.println("流程定义ID:"+hai.getProcessDefinitionId());
				System.out.println("流程实例ID:"+hai.getProcessInstanceId());
				System.out.println("执行实例ID:"+hai.getExecutionId());
				System.out.println("活动ID:"+hai.getActivityId());
				System.out.println("任务ID:"+hai.getTaskId());
				System.out.println("活动名称:"+hai.getActivityName());
				System.out.println("活动类型:"+hai.getActivityType());
				System.out.println("任务办理人:"+hai.getAssignee());
				System.out.println("开始时间:"+hai.getStartTime());
				System.out.println("结束时间:"+hai.getEndTime());
				System.out.println("持续时间:"+hai.getDurationInMillis());
				System.out.println("#######################################");
			}
		}
	}

	/**
	 * 3、查询历史任务。涉及的表：act_hi_taskinst
	 */
	@Test
	public void queryHistoryTask() {
		HistoryService historyService = this.processEngine.getHistoryService();

		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
				//条件
		//		.deploymentId(deploymentId)
		//		.deploymentIdIn(deploymentIds)
		//		.executionId(executionId)
		//		.processDefinitionId(processDefinitionId)
		//		.processDefinitionKey(processDefinitionKey)
		//		.processDefinitionKeyIn(processDefinitionKeys)
		//		.processDefinitionKeyLike(processDefinitionKeyLike)
		//		.processDefinitionName(processDefinitionName)
		//		.processDefinitionNameLike(processDefinitionNameLike)

				//排序
		//		.orderByTaskDefinitionKey()

				//结果集
				.list();
		//		.listPage(firstResult, maxResults)
		//		.count()
		//		.singleResult()

		if(null!=list&&list.size()>0) {
			for (HistoricTaskInstance task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务办理人:" + task.getAssignee());
				System.out.println("执行实例ID:" + task.getExecutionId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("任务创建时间:" + task.getCreateTime());
				System.out.println("任务结束时间:" + task.getEndTime());
				System.out.println("#######################################");
			}
		}
	}

	/**
	 * 4、查询历史的流程变量。涉及的表：act_hi_varinst
	 */
	@Test
	public void getHistoryVariables() {

		HistoryService historyService = this.processEngine.getHistoryService();

		/**
		 * 流程实例ID
		 */
		String processInstanceId = "7501";
		List<HistoricVariableInstance> list = historyService.createHistoricVariableInstanceQuery()
				.processInstanceId(processInstanceId)
				.list();

		for (HistoricVariableInstance historicVariableInstance : list) {
			System.out.println("ID：" + historicVariableInstance.getId());
			System.out.println("变量值：" + historicVariableInstance.getValue());
			System.out.println("变量名:" + historicVariableInstance.getVariableName());
			System.out.println("变量类型：" + historicVariableInstance.getVariableTypeName());
			System.out.println("流程实例ID：" + historicVariableInstance.getProcessInstanceId());
			System.out.println("#####################");
		}
	}

}
