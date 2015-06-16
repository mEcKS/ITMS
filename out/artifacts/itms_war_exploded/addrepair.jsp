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
                <h1>Принять в ремонт</h1>
            </div>
        </div>
        <br>

        <div class="panel panel-default">
            <div class="panel-heading">
                <label class="control-label">Создать</label>

            </div>
            <div class="panel-body">
                <br>

                <form action="doaddrepair" id="addRepair" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Дата приема *</label>

                        <div class="col-xs-5">
                            <div class="input-group input-append date" id="dateRangePicker">
                                <input type="text" class="form-control" id="daterepair" name="daterepair" placeholder="YYYY-MM-DD"/>
                                <span class="input-group-addon add-on"><span
                                        class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Номер накладной *</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="numbergk"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Подразделение *</label>

                        <div class="col-xs-5">
                            <select class="form-control" id="selectdepartament" name="selectdepartament">
                                <option value="">[Не указано]</option>
                                <c:forEach items="${requestScope.brancheses}" var="branches">
                                    <option value="${branches.name}">${branches.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Тип оборудования *</label>

                        <div class="col-xs-5">
                            <select class="form-control" id="typeequipment" name="typeequipment">
                                <option value="">[Не указано]</option>
                                <c:forEach items="${requestScope.types}" var="type">
                                    <option value="${type.name}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Название *</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="nameeq"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Инвентарный номер</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="inventorynumber"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Серийный номер</label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" name="serialnumber"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Комментарий</label>

                        <div class="col-xs-5">
                            <textarea class="form-control" rows="2" id="info" name="info"></textarea>
                        </div>
                    </div>
                    <legend></legend>
                    <div class="form-group">
                        <div class="col-xs-9 col-xs-offset-3">
                            <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-ok"></i> Создать</button>

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
                daterepair: {
                    validators: {
                        notEmpty: {
                        },
                        date: {
                            format: 'YYYY-MM-DD'
                        }
                    }
                },
                numbergk: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            min: 3,
                            max: 11
                        },
                        regexp: {
                            regexp: /^[a-zA-Zа-яА-Я0-9_]+$/
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

