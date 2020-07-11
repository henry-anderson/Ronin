# EDL Weapons
This document defines a procedural and algorithmic approach in deciding which candidates receive EDL weapons on an unbias method in which clan leaders control very little of the decision making process. The General in charge of the respective EDL bank decides whether we will be distributing an offhand, or main hand weapon. Eligible players are assigned a rating value based on the lifetime and recent DKP acquired on the account in the vote. The player with the highest rating receives their weapon.

## Rating
<table>
 <thead>
  <tr align="center">
    <th><img src="https://i.imgur.com/Qfrykor.png" height="80%"></th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td align="center"><sub>r refers to the players rating value</sub></td>
  </tr>
 </tbody>
</table>

<b>L</b>: The lifetime DKP of the player<br />
<b>a<sub>90</sub></b>: The DKP accumulated by the player over the last 90 days<br />
<b>k<sub>u</sub></b>: The amount of Unox (215) attendances in the past 60 days across all accounts<br / >
<b>k<sub>r</sub></b>: The amount of Revenant (210) attendances in the past 60 days across all accounts

<p />

The player with the highest rating receives the weapon. The formula comes down to an equal weight between recent activity and past contribution which creates a balance between new players and old players. This allows new players to thrive in the clan, while still requiring old players to put in the work.

<img src="https://i.imgur.com/WA9KvQr.png" width="500" align="right">Shown to the right is a graph that depicts the effect of attendance on a fictional player's rating who currently has 25000 lifetime and 5000 recent activity. The player's Revenant attendance is held constant while the rating at differing Unox attendances is shown. Player's are penalized based on their Unox and Revenant attendances which exponentially decreases until that penalty is negligible. 

DKP is already weighted based on importance of the boss so it's very unlikely that someone with attendances would rank very highly using this system. The purpose behind combined attendances being used is so that players with lockers aren't penalized. They are still able to transfer DKP to their main if they log their locker, but this is generally a practice most seem to use only on raids worth large amounts of points. It may seem unfair to people who are not dual loggers, but the effect attendance has on rating plateus after a certain point making the benefit for dual loggers very minimal over people who play on a single toon. This was implemented as part of the rating instead of a requirement so that players would continue to attend these bosses instead of stopping as soon as they hit the minimum. This way players will keep attending these bosses beyond a certain minimum so they incur the lowest possible penalty.

## Eligibility
We must prevent inactive players who have acquired a large amount of points in the past from receiving their weapons along, players who have only recently joined the clan, and players whose activity is significantly declining.

<table>
 <tr align="center">
  <td colspan="4"><b>Overview of the Minimum Requirements</b></td>
 </tr>
 <tr align="center"
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
  
 </tr>
 <tr align="center">
   <td colspan="3"><sub><i>The 45 day minimum is defined in the function for declining activity</i></sub></td>
 </tr>
</table>

### Lifetime Minimum
The player must have at least 2400 lifetime DKP for their main hand and 3000 lifetime DKP. This requirement is to make sure that players have put in enough work before receiving their weapons when the banks are saturated and their competition is limited. 

### Recent Activity
The player must have acquired at least 800 DKP for their main hand and 1000 DKP for their offhand in the past 90 days. While this may seem too lenient we need to make sure casual players and players with multiple toons can succeed too. This is also quite low due to the saturation of some classes. It is much easier to get an EDL offhand for a druid than it is for a rogue.

### Declining Activity
<table>
 <thead>
  <tr align="center">
    <th><img src="https://i.imgur.com/IjLSj5u.png" height="75px"></th>
  </tr>
 </thead>
 <tbody>
  <tr align="center">
   <td><sub><i>Player passes when the function's output equals 1</i></sub><br /></td>
  </tr>
 </tbody>
</table>
<b>a<sub>90</sub></b>: The player's 90 day activity<br />
<b>a<sub>45</sub></b>: The player's 45 day activity<br />
<b>a<sub>min</sub></b>: The minimum required activity (1000 or 800)<br />
<br />
This prevents players with declining activity from qualifying. In simplistic terms, the first function requires that player to have a minimum of 500 points in the past 45 days or they do not qualify. The second function uses an Iverson bracket to show that the player must either have acquired 30% of their 90 day total within the past 45 days or their 45 day activity must be 1.5x the minimum requirement. The last option is to give some leniency to power players who have far surpassed the minimum.

### Loyalty
The player must be in the clan for at least 90 days without leaving to receive either of their weapons. If the toon was outside of the clan and recently joined, but their main had been in the clan for the past 90 days they still qualify which is a situation that has been seen in the past by Lya and Ouch's toons. The reverse it also true. If your main toon left the clan within 90 days, but the toon in question remained in they do not qualify. Whether a player left or not is sometimes ambiguous and this will be left up to the General's to decide.

## Discussion
Below is a theoretical rogue offhand vote based on data from 07/11/2020. Sneakashell would be the winner as his rating is the highest due to his high lifetime and activity. Thallen would be second because his lifetime is high, but activity is low in comparison. Assuming everyone's lifetime and attendance stayed constant, if Thallen wanted to win his 90 day activity would need to increase to 10800. They have about the same lifetime points, but Thallen incurs a larger attendance deduction than Sneakashell which is why his activity would need to be significantly higher. If his attendance matched Sneakashell's, Thallen would only need to increase his 90 day activity to 9250.

Despite Palaemon's lifetime, he is third because of his relatively low activity. Assuming constant lifetime and attendance he would need to increase his 90 day activity to 1600 to beat Thallen and 7000 to beat Sneakashell. Some TankGuy is a newer player with low lifetime, but good activity. His lifetime would need to be 5300 to beat Palaemon and 7000 to beat Thallen.

<table>
<thead>
  <tr align="center">
    <th>Name</th>
    <th>Rating / 10<sup>6</sup></th>
    <th>Lifetime</th>
    <th>90 day</th>
    <th>45 day</th>
    <th>Unox</th>
    <th>Revenant</th>
   <th>Eligible</th>
  </tr>
</thead>
<tbody>
  <tr align="center">
    <td>Sneakashell</td>
    <td>106.49</td>
    <td>112747</td>
    <td>8704</td>
    <td>3839</td>
    <td>163</td>
    <td>86</td>
   <td>True</td>
  </tr>
  <tr align="center">
    <td>Thallen</td>
    <td>23.97</td>
    <td>12037</td>
    <td>2424</td>
    <td>1169</td>
    <td>36</td>
    <td>20</td>
   <td>True</td>
  </tr>
  <tr align="center">
    <td>Palaemon</td>
    <td>17.96</td>
    <td>17751</td>
    <td>1165</td>
    <td>515</td>
    <td>57</td>
    <td>19</td>
   <td>True</td>
  </tr>
  <tr align="center">
    <td>Some TankGuy</td>
    <td>13.61</td>
    <td>3950</td>
    <td>3824</td>
    <td>2302</td>
    <td>43</td>
    <td>58</td>
   <td>True</td>
  </tr>
  <tr align="center">
    <td>supersayian</td>
    <td>1.47</td>
    <td>1333</td>
    <td>1163</td>
    <td>233</td>
    <td>159</td>
    <td>44</td>
   <td>False</td>
  </tr>
  <tr align="center">
    <td>Sir Meliodas</td>
    <td>0</td>
    <td>5613</td>
    <td>1495</td>
    <td>175</td>
    <td>2</td>
    <td>3</td>
   <td>False</td>
  </tr>
   <tr align="center">
    <td>Depr1ved</td>
    <td>0</td>
    <td>6796</td>
    <td>3096</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>False</td>
  </tr>
</tbody>
</table>

Supersayian, Sir Meliodas, and Depr1ved did not pass the necessary requirements to qualify. Supersayian would need to surpass 3000 lifetime to qualify. He would also need to increase his 45 day activity by about 250 points to pass the declining activity requirement. Sir Meliodas did not pass the declining activity requirement as his 45 day activity is only 10% of his 90 day activity. His rating is zero because his attendance within the past 60 days was minimal.

Depr1ved was a power player who recently went inactive. Despite having acquired 3096 points in the past 90 days he is not eligible. He has not received any points in the past 45 days which automatically disqualifies him as it is under 500.

The table below depicts which requirements each player is passing. While attendance isn't technically a requirement, it still ruins a player's rating at a certain point which is why it is included in the table.

<table>
 <thead>
  <tr align="center">
    <th>Name</th>
    <th>Lifetime</sup></th>
    <th>90 day</th>
    <th>45 day</th>
    <th>Declining Activity</th>
    <th>Attendance</th>
  </tr>
</thead>
 <tbody>
  <tr align="center">
    <td>Sneakashell</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
  </tr>
  <tr align="center">
    <td>Thallen</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
  </tr>
  <tr align="center">
    <td>Palaemon</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
  </tr>
  <tr align="center">
    <td>Some TankGuy</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
    <td>True</td>
  </tr>
  <tr align="center">
    <td>supersayian</td>
    <td>False</td>
    <td>True</td>
    <td>False</td>
    <td>False</td>
    <td>True</td>
  </tr>
  <tr align="center">
   <td>Sir Meliodas</td>
    <td>True</td>
    <td>True</td>
    <td>False</td>
    <td>False</td>
    <td>False</td>
  </tr>
   <tr align="center">
    <td>Depr1ved</td>
    <td>True</td>
    <td>True</td>
    <td>False</td>
    <td>False</td>
    <td>False</td>
  </tr>
 </tbody>
 </table>

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
