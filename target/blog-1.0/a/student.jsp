<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setAttribute("path", request.getContextPath()); %>
<% request.setAttribute("easyui", request.getContextPath()+"/res/plugin/jquery-easyui-1.6.3"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>学生信息管理</title>
	<link rel="stylesheet" type="text/css" href="/res/plugin/jquery-easyui-1.6.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/res/plugin/jquery-easyui-1.6.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/res/plugin/jquery-easyui-1.6.3/demo/demo.css">
	<script type="text/javascript" src="/res/plugin/jquery-easyui-1.6.3/jquery.min.js"></script>
	<script type="text/javascript" src="/res/plugin/jquery-easyui-1.6.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/res/plugin/jquery-easyui-1.6.3/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="/res/plugin/amazeui/css/amazeui.min.css">
	<script type="text/javascript" src="/res/plugin/amazeui/js/amazeui.min.js"></script>
	<script type="text/javascript" src="/js/date.format.js"></script>
</head>
<body>

	<table id="dg" title="学生信息管理" style="width:100%;height:650px" >
		<thead>
			<tr>
                    <th data-options="field:'id'">id</th>
                    <th data-options="field:'code'">code</th>
                    <th data-options="field:'name'">name</th>
                    <th data-options="field:'sex'">sex</th>
                    <th data-options="field:'birthday',formatter:dateFormatter">birthday</th>
                    <th data-options="field:'jiguan'">jiguan</th>
                    <th data-options="field:'photo'">photo</th>
                    <th data-options="field:'ruxueDate',formatter:dateFormatter">ruxueDate</th>
                    <th data-options="field:'xueli'">xueli</th>
                    <th data-options="field:'xueliDate',formatter:dateFormatter">xueliDate</th>
                    <th data-options="field:'idcCode'">idcCode</th>
                    <th data-options="field:'idcAddr'">idcAddr</th>
                    <th data-options="field:'idcPicture1'">idcPicture1</th>
                    <th data-options="field:'idcPicture2'">idcPicture2</th>
                    <th data-options="field:'idcPicture3'">idcPicture3</th>
                    <th data-options="field:'idcAffirm'">idcAffirm</th>
                    <th data-options="field:'curAddr'">curAddr</th>
                    <th data-options="field:'phone'">phone</th>
                    <th data-options="field:'qq'">qq</th>
                    <th data-options="field:'weixin'">weixin</th>
                    <th data-options="field:'email'">email</th>
                    <th data-options="field:'jiazhangName'">jiazhangName</th>
                    <th data-options="field:'jiazhangPhone'">jiazhangPhone</th>
                    <th data-options="field:'zhaoshengName'">zhaoshengName</th>
                    <th data-options="field:'zhaoshengPhone'">zhaoshengPhone</th>
                    <th data-options="field:'remark'">remark</th>
                    <th data-options="field:'createTime',formatter:dateFormatter">创建时间</th>
                    <th data-options="field:'updateTime',formatter:dateFormatter">修改时间</th>
				
				
			</tr>
		</thead>
	</table>
	<div id="dd-add">
<form>
<table class="am-table am-table-bordered">
    <tbody>
        <tr>
            <td>code</td>
            <td><input name="code" type="text" class="am-form-field am-radius" placeholder="请填写code" /></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input name="name" type="text" class="am-form-field am-radius" placeholder="请填写name" /></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><input name="sex" type="text" class="am-form-field am-radius" placeholder="请填写sex" /></td>
        </tr>
        <tr>
            <td>birthday</td>
            <td><input name="birthday" type="text" class="easyui-datebox" placeholder="请填写birthday" /></td>
        </tr>
        <tr>
            <td>jiguan</td>
            <td><input name="jiguan" type="text" class="am-form-field am-radius" placeholder="请填写jiguan" /></td>
        </tr>
        <tr>
            <td>photo</td>
            <td><input name="photo" type="text" class="am-form-field am-radius" placeholder="请填写photo" /></td>
        </tr>
        <tr>
            <td>ruxueDate</td>
            <td><input name="ruxueDate" class="easyui-datebox" placeholder="请填写ruxueDate" /></td>
        </tr>
        <tr>
            <td>xueli</td>
            <td><input name="xueli" type="text" class="am-form-field am-radius" placeholder="请填写xueli" /></td>
        </tr>
        <tr>
            <td>xueliDate</td>
            <td><input name="xueliDate" type="text" class="easyui-datebox" placeholder="请填写xueliDate" /></td>
        </tr>
        <tr>
            <td>idcCode</td>
            <td><input name="idcCode" type="text" class="am-form-field am-radius" placeholder="请填写idcCode" /></td>
        </tr>
        <tr>
            <td>idcAddr</td>
            <td><input name="idcAddr" type="text" class="am-form-field am-radius" placeholder="请填写idcAddr" /></td>
        </tr>
        <tr>
            <td>idcPicture1</td>
            <td><input name="idcPicture1" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture1" /></td>
        </tr>
        <tr>
            <td>idcPicture2</td>
            <td><input name="idcPicture2" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture2" /></td>
        </tr>
        <tr>
            <td>idcPicture3</td>
            <td><input name="idcPicture3" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture3" /></td>
        </tr>
        <tr>
            <td>idcAffirm</td>
            <td><input name="idcAffirm" type="text" class="am-form-field am-radius" placeholder="请填写idcAffirm" /></td>
        </tr>
        <tr>
            <td>curAddr</td>
            <td><input name="curAddr" type="text" class="am-form-field am-radius" placeholder="请填写curAddr" /></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input name="phone" type="text" class="am-form-field am-radius" placeholder="请填写phone" /></td>
        </tr>
        <tr>
            <td>qq</td>
            <td><input name="qq" type="text" class="am-form-field am-radius" placeholder="请填写qq" /></td>
        </tr>
        <tr>
            <td>weixin</td>
            <td><input name="weixin" type="text" class="am-form-field am-radius" placeholder="请填写weixin" /></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input name="email" type="text" class="am-form-field am-radius" placeholder="请填写email" /></td>
        </tr>
        <tr>
            <td>jiazhangName</td>
            <td><input name="jiazhangName" type="text" class="am-form-field am-radius" placeholder="请填写jiazhangName" /></td>
        </tr>
        <tr>
            <td>jiazhangPhone</td>
            <td><input name="jiazhangPhone" type="text" class="am-form-field am-radius" placeholder="请填写jiazhangPhone" /></td>
        </tr>
        <tr>
            <td>zhaoshengName</td>
            <td><input name="zhaoshengName" type="text" class="am-form-field am-radius" placeholder="请填写zhaoshengName" /></td>
        </tr>
        <tr>
            <td>zhaoshengPhone</td>
            <td><input name="zhaoshengPhone" type="text" class="am-form-field am-radius" placeholder="请填写zhaoshengPhone" /></td>
        </tr>
        <tr>
            <td>remark</td>
            <td><input name="remark" type="text" class="am-form-field am-radius" placeholder="请填写remark" /></td>
        </tr>
        
        
   
    </tbody>
</table>
</form>
	</div>
	<div id="dd-edit">
		<form>
<table class="am-table am-table-bordered ">
    <tbody>
	        <tr>
	            <td>id</td>
	            <td><input name="id" type="text" readonly="readonly" class="am-form-field am-radius" placeholder="请填写id" /></td>
	        </tr>
	        <tr>
	            <td>code</td>
	            <td><input name="code" type="text" class="am-form-field am-radius" placeholder="请填写code" /></td>
	        </tr>
	        <tr>
	            <td>name</td>
	            <td><input name="name" type="text" class="am-form-field am-radius" placeholder="请填写name" /></td>
	        </tr>
	        <tr>
	            <td>sex</td>
	            <td><input name="sex" type="text" class="am-form-field am-radius" placeholder="请填写sex" /></td>
	        </tr>
	        <tr>
	            <td>birthday</td>
	            <td><input name="birthday" type="text" class="easyui-datebox" placeholder="请填写birthday" /></td>
	        </tr>
	        <tr>
	            <td>jiguan</td>
	            <td><input name="jiguan" type="text" class="am-form-field am-radius" placeholder="请填写jiguan" /></td>
	        </tr>
	        <tr>
	            <td>photo</td>
	            <td><input name="photo" type="text" class="am-form-field am-radius" placeholder="请填写photo" /></td>
	        </tr>
	        <tr>
	            <td>ruxueDate</td>
	            <td><input name="ruxueDate" type="text" class="easyui-datebox" placeholder="请填写ruxueDate" /></td>
	        </tr>
	        <tr>
	            <td>xueli</td>
	            <td><input name="xueli" type="text" class="am-form-field am-radius" placeholder="请填写xueli" /></td>
	        </tr>
	        <tr>
	            <td>xueliDate</td>
	            <td><input name="xueliDate" type="text" class="easyui-datebox" placeholder="请填写xueliDate" /></td>
	        </tr>
	        <tr>
	            <td>idcCode</td>
	            <td><input name="idcCode" type="text" class="am-form-field am-radius" placeholder="请填写idcCode" /></td>
	        </tr>
	        <tr>
	            <td>idcAddr</td>
	            <td><input name="idcAddr" type="text" class="am-form-field am-radius" placeholder="请填写idcAddr" /></td>
	        </tr>
	        <tr>
	            <td>idcPicture1</td>
	            <td><input name="idcPicture1" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture1" /></td>
	        </tr>
	        <tr>
	            <td>idcPicture2</td>
	            <td><input name="idcPicture2" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture2" /></td>
	        </tr>
	        <tr>
	            <td>idcPicture3</td>
	            <td><input name="idcPicture3" type="text" class="am-form-field am-radius" placeholder="请填写idcPicture3" /></td>
	        </tr>
	        <tr>
	            <td>idcAffirm</td>
	            <td><input name="idcAffirm" type="text" class="am-form-field am-radius" placeholder="请填写idcAffirm" /></td>
	        </tr>
	        <tr>
	            <td>curAddr</td>
	            <td><input name="curAddr" type="text" class="am-form-field am-radius" placeholder="请填写curAddr" /></td>
	        </tr>
	        <tr>
	            <td>phone</td>
	            <td><input name="phone" type="text" class="am-form-field am-radius" placeholder="请填写phone" /></td>
	        </tr>
	        <tr>
	            <td>qq</td>
	            <td><input name="qq" type="text" class="am-form-field am-radius" placeholder="请填写qq" /></td>
	        </tr>
	        <tr>
	            <td>weixin</td>
	            <td><input name="weixin" type="text" class="am-form-field am-radius" placeholder="请填写weixin" /></td>
	        </tr>
	        <tr>
	            <td>email</td>
	            <td><input name="email" type="text" class="am-form-field am-radius" placeholder="请填写email" /></td>
	        </tr>
	        <tr>
	            <td>jiazhangName</td>
	            <td><input name="jiazhangName" type="text" class="am-form-field am-radius" placeholder="请填写jiazhangName" /></td>
	        </tr>
	        <tr>
	            <td>jiazhangPhone</td>
	            <td><input name="jiazhangPhone" type="text" class="am-form-field am-radius" placeholder="请填写jiazhangPhone" /></td>
	        </tr>
	        <tr>
	            <td>zhaoshengName</td>
	            <td><input name="zhaoshengName" type="text" class="am-form-field am-radius" placeholder="请填写zhaoshengName" /></td>
	        </tr>
	        <tr>
	            <td>zhaoshengPhone</td>
	            <td><input name="zhaoshengPhone" type="text" class="am-form-field am-radius" placeholder="请填写zhaoshengPhone" /></td>
	        </tr>
	        <tr>
	            <td>remark</td>
	            <td><input name="remark" type="text" class="am-form-field am-radius" placeholder="请填写remark" /></td>
	        </tr>
        
    </tbody>
</table>
		</form>
	</div>
	<script type="text/javascript">
	function dateFormatter(value,row,index){
		if(!value)return '';
		var a = new Date(value);
		return a.format('yyyy-MM-dd hh:mm');
	}
		$(function(){ //文档就绪事件
			var crud={
				save:'${path}/student/save',
				update:'${path}/student/update',
				del:'${path}/student/delete',
				list:'${path}/student/list'
			}
			var ddAdd=$('#dd-add').dialog({    
			    title: '添加用户信息',    
			    width: 600,    
			    height: 400,    
			    closed: true,    
			    cache: false,    
			    modal: true,
			    buttons:[{
					text:'保存',
					handler:function(){
						var param=$('#dd-add form').serialize();
						$.post(crud.save,param,function(result){
							if(result=='OK'){
								$.messager.show({
									title:'系统提示',
									msg:'添加成功.',
									timeout:3000,
									showType:'slide'
								});
								ddAdd.dialog('close');
								$('#dg').datagrid('reload');
							}
						});
					}
				},{
					text:'取消',
					handler:function(){ddAdd.dialog('close');}
				}]
			});
			var ddEdit=$('#dd-edit').dialog({    
			    title: '编辑信息',    
			    width: 600,    
			    height: 400,    
			    closed: true,    
			    cache: false,    
			    //href: 'get_content.php',
			    modal: true,
			    buttons:[{
					text:'确认修改',
					handler:function(){
						var param = $('#dd-edit form').serialize();
						$.post(crud.update,param,function(result){
							if(result=='OK'){
								$.messager.show({
									title:'系统提示',
									msg:'修改信息成功.',
									timeout:1500,
									showType:'slide'
								});
								ddEdit.dialog('close');
								$('#dg').datagrid('reload');
							}
						}); 
						
						
						
					}
				},{
					text:'取消',
					handler:function(){ddEdit.dialog('close');}
				}]
			});
			$('#dg').datagrid({
				rownumbers:true,
				singleSelect:true,
				pagination:true,
				url:crud.list,
				method:'get',
				toolbar: [{
					text:'添加',
					iconCls: 'icon-add',
					handler: function(){
						ddAdd.dialog('open');
					}
				},'-',{
					text:'编辑',
					iconCls: 'icon-edit',
					handler: function(){
						var row=$('#dg').datagrid('getSelected');
						if(!row){
							$.messager.alert('提示消息','请选择要编辑的数据！','info');
							return;
						}
						ddEdit.dialog('open');
						console.log(row);
						row.birthday=new Date(row.birthday).format('yyyy-MM-dd');
						row.ruxueDate=new Date(row.ruxueDate).format('yyyy-MM-dd');
						row.xueliDate=new Date(row.xueliDate).format('yyyy-MM-dd');
						$("#dd-edit form").form('load',row);
						
					}
				},'-',{
					text:'删除',
					iconCls: 'icon-cancel',
					handler: function(){
						var row=$('#dg').datagrid('getSelected');
						if(!row){
							$.messager.alert('提示消息','请选择要删除的数据！','info');
							return;
						}
						$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
						    if (r){    
						        $.post(crud.del,{id:row.id},function(data){
						        	if(data.code==200){
						        		$.messager.show({
											title:'系统提示',
											msg:'成功删除数据!',
											timeout:1500,
											showType:'slide'
										});
						        		$('#dg').datagrid('reload');
						        	}else{
						        		if(data.msg.indexOf('EmptyResultDataAccessException')!=-1){
						        			alert('该数据不存在');
						        		}
						        	}
						        });
						    }    
						}); 
					}
				}]

			});
			
			var pager = $('#dg').datagrid().datagrid('getPager');	//获取分页栏对象
			pager.pagination({
				//beforePageText:'第',
				//afterPageText:'页，共 {pages}页',
				//displayMsg:'从 {from} 到 {to} ，总记录数： {total} ',
			});
		})
	</script>
</body>
</html>