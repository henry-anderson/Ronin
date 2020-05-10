function BossPointParser(line) {
    this.line = line.toLowerCase();
    let splitOn = this.line.split(" on ");
    let first = splitOn[0];
    if(splitOn[1].includes(".")) {
        this.players = splitOn[1].split(".");
    }
    else {
        this.players = splitOn[1].split(",");
    }
    let keywords = first.split(" ");
    this.boss = getBoss(keywords[0]);
    this.stars = parseInt(keywords[1]);
    this.pointType = getPointType(keywords[2]);
}

function lineContainsBoss(line) {
    if(getAlias(line) != null) {
        return true;
    }
    return false;
}
function getAlias(line) {
    for(let i = 0; i < getBosses().length; i++) {
        let boss = getBosses()[i];
        for(let j = 0; j < boss.aliases.length; j++) {
            let alias = boss.aliases[j];
            if(line.includes(alias + " ")) {
                return alias;
            }
        }
    }
    return null;
}

function lineContainsPointType(line) {
    for(let i = 0; i < getPointTypes().length; i++) {
        let type = getPointTypes()[i];
        for(let j = 0; j < type.length; j++) {
            let alias = type[j];
            if(line.includes(" " + alias)) {
                return true;
            }
        }
    }
    return false
}

//filters out all the typos and such
function formatInput(text, playerAliases) {
    let splitText = text.split("\n");
    let formatted = "";
    for (let i = 0; i < splitText.length; i++) {
        let line = splitText[i].toLowerCase();
        if(line.includes(" on ")) {
            let onSplit = line.split(" on ", 2);
            let syntax = onSplit[0].trim().replace("/", " ").replace("\\", " ").replace("*", "").replace("'", "");
            let players = onSplit[1].trim();
            if (lineContainsBoss(syntax) && lineContainsPointType(syntax)) {
                let alias = getAlias(syntax);
                let formattedLine = (alias + syntax.split(alias, 2)[1]) + " on " + players;
                let split = formattedLine.split(" ");
                let stars = split[1].replace("*", "");
                if (split.length > 2 && ((stars === "4") || (stars === "5") || stars === "6")) {
                    formatted += formattedLine + "\n";
                }
            }
        }
    }
    return formatted;
}
