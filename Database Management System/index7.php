<?php

	 include_once 'includes/dbh.inc.php';
?>


<!DOCTYPE html>
<html lang="ro">
<style>
body {
  background-image: url('back.gif.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%;
}
</style>
<head>
<title>Baze de date</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: "Times New Roman", Times, serif;
   background-color: Gray;
}


header {
 border: 2px solid white;
  border-radius: 8px;
  background-color: #000000;
  padding: 60px;
  text-align: center;
  font-size: 44px;
  color: white;
}

nav {
  border: 2px solid white;
  border-radius: 8px;
  float: left;
  width: 15%;
  height: 1000px; 
  background-color: #000000;
  padding: 20px;
}

nav ul {
  list-style-type: none;
  padding: 0;
 
}

article {
  float: left;
  padding: 40px;
  width: 85%;
  background-color: #f1f1f1;
  height: 1000px;
}
article1 {
 border: 2px solid white;
  border-radius: 8px;
  float: left;
  padding: 40px;
  width: 85%;
  background-color: #f1f1f1;
  height: 1000px; 

}


section:after {
  content: "";
  display: table;
  clear: both;
}


footer {
border: 2px solid grey;
  border-radius: 8px;
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
/*Colorarea partii de navigare*/
a  { color:#A9A9A9; }
    a:visited { color:#b4b4b4; }
    a:hover { color:#A9A9A9; }
    a:active { color:#A9A9A9; }
    /* Don't underline links */
    a:link {text-decoration: none;}
    a:visited {text-decoration: none;}
</style>
</head>
<body>

<header>

 
  <p>

  <span style='color: white'>BAZE DE DATE<span>


</p>
<hr/> 
<p style="font-size:20px;text-align:right">U.T. Cluj-Napoca</p>
      <p style="font-size:20px;text-align:right">Flinta Claudiu</p>
</header>

<section>
 <div>
  <nav>
    <ul>
		<li><a href="http://localhost/phplessons/site.php/">Pagina Principala</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index1.php/">Query 1</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index2.php/">Query 2</a></li>
      <hr/>
		<li><a href="http://localhost/phplessons/index3.php/">Query 3</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index4.php/">Query 4</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index5.php/">Query 5</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index6.php/">Query 6</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index7.php/">Query 7</a></li>
     <hr/>
		<li><a href="http://localhost/phplessons/index8.php/">Query 8</a></li>		
    </ul>
  </nav>
 </div>
  
  <article>
   <form>
<input type = "text" name = "gen" placeholder="Introduceti Gen">
	<br>
	<button type ="submit" name="submit" value = "submit" >Cauta</button>
</form>

<?php
 
 

   if(isset($_GET['submit'])){

    $gen = $_GET['gen'];
	$sql = "SELECT distributie.id_actor, COUNT(*)
FROM distributie JOIN film ON distributie.titlu_film = film.titlu
WHERE film.gen='$gen'
GROUP BY ID_ACTOR;";
	$result = mysqli_query($conn, $sql);
	
	$resultCheck = mysqli_num_rows($result);
	
	if($resultCheck > 0)
	{
		
		   echo '<table border="1" cellspacing="5" cellpadding="5" width="100%">
    <tr>
	    <th>Id Actor</th>
		<th>Numar Filme Jucate</th>
		
    </tr>';
		while($row = mysqli_fetch_array($result)){
			echo '
        <tr>
		    <td>'.$row[0].'</td>
            <td>'.$row[1].'</td>
        </tr>';

			
		}
	}
	else
	{
		echo "Date Invalide!";
	}
	
   }
		
?>
</article>
 
</section>

