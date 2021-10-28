let globBtnId = '';
let globBookId = 0;
let globUserId = 0;
let globAuthorId = 0;
let globLanguageId = 0;
let globTopicId = 0;
let globEmployeeId = 0;
let globBookInfoId = 0;
let globGiveId = 0;

$(function () {
    $('body').layout({applyDemoStyles: true});
    $(' .ui-layout-west, .ui-layout-east, .ui-layout-center ').css('background-color', '#CEB8A4'); //#CEB8A4
    $('.ui-layout-north, .ui-layout-south').css('background-color', '#636456');

    $('#userDataBtnId').click(function () {
        getUserList();
    });
    $('#authorDataBtnId').click(function () {
        getAuthorList();
    });
    $('#bookDataBtnId').click(function () {
        getBookList();
    });
    $('#bookInfoDataBtnId').click(function () {
        getBookInfoList();
    });
    $('#giveBookDataBtnId').click(function () {
        getGiveBookList();
    });
    $('#statisticsDataBtnId').click(function () {
        getStatisticsList();
    });
    $('#problemUserDataBtnId').click(function () {
        getProblemUserList();
    });
    $('#languageDataBtnId').click(function () {
        getLanguageList();
    });
    $('#topicDataBtnId').click(function () {
        getTopicList();
    });
    $('#employeeDataBtnId').click(function () {
        getEmployeeList();
    });
    $('#returnBookDataBtnId').click(function () {
        $('#returnBookDialogId').load('views/newReturnBook.jsp', function () {
            $(this).dialog('open');
        });
    });

    $('.btnDesign').click(function () {
        globBtnId = $(this).attr('id');
    });
    $('.btnDesignLittle').click(function () {
        globBtnId = $(this).attr('id');
    });

    $('#newBtnId').click(function () {
        switch (globBtnId) {
            case 'bookDataBtnId':
                $('#newBookDialogId').load("cs?action=newBook", function () {
                    $(this).dialog('open');
                });
                break;
            case 'userDataBtnId':
                $('#newUserDialogId').load("views/newUser.jsp", function () {
                    $(this).dialog('open');
                });
                break;
            case 'authorDataBtnId':
                $('#newAuthorDialogId').load("views/newAuthor.jsp", function () {
                    $(this).dialog('open');
                });
                break;
            case 'languageDataBtnId':
                $('#newLanguageDialogId').load("views/newLanguage.jsp", function () {
                    $(this).dialog('open');
                });
                break;
            case 'topicDataBtnId':
                $('#newTopicDialogId').load("views/newLanguage.jsp", function () {
                    $(this).dialog('open');
                });
                break;
            case 'employeeDataBtnId':
                $('#newEmployeeDialogId').load("cs?action=newEmployee", function () {
                    $(this).dialog('open');
                });
                break;
            case 'problemUserDataBtnId':
                $('#problemUserDialogId').load('views/newProblemUser.jsp', function () {
                    $(this).dialog('open');
                });
                break;
            case 'bookInfoDataBtnId':
                $('#newBookInfoDialogId').load('cs?action=newBookInfo', function () {
                    $(this).dialog('open');
                });
                break;
            case'giveBookDataBtnId':
                $('#newGiveBookDialogId').load('cs?action=newGiveBook', function () {
                    $(this).dialog('open');
                });
                break;
        }
    });
    $('#newGiveBookDialogId').dialog({
        title: 'New give book',
        height: 300,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addGiveBook();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editGiveBookDialogId').dialog({
        title: 'Edit give book',
        height: 300,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateGiveBook();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#newBookInfoDialogId').dialog({
        title: 'New book information',
        height: 250,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editBookInfoDialogId').dialog({
        title: 'Edit book information',
        height: 250,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newBookDialogId').dialog({
        title: 'New Book',
        height: 350,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addBook();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#newUserDialogId').dialog({
        title: 'New User',
        height: 300,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addUser();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#newAuthorDialogId').dialog({
        title: 'New Author',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addAuthor();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#newLanguageDialogId').dialog({
        title: 'New Language',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addLanguage();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#newTopicDialogId').dialog({
        title: 'New Topic',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addTopic();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#newEmployeeDialogId').dialog({
        title: 'New Employee',
        height: 250,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addEmployee();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#problemUserDialogId').dialog({
        title: 'New Problemic User',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                let isYes = confirm("Are you sure to add id:" + $('#problemUserId').val() + "?");
                if (isYes) {
                    addProblemUser();
                }
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });
    $('#returnBookDialogId').dialog({
        title: 'Return Book',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                addReturnBook();
                $(this).dialog('close');

            },
            "Close": function () {
                $(this).dialog('close');

            }
        }
    });

    $('#editUserDialogId').dialog({
        title: 'Edit User',
        height: 320,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateUser();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#editAuthorDialogId').dialog({
        title: 'Edit Author',
        height: 250,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateAuthor();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editBookDialogId').dialog({
        title: 'Edit Book',
        height: 400,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateBook();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editLanguageDialogId').dialog({
        title: 'Edit Language',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateLanguage();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editTopicDialogId').dialog({
        title: 'Edit Topic',
        height: 200,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateTopic();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });
    $('#editEmployeeDialogId').dialog({
        title: 'Edit Book',
        height: 250,
        width: 400,
        modal: true,
        autoOpen: false,
        buttons: {
            "Save": function () {
                updateEmployee();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });


});

function getUserList() {
    $.ajax({
        url: 'cs?action=getUserList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getAuthorList() {
    $.ajax({
        url: 'cs?action=getAuthorList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getBookList() {
    $.ajax({
        url: 'cs?action=getBookList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getBookInfoList() {
    $.ajax({
        url: 'cs?action=getBookInfoList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getGiveBookList() {
    $.ajax({
        url: 'cs?action=getGiveBookList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getStatisticsList() {
    $.ajax({
        url: 'cs?action=getStatisticsList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getProblemUserList() {
    $.ajax({
        url: 'cs?action=getProblemUserList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getLanguageList() {
    $.ajax({
        url: 'cs?action=getLanguageList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getTopicList() {
    $.ajax({
        url: 'cs?action=getTopicList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function getEmployeeList() {
    $.ajax({
        url: 'cs?action=getEmployeeList',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        },
        error: function (response) {
            alert("Error!");
        }
    });
}

function addBook() {
    let name = $('#bookNameId').val();
    let languageId = $('#bookLanguageCmbId').val();
    let page = $('#bookPageId').val();
    let price = $('#bookPriceId').val();
    let shelfId = $('#bookShelfCmbId').val();
    let dateOfPublication = $('#bookDateOfPublicationId').val();
    let numberOfBook = $('#bookNumberOfBookId').val();
    let data = {
        "name": name,
        "languageId": languageId,
        "shelfId": shelfId,
        "page": page,
        "price": price,
        "dateOfPublication": dateOfPublication,
        "numberOfBook": numberOfBook,
    }
    $.ajax({
        url: 'cs?action=addBook',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Book has been successfully added!');
                getBookList();
            } else {
                alert('Problem! Book has not been successfully added!');
            }
        }
    });
}

function addUser() {
    let name = $('#userNameId').val();
    let surname = $('#userSurnameId').val();
    let dob = $('#userDobId').val();
    let identityNumber = $('#identityNumberId').val();
    let mail = $('#userMailId').val();
    let phone = $('#userPhoneId').val();
    let data = {
        "name": name,
        "surname": surname,
        "dob": dob,
        "identityNumber": identityNumber,
        "mail": mail,
        "phone": phone
    }
    $.ajax({
        url: 'cs?action=addUser',
        method: "POST",
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('User has been successfully added!');
                getUserList();
            } else {
                alert('Problem! User has not been successfully added!');
            }
        }
    });
}

function addAuthor() {
    let name = $('#authorNameId').val();
    let surname = $('#authorSurnameId').val();
    let data = {
        "name": name,
        "surname": surname
    }
    $.ajax({
        url: 'cs?action=addAuthor',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Author has been successfully added!');
                getAuthorList();
            } else {
                alert('Problem! User has not been successfully added!');
            }
        }
    });
}

function addTopic() {
    let name = $('#topicNameId').val();
    $.ajax({
        url: 'cs?action=addTopic',
        type: 'POST',
        dataType: 'text',
        data: 'name=' + name,
        success: function (response) {
            if (response == 'success') {
                alert('Topic has been successfully added!');
                getTopicList();
            } else {
                alert('Problem! Topic has not been successfully added!');
            }
        }
    });
}

function addLanguage() {
    let name = $('#languageNameId').val();
    $.ajax({
        url: 'cs?action=addLanguage',
        type: 'POST',
        dataType: 'text',
        data: 'name=' + name,
        success: function (response) {
            if (response == 'success') {
                alert('Language has been successfully added!');
                getLanguageList();
            } else {
                alert('Problem! Language has not been successfully added!');
            }
        }
    });
}

function addGiveBook() {
    let bookId = (document.getElementById('giveBookInput').value);
    let userId = (document.getElementById('giveUserInput').value);
    let employee = $('#giveEmployeeCmbId').val();
    let readingRoom = $('#giveReadingRoomCmbId').val();
    let returnDate = $('#giveReturnDate').val();
    let data = {
        "bookId": bookId,
        "userId": userId,
        "employee": employee,
        "readingRoom": readingRoom,
        "returnDate": returnDate
    }
    $.ajax({
        url: 'cs?action=addGiveBook',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Information has been successfully added!');
                getGiveBookList();
            } else {
                alert('Problem! Information has not been successfully added!');
            }
        }
    });
}

function addEmployee() {
    let name = $('#employeeNameId').val();
    let surname = $('#employeeSurnameId').val();
    let positionId = $('#employeePositionCmbId').val();
    let data = {
        "name": name,
        "surname": surname,
        "positionId": positionId
    }
    $.ajax({
        url: 'cs?action=addEmployee',
        method: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Employee has been successfully added!');
                getEmployeeList();
            } else {
                alert('Problem! Employee has not been successfully added!');
            }
        }
    });

}

function addProblemUser() {
    let userId = $('#problemUserId').val();
    $.ajax({
        url: 'cs?action=addProblemUser',
        method: 'POST',
        dataType: 'text',
        data: "userId=" + userId,
        success: function (response) {
            if (response == 'success') {
                alert('Promlemic user has been successfully added!');
                getProblemUserList();
            } else {
                alert('Problem! Problemic user has not been successfully added!');
            }
        }
    });
}

function addReturnBook() {
    let returnBookId = $('#returnBookId').val();
    $.ajax({
        url: 'cs?action=addReturnBook',
        method: 'POST',
        dataType: 'text',
        data: "returnBookId=" + returnBookId,
        success: function (response) {
            if (response == 'success') {
                alert('Book has been successfully returned!');
                getBookList()
            } else {
                alert('Problem! Book has not been successfully returned!');
            }
        }
    });
}

function editUser(userId) {
    globUserId = userId;
    $.ajax({
        url: 'cs?action=editUser',
        type: 'GET',
        data: 'userId=' + userId,
        dataType: 'html',
        success: function (response) {
            $('#editUserDialogId').html(response);
            $('#editUserDialogId').dialog('open');
        }
    });
}

function updateUser() {
    let name = $('#userNameIdU').val();
    let surname = $('#userSurnameIdU').val();
    let dob = $('#userDobIdU').val();
    let identityNumber = $('#identityNumberIdU').val();
    let mail = $('#userMailIdU').val();
    let phone = $('#userPhoneIdU').val();
    let userActivity = $('#userActivityIdU').val();
    let data = {
        "name": name,
        "surname": surname,
        "dob": dob,
        "identityNumber": identityNumber,
        "mail": mail,
        "phone": phone,
        "userActivity": userActivity,
        "userId": globUserId
    }
    $.ajax({
        url: 'cs?action=updateUser',
        method: "POST",
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('User has been successfully updated!');
                getUserList();
            } else {
                alert('Problem! User has not been successfully updated!');
            }
        }
    });
}

function deleteUser(userId, fullname) {
    let isYes = confirm("Are you sure to delete " + fullname + "?")
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteUser',
            type: 'POST',
            data: 'userId=' + userId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('User has been successfully deleted!');
                    getUserList();
                } else {
                    alert('Problem! User has not been successfully deleted!');
                }
            }
        });
    }
}

function editAuthor(authorId) {
    globAuthorId = authorId;
    $.ajax({
        url: 'cs?action=editAuthor',
        type: 'GET',
        data: 'authorId=' + authorId,
        dataType: 'html',
        success: function (response) {
            $('#editAuthorDialogId').html(response);
            $('#editAuthorDialogId').dialog('open');
        }
    });
}

function updateAuthor() {
    let name = $('#authorNameIdU').val();
    let surname = $('#authorSurnameIdU').val();

    let data = {
        "name": name,
        "surname": surname,
        "authorId": globAuthorId
    }
    $.ajax({
        url: 'cs?action=updateAuthor',
        method: "POST",
        data: data,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Author has been successfully updated!');
                getAuthorList();
            } else {
                alert('Problem! Author has not been successfully updated!');
            }
        }
    });
}

function deleteAuthor(authorId, fullname) {
    let isYes = confirm("Are you sure to delete " + fullname + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteAuthor',
            type: 'POST',
            data: 'authorId=' + authorId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Author has been successfully deleted!');
                    getAuthorList();
                } else {
                    alert('Problem! Author has not been successfully deleted!');
                }
            }

        });
    }
}

function editBook(bookId) {
    globBookId = bookId;
    $.ajax({
        url: 'cs?action=editBook',
        type: 'GET',
        data: 'bookId=' + bookId,
        dataType: 'html',
        success: function (response) {
            $('#editBookDialogId').html(response);
            $('#editBookDialogId').dialog('open');
        }
    });
}

function updateBook() {
    let name = $('#bookNameIdU').val();
    let languageId = $('#bookLanguageCmbIdU').val();
    let page = $('#bookPageIdU').val();
    let price = $('#bookPriceIdU').val();
    let shelfId = $('#bookShelfCmbIdU').val();
    let dateOfPublication = $('#bookDateOfPublicationIdU').val();
    let numberOfBook = $('#bookNumberOfBookIdU').val();
    let data = {
        "name": name,
        "languageId": languageId,
        "shelfId": shelfId,
        "page": page,
        "price": price,
        "dateOfPublication": dateOfPublication,
        "numberOfBook": numberOfBook,
        "bookId": globBookId
    }
    $.ajax({
        url: 'cs?action=updateBook',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Book has been successfully updated!');
                getBookList();
            } else {
                alert('Problem! Book has not been successfully updated!');
            }
        }
    });
}

function deleteBook(bookId, bookName) {
    let isYes = confirm("Are you sure to delete " + bookName + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteBook',
            type: 'POST',
            data: 'bookId=' + bookId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Book has been successfully deleted!');
                    getBookList();
                } else {
                    alert('Problem! Book has not been successfully deleted!');
                }
            }

        });
    }
}

function deleteProblemUser(userId, fullname) {
    let isYes = confirm("Are you sure to delete " + fullname + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteProblemUser',
            type: 'POST',
            data: 'userId=' + userId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Problemic user has been successfully deleted!');
                    getProblemUserList();
                } else {
                    alert('Problem! Problemic user has not been successfully deleted!');
                }
            }

        });
    }
}

function editLanguage(languageId) {
    globLanguageId = languageId;
    $.ajax({
        url: 'cs?action=editLanguage',
        type: 'GET',
        data: 'languageId=' + languageId,
        dataType: 'html',
        success: function (response) {
            $('#editLanguageDialogId').html(response);
            $('#editLanguageDialogId').dialog('open');
        }
    });
}

function updateLanguage() {
    let name = $('#languageNameIdU').val();
    let data = {
        "name": name,
        "languageId": globLanguageId
    }
    $.ajax({
        url: 'cs?action=updateLanguage',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Language has been successfully updated!');
                getLanguageList();
            } else {
                alert('Problem! Language has not been successfully updated!');
            }
        }
    });
}

function deleteLanguage(languageId, languageName) {
    let isYes = confirm("Are you sure to delete " + languageName + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteLanguage',
            type: 'POST',
            data: 'languageId=' + languageId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Language has been successfully deleted!');
                    getLanguageList();
                } else {
                    alert('Problem! Language has not been successfully deleted!');
                }
            }

        });
    }
}

function editTopic(topicId) {
    globTopicId = topicId;
    $.ajax({
        url: 'cs?action=editTopic',
        type: 'GET',
        data: 'topicId=' + topicId,
        dataType: 'html',
        success: function (response) {
            $('#editTopicDialogId').html(response);
            $('#editTopicDialogId').dialog('open');
        }
    });
}

function updateTopic() {
    let name = $('#topicNameIdU').val();
    let data = {
        "name": name,
        "topicId": globTopicId
    }
    $.ajax({
        url: 'cs?action=updateTopic',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Topic has been successfully updated!');
                getTopicList();
            } else {
                alert('Problem! Topic has not been successfully updated!');
            }
        }
    });
}

function deleteTopic(topicId, topicName) {
    let isYes = confirm("Are you sure to delete " + topicName + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteTopic',
            type: 'POST',
            data: 'topicId=' + topicId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Topic has been successfully deleted!');
                    getTopicList();
                } else {
                    alert('Problem! Topic has not been successfully deleted!');
                }
            }

        });
    }
}

function editEmployee(employeeId) {
    globEmployeeId = employeeId;
    $.ajax({
        url: 'cs?action=editEmployee',
        type: 'GET',
        data: 'employeeId=' + employeeId,
        dataType: 'html',
        success: function (response) {
            $('#editEmployeeDialogId').html(response);
            $('#editEmployeeDialogId').dialog('open');
        }
    });
}

function updateEmployee() {
    let name = $('#employeeNameIdU').val();
    let surname = $('#employeeSurnameIdU').val();
    let positionId = $('#employeePositionCmbIdU').val();
    let data = {
        "name": name,
        "surname": surname,
        "positionId": positionId,
        "employeeId": globEmployeeId
    }
    $.ajax({
        url: 'cs?action=updateEmployee',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Employee has been successfully updated!');
                getEmployeeList();
            } else {
                alert('Problem! Employee has not been successfully updated!');
            }
        }
    });
}

function deleteEmployee(employeeId, fullname) {
    let isYes = confirm("Are you sure to delete " + fullname + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteEmployee',
            type: 'POST',
            data: 'employeeId=' + employeeId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Employee has been successfully deleted!');
                    getEmployeeList();
                } else {
                    alert('Problem! Employee has not been successfully deleted!');
                }
            }

        });
    }
}

function infoBook(bookId) {
    $.ajax({
        url: 'cs?action=infoBook',
        type: 'GET',
        data: 'bookId=' + bookId,
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }
    });
}

function editBookInfo(bookInfoId) {
    globEmployeeId = bookInfoId;
    $.ajax({
        url: 'cs?action=editBookInfo',
        type: 'GET',
        data: 'bookInfoId=' + bookInfoId,
        dataType: 'html',
        success: function (response) {
            $('#editBookInfoDialogId').html(response);
            $('#editBookInfoDialogId').dialog('open');
        }
    });
}

function deleteBookInfo(bookInfoId) {
    let isYes = confirm("Are you sure to delete ID: " + bookInfoId + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteBookInfo',
            type: 'POST',
            data: 'bookInfoId=' + bookInfoId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Book information has been successfully deleted!');
                    getBookInfoList();
                } else {
                    alert('Problem! Book information has not been successfully deleted!');
                }
            }

        });
    }
}

function editGiveBook(giveId) {
    globGiveId = giveId;
    $.ajax({
        url: 'cs?action=editGiveBook',
        type: 'GET',
        data: 'giveId=' + giveId,
        dataType: 'html',
        success: function (response) {
            $('#editGiveBookDialogId').html(response);
            $('#editGiveBookDialogId').dialog('open');
        }
    });
}

function updateGiveBook() {
    let bookId = (document.getElementById('giveBookInputUpdate').value);
    let userId = (document.getElementById('giveUserInputUpdate').value);
    let employee = $('#giveEmployeeCmbIdUpdate').val();
    let readingRoom = $('#giveReadingRoomCmbIdUpdate').val();
    let returnDate = $('#giveReturnDateUpdate').val();

    let data = {
        "bookId": bookId,
        "userId": userId,
        "employee": employee,
        "readingRoom": readingRoom,
        "returnDate": returnDate,
        "giveId": globGiveId
    }
    $.ajax({
        url: 'cs?action=updateGiveBook',
        type: 'POST',
        dataType: 'text',
        data: data,
        success: function (response) {
            if (response == 'success') {
                alert('Information has been successfully updated!');
                getGiveBookList();
            } else {
                alert('Problem! Information has not been successfully updated!');
            }
        }
    });
}

function deleteGiveBook(giveId) {
    let isYes = confirm("Are you sure to delete ID: " + giveId + "?");
    if (isYes) {
        $.ajax({
            url: 'cs?action=deleteGiveBook',
            type: 'POST',
            data: 'giveId=' + giveId,
            dataType: 'text',
            success: function (response) {
                if (response == 'success') {
                    alert('Information has been successfully deleted!');
                    getGiveBookList();
                } else {
                    alert('Problem! Information has not been successfully deleted!');
                }
            }

        });
    }
}


