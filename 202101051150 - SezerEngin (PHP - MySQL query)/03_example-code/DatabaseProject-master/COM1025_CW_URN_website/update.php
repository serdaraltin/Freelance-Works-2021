<?php
if (isset($_POST['action']) && !empty($_POST['Sponsor'])) {
    switch ($_POST['action']) {
        case 'add':
            $Sponsor = trim(htmlspecialchars($_POST['Sponsor']));
            
            $stmt = $conn->prepare('INSERT INTO PlayerSponsors (PlayerID, SponsorName) VALUES(?, ?)');
            if (!$stmt) {
                echo 'Prepare failed: (' . $conn->errno . ') ' . $conn->error;
            }
            if (!$stmt->bind_param('is', $_POST['Player'], $Sponsor)) {
                echo 'Binding parameters failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            if (!$stmt->execute()) {
                echo 'Execute failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            $stmt->close();
            break;

        case 'update':
            $stmt = $conn->prepare('UPDATE PlayerSponsors SET PlayerID=?, SponsorName=? WHERE PlayerID=? AND SponsorName=?');
            if (!$stmt) {
                echo 'Prepare failed: (' . $conn->errno . ') ' . $conn->error;
            }
            if (!$stmt->bind_param('isis', $_POST['Player'], $_POST['Sponsor'], $_POST['_Player'], $_POST['_Sponsor'])) {
                echo 'Binding parameters failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            if (!$stmt->execute()) {
                echo 'Execute failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            $stmt->close();
            break;

        case 'delete':
            $stmt = $conn->prepare('DELETE FROM PlayerSponsors WHERE PlayerID=? AND SponsorName=?');
            if (!$stmt) {
                echo 'Prepare failed: (' . $conn->errno . ') ' . $conn->error;
            }
            if (!$stmt->bind_param('is', $_POST['_Player'], $_POST['_Sponsor'])) {
                echo 'Binding parameters failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            if (!$stmt->execute()) {
                echo 'Execute failed: (' . $stmt->errno . ') ' . $stmt->error;
            }
            $stmt->close();
            break;

        default:
            break;
    }
}
