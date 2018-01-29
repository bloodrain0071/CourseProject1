/**
 * Created with IntelliJ IDEA.
 * User: fuadp
 * Date: 3/26/17
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */


function getTeacherCombo() {

    $.ajax({
        type: 'GET',
        url: 'cs?action=getTeacherCombo',
        dataType: 'html',
        success: function(data) {
            $('#teacherComboId').html(data);
        }
    });

}

function editTeacherCombo(teacherId) {

    $.ajax({
        type: 'GET',
        url: 'cs?action=getTeacherCombo',
        dataType: 'html',
        success: function(data) {
            $('#teacherComboId1').html(data);
            $('#teacherComboId1').val(teacherId);
        }

    });

}


function getTeacherComboAdv() {

    $.ajax({
        type: 'GET',
        url: 'cs?action=getTeacherCombo',
        dataType: 'html',
        success: function(data) {
            $('#advTeacherComboId').html(data);
        }
    });


}

function getLessonComboAdv() {

    $.ajax({
       type: 'GET',
        url: 'cs?action=getLessonCombo',
        dataType: 'html',
        success: function(data) {
             $('#advLessonComboId').html(data);
        }
    });

}


function getTeacherComboByLessonId(lessonId) {

    $.ajax({
         type: 'GET',
         url: 'cs?action=getTeacherComboByLessonId',
         dataType: 'html',
         data: 'lessonId='+lessonId,
         success: function(data) {
             $('#advTeacherComboId').html(data);
         }
    });


}



