pointsMap = new Map();

function addPoints(player, points) {
    if(pointsMap.get(player) != undefined) {
        let currentPoints = pointsMap.get(player);
        let total = currentPoints + points;
        pointsMap.set(player, total);
    }
    else {
        pointsMap.set(player, points);

    }
}

function countPoints(formatted) {
    let split = formatted.split("\n");
    for(let i = 0; i < split.length; i++) {
        let line = split[i];
        if(line.length > 0) {
            let parser = new PointParser(line);
            if (parser.pointType === PointType.KILL) {
                let points = getKillPoints(parser.boss, parser.stars);
                for (let j = 0; j < parser.players.length; j++) {
                    let player = parser.players[j].trim();
                    addPoints(player, points);
                }
            } else if (parser.pointType === PointType.CAMP) {
                let points = parser.boss.points.camp;
                for (let j = 0; j < parser.players.length; j++) {
                    let player = parser.players[j].trim();
                    addPoints(player, points);

                }
            } else if (parser.pointType === PointType.CAMP_KILL) {
                let points = getKillPoints(parser.boss, parser.stars) + parser.boss.points.camp;
                for (let j = 0; j < parser.players.length; j++) {
                    let player = parser.players[j].trim();
                    addPoints(player, points);
                }
            }
        }
    }
    return getFormattedPoints();
}

function getFormattedPoints() {
    let count = "";
    for (let [player, points] of new Map([...pointsMap.entries()].sort())) {     // get data sorted
        count += player + ", " + points + "\n";

    }
    pointsMap.clear();
    return count;
}