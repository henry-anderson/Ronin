# EDL Weapons
This document defines a procedural and algorithmic approach in deciding which candidates receive EDL weapons on an unbias method in which clan leaders control very little of the decision making process. The General in charge of the respective EDL bank decides whether we will be distributing an offhand, or main hand weapon. Eligible players are assigned a rating value based on the lifetime and recent DKP acquired on the account in the vote. The player with the highest rating receives their weapon.

## Rating
<img src="https://i.imgur.com/CNGAn54.png" height="50px">
<b>r</b>: The players rating<br />
<b>L<sub>c</sub></b>: The lifetime DKP of the player<br />
<b>a<sub>c90</sub></b>: The DKP accumulated by the player over the last 90 days<br />
<b>k<sub>p</sub></b>: The amount of Proteus attendances in the past 60 days across all accounts<br />
<b>k<sub>u</sub></b>: The amount of Unox (215) attendances in the past 60 days across all accounts

<p />

The player with the highest rating receives the weapon. An equal weight between recent activity and past contribution creates a balance between new players and old players. This allows new players to thrive in the clan, while still requiring old players to put in the work.

Whether the amount of purenesses or class specific confluxes is used depends on the limiting factor. Class specific confluxes are used for rangers and rogues while purenesses are used for warriors, mages, and druids. This is due to the fact that we have a surplus of warrior, mage, and druid confluxes. For DPS classes larger pieces are slightly favored as gloves take two class specific confluxes to make while a chest only takes five yet it is 5x stronger than the gloves.

<img src="https://i.imgur.com/WA9KvQr.png" width="500" align="right">Shown to the right is a graph that depicts the effect of attendance on a fictional player's rating who currently has 25000 lifetime and 5000 recent activity. The player's proteus attendance is held constant while the rating at differing unox attendances is shown. Player's are penalized based on their proteus and unox attendances which exponentially decreases until that penalty is negligible. 

DKP is already weighted based on importance of the boss so it's very unlikely that someone with few unox or proteus attendances would rank very highly using this system. The purpose behind combined attendances being used is so that players with lockers aren't penalized. They are still able to transfer DKP to their main if they log their locker, but this is generally a practice most seem to use only on raids worth large amounts of points. It may seem unfair to people who are not dual loggers, but attendance plateus after a certain point making the benefit for dual loggers very minimal over people who play on a single toon. This was implemented as part of the rating instead of a requirement so that players would continue to attend these bosses instead of stopping as soon as they hit the minimum. This way players will keep attending these bosses beyond a certain minimum so they incur the lowest possible penalty.

## Eligibility
We must prevent inactive players who have acquired a large amount of points in the past from receiving their weapons along, players who have only recently joined the clan, and players whose activity is significantly declining.

<table>
 <tr align="center">
  <td></td>
  <td colspan="4"><b>Overview of the Minimum Requirements</b></td>
 </tr>
 <tr align="center">
  <td><b>Requirement</b></td>
  <td><b>Main Hand</b></td>
  <td><b>Offhand</b></td>
 </tr>
 <tr align="center">
  <td><b>Lifetime</b></td>
  <td>2400</td>
  <td>3000</td>
 </tr>
 <tr align="center">
  <td><b>90 Day Activity</b></td>
  <td>800</td>
  <td>1000</td>
 </tr>
 <tr align="center">
  <td><b>45 Day Activity</b></td>
  <td>500</td>
  <td>500</td>
</table>

<div style="font-size:3px;">The 45 day activity requirement is defined in the formula for detecting declining activity</div>

### Lifetime Minimum
The player must have at least 2400 lifetime DKP for their main hand and 3000 lifetime DKP.

### Recent Activity
The player must have acquired at least 800 DKP for their main hand and 1000 DKP for their offhand in the past 90 days.

### Declining Activity
<img src="https://i.imgur.com/IjLSj5u.png" height="75px">
<i>Player passes when the function's output equals 1</i><br />
<b>a<sub>90</sub></b>: The player's 90 day activity<br />
<b>a<sub>45</sub></b>: The player's 45 day activity<br />
<b>a<sub>min</sub></b>: The minimum required activity (1000 or 800)<br />

<br />
This prevents players with declining activity from qualifying. In simplistic terms, the first function requires that player to have a minimum of 500 points in the past 45 days or they do not qualify. The second function uses an Iverson bracket to show that the player must either have acquired 30% of their 90 day total within the past 45 days or their 45 day activity must be 1.5x the minimum requirement. The last option is to give some leniency to power players who have far surpassed the minimum.

<

### Loyalty
The player must be in the clan for at least 90 days without leaving to receive either of their weapons. If the toon was outside of the clan and recently joined, but their main had been in the clan for the past 90 days they still qualify which is a situation that has been seen in the past by Lya and Ouch's toons. The reverse it also true. If your main left the clan within 90 days, but the toon in question remained in they do not qualify. Whether a player left or not is sometimes ambiguous and this will be left up to the General's to decide.

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
* The General in charge of the bank decides whether we will be giving away an offhand or main hand weapon
* A final count is completed
* Proteus and Unox attendances are added up for each player in the chosen category
* All relevant information is inserted into the program
* The winner along with all input data is posted in the general group to be audited for mistakes for a 24 hour period
* Drops are sent and the winner is announced to the clan

It's a bad idea to post the raw results directly to the clan as it may indirectly cause drama and shaming for inactivity. Instead clan members should be allowed to request this information directly from us to see how they ranked and where they need to improve.

If a winner is chosen and we do not yet have the required confluxes to distribute that piece of armor then it will be postponed and the entire process will be repeated when we have acquired the necessary components. The same category of players must be selected and the same winner must be chosen for them to actually receive their Doch Gul.

## Conclusion
Determining Doch Gul recipients based on an algorithmic approach is far superior than a vote based system. Ever since we moved beyond simply distributing gloves it has become increasingly difficult to make the best decisions with some players having different pieces than others. This rating scale standardizes each player's rating to match the amount of confluxes that will be invested in them so that players with no DG can be compared to both players with gloves and chest or even players in Lark, or Rengwen's situation. It's simply impossible to take every piece of information into account using a vote based system yet it can be done in milliseconds here without any accusations of bias. This system gives each player practically complete control over whether they will be receiving DG or not instead of depending on faith in their leadership.
