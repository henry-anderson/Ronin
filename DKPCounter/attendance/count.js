pointsMap = new Map();

function addPoints(player, points) {
	points = Math.round(points);
    if(pointsMap.get(player) != undefined) {
        let currentPoints = pointsMap.get(player);
        let total = currentPoints + points;
        pointsMap.set(player, total);
    }
    else {
        pointsMap.set(player, points);

    }
}

function countPoints(formatted, bosses) {
    let split = formatted.split("\n");
    for(let i = 0; i < split.length; i++) {
        let line = split[i];
        if(line.length > 0) {
			let onSplit = line.split(" on ", 2);
            let syntax = onSplit[0].trim();
			if(lineContainsBoss(syntax)) {
	            let parser = new BossPointParser(line);
	            if (parser.pointType === PointType.KILL && bosses.includes(parser.boss)) {
	                let points = 1;
	                for (let j = 0; j < parser.players.length; j++) {
						let player = parser.players[j].trim();
						addPoints(getPlayerFromAlias(player), points);
	                }
	            } else if (parser.pointType === PointType.CAMP && bosses.includes(parser.boss)) {
	                let points =1;
	                for (let j = 0; j < parser.players.length; j++) {
	                    let player = parser.players[j].trim();
	                    addPoints(getPlayerFromAlias(player), points);
	                }
	            } else if (parser.pointType === PointType.CAMP_KILL && bosses.includes(parser.boss)) {
	                let points = 1
	                for (let j = 0; j < parser.players.length; j++) {
	                    let player = parser.players[j].trim();
	                    addPoints(getPlayerFromAlias(player), points);
	                }
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