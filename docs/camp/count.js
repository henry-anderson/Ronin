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
			let onSplit = line.split(" on ", 2);
            let syntax = onSplit[0].trim();
			if(lineContainsBonusType(syntax)) {
				let bonusTypeAlias = getBonusTypeAlias(syntax);
				let bonusType = getBonusType(bonusTypeAlias);
				if(bonusType === BonusType.CAMP) {
					let parser = new CampPointParser(line);
					let points = parser.hours * BonusType.CAMP.points;
					addPoints(getPlayerFromAlias(parser.player), points);
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