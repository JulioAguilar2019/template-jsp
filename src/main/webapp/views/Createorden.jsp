<%--
  Created by IntelliJ IDEA.
  User: julioaguilar
  Date: 3/30/23
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Layout/Navbar.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<section class="max-w-4xl p-6 mx-auto bg-white rounded-md shadow-md dark:bg-gray-800">
  <h2 class="text-lg font-semibold text-gray-700 capitalize dark:text-white">Create a new bird</h2>

  <form action="${pageContext.request.contextPath}/ServletOrdenes?action=save" method="post">
    <div class="grid grid-cols-1 gap-6 mt-4 sm:grid-cols-2">
        <div id="customSelect" class="border border-gray-300 rounded-lg">

            <select name="IdProducto" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">
                <option value="0">Seleccione un producto</option>
                <c:forEach items="${productos}" var="productos">
                    <option value="${productos.getIdProducto()}">${productos.getNombre()}</option>
                </c:forEach>
        </div>

      <div>
        <label class="text-gray-700 dark:text-gray-200" for="descripcion">Cantidad</label>
        <input id="descripcion" required type="number" name="cantidad" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">
      </div>
        <div>
            <label class="text-gray-700 dark:text-gray-200" for="precio">Fecha</label>
            <input id="precio" required type="date" min="0" name="fecha" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">
        </div>
        <div>
            <label class="text-gray-700 dark:text-gray-200" for="categoria">Direccion</label>
            <input id="categoria" required type="text" name="direccion" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">
        </div>


<%--      <div>--%>
<%--        <label class="text-gray-700 dark:text-gray-200" for="plumage">Plumage</label>--%>
<%--        <input id="plumage" required type="text" name="plumage" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">--%>
<%--      </div>--%>

<%--      <div>--%>
<%--        <label class="text-gray-700 dark:text-gray-200" for="habitat">Habitat</label>--%>
<%--        <input id="habitat" required name="habitat" type="text" class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-200 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-400 focus:ring-blue-300 focus:ring-opacity-40 dark:focus:border-blue-300 focus:outline-none focus:ring">--%>
<%--      </div>--%>
    </div>

    <div class="flex justify-end mt-6">
      <button class="px-8 py-2.5 leading-5  text-white transition-colors duration-300 transform bg-gray-700 rounded-md hover:bg-gray-600 focus:outline-none focus:bg-gray-600">Save</button>
    </div>
  </form>
</section>