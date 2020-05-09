# Doch Gul
This document defines a procedural and algorithmic approach in deciding which candidates receive pieces of Doch Gul (DG) armor based on an unbias method in which clan leaders control very little of the decision making process. Generals decide on a category of players in which they want to distribute DG pieces too. Eligible players are assigned a rating value based on the lifetime and recent DKP acquired across all of their accounts the highest of which received the next piece of armor they are working towards.

## Categories
Players are separated into four categories based on their class. When the clan is prepared to hand out DG, the Generals vote on one of these categories to decide which piece they would like to create without actually picking the player themselves. This allows strategy and the needs of the clan to continue to be incorporated as a factor in this process. Generally the limiting factor to create DG for rogues and rangers is class specific confluxes while for warriors, druids, and mages it is purenesses. The limiting factor of each category is used to determine each player's rating.
<table>
 <tr>
   <td><b>Ranger</b></td>
   <td><b>Rogue</b></td>
   <td><b>Other (Gloves)</b></td>
   <td><b>Other (Chest+)</b></td>
 </tr>
 <tr>
  <td><i>Class Conflux</i></td>
  <td><i>Class Conflux</i></td>
  <td><i>Pureness</i></td>
  <td><i>Pureness</i></td>
 </tr> 
 <tr>
   <td>All rangers compete with each other for the next piece of Doch Gul regardless of which pieces they currently have.</td>
   <td>All rogues compete with each other for the next piece of Doch Gul regardless of which pieces they currently have.</td>
   <td>Warriors, Mages, and Druids who do not currently have gloves belong to this category.</td>
   <td>Warriors, Mages, and Druids who already have their gloves and are currently working to obtain any other piece of Doch Gul.</td>
 </tr>
</table> 

## Rating
<img src="https://render.githubusercontent.com/render/math?math=r=%20\frac{a_cL_c}{p}" height="40">
<b>r</b>: The players rating<br />
<b>L<sub>c</sub></b>: The combined lifetime DKP of the player across all accounts<br />
<b>a<sub>c</sub></b>: The combined DKP accumulated over the last 90 days<br />
<b>p</b>: The amount of confluxes (class specific or pureness) already given to the player combined with the amount of confluxes we would be investing in the player if they were to win their next piece of armor.
<p />

The player with the highest rating receives the next piece of Doch Gul in the order of gloves, chest, legs, boots, helm. Standardizing the player's rating with the amount of confluxes currently invested allows for comparison across players with different pieces. This lets all players that fall into a certain class compete with each other instead of separating players based on which pieces they currently have.

The simplicity of the formula comes down to an equal weight between recent activity and past contribution creating a balance between new players and old players. This allows new players to thrive in the clan, while still requiring old players to put in the work.

Whether the amount of purenesses or class specific confluxes is used depends on the limiting factor. Class specific confluxes are used for rangers and rogues while purenesses are used for warriors, mages, and druids. This is due to the fact that we have a surplus of warrior, mage, and druid confluxes. For DPS classes larger pieces are slightly favored as gloves take two class specific confluxes to make while a chest only takes five yet it is 5x stronger than the gloves.

<table>
 <tr>
  <td>Piece</td>
  <td>Class Conflux</td>
  <td>Pureness</td>
  <td rowspan="6">

As an example, <img src="https://render.githubusercontent.com/render/math?math=p%20=%207"> for a ranger who already has gloves because they would have used 7 total class specific confluxes to create their chest.

If that player was a druid, <img src="https://render.githubusercontent.com/render/math?math=p%20=%206">, because pures are used instead as that is the limiting factor for warriors, mages, and druids and it would take 6 purenesses to create the player's chest.

Suppose the player was a rogue and hasn't received any Doch Gul. In this sitation <img src="https://render.githubusercontent.com/render/math?math=p%20=%202"> as it would take two class specific confluxes to create their gloves.


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

## Eligibility
This is where it starts to get difficult. We must prevent inactive players who have acquired a large amount of points in the past from receiving Doch Gul along with players who rarely play on the account they have designated as their main DG account. Minimum amounts for combined lifetime, combined recent activity, main lifetime, and main activity can be used to disqualify these players.

The problem that arises here is that the clan goes through cycles. It is much easier to accumulate points while we are prospering than it is during a down period. DKP inflation is another factor to consider making it likely that these minimum values will need to be changed. Constantly changing the minimums risks fracturing trust in the clan's leadership as it can be seen as manipulating the algorithm's outcome to disqualify certain players. The solution is the use of a dynamic minimum 90 day activity relative to the total 90 day DKP pool of the rest of the clan.

Simply using minimum activity is not enough, another necessary requirement is steady activity. A power player may acquire twice the required minimum in one month then go inactive yet still be eligible from that single month. This can be solved by requiring the player's 45 day activity to be within a certain percentage of their 90 day activity.

### Minimums
<img src="https://i.imgur.com/rYxce11.png" width="500" align="right">Shown to the right is a 10 day moving average of the total 90 day DKP activity of the clan since 2018. For simplicity, this total can be referred to as the DKP pool. 

It is significantly easier to acquire points during those peaks than it is during a trough. It's ignorant to assume we will never again dip below the 150,000 mark so the minimums must take that into consideration. The minimum will be based on a percentage of the total pool.

It's no secret that I am a casual player. Personally, Thallen's 90 day activity is about 3000 as of 4/30/20. While I don't want to exclude casual players, it's hard to justify giving gloves to anyone with my activity. 3500 points currently equates to about 1.27% of the DKP pool which seems like a good minimum for gloves at that point in time. As of 4/30/20 there are 37 separate players above that activity compared to only 13 players on 06/15/19.

## Combined Recent Activity
<img src="https://render.githubusercontent.com/render/math?math=\Large%20a_c%20\geq%20L_{cmin}\text{%20where,%20}" ">
<img src="https://render.githubusercontent.com/render/math?math=\Large%20a_%7Bcmin%7D%3D%5Cbegin%7Bcases%7Dx_1%20d_%7B90%7D%2C%20%26%20%5Ctext%7Bif%20%7Dx_1%20d_%7B90%7D%20%3E%202500%20%5C%5C2500%2C%20%26%20%5Ctext%7Botherwise%7D%20%5Cend%7Bcases%7D%20">
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />
<b>d<sub>90</sub></b>: The 90 day DKP pool<br />
<b>x<sub>1</sub></b>: A percent of the DKP pool (to be decided)<br />

## Combined Lifetime Minimum
<img src="https://render.githubusercontent.com/render/math?math=\Large%20L_c%20\geq%20L_{cmin}\text{%20where,%20}">
<img src="https://render.githubusercontent.com/render/math?math=%\Large%20L_%7Bcmin%7D%20%3D%5Cbegin%7Bcases%7D%0Ax_2%20a_%7Bcmin%7D%2C%20%26%20%5Ctext%7Bif%20%7D%205000%20%20%5Cleq%20%20x_2%20a_%7Bcmin%7D%20%20%5Cleq%2010000%0A%5C%5C5000%2C%20%26%20%5Ctext%7Bif%20%7D%20x_2%20a_%7Bcmin%7D%20%20%5Cleq%205000%0A%5C%5C10000%2C%20%26%20%5Ctext%7Bif%20%7D%20x_2%20a_%7Bcmin%7D%20%20%20%5Cgeq%20%2010000%0A%5Cend%7Bcases%7D%20">
<b>L<sub>cmin</sub></b>: The minimum combined lifetime to qualify<br />
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />
<b>x<sub>2</sib></b>: A percent of 90 day activity(to be decided)<br />
<p />

## Declining Activity


