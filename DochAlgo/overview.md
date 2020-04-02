## Formula
<img src="https://render.githubusercontent.com/render/math?math=r%20%3D%20xy%20%2F%20(c%20%2B%201)" width="125">
<b>r</b>: The players rating<br />
<b>x</b>: The combined lifetime DKP of the player across all accounts<br />
<b>y</b>: The combined DKP accumulated over the last 90 days<br />
<b>c</b>: The amount of confluxes (class specific or pureness) already given to the player combined with the amount of confluxes we would be investing in the player if they were to win their next piece of armor.

The player with the highest rating receives the next piece of Doch Gul in the order of gloves, chest, legs, boots, helm. Standardizing the player's rating with the amount of purenesses currently invested allows for comparison across players with other pieces and lets all players in a certain category

Whether the amount of purenesses or class specific confluxes is used depends on the limiting factor. Class specific confluxes are used for rangers and rogues while purenesses are used for warriors, mages, and druids. 

As an example, it would require 7 class specific confluxes to give a ranger who already has 
<img src="https://render.githubusercontent.com/render/math?math=c%20=%207"> ranger who already has gloves
<table>
 <tr>
  <td>Piece</td>
  <td>Class Conflux</td>
  <td>Pureness</td>
  <td rowspan="6">

As an example, <img src="https://render.githubusercontent.com/render/math?math=c%20=%207"> for a ranger who already has gloves because they would have used 7 total class specific confluxes to create their chest.

If that player was a druid, <img src="https://render.githubusercontent.com/render/math?math=c%20=%206">, because pures are used instead as that is the limiting factor for warriors, mages, and druids and it would take 6 purenesses to create the player's chest.

Suppose the player was a rogue and hasn't received any Doch Gul. In this sitation <img src="https://render.githubusercontent.com/render/math?math=c%20=%202"> as it would take two class specific confluxes to create their gloves.


</td>
 </tr>
  <tr>
  <td>Gloves</td>
  <td>2</td>
  <td>1</td>
 </tr>
   <tr>
  <td>Boots</td>
  <td>3</td>
  <td>2</td>
 </tr>
   <tr>
  <td>Helm</td>
  <td>4</td>
  <td>3</td>
 </tr>
   <tr>
  <td>Legs</td>
  <td>5</td>
  <td>4</td>
 </tr>
  <tr>
  <td>Chest</td>
  <td>5</td>
  <td>5</td>
 </tr>

</td>
</table
