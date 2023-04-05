<%--
  Created by IntelliJ IDEA.
  User: julioaguilar
  Date: 3/30/23
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Layout/Navbar.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<Button class="px-6 py-2 font-medium tracking-wide text-white capitalize transition-colors duration-300 transform bg-blue-600 rounded-lg hover:bg-blue-500 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-80">
  <a href="${pageContext.request.contextPath}/ServletAve?action=save">Create new</a>
</Button>

<section class="container px-4 mx-auto">
<div class="flex flex-col mt-6">
<div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
<div
class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8"
>
<div
class="overflow-hidden border border-gray-200 dark:border-gray-700 md:rounded-lg"
>
<table
class="min-w-full divide-y divide-gray-200 dark:divide-gray-700"
>
<thead class="bg-gray-50 dark:bg-gray-800">
<tr>
  <th
          scope="col"
          class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    <div class="flex items-center gap-x-3">
      <span>Id</span>
    </div>
  </th>
  <th
          scope="col"
          class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    <div class="flex items-center gap-x-3">
      <span>Name</span>
    </div>
  </th>
  <th
          scope="col"
          class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    <div class="flex items-center gap-x-3">
      <span>Kind</span>
    </div>
  </th>
  <th
          scope="col"
          class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    <div class="flex items-center gap-x-3">
      <span>Plumage</span>
    </div>
  </th>
  <th
          scope="col"
          class="py-3.5 px-4 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    <div class="flex items-center gap-x-3">
      <span>Habitat</span>
    </div>
  </th>
  <th
          scope="col"
          class="px-4 py-3.5 text-sm font-normal text-left rtl:text-right text-gray-500 dark:text-gray-400"
  >
    Actions
  </th>
</tr>
</thead>
<c:if test="${aves != null}">
  <c:forEach items="${aves}" var="ave">

                <tbody
                        class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900"
                >
                <tr>
                  <td
                          class="px-4 py-4 text-sm font-medium text-gray-700 whitespace-nowrap"
                  >
                    <div class="inline-flex items-center gap-x-3">
                      <div class="flex items-center gap-x-2">

                        <div>
                          <h2
                                  class="font-medium text-gray-800 dark:text-white"
                          >
                            ${ave.id}
                          </h2>

                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-4 py-4 text-sm text-gray-500 dark:text-gray-300 whitespace-nowrap">
                    ${ave.name}
                  </td>
                  <td class="px-4 py-4 text-sm text-gray-500 dark:text-gray-300 whitespace-nowrap">
                      ${ave.kind}
                  </td>
                  <td class="px-4 py-4 text-sm text-gray-500 dark:text-gray-300 whitespace-nowrap">
                      ${ave.plumage}
                  </td>
                  <td class="px-4 py-4 text-sm text-gray-500 dark:text-gray-300 whitespace-nowrap">
                      ${ave.habitat}
                  </td>

                  <td class="px-4 py-4 text-sm whitespace-nowrap">
                    <div class="flex items-center gap-x-6">
                      <a
                              href="${pageContext.request.contextPath}/ServletAve?action=delete&id=${ave.id}"
                              class="text-gray-500 transition-colors duration-200 dark:hover:text-red-500 dark:text-gray-300 hover:text-red-500 focus:outline-none"
                      >
                        <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                class="w-5 h-5"
                        >
                          <path
                                  stroke-linecap="round"
                                  stroke-linejoin="round"
                                  d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0"
                          />
                        </svg>
                      </a>

                      <a
                              href="${pageContext.request.contextPath}/ServletAve?action=findOne&id=${ave.id}"
                              class="text-gray-500 transition-colors duration-200 dark:hover:text-yellow-500 dark:text-gray-300 hover:text-yellow-500 focus:outline-none"
                      >
                        <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                class="w-5 h-5"
                        >
                          <path
                                  stroke-linecap="round"
                                  stroke-linejoin="round"
                                  d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10"
                          />
                        </svg>
                      </a>

  </c:forEach>
</c:if>
                    </div>
                  </td>
                </tr>
</section>
