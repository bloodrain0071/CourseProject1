<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 3/7/17
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>

    <script type="text/javascript" src="js/jquery/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/combo.js"></script>

    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css" />


    <script type="text/javascript">

    history.pushState(null, null, 'index.jsp');
    window.addEventListener('popstate', function(event) {
        history.pushState(null, null, 'index.jsp');
    });

        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });

            $('.ui-layout-center').css('background-color','aqua');
            $('.ui-layout-north').css('background-color','aqua');
            $('.ui-layout-south').css('background-color','aqua');
            $('.ui-layout-east').css('background-color','aqua');
            $('.ui-layout-west').css('background-color','aqua');




            $('#studentBtnId').click(function() {
                $('#studentDataId').show();
                $('#teacherDataId').hide();
                $('#lessonDataId').hide();
                $('#registerStudentDataId').hide();
                getStudentList();
                $('#newId').prop('value','New Student');
            });

            $('#teacherBtnId').click(function() {
                $('#studentDataId').hide();
                $('#teacherDataId').show();
                $('#lessonDataId').hide();
                $('#registerStudentDataId').hide();
                getTeacherList();
                $('#newId').prop('value','New Teacher');
            });

            $('#lessonBtnId').click(function() {
                $('#studentDataId').hide();
                $('#teacherDataId').hide();
                $('#lessonDataId').show();
                $('#newId').prop('value','New Lesson');
                $('#registerStudentDataId').hide();
            });

            $('#registerStudentBtnId').click(function() {
                $('#studentDataId').hide();
                $('#teacherDataId').hide();
                $('#lessonDataId').hide();
                $('#registerStudentDataId').show();
                $('#newId').prop('value','Register Student');
            });


            $('#newStudentDialogId').dialog({
                  title: 'New Student',
                  autoOpen: false,
                  resizable: false,
                  modal: true,
                  height: 400,
                  width: 400,
                  buttons: {
                      "Save": function() {
                          addStudent();
                          $(this).dialog('close');
                      },
                      "Close": function() {
                          $(this).dialog('close');

                      }
                  }


            });


            $('#editStudentDialogId').dialog({
                title: 'Update Student',
                autoOpen: false,
                resizable: false,
                modal: true,
                height: 400,
                width: 400,
                buttons: {
                    "Update": function() {
                        updateStudent();
                        $(this).dialog('close');
                    },
                    "Close": function() {
                        $(this).dialog('close');

                    }
                }


            });


            $('#newTeacherDialogId').dialog({
                title: 'New Teacher',
                autoOpen: false,
                resizable: false,
                modal: true,
                height: 400,
                width: 400,
                buttons: {
                    "Save": function() {
                    //    addStudent();
                        $(this).dialog('close');
                    },
                    "Close": function() {
                        $(this).dialog('close');

                    }
                }


            });

            $('#newLessonDialogId').dialog({
                title: 'New Lesson',
                autoOpen: false,
                resizable: false,
                modal: true,
                height: 400,
                width: 400,
                buttons: {
                    "Save": function() {
                      //  addStudent();
                        $(this).dialog('close');
                    },
                    "Close": function() {
                        $(this).dialog('close');

                    }
                }


            });

            $('#registerStudentDialogId').dialog({
                title: 'Register Student',
                autoOpen: false,
                resizable: false,
                modal: true,
                height: 400,
                width: 400,
                buttons: {
                    "Register": function() {
                       // addStudent();
                        $(this).dialog('close');
                    },
                    "Close": function() {
                        $(this).dialog('close');

                    }
                }


            });



            $('.btnDesign').click(function() {
                var btnId =  $(this).attr('id');
                globBtnId = btnId;
            });




            $('#newId').click(function() {


                switch (globBtnId) {

                    case 'studentBtnId':
                        $('#newStudentDialogId').load('views/newStudent.jsp',function() {
                            $('#newStudentDialogId').dialog('open');
                        });
                        break;
                    case 'teacherBtnId':
                        $('#newTeacherDialogId').load('views/newTeacher.jsp',function() {
                            $('#newTeacherDialogId').dialog('open');
                        });
                        break;
                    case 'lessonBtnId':
                        $('#newLessonDialogId').load('views/newLesson.jsp',function() {
                            $('#newLessonDialogId').dialog('open');
                        });
                        break;
                    case 'registerStudentBtnId':
                        $('#registerStudentDialogId').load('views/registerStudent.jsp',function() {
                            $('#registerStudentDialogId').dialog('open');
                        });
                        break;
                    default:
                         alert('Please, first select menu!');
                        break;

                }

            });

            $('#searchId').click(function() {
                var keyword = $('#keywordId').val();
                switch (globBtnId) {

                    case 'studentBtnId':
                       searchStudentData(keyword);
                        break;
                    case 'teacherBtnId':

                        break;
                    case 'lessonBtnId':

                        break;
                    default:
                        alert('Please, first select menu!');
                        break;

                }

            });

            $('#keywordId').keyup(function() {
                var keyword = $('#keywordId').val();
                switch (globBtnId) {

                    case 'studentBtnId':
                        searchStudentData(keyword);
                        break;
                    case 'teacherBtnId':

                        break;
                    case 'lessonBtnId':

                        break;
                    default:
                        alert('Please, first select menu!');
                        break;

                }
            });




        });
    </script>

</head>
<body>
<div class="ui-layout-center">



    <div id="studentDataId" style="display: none">

    </div>


    <div id="teacherDataId" style="display: none">

    </div>

    <div id="lessonDataId" style="display: none">
        <table id="lessonTableId" border="1px solid" style="width: 100%">
            <thead>
            <tr>
                <th>No</th>
                <th>Dersin adi</th>
                <th>Kecirilme saati</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Java</td>
                <td>96</td>

            </tr>
            <tr>
                <td>2</td>
                <td>C#</td>
                <td>96</td>

            </tr>
            <tr>
                <td>3</td>
                <td>Web</td>
                <td>96</td>

            </tr>
            <tr>
                <td>4</td>
                <td>Oracle</td>
                <td>64</td>

            </tr>

            </tbody>

        </table>

    </div>
    <div id="registerStudentDataId" style="display: none" />

    <table id="registerStudentTableId" border="1px solid" style="width: 100%">
        <thead>
        <tr>
            <th>No</th>
            <th>Telebenin ad soyadi</th>
            <th>Icazesi</th>
            <th>Qeydiyyatdan kecme tarixi</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Togrul Alizade</td>
            <td>admin</td>
            <td>2017-04-04</td>

        </tr>

        </tbody>

    </table>

    </div>


  <div id="newStudentDialogId"></div>
  <div id="newTeacherDialogId"> </div>
  <div id="newLessonDialogId"></div>
  <div id="editStudentDialogId"></div>
  <div id="registerStudentDialogId"></div>

</div>
<div class="ui-layout-north">
    <h1 style="text-align: center">Course</h1>
    <span style="float: right;margin-top: -45px;margin-right: 70px;">Welcome, ${login.name} ${login.surname}</span>
    <a href="logout.jsp"><img src="images/logout.png" style="width: 50px;float: right;margin-top: -59px;"></a>
</div>

<div class="ui-layout-east">

    <c:choose>
        <c:when test="${login.role eq 'admin'}">
            <input type="button" value="New" id="newId" class="btnDesign1" /> <br>
            <input type="text" id="keywordId" placeholder="Search..." style="height: 30px;width: 125px;">
            <input type="button" value="Axtar" id="searchId" style="height: 30px;">
        </c:when>
        <c:when test="${login.role eq 'student'}">
         <%--   <input type="button" value="New" id="newId" class="btnDesign1" /> <br>--%>
            <input type="text" id="keywordId" placeholder="Search..." style="height: 30px;width: 125px;">
            <input type="button" value="Axtar" id="searchId" style="height: 30px;">
        </c:when>

    </c:choose>


</div>
<div class="ui-layout-west">


    <c:choose>
        <c:when test="${login.role eq 'admin'}">
            <input type="button" value="Student" id="studentBtnId" class="btnDesign"  />  <br>
            <input type="button" value="Teacher" id="teacherBtnId" class="btnDesign" />   <br>
            <input type="button" value="Lesson" id="lessonBtnId" class="btnDesign" />   <br>
            <input type="button" value="Register Student Data" id="registerStudentBtnId" class="btnDesign" />
        </c:when>
        <c:when test="${login.role eq 'student'}">
           <%-- <input type="button" value="Student" id="studentBtnId" class="btnDesign"  />  <br>
            <input type="button" value="Teacher" id="teacherBtnId" class="btnDesign" />   <br>--%>
            <input type="button" value="Lesson" id="lessonBtnId" class="btnDesign" />   <br>
        </c:when>

    </c:choose>


  <%--  <input type="button" value="Register" id="registerBtnId" class="btnDesign" />   <br>--%>


</div>
<div class="ui-layout-south">
   <div style="text-align: center">Copyright © Fuad Pashabeyli</div>
</div>

</body>
</html>