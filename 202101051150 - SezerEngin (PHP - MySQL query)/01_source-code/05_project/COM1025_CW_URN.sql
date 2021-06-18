DROP TABLE IF EXISTS TournamentSponsors;
DROP TABLE IF EXISTS PlayerSponsors;
DROP TABLE IF EXISTS Matches;
DROP TABLE IF EXISTS Prize;
DROP TABLE IF EXISTS Placement;
DROP TABLE IF EXISTS Attended;
DROP TABLE IF EXISTS Tournament;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Person;



DROP TRIGGER IF EXISTS four_hands;
DROP TRIGGER IF EXISTS frauds;
DROP TRIGGER IF EXISTS more_frauds;

CREATE TABLE Tournament (
    ID int UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
    Name varchar(255) NOT NULL,
    Game varchar(255) NOT NULL,
    Venue varchar(255),
    StartDate date,
    EndDate date,
    PRIMARY KEY (ID)
);

CREATE TABLE TournamentSponsors (
    TournamentID int UNSIGNED NOT NULL,
    SponsorName varchar(255) NOT NULL,
    PRIMARY KEY (TournamentID, SponsorName),
    FOREIGN KEY (TournamentID) REFERENCES Tournament(ID)
);

CREATE TABLE Person (
    ID int UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
    Forename varchar(255) NOT NULL,
    Lastname varchar(255) NOT NULL,
    DateOfBirth date,
    Email text(2083),
    Phone varchar(20),
    Country varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE Attended (
    TournamentID int UNSIGNED NOT NULL,
    PersonID int UNSIGNED NOT NULL,
    PRIMARY KEY (TournamentID, PersonID),
    FOREIGN KEY (TournamentID) REFERENCES Tournament(ID),
    FOREIGN KEY (PersonID) REFERENCES Person(ID)
);

CREATE TABLE Player (
    PersonID int UNSIGNED NOT NULL,
    Tag varchar(255) NOT NULL,
    PRIMARY KEY (PersonID),
    FOREIGN KEY (PersonID) REFERENCES Person(ID)
);

CREATE TABLE PlayerSponsors (
    PlayerID int UNSIGNED NOT NULL,
    SponsorName varchar(255) NOT NULL,
    PRIMARY KEY (PlayerID, SponsorName),
    FOREIGN KEY (PlayerID) REFERENCES Player(PersonID)
);

CREATE TABLE Matches (
    ID int UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
    TournamentID int UNSIGNED NOT NULL,
    Player1ID int UNSIGNED NOT NULL,
    Player2ID int UNSIGNED NOT NULL,
    P1Score int UNSIGNED NOT NULL,
    P2Score int UNSIGNED NOT NULL,
    PRIMARY KEY (ID),
    -- To check the player is actually attending the tournament before making him play matches:
    FOREIGN KEY (TournamentID, Player1ID) REFERENCES Attended(TournamentID, PersonID),
    FOREIGN KEY (TournamentID, Player2ID) REFERENCES Attended(TournamentID, PersonID)
);

CREATE TABLE Placement (
    ID int UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
    TournamentID int UNSIGNED NOT NULL,
    PlayerID int UNSIGNED NOT NULL,
    Position int UNSIGNED NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (TournamentID, PlayerID) REFERENCES Attended(TournamentID, PersonID)
);

CREATE TABLE Prize (
    PlacementID int UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
    Amount float UNSIGNED NOT NULL,
    PRIMARY KEY (PlacementID),
    FOREIGN KEY (PlacementID) REFERENCES Placement(ID)
);

-- Changhing the delimiter to // allowing ; to be used for multi line statements
DELIMITER //

-- Prevents the same player being inserted as player 1 and 2 at the same time for a match
CREATE TRIGGER four_hands BEFORE INSERT ON Matches
    FOR EACH ROW
    BEGIN
        DECLARE msg varchar(128);
        IF NEW.Player1ID = NEW.Player2ID THEN
            SET msg = concat("MyTriggerError: Player ", CAST(NEW.Player1ID AS CHAR), " cant play against himself!");
            SIGNAL SQLSTATE "45000" SET message_text = msg;
        END IF;
    END;//

-- Prevents player which is attending the tournament as spectator (no matches played) from being inserted in Placement
CREATE TRIGGER more_frauds BEFORE INSERT ON Placement
    FOR EACH ROW
    BEGIN
        DECLARE msg varchar(128);
        IF NEW.PlayerID NOT IN (
            SELECT Player1ID FROM Matches m
            WHERE m.TournamentID=NEW.TournamentID
            UNION
            SELECT Player2ID FROM Matches m
            WHERE m.TournamentID=NEW.TournamentID
        ) THEN 
            SET msg = concat("MyTriggerError: Player ", CAST(NEW.PlayerID AS CHAR),  " is a spectator for this tourney and cannot therefore have a placement");
            SIGNAL SQLSTATE "45000" SET message_text = msg;
        END IF;
END;//

-- Changing delimiter back to ;
DELIMITER ;

INSERT INTO
    Tournament (Name, Game, Venue, StartDate, EndDate)
VALUES
    ("FGC AL #40", "Tekken 7", "3 S York Rd, Hatboro, PA 19040, USA", "2019-12-26", "2019-12-26"),
    ("FGC AL #40", "BBTag", "3 S York Rd, Hatboro, PA 19040, USA", "2019-12-26", "2019-12-26");

INSERT INTO
    TournamentSponsors (TournamentID, SponsorName)
VALUES
    (2, "Bed Rull"),
    (2, "Pocky");

INSERT INTO
    Person (Forename, Lastname, DateOfBirth, Email, Phone, Country)
VALUES
    ("Shameek","Simmons", "1999-12-26", null, null, "UK"),
    ("Gregory",  "Kelley",  "1998-12-26",  null,  null,  "US"),
    ("Chloe", "Keith", "1992-12-26",  null,  null,  "US"),
    ("Jenna", "Lawrence", "1989-12-26", null, null, "US"),
    ("Evan", "Browning", "1997-12-26", null, null, "US"),
    ("Dameian", "Winns", "1997-12-26", null, null, "NZ"),
    ("Daniel", "Scotts", "2000-12-26", null, null, "AUS"),
    ("Daniel", "Lewis", "1995-12-26", null, null, "UK"),
    ("Scott", "Scotts", "2001-12-26", null, null, "US"),
    ("Alexander", "Collazo", "1994-12-26", null, null, "MEX"),
    ("Random", "Name", "1990-12-26", null, null, "US"),
    ("Barack", "Obama", "1990-12-26", null, null, "US"),
    ("Kevin", "Kevins", "2000-12-26", null, null, "US"),
    ("Ryan", "Crowes", "2000-12-26", null, null, "US"),
    ("Justin", "Ruffling", "1999-12-26", null, null, "AUS"),
    ("Tyler", "P", "1999-12-26", null, null, "US"),
    ("Seth", "Hoffman", "1997-12-26", null, null, "US"),
    ("Canthink", "Aname", "1997-12-26", null, null, "MEX"),
    ("Pog", "Champ", "1993-12-26", null, null, "US"),
    ("Sam", "Sora", "1992-12-26", null, null, "US"),
    ("Justin", "Wong", "1994-12-26", null, null, "CHN"),
    ("Nairobi", "Nairo", "1995-12-26", null, null, "US");

INSERT INTO
    Attended (TournamentID, PersonID)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8),
    (1, 9),
    (1, 10),
    (1, 11),
    (1, 12),
    (1, 13),
    (1, 14),
    (2, 15),
    (2, 16),
    (2, 17),
    (2, 18),
    (2, 19),
    (2, 20),
    (2, 21),
    (2, 22),
    (2, 12),
    (2, 13),
    (2, 3),
    (2, 9);

INSERT INTO
    Player (PersonID, Tag)
VALUES
    (1, "Meeks"),
    (2, "iVesperX"),
    (5, "BigDame21"),
    (6, "Phatb0i"),
    (8, "Lex Steel"),
    (9, "Scott"),
    (10, "AxEL"),
    (13, "RyenV"),
    (14, "Kevin"),
    (15, "boom"),
    (16, "Tturtle"),
    (17, "Vyers"),
    (22, "Pizza Piegrus"),
    (19, "Fight Haver");

INSERT INTO
    PlayerSponsors (PlayerID, SponsorName)
VALUES
    (1, "DTS"),
    (2, "FS"),
    (5, "WD"),
    (8, "WISH"),
    (10, "DTS"),
    (13, "DTS"),
    (15, "PRO"),
    (15, "DTS");

INSERT INTO
    Matches (TournamentID, Player1ID, Player2ID, P1Score, P2Score)
VALUES
    (1, 14, 9, 0, 2),
    (1, 10, 14, 2, 0),
    (1, 1, 9, 2, 0),
    (1, 13, 5, 1, 2),
    (1, 2, 8, 2, 0),
    (1, 6, 10, 2, 1),
    (1, 10, 8, 0, 2),
    (1, 13, 9, 1, 2),
    (1, 1, 5, 2, 0),
    (1, 2, 6, 2, 1),
    (1, 5, 8, 2, 1),
    (1, 6, 9, 2, 0),
    (1, 1, 2, 2, 3),
    (1, 5, 6, 2, 0),
    (1, 1, 5, 3, 0),
    (1, 2, 1, 0, 3),
    (1, 1, 2, 3, 2),
    (2, 17, 22, 3, 1),
    (2, 19, 13, 3, 0),
    (2, 15, 17, 3, 0),
    (2, 16, 19, 3, 1),
    (2, 16, 22, 3, 1),
    (2, 17, 13, 2, 3),
    (2, 16, 13, 3, 1),
    (2, 15, 19, 3, 0),
    (2, 19, 16, 1, 3),
--  (2, 15, 15, 3, 0), Remove single comments to check Matches' triggers
    (2, 15, 16, 3, 0);

INSERT INTO
    Placement (TournamentID, PlayerID, Position)
VALUES
    (1, 1, 1),
    (1, 2, 2),
    (1, 5, 3),
    (1, 6, 4),
    (1, 8, 5),
    (1, 9, 5),
    (1, 10, 7),
    (1, 13, 7),
    (1, 14, 9),
    (2, 15, 1),
    (2, 16, 2),
    (2, 19, 3),
    (2, 13, 4),
    (2, 22, 5),
--  (1, 17, 1),  Check Placement's trigger
    (2, 17, 5);

INSERT INTO
    Prize (PlacementID, Amount)
VALUES
    (1, 55),
    (2, 25),
    (3, 10),
    (10, 35),
    (11, 15),
    (12, 10);
