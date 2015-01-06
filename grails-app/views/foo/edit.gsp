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
        case  0 : return gameover ? "<td> </td>" : "<td onClick='ttt($pos)'></td>"
      }
    }
  %>

<table border=1>
  <tr>${raw( td(0) + td(1) + td(2) )}</tr>
  <tr>${raw( td(3) + td(4) + td(5) )}</tr>
  <tr>${raw( td(6) + td(7) + td(8) )}</tr>
</table>

<br>
Lookahead
<g:select id="lookahead" name="lookahead" from="${(0..8).toList()}" value="${lookahead}">
</g:select>
<br>
<g:if test="${gameover}">GAME OVER<br></g:if>
<button onclick="newGame()">New Game</button>

<p>
  This is a small example of a
  <a href="https://github.com/Dierk/fregePluginApp/blob/master/src/frege/fregepluginapp/Minimax.fr">game tree written Frege</a>
  and included
  <a href="https://github.com/Dierk/fregePluginApp/blob/master/grails-app/controllers/fregepluginapp/FooController.groovy">inside a Grails application</a>
  with the help of the
  <a href="https://github.com/Dierk/FregeGrailsPlugin">Grails Frege Plugin</a>.
</p>
<p>
  The computer is X, you are O. The computer will start with a random move.<br>
  Please tweet cc @mittie if you ever managed to win with a lookahead > 2.
</p>
<p>
  P.S. no consideration has been given so far to a nice game play, i.e. displaying game state and statistics.
</p>

<script>
  var SERVER_URL = window.location.protocol + "//" + window.location.host + window.location.pathname;

  function ttt(index) {
    var lookahead = document.getElementById("lookahead").value;
    window.open(SERVER_URL + "?index=" + index + "&lookahead=" +lookahead, "_self")
  }
  function newGame() {
    var lookahead = document.getElementById("lookahead").value;
    window.open(SERVER_URL + "?newGame=true" + "&lookahead=" +lookahead, "_self")
  }

</script>

</body>
</html>
