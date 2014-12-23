<!DOCTYPE html>
<html>
<head>
  <title>Tic Tac Toe</title>
  <style type="text/css" media="screen">
  td {
    width: 50px;
    height: 50px;
    text-align: center;
  }
  </style>
</head>

<body>

<h1>Tic Tac Toe</h1>

  <%
    td = { pos ->
      switch (board[pos]) {
        case  1 : return "<td>X</td>"
        case -1 : return "<td>O</td>"
        case  0 : return "<td onClick='ttt($pos)'></td>"
      }
    }
  %>

<table border=1>
  <tr>${raw( td(0) + td(1) + td(2) )}</tr>
  <tr>${raw( td(3) + td(4) + td(5) )}</tr>
  <tr>${raw( td(6) + td(7) + td(8) )}</tr>
</table>
<g:if test="${gameover}">GAME OVER</g:if>
<a href="/fregePluginApp/foo/ttt">New Game</a>

<script>
  var SERVER_URL = window.location.protocol + "//" + window.location.host + "/fregePluginApp/foo/ttt?";

  function ttt(index) {
    window.open(SERVER_URL + "board=${boardStr}" + "&" + "new=" + index, "_self")
  }

</script>

</body>
</html>
