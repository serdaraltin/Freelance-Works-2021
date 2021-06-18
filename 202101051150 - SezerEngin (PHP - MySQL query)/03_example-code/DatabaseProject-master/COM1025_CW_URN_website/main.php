<?php
    define('MYSQL_SERVER', 'localhosts');
    define('MYSQL_USER', 'root');
    define('MYSQL_PASSWORD', '');
    define('MYSQL_DATABASE', 'tournaments_db');

    $conn = new mysqli(MYSQL_SERVER, MYSQL_USER, MYSQL_PASSWORD, MYSQL_DATABASE);

    if ($conn->connect_error) {
        die('Connection failed: ' . $conn->connect_error);
    }

    include 'update.php'; 

    $res = $conn->query('SELECT PersonID, Tag FROM Player');
    if (!$res) {
        echo 'Query failed : (' . $conn->errno . ') ' . $conn->error;
    }

    $playerTags = $res->fetch_all(MYSQLI_ASSOC);  
    $res->free();

    function emitTagSelector($value)
    {
        global $playerTags;
        echo '<select name="Player">';
        foreach ($playerTags as $tag) {
            echo '<option ';
            echo ($tag['PersonID'] === $value) ? 'selected' : '';
            echo ' value="'. $tag['PersonID'] .'">' . $tag['Tag'];
            echo '</option>';
        }
        echo '</select>';
    }
?>

<!DOCTYPE html>
<html>
    <head>
        <title> Pretty HTML Page </title>
        <style>
            table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            }
            th, td {
                padding: 5px;
            }
        </style>
    </head>

    <body>
      
        <form method="POST">
            <input type="checkbox" name="person">Person Table<br>
            <input type="checkbox" name="player">Player Table<br>
            <input type="checkbox" name="tournament">Tournaments Table<br>
            <input type="submit" style="margin-top: 5px;">
        </form>
 
        <table style="position:absolute; top: 10px; left: 600px;">
            <tr>
                <th>Tag</th>
                <th>Sponsor</th>
            </tr>
            <?php
            $res = $conn->query('SELECT PlayerID, SponsorName FROM PlayerSponsors');
            if (!$res) {
                echo 'Query failed: (' . $conn->errno . ') ' . $conn->error;
            }

            while ($row = $res->fetch_assoc()) { ?>
                <tr>
                    <form method="POST">
                        <td>
                            <?php emitTagSelector($row['PlayerID']) ?>
                        </td>
                        <td>
                            <input size="7" type="text" name="Sponsor" value="<?php echo $row['SponsorName'] ?>">
                        </td>
                        <td>
                            <input type="submit" name="action" value="update">
                            <input type="submit" name="action" value="delete">
                            <input type="hidden" name="_Player" value="<?php echo $row['PlayerID'] ?>"> 
                            <input type="hidden" name="_Sponsor" value="<?php echo $row['SponsorName'] ?>">
                        </td>
                    </form>
                </tr>
            <?php
            }
            $res->free(); ?>
            <tr>
                <form method="POST">
                    <td>
                        <?php emitTagSelector(null) ?> 
                    </td>
                    <td>
                        <input size="7" type="text" name="Sponsor">
                    </td>
                    <td>
                        <input style="width: 56px;" type="submit" name="action" value="add">
                    </td>
                </form>
            </tr>
        </table>
     
        <table style="position: absolute; top: 400px; left: 600px;">
            <tr>
                <th>Tag</th>
                <th>Sponsor</th>
            </tr>
            <?php
            $res = $conn->query('SELECT Tag, SponsorName FROM PlayerSponsors s INNER JOIN Player p ON s.PlayerID=p.PersonID');
            if (!$res) {
                echo 'Query failed: (' . $conn->errno . ') ' . $conn->error;
            }

            while ($row = $res->fetch_assoc()) {
                echo '<tr>';
                echo '<td>' . $row['Tag'] . '</td>';
                echo '<td>' . $row['SponsorName'] . '</td>';
                echo '</tr>';
            }
            $res->free(); ?>
        </table>
        
        <form style="position: absolute; right: 100px; top: 10px;" method="POST">
            <select name="data">
                <option value="standings">BBTag Standings</option>
                <option value="winners">Tekken Winners</option>
                <option value="spectators">BBtag players and spectators</option>
                <option value="pros">Tekken pros and amateurs</option>
                <option value="country_stats"> Country Stats </option>
            </select>
            <input style="margin-top: 5px;" type="submit">
        </form>

        <?php
        include 'checkbox.php';    
        include 'select.php';      
        ?>
    </body>
</html>

<?php
$conn->close(); 
?>