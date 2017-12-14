
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQ그리드테스트</title>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/jquery.jqGrid-4.4.3/css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/jquery.jqGrid-4.4.3/css/ui.jqgrid.css" />
<script src="${pageContext.request.contextPath}/resources/jquery.jqGrid-4.4.3/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/jquery.jqGrid-4.4.3/js/i18n/grid.locale-kr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script type="text/javascript" charset="UTF-8">
jQuery(document).ready(function(){
	jQuery("#gridlist").jqGrid({
        url:'userList',
        datatype: 'json',
        mtype:'POST',       
        colNames:["순번",'아이디','유저명','비고','수정자','등록일'],
        colModel:[
        	{name:'rnum',index:'rnum', width:4, align:"center"},
       		{name:'user_id',index:'user_id', width:5, align:"left"},
       		{name:'user_name',index:'user_name', width:5, align:"left"},
       		{name:'remark',index:'remark', width:5, align:"left"},
       		{name:'lst_modify_id',index:'lst_modify_id', width:5, align:"left"},		
       		{name:'lst_modify_dt',index:'lst_modify_dt', width:5,align:"left"},		
       		
       		
                  
        ],
        pager: jQuery('#gridpager'),
        pagination:true,
        rowNum:10,
        rowList:[10,20,30],
        sortname: 'user_id',
        viewrecords: true,
        sortorder: "desc",
        caption: "유저리스트",
        autowidth : true,
        height :'auto',
       
        jsonReader: {
            repeatitems:false
        },
        ondblClickRow: function(id){
         alert("You double click row with id: "+id);
         // id value is grgrid key set value
         // column property "key : true" default  "key : false";
        },
        onSelectRow: function(id) {
         
        },
        loadComplete : function(xhr) {
        },
        gridComplete: function() {
        },
     loadError: function(xhr,st,err) {
      alert(err);
     },
     editurl:"userEdit"
  }).navGrid('#gridpager', {edit:true,add:true,del:true,search:true});
 
 
  jQuery("#gridlist") .jqGrid({
            pager : '#gridpager',
            recordtext: "View {0} - {1} of {2}",
         emptyrecords: "No records to view",
      loadtext: "Loading...",
      pgtext : "Page {0} of {1}"
  });   
 
  $.extend($.jgrid.edit, {
          closeAfterAdd: true,
          recreateForm: true,
          reloadAfterSubmit: false,
          left : 100,
          top : 100,
          dataheight: '100%',
          width: 500 ,
          addCaption: "유저 추가",
    editCaption: "유저 편집",
    bSubmit: "저장-전송",
    bCancel: "취소",
    bClose: "닫기",
    saveData: "Data has been changed! Save changes?",
    bYes : "Yes",
    bNo : "No",
    bExit : "Cancel"
   });
});
  
	</script>

</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/leaf.jpg">
<table id="gridlist"></table>
<div id="gridpager"></div>

</body>
</html>