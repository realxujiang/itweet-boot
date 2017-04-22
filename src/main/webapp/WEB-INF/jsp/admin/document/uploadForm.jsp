<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>文件上传</title>
</head>

<body>

    <div th:if="${message}">
        <h2 th:text="${message}"/>
    </div>

    <div>
        <form method="POST" enctype="multipart/form-data" action="/admin/document/upload">
            <table>
                <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
                <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
            </table>
        </form>
    </div>

    <div>
        <ul>
            <li th:each="file : ${files}">
                <a th:href="${file}" th:text="${file}" />
            </li>
        </ul>
    </div>

</body>

</html>