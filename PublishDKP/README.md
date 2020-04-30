# PublishDKP

This program takes a list of players followed by a number of points to award and submits them to WebDKP.

## Configuration

Before PublishDKP can be used it must be configured. There should be a config.txt file in the same folder as the jar file. This is the configuration file and it will look something like this.

<pre>
url: https://www.webdkp.com/dkp/Reborn/Ronin
username: username123
password: password123
</pre>

The "url" parameter is the URL of the table while "username" and "password" refer to admin login information required to modify the table.

## Usage

The program takes an input in the following format.
<pre>[player], [points]</pre>
Where [player] represents the player's name and [points] is an integer representing the amount of points to be added to the player's WebDKP profile.

To use it simply enter a list such as the following and press the "Publish" button.

<pre>
TimeShift, 55
Thallen, 182
Unpleased, 505
</pre>

This will add the specified amount of points to the player on WebDKP. If the player doesn't exist in the WebDKP table they will be created.

Loot awards can also be added to WebDKP automatically using the following syntax.
<pre>
[player] -[points] for [item]
</pre>

Only negative values may be used.

<pre>
Mag1calme -50 for Dark Skull of Freeze
Krozone - 3333 for Royal Necral Ring of Blood
ExBlood - 2815 for Darkscale Helm of Victory
</pre>


## Libraries

* [HTTPicnic](https://github.com/henry-anderson/HTTPicnic)
* [configJ](https://github.com/henry-anderson/configJ)
* [JSON-java](https://github.com/stleary/JSON-java)
