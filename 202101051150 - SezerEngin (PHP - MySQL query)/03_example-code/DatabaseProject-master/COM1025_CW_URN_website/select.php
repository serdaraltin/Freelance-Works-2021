<?php
if (isset($_POST["data"])) {
    switch ($_POST["data"]) {
        case "standings":
            $res = $conn->query(
                "SELECT Forename, Lastname, Tag, Position FROM placement as pla
                INNER JOIN Player pl ON pl.PersonID=pla.PlayerID
                INNER JOIN Person p ON p.ID=pl.PersonID
                WHERE pla.TournamentID=2
                ORDER BY Position ASC"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>

            <table style="position: absolute; top: 100px; right: 60px;">
                <tr>
                    <th>Forename</th>
                    <th>Surname</th>
                    <th>Tag</th>
                    <th>Position</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Forename'] . '</td>';
                    echo '<td>' . $row['Lastname'] . '</td>';
                    echo '<td>' . $row['Tag'] . '</td>';
                    echo '<td>' . $row['Position'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>
            <?php
            break;

        case "winners":
            $res = $conn->query(
                "SELECT Tag, Position, Amount FROM Placement pla
                INNER JOIN Player pl ON pl.PersonID=pla.PlayerID
                INNER JOIN Prize p ON pla.ID=p.PlacementID
                WHERE pla.TournamentID=1"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>

            <table style="position: absolute; top: 100px; right: 103px;">
                <tr>
                    <th>Tag</th>
                    <th>Position</th>
                    <th>Amount ($)</th>
                <tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Tag'] . '</td>';
                    echo '<td>' . $row['Position'] . '</td>';
                    echo '<td>' . $row['Amount'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>
            <?php
            break;

        case "spectators":
            $res = $conn->query(
                "SELECT DISTINCT Forename, Lastname, Tag FROM Matches m
                INNER JOIN Player pl ON m.Player1ID=pl.PersonID OR m.Player2ID=pl.PersonID
                INNER JOIN Person p ON p.ID=pl.PersonID
                WHERE m.TournamentID=2"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>

            <p style='position:absolute; top: 60px; right:300px;'>Players:</p>
            <table style='position:absolute; top: 100px; right:95px;'>
                <tr>
                    <th>Forename</th>
                    <th>Lastname</th>
                    <th>Tag</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Forename'] . '</td>';
                    echo '<td>' . $row['Lastname'] . '</td>';
                    echo '<td>' . $row['Tag'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>

            <?php
            $res = $conn->query(
                "SELECT Forename, Lastname FROM attended a  
                INNER JOIN person p ON a.PersonID=p.ID
                WHERE a.TournamentID=2 AND NOT EXISTS 
                (
                SELECT Player1ID, Player2ID FROM Matches m
                WHERE m.TournamentID=2 AND
                (a.PersonID=m.Player1ID OR a.PersonID=m.Player2ID)
                )"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>    
        
            <p style='position: absolute; top: 310px; right:278px;'>Spectators:</p>
            <table style='position: absolute; top: 350px; right:190px;'>
                <tr>
                    <th>Forename</th>
                    <th>Lastname</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Forename'] . '</td>';
                    echo '<td>' . $row['Lastname'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>
            <?php
            break;

        case "pros":
            $res = $conn->query(
                "SELECT DISTINCT Forename, Lastname, Tag, SponsorName FROM Matches m
                INNER JOIN Player pl ON m.Player1ID=pl.PersonID OR m.Player2ID=pl.PersonID
                INNER JOIN Person p ON p.ID=pl.PersonID
                INNER JOIN PlayerSponsors ps ON ps.PlayerID=pl.PersonID
                WHERE m.TournamentID=1"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>

            <p style='position:absolute; top: 60px; right:363px;'>Pros:</p>
            <table style='position: absolute; top: 100px; right: 74px;'>
                <tr>
                    <th>Forename</th>
                    <th>Lastname</th>
                    <th>Tag</th>
                    <th>Sponsors</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Forename'] . '</td>';
                    echo '<td>' . $row['Lastname'] . '</td>';
                    echo '<td>' . $row['Tag'] . '</td>';
                    echo '<td>' . $row['SponsorName'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>
            
            <?php
            $res = $conn->query(
                "SELECT DISTINCT Forename, Lastname, Tag FROM Matches m
                INNER JOIN Player pl ON m.Player1ID=pl.PersonID OR m.Player2ID=pl.PersonID
                INNER JOIN Person p ON p.ID=pl.PersonID
                LEFT JOIN PlayerSponsors ps ON ps.PlayerID=pl.PersonID
                WHERE m.TournamentID=1 AND ISNULL(ps.SponsorName)"
                );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>
            
            <p style='position: absolute; top: 310px; right: 331px;'>Amateurs:</p>
            <table style='position: absolute; top: 350px; right:178px;'>
                <tr>
                    <th>Forename</th>
                    <th>Lastname</th>
                    <th>Tag</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Forename'] . '</td>';
                    echo '<td>' . $row['Lastname'] . '</td>';
                    echo '<td>' . $row['Tag'] . '</td>';
                    echo '</tr>';
                }
                $res->free(); ?>
            </table>
            <?php
            break;

        case "country_stats":
            $res = $conn->query(
                "SELECT Country, COUNT(ID) AS Count FROM Person
                GROUP BY Country
                ORDER BY Count DESC"
            );
            if (!$res) {
                echo "Query failed: (" . $conn->errno . ") " . $conn->error;
            } ?>
            
            <table style='position: absolute; top: 100px; right: 222px;'>
                <tr>
                    <th>Country</th>
                    <th>Count</th>
                </tr>
                <?php
                while ($row = $res->fetch_assoc()) {
                    echo '<tr>';
                    echo '<td>' . $row['Country'] . '</td>';
                    echo '<td>' . $row['Count'] . '</td>';
                    echo '</tr>';
                } ?>
            </table>
            <?php
            break;
    }
}
?>