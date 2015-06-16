<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jQuery -->
<script src="templates/components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="templates/components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- DataTables JavaScript -->
<script src="templates/components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="templates/components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

<!-- Bootstrap Validator 0.5.2 JavaScript -->
<script src="templates/components/bootstrapvalidator/dist/js/bootstrapValidator.min.js"></script>
<script src="templates/components/bootstrapvalidator/src/js/language/ru_RU.js"></script>

<!-- Menu Toggle Script -->
<script>
  $("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });
</script>
