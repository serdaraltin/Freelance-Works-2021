<?php
if (isset($_POST["person"])) {
    $res = $conn->query(
        "SELECT ID, Forename, Lastname, DateOfBirth, Country, FLOOR(DATEDIFF(CURDATE(), DateofBirth)/365) AS Age FROM Person"
    );
    if (!$res) {
        echo "Query failed: (" . $conn->errno . ") " . $conn->error;
    } ?>  

    <p style='position:relative; top: 10px;'> Persons Table (No Email and Phone columns): </p>
    <table>
        <tr>
            <th>ID</th>
            <th>Forename</th>
            <th>LastName</th>
            <th>Date Of Birth</th>
            <th>Country</th>
            <th>Age</th>
        </tr>
        <?php
        while ($row = $res->fetch_assoc()) {
            echo '<tr>';
            echo '<td>' . $row['ID'] . '</td>';
            echo '<td>' . $row['Forename'] . '</td>';
            echo '<td>' . $row['Lastname'] . '</td>';
            echo '<td>' . $row['DateOfBirth'] . '</td>';
            echo '<td>' . $row['Country'] . '</td>';
            echo '<td>' . $row['Age'] . '</td>';
            echo '</tr>';
        }
    $res->free(); ?>
    </table>
<?php
} ?>

<?php
if (isset($_POST["player"])) {
        $res = $conn->query(
        "SELECT PersonID, Tag FROM Player"
    );
        if (!$res) {
            echo "Query failed: (" . $conn->errno . ") " . $conn->error;
        } ?>    

    <p style='position:relative; top: 10px;'> Player Table: </p>
    <table>
        <tr>
            <th>PersonID</th>
            <th style="text-align: left;">Tag</th>
        </tr>
        <?php
        while ($row = $res->fetch_assoc()) {
            echo '<tr>';
            echo '<td>' . $row['PersonID'] . '</td>';
            echo '<td>' . $row['Tag'] . '</td>';
            echo '</tr>';
        }
        $res->free(); ?>
    </table>
<?php
} ?>

<?php
if (isset($_POST["tournament"])) {
        $res = $conn->query(
        "SELECT ID, Name, Game, StartDate, EndDate, DATEDIFF(StartDate, EndDate) + 1 AS Duration FROM Tournament" 
    );
        if (!$res) {
            echo "Query failed: (" . $conn->errno . ") " . $conn->error;
        } ?>    

    <p style='position:relative; top: 10px;'> Tournaments table (No Venue column): </p>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Game</th>
            <th>StartDate</th>
            <th>EndDate</th>
            <th>Duration (days)</th>
        </tr>
        <?php
        while ($row = $res->fetch_assoc()) {
            echo '<tr>';
            echo '<td>' . $row['ID'] . '</td>';
            echo '<td>' . $row['Name'] . '</td>';
            echo '<td>' . $row['Game'] . '</td>';
            echo '<td>' . $row['StartDate'] . '</td>';
            echo '<td>' . $row['EndDate'] . '</td>';
            echo '<td>' . $row['Duration'] . '</td>';
            echo '</tr>';
        }
        $res->free(); ?>
    </table>
<?php
} ?>