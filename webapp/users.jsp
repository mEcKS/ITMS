<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: m.chmil
  Date: 18.05.2015
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="tmpl/header.jsp" %>
<body>
<div id="wrapper">
  <!-- Sidebar -->
  <%@ include file="tmpl/sidebar.jsp" %>
  <!-- /#sidebar-wrapper -->
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <div class="row">
        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><i class="glyphicon glyphicon-menu-hamburger"></i></a>
        <h1>Пользователи</h1>
      </div>
    </div>
    <br>

        <div class="dataTable_wrapper">
          <table class="table table-striped table-bordered table-hover" id="dataTables-example" width="100%">
            <thead>
            <tr>
              <th>ID</th>
              <th>Имя Рус</th>
              <th>Фамилия Рус</th>
              <th>Отчество Рус</th>
              <th>Имя Eng</th>
              <th>Фамилия Eng</th>
              <th>Филиал</th>
              <th>Подразделение</th>
              <th>Должность</th>
              <th>Код CFO</th>
              <th>Город</th>
              <th>Страна</th>
              <th>Дата рождения</th>
              <th>Дата приема</th>
              <th>Дата уволнения</th>
              <th>Функциональный менеджер</th>
              <th>Административный менеджер</th>
              <th>Email</th>

              <th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.argisusers}" var="user">
              <tr>
                <td>${user.tabNum}</td>
                <td>${user.firstNameRUS}</td>
                <td>${user.lastNameRUS}</td>
                <td>${user.patronymicRUS}</td>
                <td>${user.firstNameENG}</td>
                <td>${user.lastNameENG}</td>
                <td>${user.branchCode}</td>
                <td>${user.departmentName}</td>
                <td>${user.positionName}</td>
                <td>${user.codeDepartmentCFO}</td>
                <td>${user.city}</td>
                <td>${user.country}</td>
                <td>${user.birthDay}</td>
                <td>${user.employmentData}</td>
                <td>${user.dateDischarge}</td>
                <td>${user.funcManager}</td>
                <td>${user.manager}</td>
                <td>${user.email}</td>
                <td>
                  <a href="repair?id=${user.tabNum}"><span class="glyphicon glyphicon-edit"></span></a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
    <!-- /.panel-body -->
  </div>
</div>
<!-- /#wrapper -->
<%@ include file="tmpl/footer.jsp" %>

<script>
  <!-- Page-Level Demo Scripts - Tables - Use for reference -->
  $(document).ready(function () {
    $('#dataTables-example').DataTable({
      scrollX: true,
      responsive: true,
      "order": [[2, "asc"]],
      "language": {
        "processing": "Подождите...",
        "search": "Поиск:",
        "lengthMenu": "Показать _MENU_ записей",
        "info": "Записи с _START_ до _END_ из _TOTAL_ записей",
        "infoEmpty": "Записи с 0 до 0 из 0 записей",
        "infoFiltered": "(отфильтровано из _MAX_ записей)",
        "infoPostFix": "",
        "loadingRecords": "Загрузка записей...",
        "zeroRecords": "Записи отсутствуют.",
        "emptyTable:": "В таблице отсутствуют данные",
        "paginate": {
          "first": "Первая",
          "previous": "Предыдущая",
          "next": "Следующая",
          "last": "Последняя"
        },
        "aria": {
          "sortAscending": ": активировать для сортировки столбца по возрастанию",
          "sortDescending": ": активировать для сортировки столбца по убыванию"
        }
      }
    });
  });
</script>
</body>
</html>
