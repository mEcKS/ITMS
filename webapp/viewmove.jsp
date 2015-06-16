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
                <h1>Перемещение ТМЦ</h1>
            </div>
        </div>
        <br>

        <div class="panel panel-default">
            <div class="panel-heading">
                <label class="control-label">Просмотр ${move.name}</label>

            </div>
            <div class="panel-body">
                <br>

                <form action="domovetmc" id="addRepair" method="post" class="form-horizontal">

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Тип перемещения</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="movetype" value="${move.moveType}" readonly/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Дата выдачи *</label>

                        <div class="col-xs-5">
                            <div class="input-group input-append date" id="dateRangePicker">
                                <input type="text" class="form-control" id="daterepair" name="daterepair" value="${move.date}" placeholder="YYYY-MM-DD" readonly/>
                                <span class="input-group-addon add-on"><span
                                        class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Подразделение *</label>

                        <div class="col-xs-5">
                            <select class="form-control" id="selectdepartament" name="selectdepartament" readonly>
                                <option value="">${move.departament}</option>

                             </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Сотрудник *</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" id="employee" name="employee" value="${move.employee}" readonly/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Тип оборудования *</label>

                        <div class="col-xs-5">
                            <select class="form-control" id="typeequipment" name="typeequipment" value="${move.type}" readonly>
                                <option value="">[Не указано]</option>

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Название *</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="nameeq" value="${move.name}" readonly/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Инвентарный номер</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="inventorynumber" value="${move.inventoryNumber}" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Серийный номер</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="serialnumber"  value="${move.serialNumber}" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Комментарий</label>

                        <div class="col-xs-5">
                            <textarea class="form-control" rows="2" id="info" name="info" readonly>${move.info}</textarea>
                        </div>
                    </div>
                    <legend></legend>
                    <div class="form-group">
                        <div class="col-xs-9 col-xs-offset-3">

                            <a href="moves" class="btn btn-default"> <i class="glyphicon glyphicon-remove"></i> Отмена</a>
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
                daterepair: {
                    validators: {
                        notEmpty: {
                        },
                        date: {
                            format: 'YYYY-MM-DD'
                        }
                    }
                },
                employee: {
                    validators: {
                        notEmpty: {
                        },
                        regexp: {
                            regexp: /^[a-zA-Zа-яА-Я0-9_ ]+$/
                        }
                    }
                },
                selectdepartament: {
                    validators: {
                        notEmpty: {
                        }
                    }
                },
                typeequipment: {
                    validators: {
                        notEmpty: {
                        }
                    }
                },
                nameeq: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            min: 3,
                            max: 50
                        },
                        regexp: {
                            regexp: /^[a-zA-Zа-яА-Я0-9_ ]+$/
                        }
                    }
                }
            }
        });
    });
</script>
</body>

</html>

