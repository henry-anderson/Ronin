# CombinedDKP

This program combines lifetime, 45 day, and 90 day DKP across all accounts owned by a player along with the player's main account's 90 day activity.

## Usage

This program is run from the command line (Terminal for OS X and Command Prompt for Windows)
<pre>java -jar CombinedDKP.jar /path/to/input.csv</pre>

Before executing the command you will want to first navigate to the folder containing the jar in your command line application. The input file  is a CSV file formatted like the following.

<pre>
Jasperodus,JaspDruid,JaspMage,JaspWarrior,JaspRogue
Ouch,ThatHurts,Go Away,Stop it,0uch
Lark,Sundropkiss,GEM,Avau
Valla Rees,LouiseN,Ivy,Beatrix,Trixii
jezuz09,Ildor Coles,liljezuz
Erandel,Rogue Reaper,tank man,FallenStar,Scope,ice slayer
Giftpilz	
o0Neith0o,Lya,Rendal,Kalipso,Paladax
Bowenarrow,Healemup,Anarchy,Aemis,Slashemup
Dreaded,Dark Hunter,Flamz,Tankzalot
</pre>
The player's main toon is defined as the first name in the list. A file named "combined.csv" will be created in the directory the program is being run from and the output will look like the following.

<pre>
Main,Combined Lifetime,Combined 90 Day Activity,Combined 45 Day Activity,Main 90 Day Activity
jasperodus,102510,4910,3160,4910
ouch,112788,20207,12610,16549
lark,55736,10622,5920,7589
valla rees,51701,13407,6286,7446
jezuz09,50592,2303,1581,1950
erandel,74767,9944,7877,3163
giftpilz,25959,155,60,155
o0neith0o,26272,3520,1707,1325
</pre>

Execution will take 5-10 minutes as it must send an HTTP request to every page on the clan's WebDKP roster. After the clan roster is loaded it will be saved as a backup file in the directory the program is being run from. For quicker execution you can reuse this backup by running the command with a second argument.

<pre>java -jar CombinedDKP.jar /path/to/input.csv /path/to/backup.txt</pre>
