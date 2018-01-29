/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/4/17
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */


//var a = 5;
var name = 'Fuad';
var globBtnId = '';
var globStudId = 0;

function test(a,b) {
    var result = 0;



    if (a > b) {
        result = a * b;
    } else {
       result = a + b;
    }

    console.log('Result = '+result);
}


function getStudentList() {
     $.ajax({
       type: 'GET',
       url: 'cs?action=getStudentList',
       dataType:'html',
       success: function(data) {
          $('#studentDataId').html(data);
       },
        error: function() {
               alert('Error');
        }

    });
}

function getTeacherList() {
    $.ajax({
        type: 'GET',
        url: 'cs?action=getTeacherList',
        dataType:'html',
        success: function(data) {
            $('#teacherDataId').html(data);
        }

    });
}

function addStudent() {

    var name = $('#nameId').val();
    var surname = $('#surnameId').val();
    var dob = $('#dobId').val();
    var address = $('#addressId').val();
    var teacherCombo = $('#teacherComboId').val();


    $.ajax({
       url: 'cs?action=addStudent',
       type: 'POST',
       data: 'name='+name+'&surname='+surname+'&dob='+dob+'&address='+address+
           '&teacherCombo='+teacherCombo,
        success: function() {
             alert('Student has suuccessfully added!');
            getStudentList();
        }
    });



}


function deleteStudent(studentId,fullName) {

   var isDeleted = confirm('Siz '+fullName+' ni silmeye eminsinizmi?');

    if (isDeleted) {
        $.ajax({
            type: 'POST',
            url: 'cs?action=deleteStudent',
            data: 'studentId='+studentId,
            success: function() {
                alert('Student has successfully deleted !!!');
                getStudentList();
            }

        });
    }    else {

    }



}


function editStudent(studentId) {

    globStudId = studentId;

    $.ajax({
        url: 'cs?action=getStudentById',
        type: 'GET',
        dataType: 'html',
        data: 'studentId='+studentId,
        success:function(data) {
             $('#editStudentDialogId').html(data);
            $('#editStudentDialogId').dialog('open');

        }

    })



}

function updateStudent() {

    var name = $('#nameId1').val();
    var surname = $('#surnameId1').val();
    var dob = $('#dobId1').val();
    var address = $('#addressId1').val();
    var teacherCombo = $('#teacherComboId1').val();


    $.ajax({
        url: 'cs?action=updateStudent',
        type: 'POST',
        data: 'name='+name+'&surname='+surname+'&dob='+dob+'&address='+address+
            '&teacherCombo='+teacherCombo+'&studentId='+globStudId,
        success: function() {
            alert('Student has suuccessfully updated!');
            getStudentList();
        }
    });

}


function searchStudentData(keyword) {
    $.ajax({
        type: 'GET',
        url: 'cs?action=searchStudentData',
        data: 'keyword='+keyword,
        dataType:'html',
        success: function(data) {
            $('#studentDataId').html(data);
        }

    });
}


function advancedSearchStudent() {
    var lessonCombo = $('#advLessonComboId').val();
    var teacherCombo = $('#advTeacherComboId').val();
    var beginDate = $('#beginDate').val();
    var endDate = $('#endDate').val();


    $.ajax({
        type: 'GET',
        url: 'cs?action=advancedSearchStudent',
        data: 'lessonCombo='+lessonCombo+'&teacherCombo='+teacherCombo+
            '&beginDate='+beginDate+'&endDate='+endDate,
        dataType: 'html',
        success: function(data) {
            $('#studentDataId1').html(data);
        }
    })

}