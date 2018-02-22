<!Doctype html>
<html>
<body>
<head> <link rel="stylesheet" type="text/css" href="mystyle.css"> </head>
 
 
<?php  
// #1 C R E A T E   D A T A B A S E :
$link = mysqli_connect("localhost","root", "");
$db = "this_db_is_lit";
if ($link === false)
{
    //die("ERROR: COULD NOT CONNECT. " . mysqli_connect_error());
}

//echo "CONNECT SUCCESSFULLY. Host Info : ". mysqli_get_host_info($link);
?>



<?php
$sql_database = "CREATE DATABASE IF NOT EXISTS this_db_is_lit";
if (mysqli_query($link, $sql_database))
{
    //echo "Database created succesfully";
}
else
{
    //echo "ERROR: COULD NOT EXECUTE SSQL DATABASE " . mysqli_error($link);
}

?>


<?php  
$connect_db = mysqli_connect("localhost", "root","",$db);
if ($connect_db === false)
{
    //die ("Error: could not connect. " . mysql_connect_error());
}
else
    {
        //echo "SUCESS CONNECTION DB ";
    }
    
    
$sql_table = "CREATE TABLE IF NOT EXISTS mynegros(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
)";

if (mysqli_query($connect_db, $sql_table)) {
    //echo "Table was created successfully";
} else {
    //echo "Error creating table: " . mysqli_error($connect_db);
}




//mysqli_close($link);
?>



<?php 
//session_start();

//define variables
$name = $email = $rate = $feedback =  "";
$nameErr = $emailErr = $rateErr = "";

if ($_SERVER["REQUEST_METHOD"] == "POST")
{
    if (empty($_POST ["name"]))
    {
        $nameErr = "Name is required";
    }
    else
    {
        $name = test_input($_POST["name"]);
    }
}

if (empty($_POST["email"]))
{
    $emailErr = "Email is required";
}
else
{
    $email = test_input($_POST["email"]);
}

if (empty($_Post["rate"]))
{
    $rateErr = "Rate is required";
}
else
{
    $rate = ($_POST["rate"]);
}

if (empty($_POST["feedback"]))
{
    $feedbackErr ="Text is required";
}
else
{
    $feedback = ($_POST["feedback"]);
}




//information setter function
function test_input($data)
 {
      $data = trim($data);
      $data = stripslashes($data);
      $data = htmlspecialchars($data);
      return $data;
 }


 ?>
 
 
 <h2>PHP Form Example</h2>
 
<p><span class="error">* required field.</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  

  Name: <input type="text" name="name" value="<?php echo htmlspecialchars($name);?>">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
  
  E-mail: <input type="text" name="email" value="<?php echo htmlspecialchars($email);?>">
  <span class="error">* <?php echo $emailErr;?></span>
  <br><br>
  
  Rate:
  <input type="radio" name="rate" <?php if (isset($rate) && $rate=="Poor") echo "checked";?> value="poor">Poor
  <input type="radio" name="rate" <?php if (isset($rate) && $rate=="Bad") echo "checked";?> value="bad">Bad
  <input type="radio" name="rate" <?php if (isset($rate) && $rate=="Fair") echo "checked";?> value="fair">Fair
  <input type="radio" name="rate" <?php if (isset($rate) && $rate=="Good") echo "checked";?> value="good">Good
  <input type="radio" name="rate" <?php if (isset($rate) && $rate=="Best") echo "checked";?> value="best">Best
  <span class="error">* <?php if ( $rateErr == "") {echo $rateErr;}?></span>
  <br><br>

  Feedback: <textarea name="feedback" rows="5" cols="40" value = "<?php echo $feedback;?>"> </textarea>
  <br><br>

  <input type ="reset" name = "reset" value = "Reset" >
  <br>
  <br>
  <input type="submit" name="submit" value="Submit">  
  <br>
  <br>
</form>

<?php
  if(isset($_REQUEST['submit']))
  {
        $add_username = 
        "ALTER TABLE mynegros 
            ADD COLUMN IF NOT EXISTS name       VARCHAR(60) NOT NULL,
            ADD COLUMN IF NOT EXISTS email      VARCHAR(60) NOT NULL,
            ADD COLUMN IF NOT EXISTS rate       ENUM('poor', 'bad', 'fair', 'good', 'best'),
            ADD COLUMN IF NOT EXISTS feedback   VARCHAR(300) NOT NULL
        ";

        if (mysqli_query($connect_db, $add_username))
        {
            //echo "Table columns created successfully...";
        }
        else
        {
            //echo "Error creating table columns: ". mysqli_error($connect_db);
        }
        $rdb_value = $_POST['rate'];
        $sql_insert = "INSERT INTO mynegros (name, email, rate, feedback) VALUES ('$name', '$email', '$rdb_value', '$feedback')";

        if (mysqli_query($connect_db,$sql_insert))
        {
            //echo "Records inserted successfully...";
        }
        else
        {
            //echo "Error: Could not execut $sql_insert."  .mysqli_error($connect_db);
        }
        
        echo '<br>';
        echo '<br>';

        echo "records have been added into database ";
        //mysqli_close($link);
        
        
    $connection = mysqli_connect('localhost', 'root', ''); //The Blank string is the password
    mysqli_select_db($link,$db);
    $query = "SELECT * FROM mynegros";
    $result = mysqli_query($link,$query);
    echo "<br>";
    echo "<br>";
    while ( $row = mysqli_fetch_assoc($result))
    {
        //echo " <tr><td" . $row['name'] . "</td><td> " . $row['email'] . "</td></tr>". $row ['rate'] . "</td><td>" .  $row['feedback'] . "</td></tr>";
        echo "\t" ."NAME : " . $row["name"]. "\t". "EMAIL : " . $row["email"] . "\t". "RATE : " . $row["rate"] . "\t". "FEEDBACK : " . $row["feedback"];
        echo "<br>";
    }
    
    echo"</table>";
    mysqli_close(($connection));
  }
?>

