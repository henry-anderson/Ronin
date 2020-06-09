# Doch Gul
This document defines a procedural and algorithmic approach in deciding which candidates receive pieces of Doch Gul (DG) armor based on an unbias method in which clan leaders control very little of the decision making process. Generals decide on a category of players in which they want to distribute DG pieces too. Eligible players are assigned a rating value based on the lifetime and recent DKP acquired across all of their accounts. The player with the highest rating receives the next piece of armor that they are working towards.

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
<img src="https://i.imgur.com/qrqmAW6.png">
<b>r</b>: The players rating<br />
<b>L<sub>c</sub></b>: The combined lifetime DKP of the player across all accounts<br />
<b>a<sub>c90</sub></b>: The combined DKP accumulated by the player over the last 90 days<br />
<b>p</b>: The amount of confluxes (class specific or pureness) already given to the player combined with the amount of confluxes we would be investing in the player if they were to win their next piece of armor.<br />
<b>k<sub>p</sub></b>: The amount of Proteus attendances in the past 60 days.<br />
<b>k<sub>u</sub></b>: The amount of Unox (215) attendances in the past 60 days.

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

<img src="https://i.imgur.com/WA9KvQr.png" width="500" align="right">Shown to the right is a graph that depicts the effect of attendance on a fictional player's rating who currently has 25000 lifetime and 5000 recent activity. The player's proteus attendance is held constant while the rating at differing unox attendances is shown. Player's are penalized based on their proteus and unox attendances which exponentially decreases until that penalty is negligible. 

DKP is already weighted based on importance of the boss so it's very unlikely that someone with few unox or proteus attendances would rank very highly using this system. This is used more as a way of stressing the importance of these two bosses and stating that if you want DG then you need to go to proteus and 215. This was implemented as part of the rating instead of a requirement so that players would continue to attend these bosses instead of stopping as soon as they hit the minimum. This way players will keep attending these bosses beyond a certain minimum so they incur the lowest possible penalty.

## Eligibility
This is where it starts to get difficult. We must prevent inactive players who have acquired a large amount of points in the past from receiving Doch Gul along with players who rarely play on the account they have designated as their main DG account. Minimum amounts for combined lifetime, combined recent activity, main lifetime, and main activity can be used to disqualify these players.

The problem that arises here is that the clan goes through cycles. It is much easier to accumulate points while we are prospering than it is during a down period. DKP inflation is another factor to consider making it likely that these minimum values will need to be changed. Constantly changing the minimums risks fracturing trust in the clan's leadership as it can be seen as manipulating the algorithm's outcome to disqualify certain players. The solution is the use of a dynamic minimum 90 day activity relative to the total 90 day DKP pool of the rest of the clan.

<img src="" width="500" align="right">Shown to the right is a 10 day moving average of the total 90 day DKP activity of the clan since 2018. For simplicity, this total can be referred to as the DKP pool. 

It is significantly easier to acquire points during those peaks than it is during a trough. It's ignorant to assume we will never again dip below the 150,000 mark so the minimums must take that into consideration. The minimum will be based on a percentage of the total pool.

It's no secret that I am a casual player. Personally, my 90 day activity is about 3000 as of 4/30/20. While I don't want to exclude casual players, it's hard to justify giving gloves to anyone with my activity. 3500 points currently equates to about 1.27% of the DKP pool which could potentially be used as a minimum for gloves. Right now (4/30/20) there are 37 separate players above that activity compared to only 13 players on 06/15/19. That shows that we couldn't simply use 3500 as  a constant otherwise it would make it too easy, or in some cases too hard to meet the requirement.

Absolute minimum and maximums will also be used to make sure that the dynamic minimum never gets too high, in the case of server dominance, or too low. The ambiguity of these requirements will motivate players to aim for the higher end of this range to guarantee that they will be eligible when the time comes.

Simply using minimum activity is not enough, another necessary requirement is steady activity. A power player may acquire twice the required minimum in one month then go inactive yet still be eligible from that single month. This can be solved by requiring the player's 45 day activity to be within a certain percentage of their 90 day activity.

<table>
 <tr align="center">
  <td></td>
  <td colspan="4"><b>Overview of the Absolute Minimum and Maximum Values</b></td>
 </tr>
 <tr align="center">
  <td><b>Requirement</b></td>
  <td><b>Minimum (Gloves)</b></td>
  <td><b>Maximum (Gloves)</b></td>
  <td><b>Minimum (Chest+)</b></td>
  <td><b>Maximum (Chest+)</b></td>
 </tr>
 <tr align="center">
  <td><b>Combined Lifetime</b></td>
  <td>5000</td>
  <td>10000</td>
  <td>10000</td>
  <td>25000</td>
 </tr>
 <tr align="center">
  <td><b>Combined Recent</b></td>
  <td>2500</td>
  <td>4200</td>
  <td>4500</td>
  <td>8000</td>
 </tr>
 <tr align="center">
  <td><b>Main Recent</b></td>
  <td>1500</td>
  <td>2520</td>
  <td>2700</td>
  <td>4800</td>
 </tr>
</table>

### Combined Recent Activity
<table>
  <tr align="center"><td colspan="2"><i>Player passes this requirement when a<sub>c90</sub> ≥ a<sub>cmin</sub></i></td</tr>
 <tr align="center">
  <td><b>Gloves</b></td>
  <td><b>Chest+</b></td>
 </tr>
 <tr align="center">
  <td><img src="https://render.githubusercontent.com/render/math?math=%5Clarge%20a_%7Bcmin%7D%20%3D%5Cbegin%7Bcases%7D%0Ax_1%20d_%7B90%7D%2C%20%26%20%5Ctext%7Bif%20%7D%202500%20%20%5Cleq%20%20x_1%20d_%7B90%7D%20%20%5Cleq%204200%0A%5C%5C4200%2C%20%26%20%5Ctext%7Bif%20%7D%20x_1%20d_%7B90%7D%20%5Ctextgreater%204200%0A%5C%5C2500%2C%20%26%20otherwise%0A%5Cend%7Bcases%7D%20"></td>
  <td><img src="https://render.githubusercontent.com/render/math?math=%5Clarge%20a_%7Bcmin%7D%20%3D%5Cbegin%7Bcases%7D%0Ay_1%20d_%7B90%7D%2C%20%26%20%5Ctext%7Bif%20%7D%204500%20%20%5Cleq%20%20y_1%20d_%7B90%7D%20%20%5Cleq%208000%0A%5C%5C8000%2C%20%26%20%5Ctext%7Bif%20%7D%20y_1%20d_%7B90%7D%20%20%20%5Ctextgreater%20%208000%0A%5C%5C4500%2C%20%26%20otherwise%0A%5Cend%7Bcases%7D%20"></td>
 </tr>
</table>

<b>a<sub>c90</sub></b>: The player's combined 90 day activity<br />
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />
<b>d<sub>90</sub></b>: The 90 day DKP pool<br />
<b>x<sub>1</sub></b>: A percent of the DKP pool used for players working on their gloves (to be decided)<br />
<b>y<sub>1</sub></b>: A percent of the DKP pool used for players who already have gloves (to be decided)<br />
<br />
This makes the required 90 day activity to be a certain percent (x<sub>1</sub> and y<sub>1</sub>) of the DKP pool so long as it is within the defined range. Static maximum and minimums are set from 2500 to 4200 for gloves and 4500 to 8000 for any piece chest and above.

x<sub>1</sub> and y<sub>1</sub> will eventually be constants, but the clan is currently at the highest peak it has ever seen so I will wait until I can see how this effects the graph of historical DKP pool values.

 ### Main Account's Recent Activity
 <img src="https://i.imgur.com/EEpGR2m.png"><br/>
 <i>Player passes when a<sub>90</sub> ≥ a<sub>min</sub></i><br />
<b>a<sub>90</sub></b>: The 90 day activity of the player's main account<br />
<b>a<sub>min</sub></b>: The minimum 90 day activity on the player's main account to qualify<br />
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />

The player must have acquired at least 60% of the combined activity minimum on their main toon. This is necessary so that we don't give DG to a player who won't actually be using it. This number can range anywhere from 1500 to 2520 for gloves and 1800 to 3400 for anything higher.

### Combined Lifetime Minimum
<table>
 <tr align="center"><td colspan="2"><i>Player passes this requirement when L<sub>c</sub> ≥ L<sub>cmin</sub></i></td</tr>
 <tr align="center">
  <td><b>Gloves</b></td>
  <td><b>Chest+</b></td>
 </tr>
 <tr align="center">
  <td><img src="https://render.githubusercontent.com/render/math?math=%5Clarge%20L_%7Bcmin%7D%20%3D%5Cbegin%7Bcases%7D%0Ax_2%20a_%7Bcmin%7D%2C%20%26%20%5Ctext%7Bif%20%7D%205000%20%20%5Cleq%20%20x_2%20a_%7Bcmin%7D%20%20%5Cleq%2010000%0A%5C%5C10000%2C%20%26%20%5Ctext%7Bif%20%7D%20x_2%20a_%7Bcmin%7D%20%20%20%5Ctextgreater%20%2010000%0A%5C%5C5000%2C%20%26%20otherwise%0A%5Cend%7Bcases%7D%20"></td>
  <td><img src="https://render.githubusercontent.com/render/math?math=%5Clarge%20L_%7Bcmin%7D%20%3D%5Cbegin%7Bcases%7D%0Ay_2%20a_%7Bcmin%7D%2C%20%26%20%5Ctext%7Bif%20%7D%2010000%20%20%5Cleq%20%20y_2%20a_%7Bcmin%7D%20%20%5Cleq%2025000%0A%5C%5C25000%2C%20%26%20%5Ctext%7Bif%20%7D%20y_2%20a_%7Bcmin%7D%20%20%20%5Ctextgreater%20%2025000%0A%5C%5C10000%2C%20%26%20otherwise%0A%5Cend%7Bcases%7D%20"></td>
 </tr>
</table>

<b>L<sub>c</sub></b>: The player's combined lifetime DKP<br />
<b>L<sub>cmin</sub></b>: The minimum combined lifetime to qualify<br />
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />
<b>x<sub>2</sub></b>: A percent of the 90 day activity minimum used for players working on their gloves (to be decided)<br />
<b>y<sub>2</sub></b>: A percent of the 90 day activity minimum used for players who already have gloves (to be decided)<br />
<p />

### Declining Activity
<img src="https://i.imgur.com/PHLTmPj.png">
<i>Player passes when this expression is true</i><br />
<b>a<sub>c90</sub></b>: The player's combined 90 day activity<br />
<b>a<sub>c45</sub></b>: The player's combined 45 day activity<br />
<b>a<sub>cmin</sub></b>: The minimum combined 90 day activity to qualify<br />
<br />
This prevents players with declining activity from qualifying. They must either have acquired at least 30% of their 90 day total within the past 45 days or their 45 day total must be more than 80% of the minimum requirement. The last option is to give some leniency to power players who have far surpasses the minimum.

### Loyalty
This requirement is not specific and the player must be in the clan for at least 90 days for gloves and 180 days for anything higher. Looking at lifetime DKP is a very good indicator of loyalty, but it has its flaws. Players must be out of the clan for 30 days before their lifetime is wiped which is where this fails. There are many unstable players who leave for short periods of time yet it has no effect on their lifetime. It is very risky to give these players our most valued armor.

## Discussion
Suppose we grouped all warriors, druids, and mages into a single category regardless of whether they have already received their gloves. Without looking at any other requirements this is what the top 6 candidate's rating would look like on 06/07/2020.

<table>
<thead>
  <tr>
    <th>Name</th>
    <th>Lifetime</th>
    <th>Recent</th>
    <th>Unox</th>
    <th>Proteus</th>
   <th>Rating / 10<sup>6</sup></th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Raynard Winters</td>
    <td>34227</td>
    <td>16983</td>
    <td>215</td>
    <td>26</td>
    <td>93.25</td>
  </tr>
  <tr>
    <td>S3XYMAGE</td>
    <td>20864</td>
    <td>4927</td>
    <td>43</td>
    <td>10</td>
    <td>86.48</td>
  </tr>
  <tr>
    <td>luckyandfun</td>
    <td>21052</td>
    <td>5406</td>
    <td>15</td>
    <td>10</td>
    <td>81.29</td>
  </tr>
  <tr>
    <td>aLdRyN</td>
    <td>19529</td>
    <td>4599</td>
    <td>21</td>
    <td>11</td>
    <td>68.93</td>
  </tr>
  <tr>
    <td>Meatball</td>
    <td>11183</td>
    <td>4240</td>
    <td>10</td>
    <td>9</td>
    <td>30.48</td>
  </tr>
  <tr>
    <td>Exblood</td>
    <td>19518</td>
    <td>3922</td>
    <td>37</td>
    <td>11</td>
    <td>10.60</td>
  </tr>
</tbody>
</table>

Despite having a significant more amount of activity, proteus, and 215 kills, S3XYMAGE and luckyandfun are not far behind Raynard Winters. This is because he already has his gloves and the rating scale is standardized based on the amount of confluxes the player would be using. That means he has to work harder to receive his chest before the others receive their gloves. This is also the reason that Exblood's rating is so low relative to the others as he already has DG gloves.
</p>

The problem that is holding down luckyandfun's rating is his 215 and proteus attendances. If this were not taken into account he would rank higher than both Raynard and S3XYMAGE. If these were rangers or rogues there would be less of a gap between players working towards their chest and players working on gloves because class confluxes are used. That creates about a 1 to 3.5 ratio between the two compared to the 1 to 5 ratio used here as pures are the limiting factor.

## Protocol
* Generals hold a 24 hour vote on a category of players
* A final count is completed
* Proteus and Unox attendances are added up for each player in the chosen category
* All relevant information is inserted into the program
* The winner along with all input data is posted in the general group to be audited for mistakes for a 24 hour period
* Drops are sent and the winner is announced to the clan

It's a bad idea to post the raw results directly to the clan as it may indirectly cause drama and shaming for inactivity. Instead clan members should be allowed to request this information directly from us to see how they ranked and where they need to improve.

If a winner is chosen and we do not yet have the required confluxes to distribute that piece of armor then it will be postponed and the entire process will be repeated when we have acquired the necessary components. The same category of players must be selected and the same winner must be chosen for them to actually receive their Doch Gul.

## Conclusion
Determining Doch Gul recipients based on an algorithmic approach is far superior than a vote based system. Ever since we moved beyond simply distributing gloves it has become increasingly difficult to make the best decisions with some players having different pieces than others. This rating scale standardizes each player's rating to match the amount of confluxes that will be invested in them so that players with no DG can be compared to both players with gloves and chest or even players in Lark, or Rengwen's situation. It's simply impossible to take every piece of information into account using a vote based system yet it can be done in milliseconds here without any accusations of bias.
