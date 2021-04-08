CREATE TABLE IF NOT EXISTS User (
                        email varchar(30) DEFAULT NULL,
                        userId varchar(30) DEFAULT NULL,
                        username varchar(20) DEFAULT NULL,
                        playerlevel int(11) DEFAULT NULL,
                        password varchar(50) DEFAULT NULL,
                        sessionFlag int(11) DEFAULT NULL,
                        activeTournament int(11) DEFAULT NULL,
                        LoginTime varchar(15) DEFAULT NULL
);