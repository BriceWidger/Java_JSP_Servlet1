<%-- 
Brice Widger
6-7-20
Bellevue University
Sources: 
studying others' work in class
Murach's Java Servlets and JSP (3rd Edition)
probably a hundred web pages (too much to list)
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>BriceWidgerRecords</title>
   <style>
      html, body {
    height: 100%;
}

html {
    display: table;
    margin: auto;
}

body {
    display: table-cell;
    vertical-align: middle;
      background-color: lightblue;

}


body a{
  background-color: lightblue;
  font-size: 25px;
      color: black;
      text-align: center;
    vertical-align: middle;
      font-style: normal;
  text-decoration: none;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
     
</style>
</head>
<body>
  <section>
    <div>
        <table>
          <tr>
          <center><h4>RECORDS</h4></center>
            <th>Wine ID &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<br></th>
            <th>Winery &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th>
            <th>Location &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th>
          </tr>
          <c:forEach var="res" items="${results}">
            <tr>
              <td>${res.get(0)}</td>
              <td>${res.get(1)}</td>
              <td>${res.get(2)}</td>            
            </tr>
          </c:forEach>
        </table>
      </div>
  </section>

<p></p>
<p></p>
<p></p>
<p></p>
<center><a href="Home"><em>-Home-</em></a></center>  
    
</body>
</html>