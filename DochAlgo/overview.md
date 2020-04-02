## Rating
<img src="https://render.githubusercontent.com/render/math?math=r%20%3D%20aL_c%20%2F%20c" width="100">
<b>r</b>: The players rating<br />
<b>L<sub>c</sub></b>: The combined lifetime DKP of the player across all accounts<br />
<b>a</b>: The combined DKP accumulated over the last 90 days<br />
<b>c</b>: The amount of confluxes (class specific or pureness) already given to the player combined with the amount of confluxes we would be investing in the player if they were to win their next piece of armor.<br />

The player with the highest rating receives the next piece of Doch Gul in the order of gloves, chest, legs, boots, helm. Standardizing the player's rating with the amount of confluxes currently invested allows for comparison across players with different pieces. This lets all players that fall into a certain class compete with each other instead of separating players based on which pieces they currently have.

The simplicity of the formula comes down to an equal weight between recent activity and past contribution creating a balance between new players and old players. An old player who is still very active will take priority over a new player, but if the old player's activity is limited relative to the new player then they will not.

Whether the amount of purenesses or class specific confluxes is used depends on the limiting factor. Class specific confluxes are used for rangers and rogues while purenesses are used for warriors, mages, and druids. This is due to the fact that we have a surplus of warrior, mage, and druid confluxes. For DPS classes larger pieces are slightly favored as gloves take two class specific confluxes to make while a chest only takes five yet it is 5x stronger than the gloves.

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
</table>

##Eligibility
