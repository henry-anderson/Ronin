## DKPCounter
* <a href="syntax.md">Syntax</a>
* <a href="examples.md">Example Syntax</a>
* <a href="points.md">Points Awarded</a>
## Syntax

The syntax is the most important aspect to the software. If it is incorrect DKP will not be counted.

### Bosses
<pre>[boss] [stars] [camp/kill] on [player1, player2, player3...]</pre>

* **[boss]** Represents the name of the boss. See the list below for aliases.
* **[stars]** The number of stars. Using the word "main" is not sufficient
  - Must be either 4, 5, or 6.
  - It is important to note that even for raids such as Mordris and Gelebron the stars must be specified.
* **[camp/kill]** Whether the points should be awarded as kill or camp points. Using "campkill" awards points for both.
  - Must be either camp, kill, or campkill.
* **[players]** This is a list of all the players that were in the group separated by a comma and space
  - Case insensitive but the names must be spelt correctly
  
  The characters "/" and "\\" are replaced with a space. "*" and "'" are removed from the string all together. This creates  some leniency on the syntax such as using "215/5 kill on..." or "snorri 6* kill on..."
  
  
#### Examples
<pre>Snorri 4 camp on Thallen, Lutece, kneeSlapper</pre>
<pre>180 4 camp on thallen, lutece, Kneeslapper</pre>
<pre>Sreng 4 campkill on Thallen, Pathetic Healz, Alvain, Cat Balou</pre>
<pre>Spider 5 kill on Thallen, Crawlin, Sugar Kane</pre>
<pre>215 6 camp on Thallen, Kilzalot, Eban, Valla Rees, Kiara Evangelin</pre>
<pre>aggy 6 kill on Thallen, Unpleased, dragon shade</pre>
<pre>necro 6 kill on TimeShift, ExBlood, Hugh Jaynus</pre>

### Camping
<pre>camped [hours] hour(s) on [player]</pre>
* **[hours]** An integer representing the amount of hours the player spent camping a raid boss.
  - Values containing decimals will not be counted.
* **[player]** The name of the player.

#### Examples
<pre>camped 2 hours on spiritaldeath</pre>
<pre>camped 1 hour on lark</pre>
<pre>camped 6 hours on valla rees</pre>

### Leveling
<pre>level [start]-[finish] on [player]</pre>
* **[start]** An integer representing the level the player started at
  - This must be an integer greater or equal to 155 
* **[end]** An integer representing the level the player ended at
  - This must be an integer greater than the starting value and less than or equal to 240
* **[player]** The name of the player.

#### Examples
<pre>level 210-215 on cogs</pre>
<pre>level 180-190 on slowking</pre>
<pre>level 155-220 on thallen</pre>
___

### Parking
<pre>[boss] [stars] park on [player]</pre>
* **[boss]** Represents the name of the boss. See the list below for aliases.
* **[stars]** The number of stars. Using the word "main" is not sufficient
  - Must be 6 as park points are only awarded for raids.
* **[player]** The name of the player
  - Case insensitive but the names must be spelt correctly
  

### Player Aliases
Player aliases are aliases that can be used instead of entering the players entire name. This is mainly used to fix simple errors, but can also be used to simplify the process. The current list of player aliases being used can be found <a href="../../docs/count/aliases.txt">here</a>. If you would like to request an alias submit a pull request with the desired changes.

<pre>mordi 5 kill on sundrop</pre>

This example would award the points to "sundropkiss" instead of "sundrop" since it is on the list of aliases.

### Boss Names and Aliases
* **155**: 155, spider, spidey, ulrob
* **160**: 160, priest
* **165**: 165, king
* **170**: 170, sreng, bolg
* **180**: 180, snorri, snor, snorr, troll
* **185**: 185, dog, doggy, dogg, ifryn
* **190**: 190, skath, magister
* **195**: 195, gron, general
* **200**: 200, krother, imp
* **205**: 205, cragskor, dragon
* **210**: 210, revenant, anguish
* **215**: 215, unox, eye
* **Aggragoth**: aggragoth, aggy, agg
* **Hrungnir**: hrungnir, hrung, hippo
* **Mordris**: mordris, mordy, mordi
* **Efnisien**: efnisien, efni, necromancer, necro
* **Proteus Base**: proteusbase, proteus_base, protb, base
* **Proteus Prime**: proteusprime, proteus_prime, protp, prime
* **Gelebron**: gelebron, gele, gel
* **Bloodthorn**: bloodthorn, bt, blood, thorn
* **Bloodthorn Root (5)**: bloodthornroot, bloodthorn_root, btroot, root
* **Factions**: factions, faction, lich, reaver
* **Ring Boss**: ringboss, ring_boss, rb, rbs, ring
* **Legacy 150-179**: legacy150, legacy_150, witchfinder, hopkins, comrack, akais, hurricanes, typhoons, garyn, devestator, jalan, paradai, blizzardgore, synak
* **Legacy 180+**: legacy180, legacy_180, natan, athatch, garanak, gara, urchaid, maelstrom, whirlwinds, whirlwind, smolach, annihilator, skain, osan, blight, tomb
* **Urchaid**: urchaid, urch
* **Garanak**: garanak, gara, garan, garank
* **Skain**: skain, skai
