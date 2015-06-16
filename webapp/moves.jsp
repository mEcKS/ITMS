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
        <h1>Прием и выдача оборудования</h1>
      </div>
    </div>
    <br>

    <div class="panel panel-default">
      <div class="panel-heading">
         <a href="move?movetype=plus">
          <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Принять</button>
        </a>
        <a href="move?movetype=minus">
          <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-minus"></span> Выдать</button>
        </a>

        </form>
      </div>

      <!-- /.panel-heading -->
      <div class="panel-body">
        <div class="dataTable_wrapper">
          <table class="table table-striped table-bordered table-hover" id="dataTables-example">
            <thead>
            <tr>
              <th>ID</th>
              <th>+/-</th>
              <th>Дата приема/выдачи</th>
              <th>Название</th>
              <th>Подразделение</th>
              <th>Сотрудник</th>
              <th>Тип</th>
              <th>Инв. номер</th>
              <th data-field="operate" data-formatter="operateFormatter" data-events="operateEvents"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.moves}" var="move">
              <tr>
                <td>${move.id}</td>
                <td>
                  <span class="glyphicon glyphicon-${move.moveType}"></span>
                </td>
                <td>${move.date}</td>
                <td>${move.name}</td>
                <td>${move.departament}</td>
                <td>${move.employee}</td>
                <td>${move.type}</td>
                <td>${move.inventoryNumber}</td>


                <td>
                  <a href="move?id=${move.id}"><span class="glyphicon glyphicon-edit"></span></a>
                  <!--Списать-->
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
      <!-- /.table-responsive -->
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
      responsive: true,
      "order": [[2, "desc"]],
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
