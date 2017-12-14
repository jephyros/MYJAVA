<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"   
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
<%   String contextRoot = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" media="screen"
        href="<%=contextRoot%>/jquery/ui/themes/base/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" media="screen"
        href="<%=contextRoot%>/jquery/grid/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen"
        href="<%=contextRoot%>/jquery/grid/plugins/ui.multiselect.css" />

<script type="text/javascript"           
         src="<%=contextRoot%>/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript"           
         src="<%=contextRoot%>/jquery/grid/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript"           
          src="<%=contextRoot%>/jquery/grid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript"           
          src="<%=contextRoot%>/jquery/grid/src/grid.common.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/grid/src/grid.formedit.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/grid/src/jqModal.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/grid/src/jqDnR.js"></script>

<!-- UI -->
<script type="text/javascript"         
            src="<%=contextRoot%>/jquery/ui/jquery.ui.core.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/ui/jquery.ui.widget.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/ui/jquery.ui.menu.js"></script>
<script type="text/javascript"           
           src="<%=contextRoot%>/jquery/ui/jquery.ui.position.js"></script>
<!-- Layout -->
<script type="text/javascript"           
         src="<%=contextRoot%>/jquery/jquery.layout-latest.js"></script>


<script type="text/javascript">
jQuery(document).ready(function(){

                jQuery("#gridlist").jqGrid({
               url:'userList',
               datatype: 'json',
               mtype:'POST',
               colNames:["순번",'아이디','유저명','비고','수정자','등록일','enabled'],
               colModel:[
                         {name:'rnum',  index:'rnum',  width:50,   editrules:{  edithidden:true } ,
                          editable:false },
                         {name:'user_id',    index:'user_id',    width:100,  editrules:{  required:true,
                          edithidden:true },
                          editable:true,
                          editoptions:{size:"50",maxlength:"50",
                                          dataEvents:[ {
                                                    type: 'blur',
                                                     fn: function(e) {
                                                      var newCodeValue = $(e.target).val();
                                                     }
                                          }]
                           }
                         },
                         {name:'user_name', index:'user_name',  width:100,
                          editrules:{  required:true,edithidden:true },editable:true,
                          editoptions:{size:"50",maxlength:"50"}},
                         {name:'remark', index:'remark',  width:100,
                          editrules:{  required:true,edithidden:true },editable:true,
                          editoptions:{size:"50",maxlength:"50"}},
                         {name:'lst_modify_id',    index:'lst_modify_id',     width:200,
                          editrules:{  required:true,edithidden:true },editable:true,
                          editoptions:{size:"50",maxlength:"50"}},
                          {name:'lst_modify_dt',    index:'lst_modify_dt',     width:200,
                              editrules:{  required:true,edithidden:true },editable:true,
                              editoptions:{size:"50",maxlength:"50"}},
                         
                  },
                 editrules:{required:true}
                         },
                         {name:'regUser',  index:'regUser', width:150,
                          editrules:{  required:true,edithidden:true },editable:true,
                          editoptions:{size:"50",maxlength:"50"}},
                         {name:'enabled',  index:'enabled', width:50, 
                          edittype:"select",
                          formatter:'select',
                          editoptions:{value:"0:Disable;1:Enable",defaultValue:"Enable"},
                          editrules:{ required:true,edithidden:true },
                          editable:true,
                          cellattr: function (rowId, val, rawObject, cm, rdata) {
                           if (val == 'Disable'){
                                  return 'style="background-color:#FF0000"';
                           } else {
                              return 'style="background-color:#33FFFF"';
                           };
                           
                          }
                         }
               ],
               pager: jQuery('#gridpager'),
               pagination:true,
               rowNum:10,
               rowList:[10,20,30],
               sortname: 'id',
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
test2      <table id="gridlist"></table>
       <div id="gridpager"></div>
</body>
</html>