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

function countPoints(formatted) {
	this.countPoints(formatted, false, 0);
}

function countPoints(formatted, allowAttempts, percent) {
    let split = formatted.split("\n");
    for(let i = 0; i < split.length; i++) {
        let line = split[i];
        if(line.length > 0) {
			let onSplit = line.split(" on ", 2);
            let syntax = onSplit[0].trim();
			if(lineContainsBoss(syntax)) {
	            let parser = new BossPointParser(line);
	            if (parser.pointType === PointType.KILL) {
	                let points = getKillPoints(parser.boss, parser.stars);
	                for (let j = 0; j < parser.players.length; j++) {
						let player = parser.players[j].trim();
						addPoints(getPlayerFromAlias(player), points);
	                }
	            } else if (parser.pointType === PointType.CAMP) {
	                let points = parser.boss.points.camp;
	                for (let j = 0; j < parser.players.length; j++) {
	                    let player = parser.players[j].trim();
	                    addPoints(getPlayerFromAlias(player), points);
	                }
	            } else if (parser.pointType === PointType.CAMP_KILL) {
	                let points = getKillPoints(parser.boss, parser.stars) + parser.boss.points.camp;
	                for (let j = 0; j < parser.players.length; j++) {
	                    let player = parser.players[j].trim();
	                    addPoints(getPlayerFromAlias(player), points);
	                }
				} else if (parser.pointType === PointType.PARK) {
					let points = parser.boss.points.park;
					for (let j = 0; j < parser.players.length; j++) {
						let player = parser.players[j].trim();
						addPoints(getPlayerFromAlias(player), points);
					}
	            } else if (parser.pointType === PointType.ATTEMPT && allowAttempts && parser.boss.points.attempt == true) {
					let points = parser.boss.points.kill6* (percent / 100);
					console.log(points);
					for (let j = 0; j < parser.players.length; j++) {
						let player = parser.players[j].trim();
						addPoints(getPlayerFromAlias(player), points);
					}
				}
			}
			else if(lineContainsBonusType(syntax)) {
				let bonusTypeAlias = getBonusTypeAlias(syntax);
				let bonusType = getBonusType(bonusTypeAlias);
				if(bonusType === BonusType.CAMP) {
					let parser = new CampPointParser(line);
					let points = parser.hours * BonusType.CAMP.points;
					addPoints(getPlayerFromAlias(parser.player), points);
				}
				else if(bonusType === BonusType.LEVEL) {
					let parser = new LevelPointParser(line);
					let points = parser.levels * BonusType.LEVEL.points;
					addPoints(getPlayerFromAlias(parser.player), parser.levels);
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