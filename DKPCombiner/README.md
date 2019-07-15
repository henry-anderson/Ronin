# DKPCombiner

This program combines DKP counts from different group into a total, final count.

## Usage

The program takes an input in the following format.
<pre>[player], [points]</pre>
Where [player] represents the player's name and [points] is an integer representing the amount of points the player has.
Groups are separated with a newline. Here is an example combining the counts from three different groups.

<pre>
Thallen, 5
Kilzalot, 15
TimeShift, 24

Kilzalot, 8
Zenoia, 10
Thallen, 20

Kilzalot, 10
</pre>
The output would look like this.

<pre>
kilzalot, 33
thallen, 25
timeshift, 24
zenoia, 10
</pre>

Player names are not case sensitive so capitalization is irrelevant.
