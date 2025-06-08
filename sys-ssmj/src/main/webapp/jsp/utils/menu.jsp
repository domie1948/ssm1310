<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "学生信息",
			"menuJump": "列表",
			"tableName": "xueshengxinxi"
		}],
		"menu": "学生管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "老师信息",
			"menuJump": "列表",
			"tableName": "laoshixinxi"
		}],
		"menu": "老师管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "课程信息",
			"menuJump": "列表",
			"tableName": "kecheng"
		}],
		"menu": "课程管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "仪器信息",
			"menuJump": "列表",
			"tableName": "yiqi"
		}],
		"menu": "仪器管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "专业信息",
			"menuJump": "列表",
			"tableName": "zhuanye"
		}],
		"menu": "专业管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "公告信息",
			"menuJump": "列表",
			"tableName": "xitonggonggao"
		}],
		"menu": "公告管理"
	}],
	"frontMenu": [],
	"roleName": "管理员",
	"tableName": "users"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["新增"],
			"menu": "学生信息",
			"menuJump": "列表",
			"tableName": "xueshengxinxi"
		}],
		"menu": "学生管理"
	}, {
		"child": [{
			"buttons": ["修改"],
			"menu": "老师信息",
			"menuJump": "列表",
			"tableName": "laoshixinxi"
		}],
		"menu": "老师管理"
	}, {
		"child": [{
			"buttons": ["修改"],
			"menu": "课程信息",
			"menuJump": "列表",
			"tableName": "kecheng"
		}],
		"menu": "课程管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改"],
			"menu": "仪器信息",
			"menuJump": "列表",
			"tableName": "yiqi"
		}],
		"menu": "仪器管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "专业信息",
			"menuJump": "列表",
			"tableName": "zhuanye"
		}],
		"menu": "专业管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "公告信息",
			"menuJump": "列表",
			"tableName": "xitonggonggao"
		}],
		"menu": "公告管理"
	}],
	"frontMenu": [],
	"roleName": "老师",
	"tableName": "laoshixinxi"
}, {
	"backMenu": [{
		"child": [{
			"buttons": ["修改"],
			"menu": "学生信息",
			"menuJump": "列表",
			"tableName": "xueshengxinxi"
		}],
		"menu": "学生管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "课程信息",
			"menuJump": "列表",
			"tableName": "kecheng"
		}],
		"menu": "课程管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "仪器信息",
			"menuJump": "列表",
			"tableName": "yiqi"
		}],
		"menu": "仪器管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "专业信息",
			"menuJump": "列表",
			"tableName": "zhuanye"
		}],
		"menu": "专业管理"
	}, {
		"child": [{
			"buttons": ["新增"],
			"menu": "留言信息",
			"menuJump": "列表",
			"tableName": "liuyanxinxi"
		}],
		"menu": "留言管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "公告信息",
			"menuJump": "列表",
			"tableName": "xitonggonggao"
		}],
		"menu": "公告管理"
	}],
	"frontMenu": [],
	"roleName": "学生",
	"tableName": "xueshengxinxi"
}];
var hasMessage = '';
