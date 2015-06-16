<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: m.chmil
  Date: 18.05.2015
  Time: 14:56
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
        <h1>Ремонт</h1>
      </div>
    </div>
    <br>

    <div class="panel panel-default">
      <div class="panel-heading">
         <label class="control-label">Просмотр ${repair.name} из ${repair.branches} от ${repair.dateIn} </label>

      </div>
      <div class="panel-body">
        <br>

        <form action="editrepair" id="addRepair" method="post" class="form-horizontal">
          <div class="form-group">
            <label class="col-xs-3 control-label">ID  </label>

            <div class="col-xs-5">
              <input type="text" class="form-control" id="idrepair" name="idrepair" value="${repair.id}" readonly/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-xs-3 control-label">Дата приема  </label>

            <div class="col-xs-5">
              <div class="input-group input-append date" id="dateRangePicker">
                <input type="text" class="form-control" id="daterepair" name="daterepair" value="${repair.dateIn}" readonly/>
                                <span class="input-group-addon add-on"><span
                                        class="glyphicon glyphicon-calendar"></span></span>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="col-xs-3 control-label">Номер накладной  </label>

            <div class="col-xs-5">
              <input type="text" class="form-control" name="numbergk" value="${repair.gk}" readonly/>
            </div>
          </div>

          <div class="form-group">
            <label class="col-xs-3 control-label">Подразделение  </label>

            <div class="col-xs-5">
              <select class="form-control" id="selectdepartament" name="selectdepartament" readonly>
                <option value="">${repair.branches}</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label class="col-xs-3 control-label">Тип оборудования  </label>

            <div class="col-xs-5">
              <select class="form-control" id="typeequipment" name="typeequipment" readonly>
                <option value="">${repair.type}</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-xs-3 control-label">Название  </label>

            <div class="col-xs-5">
              <input type="text" class="form-control" name="nameeq" value="${repair.name}" readonly/>
            </div>
          </div>

          <div class="form-group">
            <label class="col-xs-3 control-label">Инвентарный номер</label>

            <div class="col-xs-5">
              <input type="text" class="form-control" name="inventorynumber" value="${repair.invNumder}" readonly/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-xs-3 control-label">Серийный номер</label>

            <div class="col-xs-5">
              <input type="text" class="form-control" name="serialnumber" value="${repair.sNNumber}" readonly/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-xs-3 control-label">Комментарий</label>

            <div class="col-xs-5">
              <textarea class="form-control" rows="2" id="info" name="info" >${repair.info}</textarea>
            </div>
          </div>

          <div class="form-group">
            <label class="col-xs-3 control-label">Статус *</label>

            <div class="col-xs-5">
              <select class="form-control" id="status" name="status">
                <option value="">[Принято в ремонт]</option>
                <option value="Отправлено">Отправлено</option>
                <option value="Не подлежит ремонту">Не подлежит ремонту</option>
              </select>
            </div>
          </div>
          <legend></legend>
          <div class="form-group">
            <div class="col-xs-9 col-xs-offset-3">
              <button type="submit" class="btn btn-primary" disabled><i class="glyphicon glyphicon-ok"></i> Изменить</button>

              <a href="repairs" class="btn btn-default"> <i class="glyphicon glyphicon-remove"></i> Отмена</a>
            </div>
          </div>
          * - поля обезательные к заполнению
        </form>

      </div>
    </div>
  </div>
</div>
<!-- /#wrapper -->
<%@ include file="tmpl/footer.jsp" %>

<script>
  $(document).ready(function() {

    <!-- Bootstrap-validator JavaScript -->
    $('#addRepair').bootstrapValidator({
      message: 'This value is not valid',
      feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
      },
      locale: 'ru_RU',
      fields: {
        status: {
          validators: {
            notEmpty: {
            }
          }
        }
      }
    });
  });
</script>
</body>

</html>

